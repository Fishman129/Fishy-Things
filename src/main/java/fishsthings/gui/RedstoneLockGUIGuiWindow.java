
package fishsthings.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import fishsthings.functions.RedstoneTorchConditionOnfunction;
import fishsthings.functions.RedstoneTorchConditionOfffunction;

import fishsthings.FishsThingsMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class RedstoneLockGUIGuiWindow extends ContainerScreen<RedstoneLockGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = RedstoneLockGUIGui.guistate;
	TextFieldWidget code;
	TextFieldWidget redstone_value;
	TextFieldWidget redstone_value_code;
	TextFieldWidget drop_code;
	public RedstoneLockGUIGuiWindow(RedstoneLockGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 255;
		this.ySize = 203;
	}
	private static final ResourceLocation texture = new ResourceLocation("fishs_things:textures/redstone_lock_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		code.render(ms, mouseX, mouseY, partialTicks);
		redstone_value.render(ms, mouseX, mouseY, partialTicks);
		redstone_value_code.render(ms, mouseX, mouseY, partialTicks);
		drop_code.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		if (RedstoneTorchConditionOfffunction.executefunction(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fishs_things:textures/redstone_torch_off.png"));
			this.blit(ms, this.guiLeft + 136, this.guiTop + 25, 0, 0, 16, 16, 16, 16);
		}
		if (RedstoneTorchConditionOnfunction.executefunction(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fishs_things:textures/redstone_torch.png"));
			this.blit(ms, this.guiLeft + 136, this.guiTop + 25, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (code.isFocused())
			return code.keyPressed(key, b, c);
		if (redstone_value.isFocused())
			return redstone_value.keyPressed(key, b, c);
		if (redstone_value_code.isFocused())
			return redstone_value_code.keyPressed(key, b, c);
		if (drop_code.isFocused())
			return drop_code.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		code.tick();
		redstone_value.tick();
		redstone_value_code.tick();
		drop_code.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Case Sensitive!", 19, 7, -12829636);
		this.font.drawString(ms, "Max of 15", 10, 79, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 28, this.guiTop + 52, 50, 20, new StringTextComponent("Enter"), e -> {
			if (true) {
				FishsThingsMod.PACKET_HANDLER.sendToServer(new RedstoneLockGUIGui.ButtonPressedMessage(0, x, y, z));
				RedstoneLockGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		code = new TextFieldWidget(this.font, this.guiLeft + 10, this.guiTop + 25, 120, 20, new StringTextComponent("Code")) {
			{
				setSuggestion("Code");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Code");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Code");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:code", code);
		code.setMaxStringLength(32767);
		this.children.add(this.code);
		redstone_value = new TextFieldWidget(this.font, this.guiLeft + 10, this.guiTop + 88, 120, 20, new StringTextComponent("Redstone Power")) {
			{
				setSuggestion("Redstone Power");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Redstone Power");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Redstone Power");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:redstone_value", redstone_value);
		redstone_value.setMaxStringLength(32767);
		this.children.add(this.redstone_value);
		redstone_value_code = new TextFieldWidget(this.font, this.guiLeft + 10, this.guiTop + 106, 120, 20, new StringTextComponent("Code")) {
			{
				setSuggestion("Code");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Code");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Code");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:redstone_value_code", redstone_value_code);
		redstone_value_code.setMaxStringLength(32767);
		this.children.add(this.redstone_value_code);
		this.addButton(new Button(this.guiLeft + 136, this.guiTop + 97, 50, 20, new StringTextComponent("Enter"), e -> {
			if (true) {
				FishsThingsMod.PACKET_HANDLER.sendToServer(new RedstoneLockGUIGui.ButtonPressedMessage(1, x, y, z));
				RedstoneLockGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		drop_code = new TextFieldWidget(this.font, this.guiLeft + 10, this.guiTop + 178, 120, 20, new StringTextComponent("Drop")) {
			{
				setSuggestion("Drop");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Drop");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Drop");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:drop_code", drop_code);
		drop_code.setMaxStringLength(32767);
		this.children.add(this.drop_code);
		this.addButton(new Button(this.guiLeft + 136, this.guiTop + 178, 50, 20, new StringTextComponent("Enter"), e -> {
			if (true) {
				FishsThingsMod.PACKET_HANDLER.sendToServer(new RedstoneLockGUIGui.ButtonPressedMessage(2, x, y, z));
				RedstoneLockGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}

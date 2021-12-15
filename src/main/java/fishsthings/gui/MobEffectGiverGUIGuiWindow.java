
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

import fishsthings.functions.MobEffectGiverRedstoneImageCondition1function;
import fishsthings.functions.MobEffectGiverRedstoneImage2function;

import fishsthings.FishsThingsMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@OnlyIn(Dist.CLIENT)
public class MobEffectGiverGUIGuiWindow extends ContainerScreen<MobEffectGiverGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MobEffectGiverGUIGui.guistate;
	TextFieldWidget mobEffect;
	public MobEffectGiverGUIGuiWindow(MobEffectGiverGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 308;
		this.ySize = 172;
	}
	private static final ResourceLocation texture = new ResourceLocation("fishs_things:textures/mob_effect_giver_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		mobEffect.render(ms, mouseX, mouseY, partialTicks);
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
		if (MobEffectGiverRedstoneImage2function.executefunction(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fishs_things:textures/redstone_torch_off.png"));
			this.blit(ms, this.guiLeft + 65, this.guiTop + 2, 0, 0, 16, 16, 16, 16);
		}
		if (MobEffectGiverRedstoneImageCondition1function.executefunction(ImmutableMap.of("x", x, "y", y, "z", z, "world", world))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fishs_things:textures/redstone_torch.png"));
			this.blit(ms, this.guiLeft + 65, this.guiTop + 2, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (mobEffect.isFocused())
			return mobEffect.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		mobEffect.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Give effect:", 119, 15, -12829636);
		this.font.drawString(ms, "to every mob on a", 108, 56, -12829636);
		this.font.drawString(ms, "No Spaces!", 123, 146, -12829636);
		this.font.drawString(ms, "radius of 8, 16, 32, or 128.", 83, 68, -12829636);
		this.font.drawString(ms, "depending on the number of Range Upgrades", 53, 78, -12829636);
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
		mobEffect = new TextFieldWidget(this.font, this.guiLeft + 90, this.guiTop + 33, 120, 20, new StringTextComponent("eg: minecraft:speed")) {
			{
				setSuggestion("eg: minecraft:speed");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("eg: minecraft:speed");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("eg: minecraft:speed");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:mobEffect", mobEffect);
		mobEffect.setMaxStringLength(32767);
		this.children.add(this.mobEffect);
		this.addButton(new Button(this.guiLeft + 126, this.guiTop + 91, 50, 20, new StringTextComponent("Confirm"), e -> {
			if (true) {
				FishsThingsMod.PACKET_HANDLER.sendToServer(new MobEffectGiverGUIGui.ButtonPressedMessage(0, x, y, z));
				MobEffectGiverGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 108, this.guiTop + 118, 90, 20, new StringTextComponent("Remove Effect"), e -> {
			if (true) {
				FishsThingsMod.PACKET_HANDLER.sendToServer(new MobEffectGiverGUIGui.ButtonPressedMessage(1, x, y, z));
				MobEffectGiverGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 2, this.guiTop + 3, 65, 20, new StringTextComponent("§cRedstone"), e -> {
			if (true) {
				FishsThingsMod.PACKET_HANDLER.sendToServer(new MobEffectGiverGUIGui.ButtonPressedMessage(2, x, y, z));
				MobEffectGiverGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}

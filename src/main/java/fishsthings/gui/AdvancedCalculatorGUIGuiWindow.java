
package fishsthings.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AdvancedCalculatorGUIGuiWindow extends ContainerScreen<AdvancedCalculatorGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = AdvancedCalculatorGUIGui.guistate;
	TextFieldWidget no1;
	TextFieldWidget no2;
	TextFieldWidget middle;
	TextFieldWidget result;
	public AdvancedCalculatorGUIGuiWindow(AdvancedCalculatorGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		no1.render(ms, mouseX, mouseY, partialTicks);
		no2.render(ms, mouseX, mouseY, partialTicks);
		middle.render(ms, mouseX, mouseY, partialTicks);
		result.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fishs_things:textures/calculatorgui2.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 0, 0, 0, 176, 166, 176, 166);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (no1.isFocused())
			return no1.keyPressed(key, b, c);
		if (no2.isFocused())
			return no2.keyPressed(key, b, c);
		if (middle.isFocused())
			return middle.keyPressed(key, b, c);
		if (result.isFocused())
			return result.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		no1.tick();
		no2.tick();
		middle.tick();
		result.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "=", 78, 120, -12829636);
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
		no1 = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 9, 120, 20, new StringTextComponent("No. 1")) {
			{
				setSuggestion("No. 1");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("No. 1");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("No. 1");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:no1", no1);
		no1.setMaxStringLength(32767);
		this.children.add(this.no1);
		no2 = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 97, 120, 20, new StringTextComponent("No. 2")) {
			{
				setSuggestion("No. 2");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("No. 2");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("No. 2");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:no2", no2);
		no2.setMaxStringLength(32767);
		this.children.add(this.no2);
		middle = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 52, 120, 20, new StringTextComponent("+, -, /, *,^")) {
			{
				setSuggestion("+, -, /, *,^");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("+, -, /, *,^");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("+, -, /, *,^");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:middle", middle);
		middle.setMaxStringLength(32767);
		this.children.add(this.middle);
		result = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 133, 120, 20, new StringTextComponent("result (do not remove)")) {
			{
				setSuggestion("result (do not remove)");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("result (do not remove)");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("result (do not remove)");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:result", result);
		result.setMaxStringLength(32767);
		this.children.add(this.result);
	}
}

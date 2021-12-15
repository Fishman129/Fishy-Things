
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

import fishsthings.FishsThingsMod;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class UltimateCalculatorGUIGuiWindow extends ContainerScreen<UltimateCalculatorGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = UltimateCalculatorGUIGui.guistate;
	TextFieldWidget no1;
	TextFieldWidget no2;
	TextFieldWidget middle;
	TextFieldWidget result;
	TextFieldWidget Round_Up;
	TextFieldWidget result_round_up;
	TextFieldWidget result_absolute_value;
	TextFieldWidget Percentage;
	TextFieldWidget Percentage2;
	TextFieldWidget result_percentage;
	public UltimateCalculatorGUIGuiWindow(UltimateCalculatorGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 385;
		this.ySize = 230;
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
		Round_Up.render(ms, mouseX, mouseY, partialTicks);
		result_round_up.render(ms, mouseX, mouseY, partialTicks);
		result_absolute_value.render(ms, mouseX, mouseY, partialTicks);
		Percentage.render(ms, mouseX, mouseY, partialTicks);
		Percentage2.render(ms, mouseX, mouseY, partialTicks);
		result_percentage.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("fishs_things:textures/calculatorgui.png"));
		this.blit(ms, this.guiLeft + 1, this.guiTop + 0, 0, 0, 385, 230, 385, 230);
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
		if (Round_Up.isFocused())
			return Round_Up.keyPressed(key, b, c);
		if (result_round_up.isFocused())
			return result_round_up.keyPressed(key, b, c);
		if (result_absolute_value.isFocused())
			return result_absolute_value.keyPressed(key, b, c);
		if (Percentage.isFocused())
			return Percentage.keyPressed(key, b, c);
		if (Percentage2.isFocused())
			return Percentage2.keyPressed(key, b, c);
		if (result_percentage.isFocused())
			return result_percentage.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		no1.tick();
		no2.tick();
		middle.tick();
		result.tick();
		Round_Up.tick();
		result_round_up.tick();
		result_absolute_value.tick();
		Percentage.tick();
		Percentage2.tick();
		result_percentage.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "=", 183, 152, -12829636);
		this.font.drawString(ms, "NOTE: Please use = for Pi", 125, 27, -256);
		this.font.drawString(ms, "Square Root", 39, 12, -256);
		this.font.drawString(ms, "Random Number Gen (0,1)", 255, 12, -256);
		this.font.drawString(ms, "Percentage", 291, 93, -256);
		this.font.drawString(ms, "Is what percentage of", 255, 138, -256);
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
		no1 = new TextFieldWidget(this.font, this.guiLeft + 129, this.guiTop + 41, 120, 20, new StringTextComponent("No. 1")) {
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
		no2 = new TextFieldWidget(this.font, this.guiLeft + 129, this.guiTop + 129, 120, 20, new StringTextComponent("No. 2")) {
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
		middle = new TextFieldWidget(this.font, this.guiLeft + 129, this.guiTop + 84, 120, 20, new StringTextComponent("+, -, /, *,^,^2")) {
			{
				setSuggestion("+, -, /, *,^,^2");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("+, -, /, *,^,^2");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("+, -, /, *,^,^2");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:middle", middle);
		middle.setMaxStringLength(32767);
		this.children.add(this.middle);
		result = new TextFieldWidget(this.font, this.guiLeft + 129, this.guiTop + 165, 120, 20, new StringTextComponent("result (do not remove)")) {
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
		Round_Up = new TextFieldWidget(this.font, this.guiLeft + 3, this.guiTop + 30, 120, 20, new StringTextComponent("Square Root")) {
			{
				setSuggestion("Square Root");
			}
			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("Square Root");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("Square Root");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:Round_Up", Round_Up);
		Round_Up.setMaxStringLength(32767);
		this.children.add(this.Round_Up);
		result_round_up = new TextFieldWidget(this.font, this.guiLeft + 3, this.guiTop + 75, 120, 20,
				new StringTextComponent("result (do not remove)")) {
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
		guistate.put("text:result_round_up", result_round_up);
		result_round_up.setMaxStringLength(32767);
		this.children.add(this.result_round_up);
		result_absolute_value = new TextFieldWidget(this.font, this.guiLeft + 255, this.guiTop + 30, 120, 20,
				new StringTextComponent("result (do not remove)")) {
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
		guistate.put("text:result_absolute_value", result_absolute_value);
		result_absolute_value.setMaxStringLength(32767);
		this.children.add(this.result_absolute_value);
		this.addButton(new Button(this.guiLeft + 282, this.guiTop + 57, 65, 20, new StringTextComponent("Generate"), e -> {
			if (true) {
				FishsThingsMod.PACKET_HANDLER.sendToServer(new UltimateCalculatorGUIGui.ButtonPressedMessage(0, x, y, z));
				UltimateCalculatorGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		Percentage = new TextFieldWidget(this.font, this.guiLeft + 255, this.guiTop + 111, 120, 20, new StringTextComponent("No. 1")) {
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
		guistate.put("text:Percentage", Percentage);
		Percentage.setMaxStringLength(32767);
		this.children.add(this.Percentage);
		Percentage2 = new TextFieldWidget(this.font, this.guiLeft + 255, this.guiTop + 156, 120, 20, new StringTextComponent("No. 2")) {
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
		guistate.put("text:Percentage2", Percentage2);
		Percentage2.setMaxStringLength(32767);
		this.children.add(this.Percentage2);
		result_percentage = new TextFieldWidget(this.font, this.guiLeft + 255, this.guiTop + 183, 120, 20,
				new StringTextComponent("result (do not remove)")) {
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
		guistate.put("text:result_percentage", result_percentage);
		result_percentage.setMaxStringLength(32767);
		this.children.add(this.result_percentage);
	}
}

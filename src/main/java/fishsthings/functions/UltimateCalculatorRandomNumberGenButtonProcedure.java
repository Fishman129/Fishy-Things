package fishsthings.functions;

import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.Map;
import java.util.HashMap;

import fishsthings.FishsThingsMod;

public class UltimateCalculatorRandomNumberGenButtonfunction {
	public static void executefunction(Map<String, Object> dependencies) {
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency guistate for function UltimateCalculatorRandomNumberGenButton!");
			return;
		}
		HashMap guistate = (HashMap) dependencies.get("guistate");
		{
			TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result_absolute_value");
			if (_tf != null) {
				_tf.setText(("" + (Math.random())));
			}
		}
	}
}

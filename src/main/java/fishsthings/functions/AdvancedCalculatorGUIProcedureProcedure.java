package fishsthings.functions;

import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.Map;
import java.util.HashMap;

import fishsthings.FishsThingsMod;

public class AdvancedCalculatorGUIfunctionfunction {
	public static void executefunction(Map<String, Object> dependencies) {
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency guistate for function AdvancedCalculatorGUIfunction!");
			return;
		}
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if ((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:middle");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("+"))) {
			{
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
				if (_tf != null) {
					_tf.setText(("" + ((new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())) + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()))))));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:middle");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("-"))) {
			{
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
				if (_tf != null) {
					_tf.setText(("" + ((new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())) - new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()))))));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:middle");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("*"))) {
			{
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
				if (_tf != null) {
					_tf.setText(("" + ((new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())) * new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()))))));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:middle");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("/"))) {
			{
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
				if (_tf != null) {
					_tf.setText(("" + ((new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())) / new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()))))));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:middle");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("^"))) {
			{
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
				if (_tf != null) {
					_tf.setText(("" + (Math.pow(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText())), new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()))))));
				}
			}
		}
	}
}

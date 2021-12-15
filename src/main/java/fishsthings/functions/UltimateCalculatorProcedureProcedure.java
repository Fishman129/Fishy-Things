package fishsthings.functions;

import net.minecraft.client.gui.widget.TextFieldWidget;

import java.util.Map;
import java.util.HashMap;

import fishsthings.FishsThingsMod;

public class UltimateCalculatorfunctionfunction {
	public static void executefunction(Map<String, Object> dependencies) {
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				FishsThingsMod.LOGGER.warn("Failed to load dependency guistate for function UltimateCalculatorfunction!");
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
			if ((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + ((Math.PI + new Object() {
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
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
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
						}.getText())) + Math.PI))));
					}
				}
			} else if (((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")) && (((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + ((Math.PI + Math.PI))));
					}
				}
			} else {
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
			if ((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + ((Math.PI - new Object() {
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
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
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
						}.getText())) - Math.PI))));
					}
				}
			} else if (((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")) && (((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + ((Math.PI - Math.PI))));
					}
				}
			} else {
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
			if ((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + ((Math.PI * new Object() {
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
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
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
						}.getText())) * Math.PI))));
					}
				}
			} else if (((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")) && (((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + ((Math.PI * Math.PI))));
					}
				}
			} else {
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
			if ((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + ((Math.PI / new Object() {
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
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
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
						}.getText())) / Math.PI))));
					}
				}
			} else if (((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")) && (((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + ((Math.PI / Math.PI))));
					}
				}
			} else {
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
			if ((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + (Math.pow(Math.PI, new Object() {
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
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("="))) {
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
						}.getText())), Math.PI))));
					}
				}
			} else if (((((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no1");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")) && (((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:no2");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText())).equals("=")))) {
				{
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result");
					if (_tf != null) {
						_tf.setText(("" + (Math.pow(Math.PI, Math.PI))));
					}
				}
			} else {
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
		if ((!(((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Round_Up");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals("")))) {
			{
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result_round_up");
				if (_tf != null) {
					_tf.setText(("" + (Math.sqrt(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Round_Up");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()))))));
				}
			}
		}
		if (((!(((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Percentage");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals(""))) && (!(((new Object() {
			public String getText() {
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Percentage2");
				if (_tf != null) {
					return _tf.getText();
				}
				return "";
			}
		}.getText())).equals(""))))) {
			{
				TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:result_percentage");
				if (_tf != null) {
					_tf.setText(("" + (((new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert((new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Percentage");
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
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Percentage2");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()))) * 100))));
				}
			}
		}
	}
}

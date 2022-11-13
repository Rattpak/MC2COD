package mc2cod;

import gui.Gui;

public class MC2COD {

	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.setVisible(true);
		gui.setLocationRelativeTo(null);
		gui.getInfoTextLabel().setText("");
	}
}

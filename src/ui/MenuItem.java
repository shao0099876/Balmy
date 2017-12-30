package ui;

import javax.swing.JMenuItem;

import tools.PublicConst;

public class MenuItem extends JMenuItem{
	public MenuItem(String s) {
		super(s);
		setFont(PublicConst.font);
	}
}
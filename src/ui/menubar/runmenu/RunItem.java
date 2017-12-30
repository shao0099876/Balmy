package ui.menubar.runmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Balmy.Resolve;
import lexer.ParseException;
import ui.MenuItem;
import ui.UserInterface;

public class RunItem extends MenuItem{
	public RunItem(UserInterface face) {
		super("Run");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Resolve(face.getTextArea().getText());
					System.out.println("\n\n"+
											"----------------------------\n"+
											"Program exited successfully!");
				} catch (ParseException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
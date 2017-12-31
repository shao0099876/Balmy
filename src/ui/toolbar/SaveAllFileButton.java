package ui.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ui.ActionPerformFunction;
import ui.UserInterface;

public class SaveAllFileButton extends JButton{
	public SaveAllFileButton(UserInterface face) {
		super(new ImageIcon(".\\Icon\\SaveAllFile.png"));
		setToolTipText("Save All");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.saveAllAction();
			}
		});
	}
}

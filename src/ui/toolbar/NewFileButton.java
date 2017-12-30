package ui.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import ui.ActionPerformFunction;

public class NewFileButton extends JButton{
	public NewFileButton() {
		super(new ImageIcon(".\\Icon\\NewFile.png"));
		setToolTipText("New File");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ActionPerformFunction.newFileAction();
			}
		});
	}
}
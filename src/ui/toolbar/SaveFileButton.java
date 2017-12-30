package ui.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import ui.ActionPerformFunction;
import ui.UserInterface;

public class SaveFileButton extends JButton{
	public SaveFileButton(UserInterface face) {
		super(new ImageIcon(".\\Icon\\SaveFile.png"));
		setToolTipText("Save File");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.saveFileAction(face);
			}
		});
	}
}
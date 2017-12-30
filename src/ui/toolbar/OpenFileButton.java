package ui.toolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import ui.ActionPerformFunction;
import ui.UserInterface;
public class OpenFileButton extends JButton{
	public OpenFileButton(UserInterface face) {
		super(new ImageIcon(".\\Icon\\OpenFile.gif"));
		setToolTipText("Open File");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ActionPerformFunction.openFileAction(face);
			}
		});
	}
}
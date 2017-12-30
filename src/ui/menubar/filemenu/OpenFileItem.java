package ui.menubar.filemenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.ActionPerformFunction;
import ui.MenuItem;
import ui.UserInterface;
public class OpenFileItem extends MenuItem{
	public OpenFileItem(UserInterface face) {
		super("Open File");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.openFileAction(face);
			}
		});
	}
}

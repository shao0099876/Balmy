package ui.menubar.filemenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.ActionPerformFunction;
import ui.MenuItem;
import ui.UserInterface;
public class SaveFileItem extends MenuItem{
	public SaveFileItem(UserInterface face) {
		super("Save File");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.saveFileAction(face);
			}
		});
	}
}

package ui.menubar.filemenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.ActionPerformFunction;
import ui.MenuItem;
import ui.UserInterface;
public class SaveAsItem extends MenuItem{
	public SaveAsItem(UserInterface face) {
		super("Save As");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.saveAsAction(face);
			}
		});
	}
}
package ui.menubar.filemenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.ActionPerformFunction;
import ui.MenuItem;
import ui.UserInterface;
public class CloseItem extends MenuItem{
	public CloseItem(UserInterface face) {
		super("Close");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.closeAction(face);
			}
		});
	}
}
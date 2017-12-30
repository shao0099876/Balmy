package ui.menubar.filemenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.ActionPerformFunction;
import ui.MenuItem;
import ui.UserInterface;
public class ExitItem extends MenuItem{
	public ExitItem(UserInterface face) {
		super("Exit");
		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.ExitAction();
			}
		});
	}
}
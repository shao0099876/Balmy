package ui.menubar.filemenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.MenuItem;
import ui.ActionPerformFunction;
public class NewFileItem extends MenuItem{
	public NewFileItem() {
		super("New File");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.newFileAction();
			}
		});
	}
}

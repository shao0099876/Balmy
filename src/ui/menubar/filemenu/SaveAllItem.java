package ui.menubar.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.ActionPerformFunction;
import ui.MenuItem;

public class SaveAllItem extends MenuItem{
	public SaveAllItem() {
		super("Save All");
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformFunction.saveAllAction();
			}
		});
	}
}

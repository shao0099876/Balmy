package ui.toolbar;
import javax.swing.JToolBar;
import ui.UserInterface;

public class ToolBar extends JToolBar{
	public ToolBar(UserInterface face) {
		super();
		add(new NewFileButton());
		add(new OpenFileButton(face));
		add(new SaveFileButton(face));
		add(new SaveAllFileButton(face));
	}
}
package ui.menubar.runmenu;
import javax.swing.JMenu;
import tools.PublicConst;
import ui.UserInterface;
public class RunMenu extends JMenu{
	public RunMenu(UserInterface face) {
		super("Run");
		setFont(PublicConst.font);
		add(new RunItem(face));
	}
	
}

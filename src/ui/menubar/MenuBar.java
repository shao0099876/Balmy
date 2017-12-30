package ui.menubar;
import javax.swing.JMenuBar;
import ui.UserInterface;
import ui.menubar.filemenu.FileMenu;
import ui.menubar.runmenu.RunMenu;
public class MenuBar extends JMenuBar{
	public MenuBar(UserInterface face) {
		super();
		add(new FileMenu(face));
		add(new RunMenu(face));
	}
	
}
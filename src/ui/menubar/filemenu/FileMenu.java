package ui.menubar.filemenu;
import ui.UserInterface;
import javax.swing.JMenu;
import tools.PublicConst;
public class FileMenu extends JMenu{
	public FileMenu(UserInterface face) {
		super("File");
		setFont(PublicConst.font);
		add(new NewFileItem());
		add(new OpenFileItem(face));
		add(new SaveFileItem(face));
		add(new SaveAsItem(face));
		add(new SaveAllItem());
		add(new CloseItem(face));
		add(new ExitItem(face));
	}
}
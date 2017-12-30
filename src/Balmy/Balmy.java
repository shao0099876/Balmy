package Balmy;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ui.UserInterface;
public class Balmy {
	private static String[] functionList=new String[] {"print","println","getAttrib","setAttrib"};
	private static String[] reservedWordList=new String[] {"print","println","getAttrib","setAttrib"};
	private static ArrayList<UserInterface> window=new ArrayList<UserInterface>();
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		addWindow();
	}
	public static boolean findReservedWordList(String s) {
		for(int i=0;i<reservedWordList.length;i++)
			if(reservedWordList[i].equals(s))
				return true;
		return false;
	}
	public static boolean findFunctionList(String s) {
		for(int i=0;i<functionList.length;i++)
			if(functionList[i].equals(s))
				return true;
		return false;
	}
	public static void addWindow() {
		window.add(new UserInterface("Untitled"+(window.size()+1)));
	}
	public static ArrayList<UserInterface> getWindow() {
		return window;
	}
}

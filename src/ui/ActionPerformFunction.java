package ui;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import Balmy.Balmy;
import tools.FileChooser;
import tools.ToolsFunction;
public class ActionPerformFunction {
	public static void newFileAction() {
		Balmy.addWindow();
	}
	public static void openFileAction(UserInterface face) {
		FileChooser chooser=new FileChooser();
		if(chooser.showOpenDialog(face)==JFileChooser.APPROVE_OPTION) {
			try {
				ToolsFunction.readFile(chooser,face.getTextArea());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			face.updateFilePath(chooser.getSelectedFile().getPath());
			face.setTitle(chooser.getSelectedFile().getName());
		}
	}
	public static void saveFileAction(UserInterface face) {
		if(face.getFilePath()!=null) {
			try {
				ToolsFunction.writeFile(face.getFilePath(),face.getTextArea());
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			return;
		}
		FileChooser chooser=new FileChooser();
		if(chooser.showSaveDialog(face)==JFileChooser.APPROVE_OPTION) {
			try {
				ToolsFunction.writeFile(chooser.getSelectedFile().getPath()+".balmy",face.getTextArea());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			face.updateFilePath(chooser.getSelectedFile().getPath()+".balmy");
			face.setTitle(chooser.getSelectedFile().getName());
		}
	}
	public static void saveAsAction(UserInterface face) {
		FileChooser chooser=new FileChooser();
		if(chooser.showSaveDialog(face)==JFileChooser.APPROVE_OPTION) {
			String path;
			if(face.getFilePath().equals(chooser.getSelectedFile().getPath()))
				path=face.getFilePath();
			else
				path=chooser.getSelectedFile().getPath()+".balmy";
			try {
				ToolsFunction.writeFile(path,face.getTextArea());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			face.updateFilePath(path);
			face.setTitle(chooser.getSelectedFile().getName());
		}
	}
	public static void closeAction(UserInterface face) {
		saveFileAction(face);
		ArrayList<UserInterface> window=Balmy.getWindow();
		window.remove(face);
		face.dispose();
	}
	public static void closeAllAction() {
		ArrayList<UserInterface> window=Balmy.getWindow();
		while(!window.isEmpty())
			closeAction(window.get(0));
	}
	public static void exitAction() {
		closeAllAction();
		System.exit(0);
	}
	public static void saveAllAction() {
		ArrayList<UserInterface> window=Balmy.getWindow();
		for(int i=0;i<window.size();i++)
			saveFileAction(window.get(i));
	}
}

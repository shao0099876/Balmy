package ui;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import tools.PublicConst;
import ui.menubar.MenuBar;
import ui.toolbar.ToolBar;
public class UserInterface extends JFrame{
	private JTextArea codeText=new JTextArea() {{
			setFont(PublicConst.font);
	}};
	private OutputArea outputText=new OutputArea();
	private String filePath=null;
	public UserInterface(String s) {
		super(s);
		setSize(1000,1000);
		JPanel mainFrame=new JPanel(new BorderLayout());
		JPanel mainFrame_north=new JPanel(new BorderLayout());
		mainFrame_north.add(BorderLayout.NORTH,new MenuBar(this));
		mainFrame_north.add(BorderLayout.CENTER,new ToolBar(this));
		mainFrame.add(BorderLayout.NORTH,mainFrame_north);
		mainFrame.add(BorderLayout.CENTER,new JScrollPane(codeText));
		mainFrame.add(BorderLayout.WEST,new TreeArea());
		System.setOut(new GUIPrintStream(System.out,outputText));
		mainFrame.add(BorderLayout.SOUTH, new JScrollPane(outputText));
		setContentPane(mainFrame);
		setVisible(true);
	}
	public JTextArea getTextArea() {
		return codeText;
	}
	public void updateFilePath(String s) {
		filePath=s;
	}
	public String getFilePath() {
		return filePath;
	}
}

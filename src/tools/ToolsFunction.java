package tools;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.swing.JTextArea;

import lexer.Token;
public class ToolsFunction {
	public static Token[] subList(Token[] list,int l,int r) {
		Token[] sub=new Token[r-l];
		int count=0;
		for(int i=l;i<r;i++)
			sub[count++]=list[i];
		return sub;
	}
	public static Token[] subList(ArrayList<Token> list,int l,int r) {
		Token[] sub=new Token[r-l];
		int count=0;
		for(int i=l;i<r;i++)
			sub[count++]=list.get(i);
		return sub;
	}
	public static int findBrackets(Token[] list,int pos) {
		int count=0;
		int res=0;
		if(list[pos].getText().equals("("))
			for(int i=pos+1;i<list.length;i++) {
				if(list[i].getText().equals("("))
					count+=1;
				if(list[i].getText().equals(")")) {
					if(count==0) {
						res=i;
						break;
					}
					count-=1;
				}
			}
		if(list[pos].getText().equals(")"))
			for(int i=pos-1;i>=0;i--) {
				if(list[i].getText().equals(")"))
					count+=1;
				if(list[i].getText().equals("(")) {
					if(count==0) {
						res=i;
						break;
					}
					count-=1;
				}
			}
		return res;
	}
	public static void readFile(FileChooser chooser,JTextArea codeText) throws IOException {
		BufferedReader fileInputReader=new BufferedReader(new FileReader(chooser.getSelectedFile()));
		String s;
		StringBuilder sb=new StringBuilder();
		while((s=fileInputReader.readLine())!=null)
			sb.append(s+"\n");
		codeText.setText(sb.toString());
		fileInputReader.close();
	}
	public static void writeFile(String s,JTextArea codeText) throws IOException {
		BufferedReader inputReader=new BufferedReader(new StringReader(codeText.getText()));
		BufferedWriter fileOutputWriter=new BufferedWriter(new FileWriter(s));
		String tmp;
		while((tmp=inputReader.readLine())!=null)
			fileOutputWriter.write(tmp+"\n");
		inputReader.close();
		fileOutputWriter.close();
	}
}

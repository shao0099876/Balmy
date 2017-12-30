package Balmy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import grammertree.Value;
import lexer.Inputer;
import lexer.Lexer;
import lexer.ParseException;
import lexer.Token;
import tools.ToolsFunction;
public class Resolve {//checked
	private Token[] list;
	private static HashMap<String,Value> varlist=new HashMap<String,Value>();
	public Resolve(String s) throws ParseException, IOException {
		Lexer l=new Lexer(new Inputer(s));
		ArrayList<Token> tmp=new ArrayList<Token>();
		for(Token t;(t=l.read())!=Token.EOF;)
			tmp.add(t);
		list=new Token[tmp.size()];
		for(int i=0;i<tmp.size();i++)
			list[i]=tmp.get(i);
		int pos=0,left=0;
		System.out.println("Balmy 0.1.0 coded by Shao Ruochen");;
		System.out.println("---------------------------------\n");
		while((pos=findEOL(left))!=-1) {
			new Analyse(ToolsFunction.subList(list,left,pos),varlist);
			left=pos+1;
		}
	}
	private int findEOL(int pos) {
		for(int i=pos;i<list.length;i++)
			if(list[i].getText().equals("\\n"))
				return i;
		return -1;
	}
}

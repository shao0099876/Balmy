package Balmy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import grammertree.GlobalFunction;
import grammertree.NodeType;
import grammertree.Operator;
import grammertree.Value;
import lexer.ParseException;
import lexer.Token;
import lexer.token.IdToken;
import tools.ToolsFunction;
import value.ValueType;
import value.object.ObjectType;
public class Analyse{
	private Token[] list=null;
	private static HashMap<String,Value> varlist=null;
	public Analyse(Token[] l,HashMap<String,Value> var) throws ParseException, IOException{
		list=l;
		varlist=var;
		if(!checkBrackets())
			return;
		analyse(list);
	}
	public static NodeType analyse(Token[] exp) throws IOException {
		if(exp[0].getText().equals("(")&&ToolsFunction.findBrackets(exp, 0)==exp.length-1)
			exp=ToolsFunction.subList(exp, 1, exp.length);
		for(int j=0;j<exp.length;j++) {
			Token t=exp[j];
			if(Operator.findOperatorList(0,t.getText()))
				return new Operator(exp,j,t);
			if(t.getText().equals("("))
				j=ToolsFunction.findBrackets(exp, j);
		}
		for(int i=1;i<Operator.operatorList.length;i++) {
			for(int j=exp.length-1;j>=0;j--) {
				Token t=exp[j];
				if(Operator.findOperatorList(i,t.getText()))
					return new Operator(exp,j,t);
				if(t.getText().equals(")")) 
					j=ToolsFunction.findBrackets(exp, j);
			}
		}
		if(exp.length==1) {
			Token t=exp[0];
			if(t instanceof IdToken) {
				if(!Balmy.findReservedWordList(t.getText())) {
					if(Analyse.varlist.containsKey(t.getText()))
						return Analyse.varlist.get(t.getText());
					Value tmp=new Value();
					Analyse.varlist.put(t.getText(),tmp);
					return tmp;
				}
			}
			else
				return new Value(t);
		}
		else{
			Token t=exp[0];
			if(t instanceof IdToken)
				if(Balmy.findFunctionList(t.getText()))
					return new GlobalFunction(ToolsFunction.subList(exp,1,exp.length),t);
		}
		return null;
	}
	private boolean checkBrackets() {
		Stack<Integer> t=new Stack<Integer>();
		for(int i=0;i<list.length;i++){
			if(list[i].getText().equals("("))
				t.push(new Integer(i));
			if(list[i].getText().equals(")")) {
				if(t.empty())
					return false;
				else t.pop();
			}
		}
		if(!t.empty())
			return false;
		return true;
	}
	public static ValueType[] parameterAnalyse(Token[] exp) throws IOException {
		exp=ToolsFunction.subList(exp, 1, ToolsFunction.findBrackets(exp, 0));
		ArrayList<ValueType> res=new ArrayList<ValueType>();
		int left=0;
		for(int i=0;i<exp.length;i++)
			if(exp[i].getText().equals(",")) {
				res.add(analyse(ToolsFunction.subList(exp, left, i)).getValue());
				left=i+1;
			}
		res.add(analyse(ToolsFunction.subList(exp, left, exp.length)).getValue());
		ValueType[] tmp=new ValueType[res.size()];
		for(int i=0;i<res.size();i++)
			tmp[i]=res.get(i);
		return tmp;
	}
	public static Value objectAnalyse(ObjectType obj, Token[] exp) throws IOException {
		Token t=exp[0];
		if(t instanceof IdToken) {
			if(obj.findFunctionList(t.getText()))
				return obj.functionAnalyse(ToolsFunction.subList(exp,1,exp.length),t);
		}
		return null;
	}
}
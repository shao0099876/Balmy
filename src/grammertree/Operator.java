package grammertree;
import java.io.IOException;
import Balmy.Analyse;
import lexer.Token;
import tools.ToolsFunction;
import value.IntType;
import value.StringType;
import value.object.ObjectType;
public class Operator extends NodeType{
	private NodeType left;
	private NodeType right;
	public static final String[][] operatorList=new String[][] {new String[] {"="},
																new String[] {"+","-"},
																new String[] {"*","/","%"},
																new String[] {"."}};
	public static boolean findOperatorList(int pos,String s) {
		for(int i=0;i<operatorList[pos].length;i++)
			if(operatorList[pos][i].equals(s))
				return true;
		return false;
	}
	public Operator(Token[]exp, int pos,Token t) throws IOException {
		switch(t.getText()) {
			case "=":{
				left=Analyse.analyse(ToolsFunction.subList(exp, 0, pos));
				right=Analyse.analyse(ToolsFunction.subList(exp, pos+1, exp.length));
				left.updateValue(right.getValue());
				updateValue(left.getValue());
				break;
			}
			case "+":{
				left=Analyse.analyse(ToolsFunction.subList(exp, 0, pos));
				right=Analyse.analyse(ToolsFunction.subList(exp, pos+1, exp.length));
				if(left.getValue() instanceof IntType&&right.getValue() instanceof IntType)
					updateValue(new IntType(left.getValue().toNum()+right.getValue().toNum()));
				if(left.getValue() instanceof StringType&&right.getValue() instanceof StringType)
					updateValue(new StringType(left.getValue().toString()+right.getValue().toString()));
				break;
			}
			case "-":{
				left=Analyse.analyse(ToolsFunction.subList(exp, 0, pos));
				right=Analyse.analyse(ToolsFunction.subList(exp, pos+1, exp.length));
				if(left.getValue() instanceof IntType&&right.getValue() instanceof IntType)
					updateValue(new IntType(left.getValue().toNum()-right.getValue().toNum()));
				break;
			}
			case "*":{
				left=Analyse.analyse(ToolsFunction.subList(exp, 0, pos));
				right=Analyse.analyse(ToolsFunction.subList(exp, pos+1, exp.length));
				if(left.getValue() instanceof IntType&&right.getValue() instanceof IntType)
					updateValue(new IntType(left.getValue().toNum()*right.getValue().toNum()));
				break;
			}
			case "/":{
				left=Analyse.analyse(ToolsFunction.subList(exp, 0, pos));
				right=Analyse.analyse(ToolsFunction.subList(exp, pos+1, exp.length));
				if(left.getValue() instanceof IntType&&right.getValue() instanceof IntType)
					updateValue(new IntType(left.getValue().toNum()/right.getValue().toNum()));
				break;
			}
			case "%":{
				left=Analyse.analyse(ToolsFunction.subList(exp, 0, pos));
				right=Analyse.analyse(ToolsFunction.subList(exp, pos+1, exp.length));
				if(left.getValue() instanceof IntType&&right.getValue() instanceof IntType)
					updateValue(new IntType(left.getValue().toNum()%right.getValue().toNum()));
				break;
			}
			case ".":{
				left=Analyse.analyse(ToolsFunction.subList(exp, 0, pos));
				right=Analyse.objectAnalyse((ObjectType) left.getValue(),ToolsFunction.subList(exp, pos+1, exp.length));
				updateValue(right.getValue());
			}
		}
	}
}
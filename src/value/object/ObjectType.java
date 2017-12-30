package value.object;
import java.io.IOException;
import grammertree.Value;
import lexer.Token;
import value.ValueType;
public abstract class ObjectType extends ValueType{
	public String[] functionList;
	public boolean findFunctionList(String s) {
		for(int i=0;i<functionList.length;i++)
			if(functionList[i].equals(s))
				return true;
		return false;
	}
	public abstract Value functionAnalyse(Token[] exp,Token t) throws IOException;
}

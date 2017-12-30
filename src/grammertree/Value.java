package grammertree;
import lexer.Token;
import lexer.token.IdToken;
import lexer.token.NumToken;
import lexer.token.StrToken;
import value.BoolType;
import value.IntType;
import value.StringType;
public class Value extends NodeType{
	public Value(Token t) {
		if(t instanceof NumToken)
			updateValue(new IntType(t.getNumber()));
		if(t instanceof StrToken)
			updateValue(new StringType(t.getText()));
		if(t instanceof IdToken)
			updateValue(new BoolType(t.getText()));
	}
	public Value() {}
}

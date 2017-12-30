package lexer.token;
import lexer.Token;
public class StrToken extends Token{
	private String literal;
	public StrToken(int line,String str){
		super(line);
		literal=str;
	}
	public String getText() {
		return literal;
	}
}

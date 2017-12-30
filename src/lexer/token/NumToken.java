package lexer.token;
import lexer.Token;
public class NumToken extends Token{
	private int value;
	public NumToken(int line,int v) {
		super(line);
		value=v;
	}
	public int getNumber() {
		return value;
	}
	public String getText() {
		return Integer.toString(value);
	}
}

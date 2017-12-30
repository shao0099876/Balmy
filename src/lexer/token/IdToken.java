package lexer.token;
import lexer.Token;
public class IdToken extends Token{
	private String text;
	public IdToken(int line,String id) {
		super(line);
		text=id;
	}
	public String getText() {
		return text;
	}
}

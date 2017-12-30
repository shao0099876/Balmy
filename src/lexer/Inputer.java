package lexer;
import java.io.IOException;
import java.io.Reader;
public class Inputer extends Reader{
	private String buffer=null;
	private int pos=0;
	public Inputer(String s){
		buffer=s;
	}
	@Override
	public void close() throws IOException {}
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		if(buffer==null)
			return -1;
		int size=0;
		int length=buffer.length();
		while(pos<length&&size<len)
			cbuf[off+size++]=buffer.charAt(pos++);
		if(pos==length)
			buffer=null;
		return size;
	}
}
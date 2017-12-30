package value.object;
import java.io.IOException;
import java.nio.file.attribute.DosFileAttributes;
import grammertree.Value;
import lexer.Token;
import value.BoolType;
public class FileAttribType extends ObjectType{
	public boolean read_only;
	public boolean archive;
	public boolean system;
	public boolean hidden;
	public FileAttribType() {
		functionList=new String[]{"isReadOnly","isArchive","isSystem","isHidden"};
	}
	public FileAttribType(DosFileAttributes attrib) {
		this();
		read_only=attrib.isReadOnly();
		archive=attrib.isArchive();
		system=attrib.isSystem();
		hidden=attrib.isHidden();
	}
	@Override
	public String toString() {
		return "Read-only:"+read_only+"\n"
				+"Archive:"+archive+"\n"
				+"System:"+system+"\n"
				+"Hidden:"+hidden+"\n";
	}
	@Override
	public int toNum() {
		return 0;
	}
	public Value functionAnalyse(Token[] exp,Token t) throws IOException {
		Value returnValue=new Value();
		switch(t.getText()) {
			case "isReadOnly":{
				returnValue.updateValue(new BoolType(read_only));
				break;
			}
			case "isArchive":{
				returnValue.updateValue(new BoolType(archive));
				break;
			}
			case "isSystem":{
				returnValue.updateValue(new BoolType(system));
				break;
			}
			case "isHidden":{
				returnValue.updateValue(new BoolType(hidden));
				break;
			}
		}
		return returnValue;
	}
	@Override
	public boolean toBool() {
		return false;
	}

}

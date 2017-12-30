package grammertree;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import Balmy.Analyse;
import lexer.Token;
import value.ValueType;
import value.VoidType;
import value.object.FileAttribType;
public class GlobalFunction extends Value{
	private static ValueType[] parameterList;
	public GlobalFunction(Token[] exp,Token t) throws IOException {
		parameterList=Analyse.parameterAnalyse(exp);
		switch(t.getText()) {
			case "print":{
				System.out.print(parameterList[0].toString());
				updateValue(new VoidType());
				break;
			}
			case "println":{
				System.out.println(parameterList[0].toString());
				updateValue(new VoidType());
				break;
			}
			case "getAttrib":{
				updateValue(new FileAttribType(Files.getFileAttributeView(Paths.get(parameterList[0].toString()),DosFileAttributeView.class).readAttributes()));
				break;
			}
			case "setAttrib":{
				DosFileAttributeView fileAttributeView=Files.getFileAttributeView(Paths.get(parameterList[0].toString()),DosFileAttributeView.class);
				fileAttributeView.setReadOnly(parameterList[1].toBool());
				fileAttributeView.setArchive(parameterList[2].toBool());
				fileAttributeView.setSystem(parameterList[3].toBool());
				fileAttributeView.setHidden(parameterList[4].toBool());
				updateValue(new VoidType());
				break;
			}
		}
	}
}
package value;

public class BoolType extends ValueType{
	private boolean data;
	public BoolType(String s) {
		if(s=="true")
			data=true;
		if(s=="false")
			data=false;
	}
	public BoolType(boolean x) {
		data=x;
	}
	@Override
	public String toString() {
		return Boolean.toString(data);
	}
	@Override
	public int toNum() {
		if(data)
			return 1;
		else
			return 0;
	}
	public boolean toBool() {
		return data;
	}
}

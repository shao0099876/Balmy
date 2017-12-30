package value;
public class IntType extends ValueType{
	public int data;
	public IntType(int x) {
		data=x;
	}
	public int toNum() {
		return data;
	}
	public String toString() {
		return Integer.toString(data);
	}
	public boolean toBool() {
		if(data!=0)
			return true;
		else
			return false;
	}
}

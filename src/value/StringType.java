package value;
public class StringType extends ValueType{
	public String data;
	public StringType(String x){
		data=x;
	}
	public String toString() {
		return data;
	}
	@Override
	public int toNum() {
		return 0;
	}
	public boolean toBool() {
		return false;
	}
}

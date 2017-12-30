package grammertree;
import value.ValueType;
public abstract class NodeType {
	private ValueType value;
	public ValueType getValue() {
		return value;
	}
	public void updateValue(ValueType v) {
		value=v;
	}
}

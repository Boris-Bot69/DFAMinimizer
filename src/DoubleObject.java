
public class DoubleObject {
	private final Object first;
	private final Object second;
	public DoubleObject(Object a, Object b) {
		first = a; second = b;
	}
	public <T> T getFirst() {
		return (T) first;
	}
	public <T> T getSecond() {
		return (T) second;
	}
	@Override
	public String toString() {
		return first.toString() + ", " + second.toString();
	}
	@Override
	public boolean equals(Object o) {
		DoubleObject d = (DoubleObject) o;
		if (d.getFirst().equals(first)) {
			if (d.getSecond().equals(second)) {
				return true;
			}
		}
		if (d.getSecond().equals(first)) {
			if (d.getFirst().equals(second)) {
				return true;
			}
		}
		return false;
	}
}

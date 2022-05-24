
public class KeyList<A, B> {
	private class KeyListElement {
		KeyListElement next;
		A a; B b;
		KeyListElement(A a, B b) {
			this.a = a;
			this.b = b;
		}
	}
	private KeyListElement head;
	public KeyList() {
		head = null;
	}
	public boolean insert(A key, B value) {
		if (head == null) {
			head = new KeyListElement(key, value);
			return true;
		}
		if (containsKey(key)) {
			return false;
		}
		KeyListElement current = head;
		while(true) {
			if (current.next == null) {
				current.next = new KeyListElement(key, value);
				return true;
			}
			current = current.next;
		}
	}
	public void remove(A key) {
		if (head.a == key) {
			head = head.next;
			return;
		}
		KeyListElement current = head;
		while(true) {
			if (current.next == null) {
				return;
			}
			if (current.next.a == key) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	public boolean containsKey(A key) {
		KeyListElement current = head;
		while(true) {
			if (current == null) {
				return false;
			}
			if (current.a.equals(key)) {
				return true;
			}
			current = current.next;
		}
	}
	public B get(A key) {
		KeyListElement current = head;
		while(true) {
			if (current == null) {
				return null;
			}
			if (current.a.equals(key)) {
				return current.b;
			}
			current = current.next;
		}
	}
	@Override
	public String toString() {
		String ret = "";
		KeyListElement c = head;
		while(true) {
			if (c == null) {
				return ret;
			}
			ret += c.a.toString() + ": " + c.b.toString() + "\n";
			c = c.next;
		}
	}
}

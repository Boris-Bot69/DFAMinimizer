
public class DFA {
	public static char[] getChars(char... c) {
		return c;
	}
	public final char[] alphabet;
	public final State[] states;
	public DFA(char[] alphabet, State[] states) {
		this.alphabet = alphabet;
		this.states = states;
	}
	public static KeyList<DoubleObject, String> minimize(DFA m) {
		KeyList<DoubleObject, String> table = new KeyList<>();
		//alle endzustaende und nicht endzustaende kombinationen markieren
		for (State a : m.states) {
			for (State b : m.states) {
				if (table.containsKey(new DoubleObject(a, b))) {
					continue;
				}
				if (a.isEndState()) {
					if (!b.isEndState()) {
						table.insert(new DoubleObject(a, b), "");
						continue;
					}
				}
				if (b.isEndState()) {
					if (!a.isEndState()) {
						table.insert(new DoubleObject(a, b), "");
					}
				}
			}
		}
		boolean nothingFound = true;
		while(true) {
			for (State a : m.states) {
				for (State b : m.states) {
					if (table.containsKey(new DoubleObject(a, b))) {
						continue;
					}
					for (char c : m.alphabet) {
						State aNext = a.transition(c);
						State bNext = b.transition(c);
						if (table.containsKey(new DoubleObject(aNext, bNext))) {
							nothingFound = false;
							String difference = c + table.get(new DoubleObject(aNext, bNext));
							table.insert(new DoubleObject(a, b), difference);
							break;
						}
					}
				}
			}
			if (nothingFound) {
				for (State a : m.states) {
					for (State b : m.states) {
						if (table.containsKey(new DoubleObject(a, b))) {
							continue;
						}
						if (a.getName().equals(b.getName())) {
							continue;
						}
						table.insert(new DoubleObject(a, b), "=");
					}
				}
				return table;
			}
			nothingFound = true;
		}
	}
}

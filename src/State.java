
public class State {
	@FunctionalInterface
	public interface TransitionFunction {
		public String apply(char inputChar);
	}
	private final TransitionFunction transitions;
	private final String name;
	public String getName() {
		return name;
	}
	private final boolean endState;
	public boolean isEndState() {
		return endState;
	}
	public State transition(char c) {
		return new State(transitions.apply(c), false, null);
	}
	public State(String n, boolean e, TransitionFunction t) {
		name = n;
		endState = e;
		transitions = t;
	}
	@Override
	public String toString() {
		return name;
	}
	@Override
	public boolean equals(Object o) {
		if (o instanceof String) {
			String s = (String) o;
			return s.equals(name);
		}
		State s = (State) o;
		return s.getName().equals(name);
	}
}


public class Minimizer {
	public static State.TransitionFunction f(char c, String s) {
		return x -> s;
	}
	public static State.TransitionFunction f(char c1, String s1, char c2, String s2) {
		return x -> {
			if (x == c1) {
				return s1;
			}
			if (x == c2) {
				return s2;
			}
			return "b";
		};
	}
	public static State.TransitionFunction f(char c1, String s1, char c2, String s2, char c3, String s3) {
		return x -> {
			if (x == c1) {
				return s1;
			}
			if (x == c2) {
				return s2;
			}
			if (x == c3) {
				return s3;
			}
			return "b";
		};
	}
	public static State.TransitionFunction f(char c1, String s1, char c2, String s2, char c3, String s3, char c4, String s4) {
		return x -> {
			if (x == c1) {
				return s1;
			}
			if (x == c2) {
				return s2;
			}
			if (x == c3) {
				return s3;
			}
			if (x == c4) {
				return s4;
			}
			return "b";
		};
	}
	public static State.TransitionFunction f(char c1, String s1, char c2, String s2, char c3, String s3, char c4, String s4, char c5, String s5) {
		return x -> {
			if (x == c1) {
				return s1;
			}
			if (x == c2) {
				return s2;
			}
			if (x == c3) {
				return s3;
			}
			if (x == c4) {
				return s4;
			}
			if (x == c5) {
				return s5;
			}
			return "b";
		};
	}
	public static State.TransitionFunction f(char c1, String s1, char c2, String s2, char c3, String s3, char c4, String s4, char c5, String s5, char c6, String s6) {
		return x -> {
			if (x == c1) {
				return s1;
			}
			if (x == c2) {
				return s2;
			}
			if (x == c3) {
				return s3;
			}
			if (x == c4) {
				return s4;
			}
			if (x == c5) {
				return s5;
			}
			if (x == c6) {
				return s6;
			}
			return "b";
		};
	}
	public static void main(String[] args) {
		char[] alphabet = {'a', 'b'};
		State[] states = {new State("0", false, f('a', "1",'b', "0")), 
				new State("1", true, f('a', "4", 'b', "2")), 
				new State("2", true, f('a', "3", 'b', "1")),
				new State("3", false, f('a', "5", 'b', "1")),
				new State("4", false, f('a', "5", 'b', "2")),
				new State("5", false, f('a', "1", 'b', "5"))};
		DFA d = new DFA(alphabet, states);
		System.out.println(DFA.minimize(d));
	}
}

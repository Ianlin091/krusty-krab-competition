package decorator;

public abstract class Component {
	public static void add(Component component) {
		throw new UnsupportedOperationException();
	}
	public static void remove(Component component) {
		throw new UnsupportedOperationException();
	}

	public abstract String dressup();
}

package decorator;

public class CD_SbH1 extends Decorator{
	String sb = "_h1";
	public CD_SbH1(Component component) {
		super(component);
	}
	
	public String dressup() {
		return component.dressup() + sb;
	}
}

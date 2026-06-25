package decorator;

public class CD_SbH2 extends Decorator{
	String sb = "_h2";
	public CD_SbH2(Component component) {
		super(component);
	}
	
	public String dressup() {
		return component.dressup() + sb;
	}

}

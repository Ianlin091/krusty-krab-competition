package decorator;

public class CD_PtH1 extends Decorator{
	String pt = "_h1";
	public CD_PtH1(Component component) {
		super(component);
	}
	
	public String dressup() {
		return component.dressup() + pt;
	}
	
}

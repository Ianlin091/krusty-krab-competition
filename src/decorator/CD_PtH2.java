package decorator;

public class CD_PtH2 extends Decorator{
	String pt = "_h2";
	public CD_PtH2(Component component) {
		super(component);
	}
	
	public String dressup() {
		return component.dressup() + pt;
	}

}

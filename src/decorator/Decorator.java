package decorator;

import java.util.ArrayList;
import java.util.List;

abstract public class Decorator extends Component{
	Component component;
	static List<String> pt = new ArrayList<>();
	static List<String> sb = new ArrayList<>();
	
	Decorator(Component component){
		this.component = component;
	}
	
	public static void add(CD_SbH1 component) {
		sb.add(component.dressup());
	}
	public static void add(CD_SbH2 component) {
		sb.add(component.dressup());
	}
	
	public static void add(CD_PtH1 component) {
		pt.add(component.dressup());
	}
	public static void add(CD_PtH2 component) {
		pt.add(component.dressup());
	}
	
	public static void remove(CD_SbH1 component) {
		sb.remove(component.dressup());
	}
	public static void remove(CD_SbH2 component) {
		sb.remove(component.dressup());
	}
	
	public static void remove(CD_PtH1 component) {
		pt.remove(component.dressup());
	}
	public static void remove(CD_PtH2 component) {
		pt.remove(component.dressup());
	}
	
	abstract public String dressup();
	
}

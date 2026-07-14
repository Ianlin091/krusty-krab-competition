package decorator;

public class ConcretePt extends Component{
	static String ad;
	public ConcretePt(){
		ad = "pt_ord";
	}
	public static void add(Component component) {}
	public static void remove(Component component) {}
	public String dressup() {return ad;}

}

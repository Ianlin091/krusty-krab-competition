package decorator;

public class ConcreteSb extends Component{
	static String ad;
	public ConcreteSb(){
		ad = "sb_ord";
	}
	public static void add(Component component) {}
	public static void remove(Component component) {}
	public String dressup() {return ad;}

}

package flyweight_observer;

//ConcreteSubject
public class ConcreteSubject extends FlyweightFactory{
	Observer pt = new PtScoreLabel();
	Observer sb = new SbScoreLabel();
	
	public void notify(String name, int score) {
		switch(name){
	        case "pt":
	        	ptScore += score;
	        	pt.update(getScoreLabel("pt", 735, -190), ptScore);
	            break;
	        case "sb":
	        	sbScore += score;
	            sb.update(getScoreLabel("sb", 5, -190), sbScore);
	            break;
		}
		
	}
	public int getPtScore() {
		return ptScore;
	}
	public int getSbScore() {
		return sbScore;
	}
}

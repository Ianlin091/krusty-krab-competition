package flyweight_observer;

import javax.swing.JLabel;

//ConcreteObserver
public class PtScoreLabel implements Observer{
	//public int ptScore = 0;
	public void update(JLabel pt, int score) {
		//ptScore += score;
		pt.setText(score + "");
	}

}

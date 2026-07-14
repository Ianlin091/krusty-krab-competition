package flyweight_observer;

import javax.swing.JLabel;

//ConcreteObserver
public class SbScoreLabel implements Observer{
	//int sbScore = 0;
	public void update(JLabel sb, int score) {
		//sbScore += score;
		//sb.getScoreLabel("sb", 5, -190).setText(sbScore + "");
		sb.setText(score + "");
	}

}

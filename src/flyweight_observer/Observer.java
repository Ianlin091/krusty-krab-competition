package flyweight_observer;

import javax.swing.JLabel;

interface Observer {
	void update(JLabel jl, int score);
}

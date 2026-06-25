package command;

import javax.swing.ImageIcon;
import krusty_krab_competition.RulesAndChoices;
import krusty_krab_competition.KrustyKrab_Controller;
import state.*;

public class Receiver {
	public static String shat = "hat", phat = "hat";
	public static ImageIcon image = null;
	public void sbhat() {
		image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/sb.png"));
		image = KrustyKrab_Controller.change(image, 0.5);
		RulesAndChoices.sb.setBounds(120, 240, 400, 300);
		RulesAndChoices.sb.setIcon(image);
		shat = "hat";
	}
	
	public void sbhat1() {
		image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/sb_chis.png"));
		image = KrustyKrab_Controller.change(image, 0.5);
		RulesAndChoices.sb.setBounds(120, 240, 400, 300);
		RulesAndChoices.sb.setIcon(image);
		shat = "hat1";
	}

	public void sbhat2() {
		image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/sb_home.png"));
		image = KrustyKrab_Controller.change(image, 0.5);
		RulesAndChoices.sb.setBounds(120, 240, 400, 300);
		RulesAndChoices.sb.setIcon(image);
		shat = "hat2";
	}

	public void pthat() {
		image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/pt.png"));
		image = KrustyKrab_Controller.change(image, 0.5);
		RulesAndChoices.pt.setBounds(570, 250, 400, 300);
		RulesAndChoices.pt.setIcon(image);
		phat = "hat";
	}
	
	public void pthat1() {
		image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/pt_chis.png"));
		image = KrustyKrab_Controller.change(image, 0.5);
		RulesAndChoices.pt.setBounds(570, 245, 400, 300);
		RulesAndChoices.pt.setIcon(image);
		phat = "hat1";
	}

	public void pthat2() {
		image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/page/pt_home.png"));
		image = KrustyKrab_Controller.change(image, 0.5);
		RulesAndChoices.pt.setBounds(570, 242, 400, 300);
		RulesAndChoices.pt.setIcon(image);
		phat = "hat2";
	}
}

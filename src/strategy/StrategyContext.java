package strategy;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import krusty_krab_competition.*;
import state.*;

public class StrategyContext {

	public static ImageIcon wordLabel = null, sign = null;

	public static void strategyMethod() {
		StatePrestart.frame.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (KrustyKrab_Controller.gameOver) {
					return;
				} else {
					int keyCode = e.getKeyCode();

					if (keyCode == KeyEvent.VK_S && !KrustyKrab_Controller.dKeyPressed
							&& !KrustyKrab_Controller.sKeyPressed) {
						SbKeyStrategy strategy_sbord = new StrategySbord();
						strategy_sbord.sbKeyPress();
					}
					if (keyCode == KeyEvent.VK_D && !KrustyKrab_Controller.sKeyPressed
							&& !KrustyKrab_Controller.dKeyPressed && KrustyKrab_Controller.l == 2) {
						SbKeyStrategy strategy_sbup = new StrategySbup();
						strategy_sbup.sbKeyPress();
					}
					if (keyCode == KeyEvent.VK_K && !KrustyKrab_Controller.lKeyPressed
							&& !KrustyKrab_Controller.kKeyPressed) {
						PtKeyStrategy strategy_ptord = new StrategyPtord();
						strategy_ptord.ptKeyPress();
					}
					if (keyCode == KeyEvent.VK_L && !KrustyKrab_Controller.kKeyPressed
							&& !KrustyKrab_Controller.lKeyPressed && KrustyKrab_Controller.r == 2) {
						PtKeyStrategy strategy_ptup = new StrategyPtup();
						strategy_ptup.ptKeyPress();
					}
				}

			}

		});
	}
}

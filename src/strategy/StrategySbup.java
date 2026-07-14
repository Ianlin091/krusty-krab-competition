package strategy;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import flyweight_observer.FlyweightFactory;
import krusty_krab_competition.RulesAndChoices;
import krusty_krab_competition.KrustyKrab_Controller;
import state.StatePrestart;

public class StrategySbup implements SbKeyStrategy {
	public static ImageIcon wordLabel = null, sign = null;
	
	// keypressed
	public int aKeyPressCount = 0; // 用來計數"A"鍵的按下次數

	public void sbKeyPress() {

		// D键事件
		KrustyKrab_Controller.dKeyPressed = true;

		// sign
		wordLabel = new ImageIcon(getClass().getResource("/krusty_krab_competition/other/牌.png"));
		sign = KrustyKrab_Controller.change(wordLabel, 1.1);
		KrustyKrab_Controller.signl.setIcon(sign); // 設置新圖
		//

		wordLabel = new ImageIcon(getClass().getResource("/krusty_krab_competition/" + RulesAndChoices.sbupad + "/01.png"));
		wordLabel = KrustyKrab_Controller.change(wordLabel, 0.9);
		JLabel sbLabel = FlyweightFactory.getCharacterLabel("sb_ord", -50, 350);
		sbLabel.setIcon(wordLabel); // 設置新圖片
		aKeyPressCount = 0; // 重置A按幾次計數器

		StatePrestart.frame.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();
				if (KrustyKrab_Controller.dKeyPressed && keyCode == KeyEvent.VK_A && aKeyPressCount < 7) {
					// 先按D後才能有A键事件
					wordLabel = new ImageIcon(
							getClass().getResource("/krusty_krab_competition/" + RulesAndChoices.sbupad + "/0" + (aKeyPressCount + 2) + ".png"));
					wordLabel = KrustyKrab_Controller.change(wordLabel, 0.9);
					sbLabel.setIcon(wordLabel); // 設置新圖
					aKeyPressCount++;

					if (aKeyPressCount == 7) {
						KrustyKrab_Controller.dKeyPressed = false; // A键按7次後，重置D键狀態，等待下一次D键事件
						//KrustyKrab_Controller.sbScore += 3;
						//KrustyKrab_Controller.sb_getscore(KrustyKrab_Controller.sbScore);
						scoreLabel.notify("sb", 3);

						wordLabel = new ImageIcon(getClass().getResource("/krusty_krab_competition/" + RulesAndChoices.sbupad + "/00.png"));
						wordLabel = KrustyKrab_Controller.change(wordLabel, 0.9);
						sbLabel.setIcon(wordLabel); // 設置新圖片
						KrustyKrab_Controller.sb_signlight();

					}
				}
			}
		});
	}
}

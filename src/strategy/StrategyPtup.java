package strategy;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import flyweight_observer.FlyweightFactory;
import krusty_krab_competition.RulesAndChoices;
import krusty_krab_competition.KrustyKrab_Controller;
import state.StatePrestart;

public class StrategyPtup implements PtKeyStrategy {
	public static ImageIcon wordLabel = null, sign = null;

	// keypressed
	public int jKeyPressCount = 0; // 用來計數"J"鍵的按下次數

	public void ptKeyPress() {

		// L键事件
		KrustyKrab_Controller.lKeyPressed = true;

		// sign
		wordLabel = new ImageIcon(getClass().getResource("/krusty_krab_competition/other/牌.png"));
		sign = KrustyKrab_Controller.change(wordLabel, 1.1);
		KrustyKrab_Controller.signr.setIcon(sign); // 設置新圖
		//

		wordLabel = new ImageIcon(getClass().getResource("/krusty_krab_competition/" + RulesAndChoices.ptupad + "/01.png"));
		wordLabel = KrustyKrab_Controller.change(wordLabel, 0.9);
		JLabel ptLabel = FlyweightFactory.getCharacterLabel("pt_ord", 460, 340);
		ptLabel.setIcon(wordLabel); // 設置新圖片
		jKeyPressCount = 0; // 重置J按幾次計數器

		StatePrestart.frame.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();
				if (KrustyKrab_Controller.lKeyPressed && keyCode == KeyEvent.VK_J && jKeyPressCount < 7) {
					// 先按L後才能有J键事件
					wordLabel = new ImageIcon(
							getClass().getResource("/krusty_krab_competition/" + RulesAndChoices.ptupad + "/0" + (jKeyPressCount + 2) + ".png"));
					wordLabel = KrustyKrab_Controller.change(wordLabel, 0.9);
					ptLabel.setIcon(wordLabel); // 設置新圖
					jKeyPressCount++;

					if (jKeyPressCount == 7) {
						KrustyKrab_Controller.lKeyPressed = false; // J键按7次後，重置L键狀態，等待下一次J键事件
						//KrustyKrab_Controller.ptScore += 3;
						//KrustyKrab_Controller.pt_getscore(KrustyKrab_Controller.ptScore);
						scoreLabel.notify("pt", 3);

						wordLabel = new ImageIcon(getClass().getResource("/krusty_krab_competition/" + RulesAndChoices.ptupad + "/00.png"));
						wordLabel = KrustyKrab_Controller.change(wordLabel, 0.9);
						ptLabel.setIcon(wordLabel); // 設置新圖片
						KrustyKrab_Controller.pt_signlight();
					}
				}
			}
		});
	}
}


package krusty_krab_competition;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import state.StateContext;
import state.StatePrestart;

public class KrustyKrab_Controller {
	public static JPanel contentPanel = null, imagePanel = null;
	public static ImageIcon background = null, sign = null, wordLabel = null;
	public static JLabel bgLabel = null, signl = null, signr = null;

	// start button
	protected static ImageIcon image = null;
	static ImageIcon button = null;
	static ImageIcon play = null;
	static ImageIcon game_rules = null;

	// timer
	public static Timer timer, count;
	public static int timeLeft = 30, seconds = 3;
	public static boolean gameOver = false; // 判斷遊戲是否結束
	protected static JLabel timerLabel = null;

	// keypressed
	public static boolean sKeyPressed = false; // 用來標記是否按下了"S"鍵(派大普通)
	public static boolean dKeyPressed = false; // 用來標記是否按下了"D"鍵(派大高級)
	public static boolean kKeyPressed = false; // 用來標記是否按下了"K"鍵(海綿普通)
	public static boolean lKeyPressed = false; // 用來標記是否按下了"L"鍵(海綿高級)

	// end
	public static ImageIcon end = null;
	public static ImageIcon e_left = null;
	public static JLabel endl = null;
	public static JLabel e_left2 = null;

	// signr、l
	public static int r = 0;
	public static int l = 0;

	public static void main(String[] args) {
		// context_prestart
		StateContext context = new StateContext();
		context.execution(context);

	}

	public static ImageIcon change(ImageIcon image, double i) {
		int width = (int) (image.getIconWidth() * i);
		int height = (int) (image.getIconHeight() * i);
		Image img = image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		ImageIcon image2 = new ImageIcon(img);
		return image2;
	}

	public static void pt_signlight() {
		int i = 0;
		// random
		// r
		i = (int) (Math.random() * 2) + 1;
		if (i == 1) {
			wordLabel = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/普通亮.png"));
			sign = KrustyKrab_Controller.change(wordLabel, 1.1);
			signr.setIcon(sign); // 設置新圖
		} else if (i == 2) {
			wordLabel = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/普通高級亮.png"));
			sign = KrustyKrab_Controller.change(wordLabel, 1.1);
			signr.setIcon(sign); // 設置新圖
		}
		// return i;
		r = i;
	}

	public static void sb_signlight() {
		int i = 0;
		// random
		// l
		i = (int) (Math.random() * 2) + 1;
		if (i == 1) {
			wordLabel = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/普通亮.png"));
			sign = KrustyKrab_Controller.change(wordLabel, 1.1);
			signl.setIcon(sign); // 設置新圖
		} else if (i == 2) {
			wordLabel = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/普通高級亮.png"));
			sign = KrustyKrab_Controller.change(wordLabel, 1.1);
			signl.setIcon(sign); // 設置新圖
		}
		// return i;
		l = i;
	}

	public boolean GameOver(boolean value) {
		if (!value) {
			return true;
		}
		return value;
	}

	public static void resetGame() {
		timeLeft = 30;
		seconds = 3;
		gameOver = false;
		sKeyPressed = false;
		dKeyPressed = false;
		kKeyPressed = false;
		lKeyPressed = false;
		r = 0;
		l = 0;

		RulesAndChoices.sbsize = false;
		RulesAndChoices.ptsize = false;
		RulesAndChoices.sbundo = false;
		RulesAndChoices.ptundo = false;
		RulesAndChoices.bgpic = "b1";
		RulesAndChoices.seconds = 3;

		command.Receiver.shat = "hat";
		command.Receiver.phat = "hat";

		flyweight_observer.FlyweightFactory.reset();
	}
}

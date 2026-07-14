package state;

//client
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import krusty_krab_competition.*;

public class StateStart extends AbsState {
	public static JLabel label1 = null, playl = null, dress1 = null, bg1 = null;

	public void execute(StateContext context) {
		// start
		image = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/board.png"));
		image = KrustyKrab_Controller.change(image, 1);
		label1 = new JLabel(image);
		label1.setBounds(200, 200, 600, 400);
		StatePrestart.frame.getLayeredPane().add(label1, BorderLayout.CENTER);

		// click
		label1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				RulesAndChoices receive = new RulesAndChoices();
				receive.ready();
				// play
				playl.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						receive.dress();
						// dress
						dress1.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {
								receive.selectbg(true);
								// bg
								bg1.addMouseListener(new MouseAdapter() {
									public void mouseClicked(MouseEvent e) {
										receive.play();
									}
								});
							}
						});
					}
				});
				//nextbutton
			}
		});

		// Create a timer to limit the game to 30 seconds
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timeLeft--; // 每次觸發計時器事件就會-1秒
				timerLabel.setText("" + timeLeft); // 更新剩餘秒數
				if (timeLeft == 0) {
					timer.stop();
					
					gameOver = GameOver(gameOver);
					
					//end
			     	context.setState(new StateEnd());
			     	context.execution(context);
				}
			}
		});
	}
}

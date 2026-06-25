package state;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import flyweight_observer.FlyweightFactory;
import krusty_krab_competition.KrustyKrab_Controller;

public class StateEnd extends AbsState {
	public void execute(StateContext context) {
		// timer
		seconds = 2;
		count = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seconds--;
				if (seconds == 1) {
					// 顯示END
					end = new ImageIcon(StatePrestart.class.getResource("/krusty_krab_competition/other/End.png"));
					end = KrustyKrab_Controller.change(end, 0.3);
					endl = new JLabel(end);
					endl.setBounds(230, 100, 600, 400);
					StatePrestart.frame.getLayeredPane().add(endl, new Integer(Integer.MAX_VALUE));

				}
				if (seconds < 0) {
					count.stop();

					endl.setVisible(false);
					StatePrestart.frame.remove(endl);
					signr.setVisible(false);
					StatePrestart.frame.remove(signr);
					signl.setVisible(false);
					StatePrestart.frame.remove(signl);

					// 顯示贏家
					if (FlyweightFactory.sbScore > FlyweightFactory.ptScore) {
						e_left = new ImageIcon(
								StatePrestart.class.getResource("/krusty_krab_competition/other/sbw.png"));
						e_left = KrustyKrab_Controller.change(e_left, 0.75);
						e_left2 = new JLabel(e_left);
						e_left2.setBounds(0, -16, 1090, 800);
						StatePrestart.frame.getLayeredPane().add(e_left2, BorderLayout.CENTER);

					} else if (FlyweightFactory.sbScore < FlyweightFactory.ptScore) {
						e_left = new ImageIcon(
								StatePrestart.class.getResource("/krusty_krab_competition/other/ptw.png"));
						e_left = KrustyKrab_Controller.change(e_left, 0.75);
						e_left2 = new JLabel(e_left);
						e_left2.setBounds(0, -16, 1090, 800);
						StatePrestart.frame.getLayeredPane().add(e_left2, BorderLayout.CENTER);

					} else {
						e_left = new ImageIcon(
								StatePrestart.class.getResource("/krusty_krab_competition/other/T.png"));
						e_left = KrustyKrab_Controller.change(e_left, 0.75);
						e_left2 = new JLabel(e_left);
						e_left2.setBounds(0, -16, 1090, 800);
						StatePrestart.frame.getLayeredPane().add(e_left2, BorderLayout.CENTER);

					}

					// 點擊贏家畫面重新開始遊戲
					if (e_left2 != null) {
						e_left2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
						e_left2.setToolTipText("點擊畫面重新開始遊戲");
						e_left2.addMouseListener(new java.awt.event.MouseAdapter() {
							public void mouseClicked(java.awt.event.MouseEvent evt) {
								int response = javax.swing.JOptionPane.showConfirmDialog(
									StatePrestart.frame,
									"是否要重新開始遊戲，並重新選擇角色及場地？",
									"重新開始確認",
									javax.swing.JOptionPane.YES_NO_OPTION,
									javax.swing.JOptionPane.QUESTION_MESSAGE
								);
								if (response == javax.swing.JOptionPane.YES_OPTION) {
									KrustyKrab_Controller.resetGame();
									StateContext newContext = new StateContext();
									newContext.execution(newContext);
								}
							}
						});
					}
				}
			}
		});
		count.start();
	}
}

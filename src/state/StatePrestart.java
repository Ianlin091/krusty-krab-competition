package state;

import javax.swing.*;

import flyweight_observer.FlyweightFactory;
import krusty_krab_competition.KrustyKrab_Controller;

import java.awt.*;


public class StatePrestart extends AbsState{	
    public static JFrame frame = new JFrame();
    public static ImageIcon background = null, wordLabel = null;
    
    public void execute(StateContext context) {
        if (frame != null) {
            frame.dispose();
        }
        frame = new JFrame();
    	// 1.設置frame title及Layout之類型
    	frame.setTitle("krusty_krab_competition");
    	frame.setLayout(new BorderLayout());
        
        // 2.設置要顯示之資訊與元件
    	contentPanel = new JPanel();
    	contentPanel.setLayout(null);
    	contentPanel.setOpaque(false);
    	
    	//scoreLabel1
    	JLabel scoreLabel = FlyweightFactory.getScoreLabel("sb", 5, -190);
    	contentPanel.add(scoreLabel);
    	frame.setContentPane(contentPanel);
    	
    	//scoreLabel2
    	JLabel scoreLabel2 = FlyweightFactory.getScoreLabel("pt", 735, -190);
    	contentPanel.add(scoreLabel2);
    	frame.setContentPane(contentPanel);

        //倒數計時 JLabel
        timerLabel = new JLabel("" + timeLeft);
        KrustyKrab_Controller.timerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setBounds(347, 10, 400, 100); 
        contentPanel.add(KrustyKrab_Controller.timerLabel);
        
        //派大
        JLabel ptLabel = FlyweightFactory.getCharacterLabel("pt_ord", 460, 340);
        frame.getLayeredPane().add(ptLabel, new Integer(Integer.MIN_VALUE));
        
        //海綿
        JLabel sbLabel = FlyweightFactory.getCharacterLabel("sb_ord", -50, 350);
        frame.getLayeredPane().add(sbLabel, new Integer(Integer.MIN_VALUE));
        
      //牌子L
        wordLabel = new ImageIcon(getClass().getResource("/krusty_krab_competition/other/牌.png"));
        wordLabel = change(wordLabel,1.1);
        signl = new JLabel(wordLabel);   
        signl.setBounds(-80, -20, 400, 400);
        frame.getLayeredPane().add(signl, new Integer(Integer.MIN_VALUE));
        
      //牌子R
        wordLabel = new ImageIcon(getClass().getResource("/krusty_krab_competition/other/牌.png"));
        wordLabel = change(wordLabel,1.1);
        signr = new JLabel(wordLabel);   
        signr.setBounds(760, -20, 400, 400);
        frame.getLayeredPane().add(signr, new Integer(Integer.MIN_VALUE));
        
        // 3.於JFrame中設置背景圖片 - 圖片無法縮放大小
        background = new ImageIcon(getClass().getResource("/krusty_krab_competition/other/background.png"));       // 背景圖片
        background = change(background,0.75);
        bgLabel = new JLabel(background);      // 把背景圖顯示在Label中
        bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());    // 把含有背景圖之Label位置設置為圖片剛好填充整個版面
        // 把内容視窗轉為JPanel，否則不能使用setOpaque()來使視窗變成透明
        imagePanel = (JPanel) frame.getContentPane();
        imagePanel.setOpaque(false);
        frame.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));     // 把背景圖添加到分層窗格的最底層以作為背景
        
        // 4.設置frame之基本設定
        frame.setMinimumSize(new java.awt.Dimension(1090, 800));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
        //start;
     	context.setState(new StateStart());
     	context.execution(context);
        
    }
    
}
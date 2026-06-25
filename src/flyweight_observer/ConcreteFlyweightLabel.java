package flyweight_observer;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import krusty_krab_competition.KrustyKrab_Controller;

//ConcreteFlyweight
public class ConcreteFlyweightLabel implements FlyweightLabel {
    // 內部狀態key
    private String key; 
    //用角色名當key，去factory的map就用這個key取出專屬於那個角色的ScoreLabel
    ConcreteFlyweightLabel(String key) {
        this.key = key;
        //this.show(x, y);
    }
    
    //score
    public JLabel show(int x, int y) {
        JLabel Label = new JLabel("0");
    	Label.setFont(new Font("Arial", Font.BOLD, 50));       // 字體大小
    	Label.setHorizontalAlignment(SwingConstants.CENTER);   // 字體置中
    	Label.setBounds(x, y, 500, 500);                     // 調整文字位置
        return Label;
    }
    
    //character
    public JLabel showcha(int x, int y) {
    	ImageIcon cha = new ImageIcon(getClass().getResource("/krusty_krab_competition/" + key + "/00.png"));
    	cha = KrustyKrab_Controller.change(cha,0.9);
    	JLabel label = new JLabel(cha);     
    	label.setBounds(x, y, 700, 700);

        return label;
    }
}

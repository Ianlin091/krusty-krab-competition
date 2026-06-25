package flyweight_observer;

import javax.swing.JLabel;

//Flyweight
interface FlyweightLabel {
    // 外部狀態 x,y --> 記分板位置
    public JLabel show(int x, int y);
	public JLabel showcha(int x, int y);
    
}
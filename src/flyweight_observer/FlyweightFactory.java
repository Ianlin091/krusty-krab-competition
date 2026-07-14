package flyweight_observer;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

// FlyweightFactory, Observer_subject
abstract public class FlyweightFactory {
    private static final Map<String, JLabel> labelCache = new HashMap<>();
    private static Map<String, JLabel> ScorelabelCache = new HashMap<>();
    public static int sbScore = 0;
    public static int ptScore = 0;

    public static void reset() {
        labelCache.clear();
        ScorelabelCache.clear();
        sbScore = 0;
        ptScore = 0;
    }
	
    // create a shared scoreboard label
    public static JLabel getScoreLabel(String key, int x, int y) {
    	JLabel js = ScorelabelCache.get(key);

        if (js != null) {
            return js;
        } else {
            FlyweightLabel sl = new ConcreteFlyweightLabel(key);
            js = sl.show(x, y);
            
            //add method
            ScorelabelCache.put(key, js);
        }
        return js;
    }
    
 // create a shared character label
    public static JLabel getCharacterLabel(String key, int x, int y) {
    	JLabel js = labelCache.get(key);

        if (js != null) {
            return js;
        } else {
            FlyweightLabel sl = new ConcreteFlyweightLabel(key);
            js = sl.showcha(x, y);
            
            labelCache.put(key, js);
        }
        return js;
    }
    
    public abstract void notify(String name, int score);

}

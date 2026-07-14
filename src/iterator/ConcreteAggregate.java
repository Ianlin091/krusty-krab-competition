package iterator;

import java.util.*;

public class ConcreteAggregate implements Aggregate { 
    private List<String> list = new ArrayList<String>();
    public void add(String ad) { 
        list.add(ad); 
    }
    public void remove(String ad) { 
        list.remove(ad); 
    }
    public Iterator getIterator() {
        return(new ConcreteIterator(list)); 
    }
}

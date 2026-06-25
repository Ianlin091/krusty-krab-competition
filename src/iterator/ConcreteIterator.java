package iterator;

import java.util.*;

public class ConcreteIterator implements Iterator { 
    private List<String> list = null; 
    private int index = 0; 
    public ConcreteIterator(List<String> list) { 
        this.list=list; 
    } 
    public boolean hasNext() { 
        if(index < list.size()) { 
            return true;
        }
        else {
            return false;
        }
    }
    public String next() {
    	String ad = null; 
        if(this.hasNext() && index < 2) {
            ad = list.get(++index); 
        } else {
        	ad = list.get(index);
        }
        return ad; 
    }   
    public String previous() {
    	String ad = null; 
        if(this.hasNext() && index > 0) { 
            ad = list.get(--index); 
        } else {
        	ad = list.get(index);
        }
        return ad; 
    }  
}

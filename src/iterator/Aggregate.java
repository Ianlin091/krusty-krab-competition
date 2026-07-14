package iterator;

public interface Aggregate { 
    public void add(String ad);
    public void remove(String ad); 
    public Iterator getIterator(); 
}

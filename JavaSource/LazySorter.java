import java.util.Comparator;
import org.primefaces.model.SortOrder;

import vancouver.model.StreetTree;
 
public class LazySorter implements Comparator<StreetTree> {
 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    public int compare(StreetTree tree1, StreetTree tree2) {
        try {
            Object value1 = StreetTree.class.getField(this.sortField).get(tree1);
            Object value2 = StreetTree.class.getField(this.sortField).get(tree2);
 
            int value = ((Comparable<Object>)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
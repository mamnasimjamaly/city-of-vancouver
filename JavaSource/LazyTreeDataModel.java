import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vancouver.model.StreetTree;
 
/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class LazyTreeDataModel extends LazyDataModel<StreetTree> {
     
    private List<StreetTree> datasource;
     
    public LazyTreeDataModel(List<StreetTree> datasource) {
        this.datasource = datasource;
    }
     
    @Override
    public StreetTree getRowData(String rowKey) {
        for(StreetTree tree : datasource) {
            if(tree.getCivicNumber().toString().equals(rowKey))
                return tree;
        }
 
        return null;
    }
 
    @Override
    public Object getRowKey(StreetTree tree) {
        return tree.getCivicNumber().toString();
    }
 
    @Override
    public List<StreetTree> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<StreetTree> data = new ArrayList<StreetTree>();
 
        //filter
        for(StreetTree tree : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(tree.getClass().getField(filterProperty).get(tree).toString());
 
                        if(filterValue == null || fieldValue.toString().startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                data.add(tree);
            }
        }
 
        //sort
        if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }
 
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}
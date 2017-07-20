import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.primefaces.model.LazyDataModel;

import vancouver.model.StreetTree;
import vancouver.model.Utils;

@Named("trees")
@SessionScoped
public class StreetTreesDataAccess implements Serializable {
	
	private LazyDataModel<StreetTree> lazyModel;
	private List<StreetTree> streetTrees;
	
	public StreetTreesDataAccess() {
		setStreetTrees(readTreeData());
	}
	

	public List<StreetTree> getStreetTrees() {
		return streetTrees;
	}

	public void setStreetTrees(List<StreetTree> streetTrees) {
		this.streetTrees = streetTrees;
	}
	
	@PostConstruct
    public void init() {
        lazyModel = new LazyTreeDataModel(readTreeData());
    }
 
    public LazyDataModel<StreetTree> getLazyModel() {
        return lazyModel;
    }

	private List<StreetTree> readTreeData() {

		ArrayList<StreetTree> treesData  = new ArrayList<>();
		JsonReader reader;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream txtInput = classLoader.getResourceAsStream("StreetTrees_ArbutusRidge.json");
		reader = Json.createReader(txtInput);
		JsonObject jsonObject = reader.readObject();
		JsonArray jsonArray = (JsonArray) jsonObject.get("features");
		for(int i = 0 ; i < jsonArray.size() ; i++) {
			JsonObject tree = (JsonObject) jsonArray.get(i);
			JsonObject treeProperties = (JsonObject) tree.get("properties");
			
			treesData.add(
					new StreetTree(
							treeProperties.getInt("TREE_ID"),
							treeProperties.getInt("CIVIC_NUMBER"),
							treeProperties.getString("STD_STREET"),
							treeProperties.getString("NEIGHBOURHOOD_NAME"),
							treeProperties.getString("ON_STREET"),
							treeProperties.getInt("ON_STREET_BLOCK"),
							treeProperties.getString("STREET_SIDE_NAME"),
							treeProperties.getString("ASSIGNED"),
							treeProperties.getInt("HEIGHT_RANGE_ID"),
							treeProperties.getInt("DIAMETER"),
							parseDate(treeProperties.getString("DATE_PLANTED")),
							treeProperties.get("PLANT_AREA").toString(),
							treeProperties.getString("ROOT_BARRIER"),
							treeProperties.getString("CURB"),
							treeProperties.getString("CULTIVAR_NAME"),
							treeProperties.getString("GENUS_NAME"),
							treeProperties.getString("SPECIES_NAME"),
							treeProperties.getString("COMMON_NAME"),
							Double.parseDouble(treeProperties.getJsonNumber("LATITUDE").toString()),
							Double.parseDouble(treeProperties.getJsonNumber("LONGITUDE").toString())
							)
					);
		}
		
		System.out.println(treesData.get(3000).getDatePlanted());
        
		return treesData;
	}
	
	/*
	 * Convert from string to Date object
	 * */ 
	private static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyyMMdd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }

	
/*	public static void main(String[] args) {
		new StreetTreesDataAccess().readTreeData();
	}
*/

}

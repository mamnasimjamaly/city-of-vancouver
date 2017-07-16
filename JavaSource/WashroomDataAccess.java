import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import vancouver.model.PublicWashroom;

@Named("rooms")
@SessionScoped
public class WashroomDataAccess implements Serializable {

	private String searchText;

	private ArrayList<PublicWashroom> washrooms;
	
	private boolean wheelChairAccess;
	
	private String searchCriteria;

	/*Default constructor.*/
	public WashroomDataAccess() {
		try {
			washrooms = getWashroomData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		searchCriteria = "name";
	}
	
	private static Map<String, String> searchTypes;
	static{
		searchTypes = new LinkedHashMap<String,String>();
		searchTypes.put("Name", "name"); 
		searchTypes.put("Address", "address");
	}

	public String getSearchText() {
		return searchText;
	}


	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}


	public ArrayList<PublicWashroom> getWashrooms() {
		return this.search();
	}


	public void setWashrooms(ArrayList<PublicWashroom> washrooms) {
		this.washrooms = washrooms;
	}

	

	public Map<String,String> getSearchTypes() {
		return searchTypes;
	}

	public String getSearchCriteria() {
		return searchCriteria;
	}


	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	
	
	public ArrayList<PublicWashroom> getWashroomData() throws Exception {
		URL url = null;
		ArrayList<PublicWashroom> washrooms = new ArrayList<>();
		try {
			url = new URL("ftp://webftp.vancouver.ca/OpenData/csv/public_washrooms.csv");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openStream()));

		String inputLine;
		inputLine = in.readLine();
		while ((inputLine = in.readLine()) != null) {
			String[] data = inputLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			PublicWashroom room = new PublicWashroom(
					Integer.parseInt(data[0]), data[1], data[2], data[3], data[4].replaceAll("^\"|\"$", ""), data[5], 
					data[6], data[7].replaceAll("^\"|\"$", "").substring(0,1),
					data[8], Double.parseDouble(data[9]), 
					Double.parseDouble(data[10]), data[11]
					);
			washrooms.add(room);

		}
		in.close();
		return washrooms;
	}

	public ArrayList<PublicWashroom> search() {
		ArrayList<PublicWashroom> filteredRooms = new ArrayList<>();
		if(this.searchText == null) {
			return this.washrooms;
		}

		if(this.searchCriteria.equals("name")) {
			for (PublicWashroom room : washrooms) {
				if(room.getName().toLowerCase().contains(searchText.toLowerCase())) {
					filteredRooms.add(room);
				}

			}
		} else if(this.searchCriteria.equals("address")) {
			for (PublicWashroom room : washrooms) {
				if(room.getAddress().toLowerCase().contains(searchText.toLowerCase())) {
					filteredRooms.add(room);
				}

			}
		}
		
		return filteredRooms;
	}

	public String clearSearch() {
		this.searchText = null;
		System.out.println("CLEAR SEARCH");
		return null;
	}
	
	public String clearFilter() {
		try {
			this.washrooms = this.getWashroomData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.wheelChairAccess = false;
		return null;
	}
	
	public String applyFilter() {
		ArrayList<PublicWashroom> rooms = new ArrayList<>();
		for(PublicWashroom room : this.washrooms) {
			if(this.wheelChairAccess) {
				if(room.getWheelchair_access().equalsIgnoreCase("y")){
					rooms.add(room);
				}
			} else {
				if(room.getWheelchair_access().equalsIgnoreCase("n")){
					rooms.add(room);
				}
			}
		}
		this.washrooms = rooms;
		return null;
	}


	public boolean isWheelChairAccess() {
		return wheelChairAccess;
	}


	public void setWheelChairAccess(boolean wheelChairAccess) {
		this.wheelChairAccess = wheelChairAccess;
	}


	
	

	//	public static void main(String[] args) throws Exception {
	//		ArrayList<PublicWashroom> rooms = getWashroomData();
	//		
	//		for(PublicWashroom room : rooms) {
	//			System.out.println(room.getAddress());
	//		}
	//		
	//	}
}

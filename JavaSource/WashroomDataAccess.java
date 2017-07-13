import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import vancouver.model.PublicWashroom;

@Named("rooms")
@SessionScoped
public class WashroomDataAccess implements Serializable {
	
	/*Default constructor.*/
	public WashroomDataAccess() {}
	
	
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
			        			Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], 
			        			data[6], data[7],
			        			data[8], Double.parseDouble(data[9]), 
			        			Double.parseDouble(data[10]), data[11]
			        			);
			        	washrooms.add(room);
			        	
			        }
			        in.close();
		return washrooms;
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

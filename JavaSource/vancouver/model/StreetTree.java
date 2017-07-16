package vancouver.model;

import java.util.Date;

public class StreetTree {
	Integer treeId;
	Integer civicNumber;
	String stdStreet;
	String neighbourhoodName;
	String onStreet;
	Integer onStreetBlock;
	String streetSideName;
	String assigned;
	Integer heightRangeId;
	Integer diameter;
	Date datePlanted;
	String plantArea;
	String rootBarrier;
	String curb;
	String cultivarName;
	String genus;
	String species;
	String commonName;
	Double lattitude;
	Double longitude;
	
	public StreetTree(Integer treeId, Integer civicNumber, String stdStreet, String neighbourhoodName, String onStreet,
			Integer onStreetBlock, String streetSideName, String assigned, Integer heightRangeId, Integer diameter,
			Date datePlanted, String plantArea, String rootBarrier, String curb, String cultivarName, String genus,
			String species, String commonName, Double lattitude, Double longitude) {
		super();
		this.treeId = treeId;
		this.civicNumber = civicNumber;
		this.stdStreet = stdStreet;
		this.neighbourhoodName = neighbourhoodName;
		this.onStreet = onStreet;
		this.onStreetBlock = onStreetBlock;
		this.streetSideName = streetSideName;
		this.assigned = assigned;
		this.heightRangeId = heightRangeId;
		this.diameter = diameter;
		this.datePlanted = datePlanted;
		this.plantArea = plantArea;
		this.rootBarrier = rootBarrier;
		this.curb = curb;
		this.cultivarName = cultivarName;
		this.genus = genus;
		this.species = species;
		this.commonName = commonName;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	public Integer getTreeId() {
		return treeId;
	}

	public void setTreeId(Integer treeId) {
		this.treeId = treeId;
	}

	public Integer getCivicNumber() {
		return civicNumber;
	}

	public void setCivicNumber(Integer civicNumber) {
		this.civicNumber = civicNumber;
	}

	public String getStdStreet() {
		return stdStreet;
	}

	public void setStdStreet(String stdStreet) {
		this.stdStreet = stdStreet;
	}

	public String getNeighbourhoodName() {
		return neighbourhoodName;
	}

	public void setNeighbourhoodName(String neighbourhoodName) {
		this.neighbourhoodName = neighbourhoodName;
	}

	public String getOnStreet() {
		return onStreet;
	}

	public void setOnStreet(String onStreet) {
		this.onStreet = onStreet;
	}

	public Integer getOnStreetBlock() {
		return onStreetBlock;
	}

	public void setOnStreetBlock(Integer onStreetBlock) {
		this.onStreetBlock = onStreetBlock;
	}

	public String getStreetSideName() {
		return streetSideName;
	}

	public void setStreetSideName(String streetSideName) {
		this.streetSideName = streetSideName;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public Integer getHeightRangeId() {
		return heightRangeId;
	}

	public void setHeightRangeId(Integer heightRangeId) {
		this.heightRangeId = heightRangeId;
	}

	public Integer getDiameter() {
		return diameter;
	}

	public void setDiameter(Integer diameter) {
		this.diameter = diameter;
	}

	public Date getDatePlanted() {
		return datePlanted;
	}

	public void setDatePlanted(Date datePlanted) {
		this.datePlanted = datePlanted;
	}

	public String getPlantArea() {
		return plantArea;
	}

	public void setPlantArea(String plantArea) {
		this.plantArea = plantArea;
	}

	public String getRootBarrier() {
		return rootBarrier;
	}

	public void setRootBarrier(String rootBarrier) {
		this.rootBarrier = rootBarrier;
	}

	public String getCurb() {
		return curb;
	}

	public void setCurb(String curb) {
		this.curb = curb;
	}

	public String getCultivarName() {
		return cultivarName;
	}

	public void setCultivarName(String cultivarName) {
		this.cultivarName = cultivarName;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
	
}

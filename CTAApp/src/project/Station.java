package project;


public class Station {
	// Variables
	private String name;
	private double lat;
	private double lon;
	private String elevation;
	private boolean wheelchair;
	private int red;
	private int green;
	private int brown;
	private int pink;
	private int blue;
	private int purple;
	private int orange;
	
	// Default constructor
	public Station() {
		name = "";
		lat = 0;
		lon = 0;
		elevation = "standard";
		wheelchair = false;
		red = -1;
		green = -1;
		brown = -1;
		purple = -1;
		pink = -1;
		orange = -1;
		blue = -1;
	}
	// Non-default constructor
	public Station(String name_input, double lat_input, double lon_input, String elevation_input, boolean wheelchair_input, int red_input, int green_input, int brown_input, int purple_input, int pink_input, int orange_input, int blue_input) {
		name = name_input;
		lat = lat_input;
		lon = lon_input;
		elevation = elevation_input;
		wheelchair = wheelchair_input;
		red = red_input;
		green = green_input;
		brown = brown_input;
		purple = purple_input;
		pink = pink_input;
		orange = orange_input;
		blue = blue_input;
	}
	// Getters and Setters for every variable
	public String getName() {
		return name;
	}
	public void setName(String name_input) {
		name = name_input;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat_input) {
		lat = lat_input;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon_input) {
		lon = lon_input;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation_input) {
		elevation = elevation_input;
	}
	public Boolean getWheelchair() {
		return wheelchair;
	}
	public void setWheelchair(boolean wheelchair_input) {
		wheelchair = wheelchair_input;
	}
	public int getRed() {
		return red;
	}
	public void setRed(int red_input) {
		red = red_input;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green_input) {
		green = green_input;
	}
	public int getPurple() {
		return purple;
	}
	public void setPurple(int purple_input) {
		purple = purple_input;
	}
	public int getBrown() {
		return brown;
	}
	public void setBrown(int brown_input) {
		brown = brown_input;
	}
	public int getPink() {
		return pink;
	}
	public void setPink(int pink_input) {
		pink = pink_input;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue_input) {
		blue = blue_input;
	}
	public int getOrange() {
		return orange;
	}
	public void setOrange(int orange_input) {
		orange = orange_input;
	}
	// toString method
	public String toString() {
		return name + " " + lat + " " + lon  + " " + elevation + " " + wheelchair + " red: " + red + " green: " + green + " blue: " + blue + " brown: " + brown + " orange: " + orange + " pink: " + pink + " purple: " + purple;
	}
	// Test to see if object obj is identical to the station.
	public boolean equals(Object obj) {
		if (!(obj instanceof Station)) {
			return false;
		}
		
		Station s = (Station)obj;
		if (name != s.getName()) {
			return false;
		} else if (lat != s.getLat()) {
			return false;
		} else if (lon != s.getLon()) {
			return false;
		} else if (elevation != s.getElevation()) {
			return false;
		} else if (wheelchair != s.getWheelchair()) {
			return false;
		} else if (red != s.getRed()) {
			return false;
		} else if (brown != s.getBrown()) {
			return false;
		} else if (pink != s.getPink()) {
			return false;
		} else if (green != s.getGreen()) {
			return false;
		} else if (orange != s.getOrange()) {
			return false;
		} else if (purple != s.getPurple()) {
			return false;
		} else if (blue != s.getBlue()) {
			return false;
		} 
		return true;
	}

}

package project;

public class Route {
	// Variables
	String start_stat_name;
	String end_stat_name;
	String start_color;
	String end_color;
	// Association Variable
	Path[] paths;
	
	// Default constructor
	public Route() {
		start_stat_name = "";
		end_stat_name = "";
		start_color = "";
		end_color = "";
	}
	// Non-default constructor
	public Route(String start_stat, String end_stat, String color1, String color2) {
		start_stat_name = start_stat;
		end_stat_name = end_stat;
		start_color = color1;
		end_color = color2;
	}
	// Getters and Setters for all variables
	public String getStartStat() {
		return start_stat_name;
	} 
	public void setStartStat(String start_stat) {
		start_stat_name = start_stat;
	}
	public String getEndStat() {
		return end_stat_name;
	} 
	public void setEndStat(String end_stat) {
		end_stat_name = end_stat;
	}
	public String getStartColor() {
		return start_color;
	} 
	public void setStartColor(String color1) {
		start_color = color1;
	}
	public String getEndColor() {
		return end_color;
	} 
	public void setEndColor(String color1) {
		end_color = color1;
	}
	public void setPaths(Path[] paths_input) {
		paths = paths_input;
	}
	public Path[] getPaths() {
		return paths;
	}
	// toString method
	public String toString() {
		return start_color + " line " + start_stat_name + " to " + end_color + " line " + end_stat_name; 
	}
	// Checks to see if obj is identical
	public boolean equals(Object obj) {
		if (!(obj instanceof Route)) {
			return false;
		}
		
		Route r = (Route)obj;
		if (start_stat_name != r.getStartStat()) {
			return false;
		} else if (start_color != r.getStartColor()) {
			return false;
		} else if (end_color != r.getEndColor()) {
			return false;
		} else if (end_stat_name != r.getEndStat()) {
			return false;
		} 
		return true;
	}
	// Checks to see if the start and end color are the same
	public boolean simple_path() {
		if (start_color.equals(end_color)) {
			return true;
		} else {
			return false;
		}
	}
	// Finds the distance on the train line
	public int findDistance(int stat_1, int stat_2) {
		if (stat_2 > stat_1) {
			return stat_2 - stat_1;
		} else {
			return stat_1 - stat_2;
		}
	}

}

package project;


public class Path extends Route {
	// Inheritance class
	
	// default constructor
	public Path() {
		super.setEndColor("");
		super.setStartColor("");
		super.setStartStat("");
		super.setEndStat("");
	}
	// Non-default constructor
	public Path(String color1, String color2, String start_stat, String end_stat) {
		super.setEndColor(color1);
		super.setStartColor(color2);
		super.setStartStat(start_stat);
		super.setEndStat(end_stat);
	}
	//tests to see if obj is identical
	public boolean equals(Object obj) {
		if (!(obj instanceof Path)) {
			return false;
		}
		
		Path p = (Path)obj;
		if (!super.equals(p)) {
			return false;
		} 
		
		return true;
	}
	// distance is always either 1 or 0 (0 if it is just switching colors at the same station, 1 if it is movement between station)
	public int findDistance(int stat_1, int stat_2) {
		if (stat_1 == stat_2) {
			return 0;
		}
		return 1;
	}
	// Default version of findDistance, always returns 1
	public int findDistance() {
		return 1;
	}
}

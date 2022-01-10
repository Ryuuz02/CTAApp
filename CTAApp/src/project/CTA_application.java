package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CTA_application {
	// Test plan was used to find errors
	
	// Prints the menu for the user
	public static void print_menu() {
		System.out.println("Please select the action you would like to take below  \n 1: Add Station  \n 2: Modify "
				+ "Station  \n 3: Remove Station  \n 4: Search by name  \n 5: Search by Criteria  \n 6: Find Nearest "
				+ "Station  \n 7: Generate Path  \n 8: Exit");
	}
	// Adds a station that the user specifies the variables for. Adds it to the end of stations then returns that array list.
	public static ArrayList<Station> add_station(ArrayList<Station> stations) {
		// Initializing variables
		Scanner user_input = new Scanner(System.in);
		String temp_input = "";
		boolean running = true;
		double station_lat = 0;
		double station_lon = 0;
		String station_elevation = "";
		boolean station_wheelchair = false;
		int station_red = -1;
		int station_green = -1;
		int station_brown = -1;
		int station_purple = -1;
		int station_pink = -1;
		int station_orange = -1;
		int station_blue = -1;
		// Variables for station, constantly checks that it has valid input so that an error does not occur
		System.out.println("What is the name of the station?");
		String station_name = user_input.nextLine();
		if (running) {
			System.out.println("What is the latitude of the station?");
			temp_input = user_input.nextLine();
			if (check_double(temp_input) ) {
				station_lat = Double.parseDouble(temp_input);
			} else {
				System.out.println("Invalid Input");
				running = false;
			}
		}
		if (running) {
			System.out.println("What is the latitude of the station?");
			temp_input = user_input.nextLine();
			if (check_double(temp_input) ) {
				station_lon = Double.parseDouble(temp_input);
			} else {
				System.out.println("Invalid Input");
				running = false;
			}
		}
		if (running) {
			System.out.println("What is the elevation of the station?");
			station_elevation = user_input.nextLine();
		}
		if (running) {
			System.out.println("Is there wheelchair access on the station (true or false)?");
			temp_input = user_input.nextLine();
			if (check_boolean(temp_input) ) {
				station_wheelchair = Boolean.parseBoolean(temp_input);
			} else {
				System.out.println("Invalid Input");
				running = false;
			}
		}
		if (running) {
			System.out.println("What stop is it on the red line?");
			temp_input = user_input.nextLine();
			station_red = check_color(temp_input);
			if (station_red == -2) {
				running = false;
			}
		}
		if (running) {
			System.out.println("What stop is it on the green line?");
			temp_input = user_input.nextLine();
			station_green = check_color(temp_input);
			if (station_green == -2) {
				running = false;
			}
		}
		if (running) {
			System.out.println("What stop is it on the brown line?");
			temp_input = user_input.nextLine();
			station_brown = check_color(temp_input);
			if (station_brown == -2) {
				running = false;
			}
		}
		if (running) {
			System.out.println("What stop is it on the purple line?");
			temp_input = user_input.nextLine();
			station_purple = check_color(temp_input);
			if (station_purple == -2) {
				running = false;
			}
		}
		if (running) {
			System.out.println("What stop is it on the pink line?");
			temp_input = user_input.nextLine();
			station_pink = check_color(temp_input);
			if (station_pink == -2) {
				running = false;
			}
		}
		if (running) {
			System.out.println("What stop is it on the orange line?");
			temp_input = user_input.nextLine();
			station_orange = check_color(temp_input);
			if (station_orange == -2) {
				running = false;
			}
		}
		if (running) {
			System.out.println("What stop is it on the blue line?");
			temp_input = user_input.nextLine();
			station_blue = check_color(temp_input);
			if (station_blue == -2) {
				running = false;
			}
		}
		// Adds the created station to the end of stations array list
		if (running) {
			stations.add(new Station(station_name, station_lat, station_lon, station_elevation, station_wheelchair, station_red, station_green, station_brown, station_purple, station_pink, station_orange, station_blue));
		}
		return stations;
		 
	}
	// User specifies a station, then what criteria to change, then changes it
	public static ArrayList<Station> modify_station(ArrayList<Station> stations) {
		Scanner user_input = new Scanner(System.in);
		System.out.println("Which station would you like to modify?");
		String station_choice = user_input.nextLine();
		boolean hit_station = false;
		for (int i = 0; i < stations.size(); i++) {
			// If its the searched for station
			if (stations.get(i).getName().equalsIgnoreCase(station_choice)) {
				hit_station = true;
				System.out.println("Which would would you like to modify about it (lat, lon, name, elevation, wheelchair, red, green, blue, pink, brown, purple, orange)?");
				String data_choice = user_input.nextLine();
				String user_choice;
				// Will use a switch case to find the criteria the user wants to change, then use setters to change it
				switch (data_choice) {
				case "name":
					System.out.println("What would you like to rename it to?");
					user_choice = user_input.nextLine();
					stations.get(i).setName(user_choice);
					break;
				case "lat":
					System.out.println("What should the new latitude be?");
					user_choice = user_input.nextLine();
					if (check_double(user_choice)) {
						stations.get(i).setLat(Double.parseDouble(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "lon":
					System.out.println("What should the new longitude be?");
					user_choice = user_input.nextLine();
					if (check_double(user_choice)) {
						stations.get(i).setLon(Double.parseDouble(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "elevation":
					System.out.println("What is the new elevation?");
					user_choice = user_input.nextLine();
					stations.get(i).setElevation(user_choice);
					break;
				case "wheelchair":
					System.out.println("Is it wheelchair accessible (true or false)?");
					user_choice = user_input.nextLine();
					if (check_boolean(user_choice)) {
						stations.get(i).setWheelchair(Boolean.parseBoolean(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "red":
					System.out.println("What is the new red stop number?");
					user_choice = user_input.nextLine();
					if (check_int(user_choice)) {
						stations.get(i).setRed(Integer.parseInt(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "green":
					System.out.println("What is the new green stop number?");
					user_choice = user_input.nextLine();
					if (check_int(user_choice)) {
						stations.get(i).setGreen(Integer.parseInt(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "brown":
					System.out.println("What is the new brown stop number?");
					user_choice = user_input.nextLine();
					if (check_int(user_choice)) {
						stations.get(i).setBrown(Integer.parseInt(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "purple":
					System.out.println("What is the new purple stop number?");
					user_choice = user_input.nextLine();
					if (check_int(user_choice)) {
						stations.get(i).setPurple(Integer.parseInt(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "orange":
					System.out.println("What is the new orange stop number?");
					user_choice = user_input.nextLine();
					if (check_int(user_choice)) {
						stations.get(i).setOrange(Integer.parseInt(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "blue":
					System.out.println("What is the new blue stop number?");
					user_choice = user_input.nextLine();
					if (check_int(user_choice)) {
						stations.get(i).setBlue(Integer.parseInt(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				case "pink":
					System.out.println("What is the new pink stop number?");
					user_choice = user_input.nextLine();
					if (check_int(user_choice)) {
						stations.get(i).setPink(Integer.parseInt(user_choice));
					} else {
						System.out.println("Invalid input");
					}
					break;
				// If the variable does not exist
				default:
					System.out.println("That variable was not found");
				}
			}
		}
		// If it could not find the station
		if (!hit_station) {
			System.out.println("Station not found");
		}
		return stations;
		
	}
	// User puts in the name of the station that they want to remove. The system then searches for that station and removes it from the list.
	public static ArrayList<Station> remove_station(ArrayList<Station> stations) {
		Scanner user_input = new Scanner(System.in);
		System.out.println("What is the name of the station that you would like to remove?");
		String removal_choice = user_input.nextLine();
		boolean station_found = false;
		// for every station in the arraylist, checks their name
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getName().equalsIgnoreCase(removal_choice)) {
				// if it matches the name, then removes it
				station_found = true;
				stations.remove(i);
			}
		}
		// If it wasn't found, tells the user
		if (!station_found) {
			System.out.println("Could not find that station");
		}
		return stations;
	}
	// The user inputs a name, the system then finds the station that matches that name, then returns the information tied to that station.
	public static void search_name(ArrayList<Station> stations) {
		Scanner user_input = new Scanner(System.in);
		System.out.println("What is the name of the station that you would to find?");
		String search_choice = user_input.nextLine();
		boolean station_found = false;
		// For every station in the array list
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getName().equalsIgnoreCase(search_choice)) {
				station_found = true;
				// Prints out the information for the stations that match that name
				System.out.println("Found " + stations.get(i).toString());
			}
		}
		// if not found, tells the user
		if (!station_found) {
			System.out.println("Could not find that station");
		}
	}
	// Asks the user for what variable they want to search for (ex. latitiude, longitute, elevation, etc.). then asks what value they want to find of that, and tells them about all stations that fit that variable
	public static void search_criteria(ArrayList<Station> stations) {
		Scanner user_input = new Scanner(System.in);
		System.out.println("What value of stations would you like to search by (lat, lon, elevation, wheelchair, red, blue, pink, purple, orange, brown, green)?");
		String search_method = user_input.nextLine();
		System.out.println("And what value of " + search_method + " would you like to search by");
		String search_choice = user_input.nextLine();
		boolean station_found = false;
		switch (search_method) {
		// Switch case for every variable. For every variable, basically converts the user input value they want to search by to the matching primitive type, then prints out all stations that match that criteria
		case "lat":
			if (check_double(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getLat() == (Double.parseDouble(search_choice))) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "lon":
			if (check_double(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getLon() == (Double.parseDouble(search_choice))) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "elevation":
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getElevation().equalsIgnoreCase(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
				break;
		case "wheelchair":
			if (check_boolean(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getWheelchair() == Boolean.parseBoolean(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "red":
			if (check_int(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getRed() == Integer.parseInt(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "blue":
			if (check_int(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getBlue() == Integer.parseInt(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "orange":
			if (check_int(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getOrange() == Integer.parseInt(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "green":
			if (check_int(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getGreen() == Integer.parseInt(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "pink":
			if (check_int(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getPink() == Integer.parseInt(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "purple":
			if (check_int(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getPurple() == Integer.parseInt(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		case "brown":
			if (check_int(search_choice)) {
				for (int i = 0; i < stations.size(); i++) {
					if (stations.get(i).getBrown() == Integer.parseInt(search_choice)) {
						station_found = true;
						System.out.println("Found " + stations.get(i).toString());
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			break;
		// If the user tries to search by something that does not exist, tells them
		default:
			station_found = true;
			System.out.println("That search criteria does not exist");
		
		}
		// if the station is not found, tells the user.
		if (!station_found) {
			System.out.println("Could not find that station");
		}
	}
	// The user gives the system their latitude and longitude. The system then uses pythagorean theorem to find their nearest station by distance (assumes you could directly walk there by diagonal between you and the station)
	public static void find_nearest(ArrayList<Station> stations) {
		Scanner user_input = new Scanner(System.in);
		System.out.println("What is your latitude?");
		String temp_input = user_input.nextLine();
		double lat_input = 0;
		double lon_input = 0;
		String chosen_station = "";
		boolean running = true;
		// if the input actually fits the primitive type we are trying to convert to, will convert it
		if (check_double(temp_input)) {
			lat_input = Double.parseDouble(temp_input);
		} else {
			System.out.println("Invalid input");
			running = false;
		}
		// does the same for longitude as it did for latitude
		if (running) {
			System.out.println("What is your longitude?");
			temp_input = user_input.nextLine();
			if (check_double(temp_input)) {
				lon_input = Double.parseDouble(temp_input);
			} else {
				System.out.println("Invalid input");
				running = false;
			}
		}
		if (running) {
			double distance = 100000;
			for (int i = 0; i < stations.size(); i++) {
				// uses pythagorean theorem to find the sides of the triangle between user and station, then finds hypotonuse as temp_distance
				double lat_difference = stations.get(i).getLat() - lat_input;
				double lon_difference = stations.get(i).getLon() - lon_input;
				double temp_distance = Math.sqrt((Math.pow(lat_difference, 2)) + Math.pow(lon_difference, 2));
				// if the temp_distance is less than the distance, replaces the distance with the temp
				if (temp_distance < distance) {
					distance = temp_distance;
					chosen_station = stations.get(i).getName();
				}
			}
			// tells the user nearest station
			System.out.println("Your nearest station is " + chosen_station + " station");
		}
	}
	// For generate path method, it takes in the station arraylist. Then, asks the user where they would like to start, and where they would like to end
	// If the stations share a train line (green, red, brown, etc.), it will just take a direct route there
	// If it does not, will instead find a station that has both lines in order for the user to switch lines to get to their destination
	public static void generate_path(ArrayList<Station> stations) throws IOException {
		// Variable intialization
		Scanner user_input = new Scanner(System.in);
		int int_choice = 0;
		String travel_route = "";
		boolean running = true;
		boolean same_color = false;
		FileWriter writer = new FileWriter("src/project/Travel_Route.txt");
		ArrayList<Station> named_stations = new ArrayList<Station>();
		System.out.println("What station are you leaving from?");
		String station_choice = user_input.nextLine();
		int station_counter = 0;
		// Checks every station with that name
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getName().equalsIgnoreCase(station_choice)) {
				station_counter++;
				named_stations.add(stations.get(i));
			}
		}
		// If none are found, tells the user and stops
		if (station_counter == 0) {
			System.out.println("Station not found");
			running = false;
		} else if (station_counter > 1) {
			// If more than 1 is found, asks which one they would like to use
			System.out.println("There are multiple stations with that name");
			for (int i = 0; i < named_stations.size(); i++) {
				System.out.println(i + " " + named_stations.get(i).toString());
			}
			System.out.println("Please input the number of the station that you would like to start at");
			String named_choice = user_input.nextLine();
			if (check_int(named_choice)) {
				int_choice = Integer.parseInt(named_choice);
			} else {
				System.out.println("That is not recongized as one of the options");
				running = false;
			}
		} 
		if (running) {
			Station start_station = named_stations.get(int_choice);
			// Does the exact same thing for the end station
			named_stations.clear();
			System.out.println("What station are you going to?");
			station_choice = user_input.nextLine();
			station_counter = 0;
			for (int i = 0; i < stations.size(); i++) {
				if (stations.get(i).getName().equalsIgnoreCase(station_choice)) {
					station_counter++;
					named_stations.add(stations.get(i));
				}
			}
			if (station_counter == 0) {
				System.out.println("Station not found");
				running = false;
			} else if (station_counter > 1) {
				System.out.println("There are multiple stations with that name");
				for (int i = 0; i < named_stations.size(); i++) {
					System.out.println(i + " " +  named_stations.get(i).toString());
				}
				System.out.println("Please input the number of the station that you would like to go to");
				String named_choice = user_input.nextLine();
				if (check_int(named_choice)) {
					int_choice = Integer.parseInt(named_choice);
				} else {
					System.out.println("That is not recongized as one of the options");
					running = false;
				}
			} 
			if (running) {
				Station end_station = named_stations.get(int_choice);
				// If statements to check if the start and end station share a train line
				if (start_station.getRed() != -1 && end_station.getRed() != -1) {
					travel_route = "Take the red line train from " + start_station.getName() + " to " + end_station.getName();
					same_color = true;
				} else if (start_station.getOrange() != -1 && end_station.getOrange() != -1) {
					travel_route = "Take the orange line train from " + start_station.getName() + " to " + end_station.getName();
					same_color = true;
				} else if (start_station.getBrown() != -1 && end_station.getBrown() != -1) {
					travel_route = "Take the brown line train from " + start_station.getName() + " to " + end_station.getName();
					same_color = true;
				} else if (start_station.getBlue() != -1 && end_station.getBlue() != -1) {
					travel_route = "Take the blue line train from " + start_station.getName() + " to " + end_station.getName();
					same_color = true;
				} else if (start_station.getGreen() != -1 && end_station.getGreen() != -1) {
					travel_route = "Take the green line train from " + start_station.getName() + " to " + end_station.getName();
					same_color = true;
				} else if (start_station.getPink() != -1 && end_station.getPink() != -1) {
					travel_route = "Take the pink line train from " + start_station.getName() + " to " + end_station.getName();
					same_color = true;
				} else if (start_station.getPurple() != -1 && end_station.getPurple() != -1) {
					travel_route = "Take the purple line train from " + start_station.getName() + " to " + end_station.getName();
					same_color = true;
				}
				if (same_color) {
					// If they do, creates a basic travel route, tells the user, and asks if they want o save it as a txt file
					System.out.println(travel_route);
					System.out.println("Would you like that saved to a file? (Yes or No)");
					String save_choice = user_input.nextLine();
					if (save_choice.equalsIgnoreCase("Yes")) {
						// If they do, writes it to the txt file
						writer.write("Here is your travel Plan:\n");
						writer.write(travel_route);
						writer.flush();
						System.out.println("Saved to Travel_Route.txt");
					} else {
						System.out.println("Very well");
					}
				} else {
					// If the stations do not share a train line
					Station iterated_station;
					ArrayList<String> start_shared_lines = new ArrayList<String>();
					ArrayList<String> end_shared_lines = new ArrayList<String>();
					if (end_station.getRed() != -1) {
						for (int i = 0; i < stations.size(); i++) {
							iterated_station = stations.get(i);
							// Finds a station that shares a train line with the start
							if (start_station.getRed() != -1 && iterated_station.getRed() != -1) {
								start_shared_lines.add("red");
							} else if (start_station.getOrange() != -1 && iterated_station.getOrange() != -1) {
								start_shared_lines.add("orange");
							} else if (start_station.getBrown() != -1 && iterated_station.getBrown() != -1) {
								start_shared_lines.add("brown");
							} else if (start_station.getBlue() != -1 && iterated_station.getBlue() != -1) {
								start_shared_lines.add("blue");
							} else if (start_station.getGreen() != -1 && iterated_station.getGreen() != -1) {
								start_shared_lines.add("green");
							} else if (start_station.getPink() != -1 && iterated_station.getPink() != -1) {
								start_shared_lines.add("pink");
							} else if (start_station.getPurple() != -1 && iterated_station.getPurple() != -1) {
								start_shared_lines.add("purple");
							}
							// And shares a train line with the end
							if (end_station.getRed() != -1 && iterated_station.getRed() != -1) {
								end_shared_lines.add("red");
							} else if (end_station.getOrange() != -1 && iterated_station.getOrange() != -1) {
								end_shared_lines.add("orange");
							} else if (end_station.getBrown() != -1 && iterated_station.getBrown() != -1) {
								end_shared_lines.add("brown");
							} else if (end_station.getBlue() != -1 && iterated_station.getBlue() != -1) {
								end_shared_lines.add("blue");
							} else if (end_station.getGreen() != -1 && iterated_station.getGreen() != -1) {
								end_shared_lines.add("green");
							} else if (end_station.getPink() != -1 && iterated_station.getPink() != -1) {
								end_shared_lines.add("pink");
							} else if (end_station.getPurple() != -1 && iterated_station.getPurple() != -1) {
								end_shared_lines.add("purple");
							}
							// Then, will use that train station as a connector in order to get to the end station
							if (start_shared_lines.size() > 0 && end_shared_lines.size() > 0) {
								travel_route = "Take the " + start_shared_lines.get(0) + " line from " + start_station.getName() + " to " + iterated_station.getName() + " then the " + end_shared_lines.get(0) + " line to " + end_station.getName(); 
								System.out.println(travel_route);
								System.out.println("Would you like that saved to a file? (Yes or No)");
								String save_choice = user_input.nextLine();
								if (save_choice.equalsIgnoreCase("Yes")) {
									// As above, prompts for saving to file
									writer.write(travel_route);
									System.out.println("Saved to Travel_Route.txt");
								} else {
									System.out.println("Very well");
								}
							}
						}
					}
				}
			}
		}
	}
	// read_file takes in the stations arraylist. It will then read every line after the first from file 
	// (the first is just the categories and not a station itself), turns those values into a station, then adds it to the end of stations. Then returns stations
	public static ArrayList<Station> read_file(ArrayList<Station> stations) throws FileNotFoundException {
		File file = new File("src/project/CTAStops.csv");
		Scanner file_reader = new Scanner(file);
		int counter = 0;
		while (file_reader.hasNextLine()) {
			if (counter != 0) {
				String next_station = file_reader.nextLine();
				// Splits the line into the values to create a station with
				List<String> seperated_string = Arrays.asList(next_station.split(","));
				Station added_station = new Station(seperated_string.get(0), Double.parseDouble(seperated_string.get(1)), Double.parseDouble(seperated_string.get(2)), seperated_string.get(3), Boolean.parseBoolean(seperated_string.get(4)), Integer.parseInt(seperated_string.get(5)), Integer.parseInt(seperated_string.get(6)), Integer.parseInt(seperated_string.get(7)), Integer.parseInt(seperated_string.get(8)), Integer.parseInt(seperated_string.get(9)), Integer.parseInt(seperated_string.get(10)), Integer.parseInt(seperated_string.get(11)));
				stations.add(added_station);
			} else {
				file_reader.nextLine();
			}
			counter++;
		}
		file_reader.close();
		// Returns the stations with the read values
		return stations;
	}
	// A switch case to handle the menu input. Based on what the user says, uses the corresponding function, or exits
	public static ArrayList<Station> find_function(int menu_value, ArrayList<Station> stations) throws IOException {
		switch (menu_value) {
			case 1:
				System.out.println("Adding Station");
				stations = add_station(stations);
				break;
			case 2:
				System.out.println("Modifying Station");
				stations = modify_station(stations);
				break;
			case 3:
				System.out.println("Removing Station");
				stations = remove_station(stations);
				break;
			case 4:
				System.out.println("Searching by Name");
				search_name(stations);
				break;
			case 5:
				System.out.println("Searching by Criteria");
				search_criteria(stations);
				break;
			case 6:
				System.out.println("Finding Nearest Station");
				find_nearest(stations);
				break;
			case 7:
				System.out.println("Generating Path");
				generate_path(stations);
				break;
		}
		return stations;
	}
	// Checks to make sure that the value would fit for a color line variable
	public static int check_color(String temp_input) {
		if (check_int(temp_input) ) {
			 return Integer.parseInt(temp_input);
		} else {
			System.out.println("Invalid Input");
			return -2;
		}
	}
	
	// The menu seen by the user. Takes in the user input to find_function from above, if it isn't a valid input, or is 8 to exit, instead ends the program
	public static boolean user_choose_menu(ArrayList<Station> stations) throws IOException {
		// Scanner for menu input, which fun fact I found while researching, if I close this menu input, the whole
		// program can no longer access System.in, meaning that I cannot close this input and still interact with the user.
		// The way around it is to pass the menu made input to every function that needs it, but that's rather ugly.
		// And for this program the resources aren't essential, for a larger, more resource heavy program, it
		// would be best to pass the main made input variable to all functions to save resources.
		Scanner menu_input =  new Scanner(System.in);
		// Prints menu
		print_menu();
		// Reads user input
		String user_choice = menu_input.nextLine();
		// If the user input can be converted to int, it will use the appropriate function or exit if specified
		if (check_int(user_choice)) {
			int converted_value = Integer.parseInt(user_choice);
			find_function(converted_value, stations);
				// For everything but 1-7 (8 will fall in here naturally so we don't need to specify that)
			if (converted_value <= 7 && converted_value >= 1) {
				return true;
			} else {
			// Returning false ends the program
				return false;
			}
		} // Else is true when the input cannot be converted to int
		else {
			System.out.println("Invalid input");
			// Returning false ends the program
			return false;
		}
		
	}
	
	// Function to test if a string can be converted to int
	public static boolean check_int(String checked_value) {
		// Tries to convert
		try {
			Integer.parseInt(checked_value);
		} //If it can't, returns false
		catch (NumberFormatException nfe) {
	        return false;
		}
		// If it can, it reaches here and returns true
		return true;
	}
	public static boolean check_boolean(String checked_value) {
		// Tries to convert
		try {
			Boolean.parseBoolean(checked_value);
		} //If it can't, returns false
		catch (NumberFormatException nfe) {
	        return false;
		}
		// If it can, it reaches here and returns true
		return true;
	}
	public static boolean check_double(String checked_value) {
		// Tries to convert
		try {
			Double.parseDouble(checked_value);
		} //If it can't, returns false
		catch (NumberFormatException nfe) {
	        return false;
		}
		// If it can, it reaches here and returns true
		return true;
	}
	// Creates a scanner, the stations arraylist, and the running boolean, which is used to determine when to end the program.
	public static void main(String[] args) throws IOException {
		Scanner user_input =  new Scanner(System.in);
		boolean running = true;
		ArrayList<Station> stations = new ArrayList<Station>();
		read_file(stations);
		while (running) {
			running = user_choose_menu(stations);
		}
		user_input.close();
	}
}
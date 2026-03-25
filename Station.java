import java.util.ArrayList; 

public class Station { 
    // the color line this station belongs to 
    public String color; 
    // the name of the station 
    public String stop; 
    // whether the station is in service or not 
    public boolean inService; 
    // the station that comes before 
    public Station prev; 
    // the station that comes after 
    public Station next; 

    // makes a station with color and stop name 
    // sets in service to true 
    public Station(String color, String stop) {
        this.color = color; 
        this.stop = stop; 
        inService = true; 
    }

    // takes a station as input 
    // sets the input station as the next station 
    // sets the current station to the previous of the next 
    public void addNext(Station s) {
        next = s; 
        s.prev = this; 
    }

    // takes a station as input 
    // sets the input station as the previous station 
    // sets the next station of the previous station as the current one
    public void addPrev(Station s) {
        prev = s; 
        s.next = this; 
    }

    // connects a station to the one in front of it 
    // connects a station to the one behind it 
    public void connect(Station s) {
        this.next = s; 
        s.prev = this; 
    }

    // returns whether the station is in service
    public boolean isAvailable() {
        return inService; 
    }

    // flips the station status 
    public boolean switchAvailable() {
        inService = !inService; 
        return inService;
    }

    // checks if the color and stop of the current station matches that of the other station
    // MUST have .equals() because Station is an Object 
    public boolean equals(Station other) {
        if(this.color.equals(other.color) && this.stop.equals(other.stop)) {
            return true; 
        }

        return false; 
    }

    // creates an empty visited list of Stations 
    // recursive call to the helper method with the destination and visited stations
    public int tripLength(Station dest) {
		ArrayList<Station> visited = new ArrayList<Station>(); 
		return tripLengthHelper(dest, visited);
	}


	public int tripLengthHelper(Station dest, ArrayList<Station> visited) {
		// loops through each of the visited stations 
        // if the current one is found, the loop is stopped 
        for (Station s : visited) {
            if (s == this) {
                return -1;
            }
        }

        // reached destination, so distance is 0 
        if (this.equals(dest)) {
            return 0;
        }

        // mark current station as visited 
        visited.add(this);

        // track the shortest valid path found so far 
        int shortest = Integer.MAX_VALUE;

        // going forward if the next station exists 
        if (next != null) {
            // call the helper method on the next station 
            // must wipe the previous visited ArrayList to ensure that the stations are not marked too early 
            int result = next.tripLengthHelper(dest, new ArrayList<Station>(visited));
            if (result != -1 && result < shortest) {
                // if path is valid and the amount of stops is less than the current shortest path 
                // the shortest path becomes the result from this recursive sequence
                shortest = result;
            }
        }

        // same idea with going backward if a station exists 
        if (prev != null) {
            int result = prev.tripLengthHelper(dest, new ArrayList<Station>(visited));
            if (result != -1 && result < shortest) {
                shortest = result;
            }
        }

        // check if the current station is a TransferStation
        if (this instanceof TransferStation) {
            // cast the TransferStation 
            TransferStation t = (TransferStation) this;
            // loop through the transfers connected to this station 
                for (Station s : t.otherStations) {
                    if (s != null) {
                        // call the method on all transfers too to see if a path exists through the transfers
                        int result = s.tripLengthHelper(dest, new ArrayList<Station>(visited));
                        if (result != -1 && result < shortest) {
                            shortest = result;
                        }
                    }
                }
        }

        // if no valid path was found in any direction, return -1 
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }

        // otherwise, count 1 step to move from current station 
        return 1 + shortest;
	}

    public String toString() {
        return "STATION " + stop + ": " + color + " line, " + "in service: " + inService + 
        ", previous station: " + (prev== null ? "none" : prev.stop) + ", next station: " + (next == null ? "none" : next.stop); 
    }
}
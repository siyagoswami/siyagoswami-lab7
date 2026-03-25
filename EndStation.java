public class EndStation extends Station {
    
    // same as a normal Station
    public EndStation(String color, String stop) {
        super(color, stop);
    }

    public void makeEnd() {
        // if the station currently only has a next, copy that into prev
        if (next != null) {
            prev = next; 
        } else if (prev != null) {
            // if the station currently only has a prev, copy that into next 
            next = prev; 
        }
    }

    public String toString() {
        return "ENDSTATION " + stop + ": " + color + " line, " + "in service: " + inService + 
        ", previous station: " + (prev == null ? "none" : prev.stop) + ", next station: " + (next == null ? "none" : next.stop); 
    }
}
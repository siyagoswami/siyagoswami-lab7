public class EndStation extends Station {
    
    public EndStation(String color, String stop) {
        super(color, stop);
    }

    public void makeEnd() {
        // previousStation should become whatever's in nextStation
        if(next != null) {
            prev = next; 
        } else if(prev != null) {
            next = prev; 
        }
    }

    public String toString() {
        return "ENDSTATION " + stop + ": " + color + " line, " + "in service: " + inService + 
        ", previous station: " + (prev == null ? "none" : prev.stop) + ", next station: " + (next == null ? "none" : next.stop); 
    }
}
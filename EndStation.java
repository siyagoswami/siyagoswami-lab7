public class EndStation extends Station {
    
    public EndStation(String color, String stop) {
        super(color, stop);
    }

    public void makeEnd() {
        // previousStation should become whatever's in nextStation
        if(nextStation != null) {
            prevStation = nextStation; 
        } else if(prevStation != null) {
            nextStation = prevStation; 
        }
    }

    public String toString() {
        return "ENDSTATION " + stop + ": " + color + " line, " + "in service: " + inService + 
        ", previous station: " + (prevStation == null ? "none" : prevStation.stop) + ", next station: " + (nextStation == null ? "none" : nextStation.stop); 
    }
}
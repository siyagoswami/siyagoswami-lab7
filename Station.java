public class Station { 
    public String color; 
    public String stop; 
    public boolean inService; 
    public Station prevStation; 
    public Station nextStation; 

    public Station(String color, String stop) {
        this.color = color; 
        this.stop = stop; 
        inService = true; 
    }

    public void addNext(Station s) {
        nextStation = s; 
    }

    public void addPrev(Station s) {
        prevStation = s; 
    }

    public void connect(Station s) {
        addNext(s); 
        s.addPrev(this);
    }

    public boolean isAvailable() {
        return inService; 
    }

    public boolean switchAvailable() {
        inService = !inService; 
        return inService;
    }

    public boolean equals(Station other) {
        if(this.color.equals(other.color) && this.stop.equals(other.stop)) {
            return true; 
        }

        return false; 
    }

    public String toString() {
        return "STATION " + stop + ": " + color + " line, " + "in service: " + inService + 
        ", previous station: " + (prevStation == null ? "none" : prevStation.stop) + ", next station: " + (nextStation == null ? "none" : nextStation.stop); 
    }
}
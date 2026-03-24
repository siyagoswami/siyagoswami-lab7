public class Station { 
    public String color; 
    public String stop; 
    public boolean inService; 
    public Station prev; 
    public Station next; 

    public Station(String color, String stop) {
        this.color = color; 
        this.stop = stop; 
        inService = true; 
    }

    public void addNext(Station s) {
        next = s; 
    }

    public void addPrev(Station s) {
        prev = s; 
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
        ", previous station: " + (prev== null ? "none" : prev.stop) + ", next station: " + (next == null ? "none" : next.stop); 
    }
}
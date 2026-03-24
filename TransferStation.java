import java.util.ArrayList; 

public class TransferStation extends Station {

    public ArrayList<Station> otherStations; 

    public TransferStation(String color, String stop) {
        super(color, stop);
        otherStations = new ArrayList<Station>();
    }

    public void addTransferStationPrev(Station s) {
        otherStations.add(s); 
        s.next = this; 
    }

    public void addTransferStationNext(Station s) {
        otherStations.add(s); 
        s.prev = this; 
    }

    public String toString() {
        String result = "TRANSFERSTATION " + stop + ": " + color + " line, " + "in service: " + inService + 
        ", previous station: " + (prev == null ? "none" : prev.stop) + ", next station: " + (next == null ? "none" : next.stop) +
        "\n\tTransfers: \n"; 

        for(Station s : otherStations) {
            result += "\t" + s.toString() + "\n";     
        }

        return result; 
    }
    
}
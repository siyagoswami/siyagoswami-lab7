import java.util.ArrayList; 

public class TransferStation extends Station {

    // stores stations from other lines that connect through this transfer station
    public ArrayList<Station> otherStations; 

    // call Station constructor first, then make empty transfers list 
    public TransferStation(String color, String stop) {
        super(color, stop);
        otherStations = new ArrayList<Station>();
    }

    // add a station that comes before this transfer station on another line
    // make sure that the previous station is linked to the current one 
    public void addTransferStationPrev(Station s) {
        otherStations.add(s); 
        s.next = this; 
    }

    // add a station that comes after this transfer station on another line
    // make sure that the transfer station comes before that station 
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
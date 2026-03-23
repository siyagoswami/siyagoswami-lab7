import java.util.ArrayList; 

public class TransferStation extends Station {

    public ArrayList<Station> transfers; 

    public TransferStation(String color, String stop) {
        super(color, stop);
        transfers = new ArrayList<Station>();
    }

    public void addTransferStationPrev(Station s) {
        transfers.add(s); 
        s.nextStation = this; 
    }

    public void addTransferStationNext(Station s) {
        transfers.add(s); 
        s.prevStation = this; 
    }

    public String toString() {
        String result = "TRANSFERSTATION " + stop + ": " + color + " line, " + "in service: " + inService + 
        ", previous station: " + (prevStation == null ? "none" : prevStation.stop) + ", next station: " + (nextStation == null ? "none" : nextStation.stop) +
        "\n\tTransfers: \n"; 

        for(Station s : transfers) {
            result += "\t" + s.toString() + "\n";     
        }

        return result; 
    }
    
}
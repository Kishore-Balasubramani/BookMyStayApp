//UC4
import java.util.HashMap;
import java.util.Map;

public class BookMyStayApp {

    public static void main(String args[]) {

        System.out.println("Welcome to my BookMyStayApp");
        System.out.println("Version : 4.0 (Room Search)\n");

        
        Room singleRoom = new singleRoom();
        Room doubleRoom = new doubleRoom();
        Room suiteRoom = new suiteRoom();

        
        RoomInventory inventory = new RoomInventory();

        
        RoomSearchService searchService = new RoomSearchService();

       
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );

        System.out.println("Search completed.");
    }
}


abstract class Room {
    protected int NumberOfBeds;
    protected int squareFeet;
    protected double PricePerNight;

    public Room(int beds, int size, double price) {
        this.NumberOfBeds = beds;
        this.squareFeet = size;
        this.PricePerNight = price;
    }

    public void displayRoomDetails(boolean isAvailable) {
        System.out.println("Beds: " + NumberOfBeds);
        System.out.println("Size: " + squareFeet);
        System.out.println("Price: " + PricePerNight);
        System.out.println("Available: " + isAvailable);
        System.out.println("------------------------");
    }
}

class singleRoom extends Room {
    public singleRoom() {
        super(1, 200, 1200);
    }
}

class doubleRoom extends Room {
    public doubleRoom() {
        super(2, 400, 2400);
    }
}

class suiteRoom extends Room {
    public suiteRoom() {
        super(1, 500, 3200);
    }
}



class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        // FIXED KEYS
        roomAvailability.put("Single", 10);
        roomAvailability.put("Double", 0);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}



class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Available Rooms:\n");

        Integer single = availability.get("Single");
        if (single != null && single > 0) {
            System.out.println("Single Room Available: " + single);
            singleRoom.displayRoomDetails(true);
        }

        Integer dbl = availability.get("Double");
        if (dbl != null && dbl > 0) {
            System.out.println("Double Room Available: " + dbl);
            doubleRoom.displayRoomDetails(true);
        }

        Integer suite = availability.get("Suite");
        if (suite != null && suite > 0) {
            System.out.println("Suite Room Available: " + suite);
            suiteRoom.displayRoomDetails(true);
        }
    }
}

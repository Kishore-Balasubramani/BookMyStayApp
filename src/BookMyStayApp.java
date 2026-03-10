import java.util.HashMap;
import java.util.Map;
public class BookMyStayApp {
    public static void main(String args[]){
        System.out.println("Welcome to my BookMyStayApp");
        System.out.println("System initialized successfully");
        System.out.println("version : 1.0");

        boolean singleRoomAvailable = true;
        boolean doubleRoomAvailable = false;
        boolean suiteRoomAvailable = true;


        Room singleRoom = new singleRoom();
        Room doubleRoom = new doubleRoom();
        Room suiteRoom = new suiteRoom();

        System.out.println("Single Room Details:");
        singleRoom.displayRoomDetails(singleRoomAvailable);

        System.out.println("Double Room Details:");
        doubleRoom.displayRoomDetails(doubleRoomAvailable);

        System.out.println("Suite Room Details:");
        suiteRoom.displayRoomDetails(suiteRoomAvailable);

        System.out.println("Application Terminated.");

        RoomInventory inventory = new RoomInventory();

        Map<String, Integer> rooms = inventory.getRoomAvailability();

        for (String roomType : rooms.keySet()) {
            System.out.println(roomType + " : " + rooms.get(roomType));
        }

        inventory.updateAvailability("DoubleRoom", 4);

        System.out.println("Updated Availability");

        for (String roomType : rooms.keySet()) {
            System.out.println(roomType + " : " + rooms.get(roomType));
        }
    }
}
abstract class Room{
    protected int NumberOfBeds;
    protected int squareFeet;
    protected double PricePerNight;

    public Room(int NumberOfBeds,int squareFeet,double PricePerNight){
        this.NumberOfBeds = NumberOfBeds;
        this.squareFeet =  squareFeet;
        this.PricePerNight = PricePerNight;
    }
    public void displayRoomDetails(boolean isAvailable){
        System.out.println("Number of Beds: " + NumberOfBeds);
        System.out.println("squareFeet: " + squareFeet);
        System.out.println("PricePerNight: " + PricePerNight);
        System.out.println("isAvailable: " + isAvailable);
        System.out.println("----------------------------");
    }
}
class singleRoom extends Room{
    public singleRoom(){
        super(1,200,1200);
    }
}
class doubleRoom extends Room{
    public doubleRoom(){
        super(2,400,2400);
    }
}
class suiteRoom extends Room{
    public suiteRoom(){
        super(1,500,3200);
    }
}
class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("SingleRoom", 10);
        roomAvailability.put("DoubleRoom", 5);
        roomAvailability.put("SuiteRoom", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}
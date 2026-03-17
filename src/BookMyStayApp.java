//UC6
import java.util.*;

public class BookMyStayApp {

    public static void main(String args[]) {

        System.out.println("Welcome to my BookMyStayApp");
        System.out.println("Version : 4.0 (Room Search)\n");


        RoomInventory inventory = new RoomInventory();


        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Kishore", "Single"));
        queue.addRequest(new Reservation("Arun", "Suite"));
        queue.addRequest(new Reservation("Divya", "Double"));
        queue.addRequest(new Reservation("Rahul", "Single"));


        BookingService bookingService = new BookingService(inventory);


        while (!queue.isEmpty()) {
            Reservation r = queue.getNextRequest();
            bookingService.confirmBooking(r);
        }

        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();

    }
}

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + ", Requested Room: " + roomType;
    }
}


class BookingRequestQueue {

    private Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation r) {
        queue.offer(r);
        System.out.println("Request added: " + r.getGuestName() + " -> " + r.getRoomType());
    }

    public Reservation getNextRequest() {
        return queue.poll(); // FIFO
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
class RoomInventory {
    private Map<String, Integer> availability = new HashMap<>();

    public RoomInventory() {
        availability.put("Single", 2);
        availability.put("Double", 1);
        availability.put("Suite", 1);
    }

    public int getAvailable(String type) {
        return availability.getOrDefault(type, 0);
    }

    public void decrement(String type) {
        availability.put(type, availability.get(type) - 1);
    }

    public void displayInventory() {
        for (String type : availability.keySet()) {
            System.out.println(type + " : " + availability.get(type));
        }
    }
}

class BookingService {

    private RoomInventory inventory;


    private Set<String> allocatedRoomIds = new HashSet<>();


    private Map<String, Set<String>> allocationMap = new HashMap<>();

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void confirmBooking(Reservation r) {

        String type = r.getRoomType();

        System.out.println("\nProcessing: " + r.getGuestName());


        if (inventory.getAvailable(type) <= 0) {
            System.out.println(" No rooms available for " + type);
            return;
        }


        String roomId = generateRoomId(type);


        if (allocatedRoomIds.contains(roomId)) {
            System.out.println(" Duplicate Room ID detected (should not happen)");
            return;
        }


        allocatedRoomIds.add(roomId);

        allocationMap.putIfAbsent(type, new HashSet<>());
        allocationMap.get(type).add(roomId);


        inventory.decrement(type);


        System.out.println(" Booking Confirmed for " + r.getGuestName());
        System.out.println("Room Type: " + type);
        System.out.println("Assigned Room ID: " + roomId);
    }


    private String generateRoomId(String type) {
        return type.substring(0, 1).toUpperCase() + UUID.randomUUID().toString().substring(0, 5);
    }
}
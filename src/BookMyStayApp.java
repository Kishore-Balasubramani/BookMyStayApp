


//UC5
import java.util.LinkedList;
import java.util.Queue;

//UC6
import java.util.*;
 (UC6 - Reservation Confirmation & Room Allocation)

//UC4
import java.util.HashMap;
import java.util.Map;
 (UC4 - Room Search & Availability Check)

//UC5
import java.util.LinkedList;
import java.util.Queue;
  (Booking Request (First-Come-First-Served))

public class BookMyStayApp {

    public static void main(String args[]) {

        System.out.println("Welcome to my BookMyStayApp");
        System.out.println("Version : 4.0 (Room Search)\n");



        System.out.println("Welcome to BookMyStayApp");
        System.out.println("Version: 5.0 - Booking Request Queue\n");


        BookingRequestQueue requestQueue = new BookingRequestQueue();

        RoomInventory inventory = new RoomInventory();
 (UC6 - Reservation Confirmation & Room Allocation)


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


    public void displayQueue() {
        System.out.println("\nCurrent Booking Queue (FIFO Order):");
        for (Reservation r : queue) {
            System.out.println(r);


        // Create Room Objects
        Room singleRoom = new singleRoom();
        Room doubleRoom = new doubleRoom();
        Room suiteRoom = new suiteRoom();

 (Booking Request (First-Come-First-Served))

        BookingRequestQueue requestQueue = new BookingRequestQueue();


        Reservation r1 = new Reservation("Kishore", "Single");
        Reservation r2 = new Reservation("Arun", "Suite");
        Reservation r3 = new Reservation("Divya", "Double");


        requestQueue.addRequest(r1);
        requestQueue.addRequest(r2);
        requestQueue.addRequest(r3);


        requestQueue.displayQueue();

        System.out.println("\nNo allocation done yet .");


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

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }


    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added: " + reservation);
    }


    public Reservation viewNextRequest() {
        return queue.peek();
    }


    public Reservation processNextRequest() {
        return queue.poll();
    }



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


    public void displayQueue() {
        System.out.println("\nCurrent Booking Queue (FIFO Order):");
        for (Reservation r : queue) {
            System.out.println(r);
  (Booking Request (First-Come-First-Served))

    public void displayInventory() {
        for (String type : availability.keySet()) {
            System.out.println(type + " : " + availability.get(type));
 (UC6 - Reservation Confirmation & Room Allocation)
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
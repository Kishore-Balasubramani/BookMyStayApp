

//UC5
import java.util.LinkedList;
import java.util.Queue;

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


        System.out.println("Welcome to BookMyStayApp");
        System.out.println("Version: 5.0 - Booking Request Queue\n");


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
        }
    }
}
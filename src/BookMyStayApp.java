//UC5
import java.util.LinkedList;
import java.util.Queue;

public class BookMyStayApp {

    public static void main(String args[]) {

        System.out.println("Welcome to my BookMyStayApp");
        System.out.println("Version : 4.0 (Room Search)\n");
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
        }
    }
}
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RRPSS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long staffID;

        System.out.println("Enter your Staff ID:");
        staffID = sc.nextInt();

        int choice = 0;

        Restaurant restaurant = new Restaurant();
        ReservationMgr reservationMgr = new ReservationMgr();
        MenuItemMgr MenuItemMgr = new MenuItemMgr();

        System.out.println("(1) Create reservation");
        System.out.println("(2) Check/Delete reservation");
        System.out.println("(3) Create menu item");
        System.out.println("(4) Show the list of seat assignments by customer ID");
        System.out.println("(5) Assign a customer to a seat");
        System.out.println("(6) Remove a seat assignment");
        System.out.println("(7) Exit");

        while (choice != 7) {
            System.out.printf("Enter the number of your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Reservation r = reservationMgr.createReservation();
                    r.allocateTable(restaurant.table);
                    restaurant.reservation.add(r);
                    r.printReservation();
                    break;
                case 2:
                    reservationMgr.checkReservation(restaurant.reservation);
                    break;
                case 3:
                    restaurant.menuItems.add(MenuItemMgr.createMenuItem());
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("(1) Show number of empty seats");
                    System.out.println("(2) Show the list of empty seats");
                    System.out.println("(3) Show the list of seat assignments by seat ID");
                    System.out.println("(4) Show the list of seat assignments by customer ID");
                    System.out.println("(5) Assign a customer to a seat");
                    System.out.println("(6) Remove a seat assignment");
                    System.out.println("(7) Exit");
                    break;
            }
        }
        sc.close();
    }

}

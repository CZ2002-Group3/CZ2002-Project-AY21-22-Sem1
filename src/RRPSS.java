import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class RRPSS {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Restaurant restaurant = new Restaurant();
        // ReservationMgr reservationMgr = new ReservationMgr();
        orderMgr orderMgr = new orderMgr();
        MenuItemMgr menuItemMgr = new MenuItemMgr();
        StaffMgr staffMgr = new StaffMgr();
<<<<<<< HEAD
        PromotionMgr promotionMgr = new PromotionMgr();
=======
        TableMgr tableMgr = new TableMgr();
>>>>>>> cad58e0c802a23181162462d3156a3b600a71883

        System.out.println("Enter your Employee ID:");
        long employeeID = sc.nextInt();

        Staff staff = staffMgr.getStaff(employeeID, restaurant.staff);
        System.out.println("Welcome " + staff.getStaffName());

        int choice = -1;

        System.out.println("(1) Create/Update/Remove menu item");
        System.out.println("(2) Create/Update/Remove promotion");
        System.out.println("(3) Create order");
        System.out.println("(4) View order");
        System.out.println("(5) Add/Remove order item/s to/from order");
        System.out.println("(6) Create reservation booking");
        System.out.println("(7) Check/Remove reservation booking");
        System.out.println("(8) Check table availability");
        System.out.println("(9) Print order invoice");
        System.out.println("(10) Print sale revenue report by period (eg day or month)");
        System.out.println("(0) Exit");

        System.out.printf("Enter the number of your choice: ");
        choice = sc.nextInt();

        while (choice != 0) {

            switch (choice) {
                case 1:
                    System.out.println("Altering restaurant menu");
                    System.out.println("(1) Add menu item");
                    System.out.println("(2) Update menu item");
                    System.out.println("(3) Delete menu item");

                    System.out.printf("Enter the number of your choice: ");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        restaurant.menuItems.add(menuItemMgr.createMenuItem());
                    } else if (choice == 2) {
                        menuItemMgr.updateMenuItem(restaurant.menuItems);
                    }
                    if (choice == 3) {
                        menuItemMgr.deleteMenuItem(restaurant.menuItems);
                    }

                    break;
                case 2:
                    System.out.println("Altering restaurant promotion menu");
                    System.out.println("(1) Create promotion");
                    System.out.println("(2) Update promotion");
                    System.out.println("(3) Delete promotion");

                    System.out.printf("Enter the number of your choice: ");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        promotionMgr.createPromotion(restaurant.promotions, restaurant.menuItems);
                    } else if (choice == 2) {
                        promotionMgr.updatePromotion(restaurant.promotions, restaurant.menuItems);
                    }
                    if (choice == 3) {
                        promotionMgr.deletePromotion(restaurant.promotions);
                    }
                    break;
                case 3:
                    System.out.printf("Enter the number of person: ");
                    int noOfPax = sc.nextInt();
                    Table table = tableMgr.assignTable(restaurant.table, 1234, noOfPax);
                    if (table != null) {
                        Order order = orderMgr.createOrder(restaurant.menuItems, restaurant.promotions, staff, table);
                        if (order != null){
                            restaurant.order.add(order);
                            table.setStatus(0);
                        }
                    }
                    break;
                case 4:
                    int orderSize = restaurant.order.size();
                    for (int i = 0; i < orderSize; i++) {
                        restaurant.order.get(i).printOrderInvoice();
                    }
                    break;
                case 5:

                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.printf("Enter Table Number: ");
                    int tableNumber = sc.nextInt();
                    orderMgr.orderPaid(restaurant.order, tableNumber);
                    break;
                case 10:
                    break;
                default:
                    System.out.println("(1) Create/Update/Remove menu item");
                    System.out.println("(2) Create/Update/Remove promotion");
                    System.out.println("(3) Create order");
                    System.out.println("(4) View order");
                    System.out.println("(5) Add/Remove order item/s to/from order");
                    System.out.println("(6) Create reservation booking");
                    System.out.println("(7) Check/Remove reservation booking");
                    System.out.println("(8) Check table availability");
                    System.out.println("(9) Print order invoice");
                    System.out.println("(10) Print sale revenue report by period (eg day or month)");
                    System.out.println("(0) Exit");
                    break;
            }
            System.out.println("(1) Create/Update/Remove menu item");
            System.out.println("(2) Create/Update/Remove promotion");
            System.out.println("(3) Create order");
            System.out.println("(4) View order");
            System.out.println("(5) Add/Remove order item/s to/from order");
            System.out.println("(6) Create reservation booking");
            System.out.println("(7) Check/Remove reservation booking");
            System.out.println("(8) Check table availability");
            System.out.println("(9) Print order invoice");
            System.out.println("(10) Print sale revenue report by period (eg day or month)");
            System.out.println("(0) Exit");

            System.out.printf("Enter the number of your choice: ");
            choice = sc.nextInt();
        }
        sc.close();
    }

}

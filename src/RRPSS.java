import java.text.*;
import java.util.*;

public class RRPSS {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        Restaurant restaurant = new Restaurant();
        ReservationMgr reservationMgr = new ReservationMgr();
        OrderMgr orderMgr = new OrderMgr();
        MenuItemMgr menuItemMgr = new MenuItemMgr();
        StaffMgr staffMgr = new StaffMgr();
        TableMgr tableMgr = new TableMgr();
        PromotionMgr promotionMgr = new PromotionMgr();
        CustomerMgr customerMgr = new CustomerMgr();
        TimeMgr timeMgr = new TimeMgr();

        // System.out.println("Enter your Employee ID:");
        // long employeeID = sc.nextInt();

        // Staff staff = staffMgr.getStaff(employeeID, restaurant.staff);
        // System.out.println("Welcome " + staff.getStaffName());

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

        do {
            while(!sc.hasNextInt()){	
                System.out.println("Input is invalid, try again!");
                System.out.print("Choice of which to update (-1 to quit): ");
                sc.next();
            }
            choice = sc.nextInt();
            break;
        } while(true);

        while (choice != 0) {

            switch (choice) {
            case 1:
                System.out.println("Altering restaurant menu");
                System.out.println("(1) Add menu item");
                System.out.println("(2) Update menu item");
                System.out.println("(3) Delete menu item");
                System.out.println("(4) Print menu item");
                System.out.println("Enter (-1) to exit Altering restaurant menu: ");

                System.out.println("Enter the number of your choice: ");

                do {
                    while(!sc.hasNextInt()){	
                        System.out.println("Input is invalid, try again!");
                        System.out.print("Choice of which to update (-1 to quit): ");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    break;
                } while(true);


                while (choice != -1) {
                    if (choice == 1) {
                        restaurant.menuItems.add(menuItemMgr.createMenuItem());
                    } else if (choice == 2) {
                        menuItemMgr.updateMenuItem(restaurant.menuItems);
                    } else if (choice == 3) {
                        menuItemMgr.deleteMenuItem(restaurant.menuItems);
                    } else if (choice == 4) {
                        menuItemMgr.printMenuItemList(restaurant.menuItems);
                    }
                    System.out.println("Altering restaurant menu");
                    System.out.println("(1) Add menu item");
                    System.out.println("(2) Update menu item");
                    System.out.println("(3) Delete menu item");
                    System.out.println("(4) Print menu item");
                    System.out.println("Enter (-1) to exit Altering restaurant menu: ");

                    System.out.println("Enter the number of your choice: ");
                    choice = sc.nextInt();
                }
                break;
            case 2:
                System.out.println("Altering restaurant promotion menu");
                System.out.println("(1) Create promotion");
                System.out.println("(2) Update promotion");
                System.out.println("(3) Delete promotion");

                System.out.printf("Enter the number of your choice: ");

                do {
                    while(!sc.hasNextInt()){	
                        System.out.println("Input is invalid, try again!");
                        System.out.print("Choice of which to update (-1 to quit): ");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    break;
                } while(true);
                

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
                // System.out.printf("Enter the number of person: ");
                // int noOfPax = sc.nextInt();

                // System.out.println("Enter Customer Contact Number: ");
                // int contactNo = sc.nextInt();

                // Customer cust = customerMgr.findCustomer(restaurant.customer, contactNo);
                // if (cust == null) {
                // System.out.println("Enter Customer Name: ");
                // String custName = sc.next();
                // System.out.println("Membership?: ");
                // boolean member = sc.nextBoolean();
                // long custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
                // cust = new Customer(custID, custName, member, contactNo);
                // restaurant.customer.add(cust);
                // }

                // Table table = tableMgr.assignTable(restaurant.table, cust.getCustomerID(),
                // noOfPax);
                // if (table != null) {
                // Order order = orderMgr.createOrder(restaurant.menuItems,
                // restaurant.promotions, staff, table, cust);
                // if (order != null) {
                // restaurant.order.add(order);
                // } else {
                // table.setStatus(0);
                // }
                // }
                break;
            case 4:
                int orderSize = restaurant.order.size();
                for (int i = 0; i < orderSize; i++) {
                    restaurant.order.get(i).printOrderInvoice(false);
                }
                break;
            case 5:
                System.out.printf("Enter Table Number: ");
                int tableNo = sc.nextInt();
                orderMgr.removeOrderItem(restaurant.order, tableNo);
                break;
            case 6:
                reservationMgr.createReservation(restaurant.reservation, restaurant.table, restaurant.customer);
                break;
            case 7:
                System.out.println("Reservation Menu");
                System.out.println("(1) Check reservation");
                System.out.println("(2) Remove reservation");

                do {
                    while(!sc.hasNextInt()){	
                        System.out.println("Input is invalid, try again!");
                        System.out.print("Choice of which to update (-1 to quit): ");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    break;
                } while(true);

                timeMgr.checkExpired(restaurant.reservation);
                if (choice == 1)
                    reservationMgr.checkReservation(restaurant.reservation);
                else if (choice == 2)
                    reservationMgr.removeReservation(restaurant.reservation);
                else
                    System.out.println("Invalid Choice");

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

            do {
                while(!sc.hasNextInt()){	
                    System.out.println("Input is invalid, try again!");
                    System.out.print("Choice of which to update (-1 to quit): ");
                    sc.next();
                }
                choice = sc.nextInt();
                break;
            } while(true);

        }
        sc.close();
    }

}

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
            while (!sc.hasNextInt()) {
                System.out.println("Input is invalid, try again!");
                System.out.print("Choice of which to update (-1 to quit): ");
                sc.next();
            }
            choice = sc.nextInt();
            break;
        } while (true);

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
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        System.out.print("Choice of which to update (-1 to quit): ");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    break;

                } while (true);

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
                    do {
                        while (!sc.hasNextInt()) {
                            System.out.println("Input is invalid, try again!");
                            System.out.println("Enter the number of your choice: ");
                            sc.next();
                        }
                        choice = sc.nextInt();
                        break;
                    } while (true);
                }
                break;
            case 2:
                System.out.println("Altering restaurant promotion menu");
                System.out.println("(1) Create promotion");
                System.out.println("(2) Update promotion");
                System.out.println("(3) Delete promotion");
                System.out.println("(4) Print list of promotions");

                System.out.printf("Enter the number of your choice (-1 to quit): ");

                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        System.out.printf("Enter the number of your choice (-1 to quit): ");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    break;
                } while (true);

                while (choice != -1) {
                    if (choice == 1) {
                        promotionMgr.createPromotion(restaurant.promotions, restaurant.menuItems);
                    } else if (choice == 2) {
                        promotionMgr.updatePromotion(restaurant.promotions, restaurant.menuItems);
                    } else if (choice == 3) {
                        promotionMgr.deletePromotion(restaurant.promotions);
                    } else {
                        promotionMgr.getPromotionList(restaurant.promotions);
                    }

                    System.out.println("Altering restaurant promotion menu:");
                    System.out.println("(1) Create promotion");
                    System.out.println("(2) Update promotion");
                    System.out.println("(3) Delete promotion");
                    System.out.println("(4) Print list of promotions");

                    System.out.printf("Enter the number of your choice (-1 to quit): ");

                    do {
                        while (!sc.hasNextInt()) {
                            System.out.println("Input is invalid, try again!");
                            System.out.printf("Enter the number of your choice (-1 to quit): ");
                            sc.next();
                        }
                        choice = sc.nextInt();
                        break;
                    } while (true);
                }
                break;

            case 3:
                // Create Order
                timeMgr.checkExpired(restaurant.reservation);
                System.out.printf("Enter your Employee ID: ");
                long employeeID = sc.nextInt();

                Staff staff = staffMgr.getStaff(employeeID, restaurant.staff);

                System.out.printf("Enter Customer Contact Number: ");
                long contactNo = sc.nextLong();

                Table table;
                Customer cust;
                Reservation reserve;

                reserve = reservationMgr.checkReservation(restaurant.reservation, contactNo);
                if (reserve != null) {
                    cust = reserve.getCustomer();
                    table = reserve.getTable();
                    restaurant.reservation.remove(reserve);
                    table.setStatus(1);
                    Order order = orderMgr.createOrder(restaurant.menuItems, restaurant.promotions, staff, table, cust);
                    if (order != null) {
                        restaurant.order.add(order);
                    } else {
                        table.setStatus(0);
                    }
                } else {
                    cust = customerMgr.findCustomer(restaurant.customer, contactNo);
                    if (cust == null) {
                        System.out.printf("Enter Customer Name: ");
                        String custName = sc.next();
                        System.out.printf("Does the customer want a membership?: ");
                        boolean member = sc.nextBoolean();
                        long custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
                        cust = new Customer(custID, custName, member, contactNo);
                        restaurant.customer.add(cust);
                    }

                    System.out.printf("Enter the number of person: ");
                    int noOfPax = sc.nextInt();

                    table = tableMgr.assignTable(restaurant.table, cust.getCustomerID(), noOfPax);
                    if (table != null) {
                        Order order = orderMgr.createOrder(restaurant.menuItems, restaurant.promotions, staff, table,
                                cust);
                        if (order != null) {
                            restaurant.order.add(order);
                        } else {
                            table.setStatus(0);
                        }
                    }
                }
                break;
            case 4:
                // View order
                System.out.println("(1) Show one order");
                System.out.println("(2) Show all orders");
                System.out.println("(0) Return back to menu");

                System.out.printf("Enter the number of your choice: ");
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    break;
                } while (true);

                int orderSize = restaurant.order.size();
                if (choice == 1) {
                    Boolean exist = false;
                    System.out.printf("Enter Table Number: ");
                    int tableNo;
                    do {
                        while (!sc.hasNextInt()) {
                            System.out.println("Input is invalid, try again!");
                            sc.next();
                        }
                        tableNo = sc.nextInt();
                        break;
                    } while (true);

                    for (int i = 0; i < orderSize; i++) {
                        Order curr = restaurant.order.get(i);
                        if (curr.getTableNumber() == tableNo) {
                            curr.printOrderInvoice(false);
                            exist = true;
                        }
                    }

                    if (!exist) {
                        System.out.println("The Order does not exist!");
                    }
                } else if (choice == 2) {
                    for (int i = 0; i < orderSize; i++) {
                        System.out.println("");
                        restaurant.order.get(i).printOrderInvoice(false);
                    }
                }
                break;
            case 5:
                // Add/Remove order item/s to/from order
                System.out.printf("Enter Table Number: ");
                int tableNo;

                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        sc.next();
                    }
                    tableNo = sc.nextInt();
                    break;
                } while (true);

                System.out.println("(1) Remove items from Order");
                System.out.println("(2) Add items to Order");
                System.out.println("(0) Return back to menu");

                System.out.printf("Enter the number of your choice: ");

                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    break;
                } while (true);

                if (choice == 1) {
                    orderMgr.removeOrderItem(restaurant.order, tableNo);
                } else if (choice == 2) {
                    orderMgr.addOrderItem(restaurant.order, restaurant.menuItems, restaurant.promotions, tableNo);
                } else
                    System.out.println("Invalid Choice");

                break;
            case 6:
                // Create reservation booking
                reservationMgr.createReservation(restaurant.reservation, restaurant.table, restaurant.customer);
                break;
            case 7:
                System.out.println("Reservation Menu");
                System.out.println("(1) Check reservation");
                System.out.println("(2) Remove reservation");

                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    break;
                } while (true);
                sc.nextLine();

                timeMgr.checkExpired(restaurant.reservation);
                if (choice == 1)
                    reservationMgr.checkReservation(restaurant.reservation);
                else if (choice == 2)
                    reservationMgr.removeReservation(restaurant.reservation);
                else
                    System.out.println("Invalid Choice");

                break;
            case 8:
                // Check table availability
                System.out.println("(1) Show one table");
                System.out.println("(2) Show all tables");
                System.out.printf("Enter the number of your choice: ");

                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        sc.next();
                    }
                    choice = sc.nextInt();
                    if (choice == 1 || choice == 2) {
                        break;
                    }
                } while (true);
                sc.nextLine();

                int tableSize = restaurant.table.size();
                if (choice == 1) {
                    Boolean exist = false;
                    System.out.printf("Enter Table Number: ");
                    int tableNo1;

                    do {
                        while (!sc.hasNextInt()) {
                            System.out.println("Input is invalid, try again!");
                            sc.next();
                        }

                        tableNo1 = sc.nextInt();
                        if (tableNo1 <= restaurant.table.size() && tableNo1 >= 1) {
                            break;
                        }
                        System.out.println("Input is invalid, try again!");
                    } while (true);
                    sc.nextLine();

                    for (int i = 0; i < tableSize; i++) {
                        Table curr = restaurant.table.get(i);
                        if (curr.getTableNumber() == tableNo1) {
                            System.out.println("Table number " + curr.getTableNumber() + " is " + curr.getStatus());
                            exist = true;
                        }
                    }

                    if (!exist) {
                        System.out.println("The table does not exist!");
                    }
                } else if (choice == 2) {
                    tableMgr.getTableStatus(restaurant.table);
                }
                break;
            case 9:
                System.out.printf("Enter Table Number: ");
                int tableNumber;

                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        sc.next();
                    }

                    tableNumber = sc.nextInt();
                    if (tableNumber <= restaurant.table.size() && tableNumber >= 1) {
                        break;
                    }
                    System.out.println("Input is invalid, try again!");
                } while (true);
                sc.nextLine();

                orderMgr.orderPaid(restaurant.order, restaurant.paidOrders, tableNumber);
                break;
            case 10:
                // Generate Sales Report
                System.out.printf("Enter the period (in days): ");
                int days = sc.nextInt();
                restaurant.generateSalesReport(days);
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
                while (!sc.hasNextInt()) {
                    System.out.println("Input is invalid, try again!");
                    System.out.print("Choice of which to update (-1 to quit): ");
                    sc.next();
                }
                choice = sc.nextInt();
                break;
            } while (true);

        }
        sc.close();
    }

}

import java.text.*;
import java.util.*;

public class RRPSS {
    
    /** 
     * @param args
     * @throws ParseExceptions
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        RestaurantMgr restaurantMgr = new RestaurantMgr();
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
                        restaurantMgr.getMenuItems().add(menuItemMgr.createMenuItem());
                    } else if (choice == 2) {
                        menuItemMgr.updateMenuItem(restaurantMgr.getMenuItems());
                    } else if (choice == 3) {
                        menuItemMgr.deleteMenuItem(restaurantMgr.getMenuItems());
                    } else if (choice == 4) {
                        menuItemMgr.printMenuItemList(restaurantMgr.getMenuItems());
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
                        promotionMgr.createPromotion(restaurantMgr.getPromotions(), restaurantMgr.getMenuItems());
                    } else if (choice == 2) {
                        promotionMgr.updatePromotion(restaurantMgr.getPromotions(), restaurantMgr.getMenuItems());
                    } else if (choice == 3) {
                        promotionMgr.deletePromotion(restaurantMgr.getPromotions());
                    } else {
                        promotionMgr.getPromotionList(restaurantMgr.getPromotions());
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
                timeMgr.checkExpired(restaurantMgr.getReservation());
                System.out.printf("Enter your Employee ID: ");
                long employeeID;

                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Input is invalid, try again!");
                        System.out.printf("Enter your Employee ID: ");
                        sc.next();
                    }
                    employeeID = sc.nextInt();
                    break;
    
                } while (true);

                Staff staff = staffMgr.getStaff(employeeID, restaurantMgr.getStaff());
                
                System.out.printf("Enter Customer Contact Number: ");
                long contactNo;

                do {
                    while (!sc.hasNextLong()) {
                        System.out.println("Input is invalid, try again!");
                        System.out.printf("Enter Customer Contact Number: ");
                        sc.next();
                    }
                    contactNo = sc.nextLong();
                    break;
    
                } while (true);

                Table table;
                Customer cust;
                Reservation reserve;

                reserve = reservationMgr.checkReservation(restaurantMgr.getReservation(), contactNo);
                if (reserve != null) {
                    cust = reserve.getCustomer();
                    table = reserve.getTable();
                    restaurantMgr.getReservation().remove(reserve);
                    table.setStatus(1);
                    Order order = orderMgr.createOrder(restaurantMgr.getMenuItems(), restaurantMgr.getPromotions(), staff, table, cust);
                    if (order != null) {
                        restaurantMgr.getOrder().add(order);
                    } else {
                        table.setStatus(0);
                    }
                } else {
                    cust = customerMgr.findCustomer(restaurantMgr.getCustomer(), contactNo);
                    if (cust == null) {
                        System.out.printf("Enter Customer Name: ");
                        String custName = sc.next();
                        boolean member;
                        char member_str;

                        do {
                            System.out.println("Does the customer want a membership? (Y/N)");
                            member_str = sc.next().charAt(0);
        
                            if (member_str == 'y' || member_str == 'Y') {
                                member = true;
                                break;
                            } else if (member_str == 'n' || member_str == 'N') {
                                member = false;
                                break;
                            } else {
                                System.out.println("Invalid input, please try again!");
                                continue;
                            }
                        } while(true);

                        long custID = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
                        cust = new Customer(custID, custName, member, contactNo);
                        restaurantMgr.getCustomer().add(cust);
                    }

                    System.out.printf("Enter the number of person: ");
                    int noOfPax;

                    do {
                        while (!sc.hasNextInt()) {
                            System.out.println("Input is invalid, try again!");
                            System.out.printf("Enter the number of person: ");
                            sc.next();
                        }
                        noOfPax = sc.nextInt();
                        break;
        
                    } while (true);

                    table = tableMgr.assignTable(restaurantMgr.getTable(), cust.getCustomerID(), noOfPax);
                    if (table != null) {
                        Order order = orderMgr.createOrder(restaurantMgr.getMenuItems(),restaurantMgr.getPromotions(), staff, table,
                                cust);
                        if (order != null) {
                            restaurantMgr.getOrder().add(order);
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

                int orderSize = restaurantMgr.getOrder().size();
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
                        Order curr = restaurantMgr.getOrder().get(i);
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
                        restaurantMgr.getOrder().get(i).printOrderInvoice(false);
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
                    orderMgr.removeOrderItem(restaurantMgr.getOrder(), tableNo);
                } else if (choice == 2) {
                    orderMgr.addOrderItem(restaurantMgr.getOrder(), restaurantMgr.getMenuItems(), restaurantMgr.getPromotions(), tableNo);
                } else
                    System.out.println("Invalid Choice");

                break;
            case 6:
                // Create reservation booking
                reservationMgr.createReservation(restaurantMgr.getReservation(), restaurantMgr.getTable(), restaurantMgr.getCustomer());
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

                timeMgr.checkExpired(restaurantMgr.getReservation());
                if (choice == 1)
                    reservationMgr.checkReservation(restaurantMgr.getReservation());
                else if (choice == 2)
                    reservationMgr.removeReservation(restaurantMgr.getReservation());
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

                int tableSize = restaurantMgr.getTable().size();
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
                        if (tableNo1 <= restaurantMgr.getTable().size() && tableNo1 >= 1) {
                            break;
                        }
                        System.out.println("Input is invalid, try again!");
                    } while (true);
                    sc.nextLine();

                    for (int i = 0; i < tableSize; i++) {
                        Table curr = restaurantMgr.getTable().get(i);
                        if (curr.getTableNumber() == tableNo1) {
                            System.out.println("Table number " + curr.getTableNumber() + " is " + curr.getStatus());
                            exist = true;
                        }
                    }

                    if (!exist) {
                        System.out.println("The table does not exist!");
                    }
                } else if (choice == 2) {
                    tableMgr.getTableStatus(restaurantMgr.getTable());
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
                    if (tableNumber <= restaurantMgr.getTable().size() && tableNumber >= 1) {
                        break;
                    }
                    System.out.println("Input is invalid, try again!");
                } while (true);
                sc.nextLine();

                orderMgr.orderPaid(restaurantMgr.getOrder(), restaurantMgr.getPaidOrders(), tableNumber);
                break;
            case 10:
                // Generate Sales Report
                System.out.printf("Enter the period (in days): ");
                int days = sc.nextInt();
                SalesReportGenerator sr = new SalesReportGenerator();
                sr.generateSalesReport(restaurantMgr.getPaidOrders(), restaurantMgr.getMenuItems(), restaurantMgr.getPromotions(), days);
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

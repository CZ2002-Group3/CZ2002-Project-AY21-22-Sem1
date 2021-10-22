import java.util.*;

public class CustomerMgr {

    public CustomerMgr() {

    }

    public Customer findCustomer(List<Customer> customers, long contactNumber) {
        int custSize = customers.size();
        for (int i = 0; i < custSize; i++) {
            if (customers.get(i).getContactNumber() == contactNumber) {
                return customers.get(i);
            }
        }
        return null;
    }
}
/**
Represents the manager of Customer class.
 @author Thai Wei Cheng
 @version 1.0
 @since 2021-10-29
*/

import java.util.*;

public class CustomerMgr {

    public CustomerMgr() {

    }

    
    /** 
     * Function to search for the customer object using their contact number.
     * @param customers This is a list of customers.
     * @param contactNumber This is the contact number of the customer used for search.
     * @return the customer object found using contact number or null if not found.
     */
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
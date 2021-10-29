/**
Represents the manager of Staff class.
 @author Thai Wei Cheng
 @version 1.0
 @since 2021-10-27
*/

import java.util.List;

public class StaffMgr {
	
	/**
	 * Create a Staff manager.
	*/
    public StaffMgr(){
    }

    
    /** 
     * Function used to check if the staff is registered under the restaurant.
     * Iterates through the list of Staff, and check for employee ID.
     * @param employeeID - staff employee ID.
     * @param staffs - This is the list of staff.
     * @return Staff - founded in the list or not.
     */
    public Staff getStaff(long employeeID, List<Staff> staffs){
        Staff foundStaff;

        int length = staffs.size();
        for(int i = 0; i < length; i++){
            if(staffs.get(i).getEmployeeID() == employeeID ){
                foundStaff = staffs.get(i);
                return foundStaff;
            }
            
        }

        return null;
    }
}
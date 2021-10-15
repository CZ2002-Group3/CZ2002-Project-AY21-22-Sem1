import java.util.List;

public class StaffMgr {
    public StaffMgr(){

    }

    public Staff getStaff(long employeeID, List<Staff> staffs){
        Staff foundStaff;

        int length = staffs.size();
        for(int i = 0; i < length; i++){
            if(staffs.get(i).getEmpolyeeID() == employeeID ){
                foundStaff = staffs.get(i);
                return foundStaff;
            }
            
        }

        return null;
    }
}
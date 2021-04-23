public abstract class NonMedicalStaff {
    // Add new member
    protected abstract void AddMedicalMember(String id, String p); // Staff ID and Password
    protected abstract void ModifyID(String id); // Staff ID
    protected abstract void ModifyPassword(String id);  // Medical staff's id
    // nurses are assigned to two shifts from 8am to 4 pm, and 2 pm to 10 pm. No more than 8 hours per day
    // doctors are assigned for 1 hour
    protected abstract void AssignShift(String id);  // Medical staff's id
    protected abstract void ModifyShiftDayTime(String id);  // Medical staff's id
    // Allow manager to add new residents to one of the vacant beds
    protected abstract void AddResidentToBed(String id1, String id2); // Resident id, bed id
}
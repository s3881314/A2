public abstract class MedicalStaff{
    protected abstract void ModifyPassword(String id, String np); // Staff ID, new Password
    protected abstract void ModifyID(String id);  // Staff ID
    // nurses are assigned to two shifts from 8am to 4 pm, and 2 pm to 10 pm. No more than 8 hours per day
    // doctors are assigned for 1 hour
    protected abstract void AssignShift(String id, String sft);  // Staff ID, Shift
    protected abstract void ModifyShift(String id, String sft);  // Staff id, Shift

}

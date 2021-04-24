public abstract class NonMedicalStaff {
    // Add new member
    protected abstract void AddDoctor(String id, String p); // Staff ID and Password
    protected abstract void AddNurse(String id, String p); // Staff ID and Password
    // Allow manager to add new residents to one of the vacant beds
    protected abstract void AddNewResidentToBed(String id,String g, String b, String w); // Resident ID, ,Gender, Bed ID, Ward ID
}
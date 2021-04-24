public class Nurse extends MedicalStaff{
    private String ID;
    private String Password;
    private String Shift;

    Nurse(String id, String p){
        this.ID = id;
        this.Password = p;
    }

    // Manager only
    public void ModifyPassword(String id, String np){  // Staff ID, new Password
        this.Password = np;
    }

    // Manager only
    public void ModifyID(String id){
        this.ID = id;
    }

    // Manager only
    public void AssignShift(String id, String sft){
        this.Shift = sft;
    }

    // Manager only
    public void ModifyShift(String id, String sft){
        this.Shift = sft;
    }
}

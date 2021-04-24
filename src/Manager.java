public class Manager extends NonMedicalStaff{
    private String ID;
    private String Password;

    Manager(String id, String p){
        this.ID = id;
        this.Password = p;
    }

    public void AddDoctor(String id, String p){
        Doctor n = new Doctor(id, p);
    }

    public void AddNurse(String id, String p){
        Nurse n = new Nurse(id, p);
    }

    public void AddNewResidentToBed(String id,String g, String b, String w){  // Resident ID, ,Gender, Bed ID, Ward ID
        Resident n = new Resident(id, g, b, w);

    }
}

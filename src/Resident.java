public class Resident {
    private String ID;
    private String Gender;
    private String Bed;
    private String Ward;
    private String Medicine = null;

    Resident(String id, String g, String b, String w){
        this.ID = id;
        this.Gender = g;
        this.Bed = b;
        this.Ward = w;
    }

    // Doctor and Nurse only
    // medical staff is able to check resident's detail
    public void CheckResidentDetail(String id){
        System.out.println("Resident ID: " + this.ID);
        System.out.println("Resident Gender: " + this.Gender);
        System.out.println("Resident Bed: " + this.Bed);
        System.out.println("Resident Ward: " + this.Ward);
    }

    // Nurse only
    public void MovingResident(String id1, String id2){ // Resident id, bed id
        // check the status of the bed
        // if it is empty, move resident
        // else print message
    }

    // Doctor only
    // Attach prescription
    public void AttachPrescription(String id, String p){  // Bed id, Prescription

    }

    // Doctor and Nurse only
    // Updating the details of medicines administered for a resident in the selected bed
    public void UpdateMedicine(String id, String m){  // Bed id, Medicine statement

    }

    // Doctor and Nurse only
    // Check administering medicine
    public void CheckAdministeringMedicine(String id){

    }
}

package Classes;

import org.junit.jupiter.api.Test;

class AbleCareHomeTest {

    @Test
    void addManager() {
        AbleCareHome a = new AbleCareHome();
        a.AddManager("M1", "Manager", "Kevin", "123", "0412356789", "M222");
    }

    @Test
    void addDoctor() {
        AbleCareHome a = new AbleCareHome();
        a.AddDoctor("M1", "Manager", "Tommy", "123", "04345678912", "D111");
    }

    @Test
    void addNurse() {
        AbleCareHome a = new AbleCareHome();
        a.AddNurse("M1", "Manager", "Andy", "123", "04112345678", "N111");
    }

    @Test
    void addResident() {
        AbleCareHome a = new AbleCareHome();
        a.AddResident("M1", "Manager", "123", "F", "123", "05/05/1997");

    }


    @Test
    void addNewResidentToBed() {
        AbleCareHome a = new AbleCareHome();
        a.AddNewResidentToBed("M1","Manager", "Ward 1", "1","1", "R1");
        a.AddNewResidentToBed("M1","Manager", "Ward 2", "1","4", "R2");
        a.AddNewResidentToBed("M1","Manager", "Ward 1", "2","2", "R3");
        a.AddNewResidentToBed("M1","Manager", "Ward 2", "1","1", "R4");
        a.AddNewResidentToBed("M1","Manager", "Ward 2", "3","3", "R5");
    }

    @Test
    void assignShift() throws ShiftException {
        AbleCareHome a = new AbleCareHome();
        try {
            a.AssignShift("M1", "Manager", "Doctor", "D1", "3", "10", "11");
            a.AssignShift("M1", "Manager", "Nurse", "N1", "4", "8", "16");
        } catch(ShiftException e){
            System.out.println("Something wrong while assigning shift.");
            e.printStackTrace();
        }
    }

    @Test
    void attachNewPrescription() {
        AbleCareHome a = new AbleCareHome();
        a.AttachNewPrescription("M1","Manager","Ward 2", "1", "4", "Medicine1,Medicine2,Medicine3");  // format for prescription: Medicine 1,Medicine 2,Medicine3,...
        a.AttachNewPrescription("D1","Doctor","Ward 1", "2", "2", "Medicine2");
    }

    @Test
    void administeringMedicine() {
        AbleCareHome a = new AbleCareHome();
        a.AdministeringMedicine("M1","Manager","Ward 2", "1", "4", "Medicine1,Medicine2");
    }
    /*
    @Test
    void updatePassword() {
        AbleCareHome a = new AbleCareHome();
        a.UpdatePassword("M1","Manager", "Doctor", "D1", "NewPassword");
        a.UpdatePassword("M1","Manager", "Nurse", "N4", "NewPassword");
    }

    @Test
    void updateShift()  throws ShiftException{
        AbleCareHome a = new AbleCareHome();
        try {
            //a.UpdateShift("M1","Manager", "Doctor", "D1","1","8","9");
            a.UpdateShift("M1","Manager", "Doctor", "D1","4","8","9");
            //a.UpdateShift("M1","Manager", "Nurse", "N1","2","14","22");
            //a.UpdateShift("M1","Manager", "Nurse", "N1","5","14","22");
        } catch(ShiftException e){
            System.out.println("Something wrong while assigning shift.");
            e.printStackTrace();
        }
    }

    @Test
    void moveResident() {
        AbleCareHome a = new AbleCareHome();
        a.MoveResident("N1","Nurse","Ward 1","1","3","R1");
    }

    @Test
    void dischargeResident() {
        AbleCareHome a = new AbleCareHome();
        a.DischargeResident("M1","Manager","R1");
    }

    @Test
    void readResidentDetails() {
        AbleCareHome a = new AbleCareHome();
        a.ReadAdministeringMedicine("M1","Manager","Ward 1", "1", "2");
    }

    @Test
    void updatePrescription() {
        AbleCareHome a = new AbleCareHome();
        a.UpdatePrescription("D1","Doctor","Ward 2", "1", "4", "Medicine1, Medicine2");
    }

    @Test
    void readPrescription() {
        AbleCareHome a = new AbleCareHome();
        a.ReadPrescription("D1","Doctor", "Ward 1", "1", "2");
    }

    @Test
    void readAdministeringMedicine() {
        AbleCareHome a = new AbleCareHome();
        a.ReadAdministeringMedicine("D1","Doctor", "Ward 1", "1", "2");
    }
    */
}
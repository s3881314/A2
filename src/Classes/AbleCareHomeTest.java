package Classes;

import org.junit.jupiter.api.Test;

class AbleCareHomeTest {
    /*
    @Test
    void addManager() {
        AbleCareHome a = new AbleCareHome();
        a.AddManager("0", "root", "M1", "1", "0412356789", "0");
        a.AddManager("0", "root", "M2", "2", "0412356789", "0");
        a.AddManager("0", "root", "M3", "3", "0412356789", "0");
        a.AddManager("0", "root", "M4", "4", "0412356789", "0");
        a.AddManager("0", "root", "M5", "5", "0412356789", "0");
    }

    @Test
    void addDoctor() {
        AbleCareHome a = new AbleCareHome();
        a.AddDoctor("1", "Manager", "D1", "1", "04345678912", "0");
        a.AddDoctor("2", "Manager", "D2", "2", "04345678912", "0");
        a.AddDoctor("3", "Manager", "D3", "3", "04345678912", "0");
        a.AddDoctor("4", "Manager", "D4", "4", "04345678912", "0");
        a.AddDoctor("5", "Manager", "D5", "5", "04345678912", "0");
    }

    @Test
    void addNurse() {
        AbleCareHome a = new AbleCareHome();
        a.AddNurse("1", "Manager", "N1", "1", "04112345678", "0");
        a.AddNurse("2", "Manager", "N2", "2", "04112345678", "0");
        a.AddNurse("3", "Manager", "N3", "3", "04112345678", "0");
        a.AddNurse("4", "Manager", "N4", "4", "04112345678", "0");
        a.AddNurse("5", "Manager", "N5", "5", "04112345678", "0");
    }

    @Test
    void addResident() {
        AbleCareHome a = new AbleCareHome();
        a.AddResident("1", "Manager", "R1", "F", "1", "05/05/1997");
        a.AddResident("2", "Manager", "R2", "F", "2", "05/05/1997");
        a.AddResident("3", "Manager", "R3", "F", "3", "05/05/1997");
        a.AddResident("4", "Manager", "R4", "F", "4", "05/05/1997");
        a.AddResident("5", "Manager", "R5", "F", "5", "05/05/1997");
    }

    @Test
    void addNewResidentToBed() {
        AbleCareHome a = new AbleCareHome();
        a.AddNewResidentToBed("1","Manager", "1", "1","1", "1");
        a.AddNewResidentToBed("2","Manager", "2", "1","4", "2");
        a.AddNewResidentToBed("3","Manager", "1", "2","2", "3");
        a.AddNewResidentToBed("4","Manager", "2", "1","1", "4");
        a.AddNewResidentToBed("5","Manager", "2", "3","3", "5");
    }

    @Test
    void assignShift() throws ShiftException {
        AbleCareHome a = new AbleCareHome();
        try {
            a.AssignShift("1", "Manager", "Doctor", "1", "3", "10", "11");
            a.AssignShift("2", "Manager", "Nurse", "1", "4", "8", "16");
        } catch(ShiftException e){
            e.printStackTrace();
        }
    }

    @Test
    void attachNewPrescription() {
        AbleCareHome a = new AbleCareHome();
        a.AttachNewPrescription("1","Doctor","Ward 2", "1", "4", "Medicine1,Medicine2,Medicine3");  // format for prescription: Medicine 1,Medicine 2,Medicine3,...
        a.AttachNewPrescription("2","Doctor","Ward 1", "2", "2", "Medicine2");
    }

    @Test
    void administeringMedicine() {
        AbleCareHome a = new AbleCareHome();
        a.AdministeringMedicine("1","Nurse","2", "1", "4", "Medicine1", "1","1");
        a.AdministeringMedicine("1","Nurse","1", "2", "2", "Medicine2", "2","2");

    }
    */

    @Test
    void updatePassword() {
        AbleCareHome a = new AbleCareHome();
        a.UpdatePassword("1","Manager", "Doctor", "1", "NewPassword");
        a.UpdatePassword("1","Manager", "Nurse", "4", "NewPassword");
    }

    @Test
    void updateShift()  throws ShiftException{
        AbleCareHome a = new AbleCareHome();
        try {
            //a.UpdateShift("M1","Manager", "Doctor", "D1","1","8","9");
            a.UpdateShift("1","Manager", "Doctor", "1","4","8","9");
            //a.UpdateShift("M1","Manager", "Nurse", "N1","2","14","22");
            //a.UpdateShift("M1","Manager", "Nurse", "N1","5","14","22");
        } catch(ShiftException e){
            e.printStackTrace();
        }
    }

    @Test
    void moveResident() {
        AbleCareHome a = new AbleCareHome();
        a.MoveResident("1","Nurse","1","1","3","1");
    }

    @Test
    void dischargeResident() {
        AbleCareHome a = new AbleCareHome();
        a.DischargeResident("1","Manager","1");
    }

    @Test
    void readResidentDetails() {
        AbleCareHome a = new AbleCareHome();
        a.ReadAdministeringMedicine("1","Manager","1", "1", "2");
    }

    @Test
    void updatePrescription() {
        AbleCareHome a = new AbleCareHome();
        a.UpdatePrescription("1","Doctor","2", "1", "4", "Medicine1, Medicine2");
    }

    @Test
    void readPrescription() {
        AbleCareHome a = new AbleCareHome();
        a.ReadPrescription("1","Doctor", "1", "1", "2");
    }

    @Test
    void readAdministeringMedicine() {
        AbleCareHome a = new AbleCareHome();
        a.ReadAdministeringMedicine("1","Doctor", "1", "1", "2");
    }
}
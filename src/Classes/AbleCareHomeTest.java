import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


class AbleCareHomeTest {

    @Test
    void addManager() {
        AbleCareHome a = new AbleCareHome();
        a.AddManager("M1","Manager","Kevin","M2","0412356789","M222");
    }

    @Test
    void addDoctor() {
        AbleCareHome a = new AbleCareHome();
        a.AddDoctor("M1","Manager","Tommy","D1","04345678912","D111");
        a.AddDoctor("M1","Manager","Tony","D2","04456789123","D222");
        a.AddDoctor("M1","Manager","Henry","D3","04567891234","D333");
        a.AddDoctor("M1","Manager","Sophie","D4","0467891234","D444");
        a.AddDoctor("M1","Manager","Jay","D5","0478912345","D555");
    }

    @Test
    void addNurse() {
        AbleCareHome a = new AbleCareHome();
        a.AddNurse("M1","Manager","Andy","N1","04112345678","N111");
        a.AddNurse("M1","Manager","David","N1","04112345678","N222");
        a.AddNurse("M1","Manager","Oliver","N1","04112345678","N333");
        a.AddNurse("M1","Manager","Gary","N1","04112345678","N444");
        a.AddNurse("M1","Manager","May","N1","04112345678","N555");
    }

    @Test
    void addResident() {
        AbleCareHome a = new AbleCareHome();
        LocalDate d = LocalDate.of(1997, 1, 2);
        a.AddResident("M1","Manager", "Laura", "F", "R1", d);
        d = LocalDate.of(1996, 1, 10);
        a.AddResident("M1","Manager", "Maureen", "F", "R2", d);
        d = LocalDate.of(1995, 3, 2);
        a.AddResident("M1","Manager", "Mark", "M", "R3", d);
        d = LocalDate.of(1980, 4, 20);
        a.AddResident("M1","Manager", "Luke", "M", "R4", d);
        d = LocalDate.of(1985, 12, 2);
        a.AddResident("M1","Manager", "Harold", "M", "R5", d);
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
        //a.MoveResident("N1","Nurse","Ward 1","1","3","R1");
    }

    @Test
    void dischargeResident() {
        AbleCareHome a = new AbleCareHome();
        //a.DischargeResident("M1","Manager","R1");
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
}
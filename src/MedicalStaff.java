// 21042021  this class should be abstract.

public abstract class MedicalStaff{
    // medical staff is able to check resident's detail
    // detail for administering medicine

    // allow manager add staff (doctors, nurses) or modify ID, password and shift days/times
    void AddDoctor(String id2, String p2, String sdt){

    }
    void AddNurse(String id2, String p2, String sdt){

    }
    void ModifyID(){

    }
    void ModifyPassword(){

    }
    // nurses are assigned to two shifts from 8am to 4 pm, and 2 pm to 10 pm. No more than 8 hours per day
    // doctors are assigneed for 1 hour
    void ModifyShiftDayTime(){

    }
    void AssignShift(){

    }
}

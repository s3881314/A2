public abstract class MedicalStaff{
    // medical staff is able to check resident's detail
    protected abstract void CheckResidentDetail(String id); // Resident's id
    // detail for administering medicine
    protected abstract void CheckAdministeringMedicine(String id);
    // Updating the details of medicines administered for a resident in the selected bed
    protected abstract void UpdateMedicine(String id); // Bed id
}

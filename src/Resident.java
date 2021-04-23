public class Resident {
    private String ID;
    private String Gender;
    private String Bed;
    private String Ward;

    Resident(String id, String g, String b, String w){
        this.ID = id;
        this.Gender = g;
        this.Bed = b;
        this.Ward = w;
    }

    void addMember(String id, String g, String b, String w){
        Resident n = new Resident(id, g, b, w);
    }
}

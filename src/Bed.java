public class Bed {
    private String ID;
    private boolean empty = true;

    Bed(String id, boolean e){
        this.ID = id;
        this.empty = e;
    }

    void addResident(boolean b){
        this.empty  = b;
    }
}

public class Bed {
    private boolean empty = true;

    Bed(boolean e){
        empty = e;
    }

    void addMember(boolean b){
        Bed n = new Bed(b);
    }
}

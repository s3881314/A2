public class Ward {
    private int NumOfBed = 0;

    Ward(int n){
        this.NumOfBed = n;
    }

    void addMember(int num){
        Ward n = new Ward(num);
    }
}

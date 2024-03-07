package e2;

public class CellImpl implements cell {
    private char value;
    private Boolean isAMine;

    public CellImpl(char value, Boolean isAMine){
        this.value=value;
        this.isAMine=isAMine;
    }

    public char getValue(){
        return this.value;
    }
    public Boolean isMine(){
        return this.isAMine;
    }


}

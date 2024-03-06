package e2;

public class CellImpl implements cell {
    private char value;

    public CellImpl(char value){
        this.value=value;
    }

    public char getValue(){
        return this.value;
    }

}

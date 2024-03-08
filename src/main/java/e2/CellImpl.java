package e2;

public class CellImpl implements cell {

    private char value;
    private Boolean isAMine;
    private Boolean clicked=false;

    public CellImpl(char value, Boolean isAMine){
        this.value=value;
        this.isAMine=isAMine;
    }

    public CellImpl() {
        this.value='0';
        this.isAMine=false;
    }

    public char getValue(){
        return this.value;
    }
    public Boolean isAMine(){
        return this.isAMine;
    }

    @Override
    public Boolean hasBeenClicked() {
        return clicked;
    }

    @Override
    public void clicked() {
       clicked=true;
    }


}

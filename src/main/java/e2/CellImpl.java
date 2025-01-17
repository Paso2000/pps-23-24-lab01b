package e2;

public class CellImpl implements cell {

    private char value;
    private boolean isAMine;
    private boolean clicked=false;
    private boolean flaged=false;

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
        return this.clicked;
    }

    @Override
    public void clicked() {
       this.clicked=true;
    }

    public void setMine(char value, boolean isAMine){
        this.value=value;
        this.isAMine=isAMine;
    }

    @Override
    public void changeFlag() {
        this.flaged=!this.flaged;
    }

    @Override
    public boolean isFlaged() {
       return this.flaged;
    }

}

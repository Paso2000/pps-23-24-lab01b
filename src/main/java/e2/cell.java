package e2;

public interface cell {

    public char getValue();

    public Boolean isAMine();

    public Boolean hasBeenClicked();

    public void clicked();

    public void setMine(char value, boolean isAMine);

}


package e2;

public interface cell {

    public char getValue();

    public Boolean isAMine();

    public Boolean hasBeenClicked();

    public void clicked();

    public void setValue(char value);

    public void setIsAMine(boolean isAMine);
}


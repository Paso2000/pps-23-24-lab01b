package e2;

import java.util.function.BooleanSupplier;

public interface cell {

    public char getValue();

    public Boolean isAMine();

    public Boolean hasBeenClicked();

    public void clicked();
}


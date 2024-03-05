package e1;

import java.util.Random;

public class InizializerImpl implements Inizializer {

    private Random random = new Random();

    public Pair<Integer,Integer> randomInit(int size, Pair<Integer,Integer> pawn) {
            Pair<Integer,Integer> pos = new Pair<>(random.nextInt(size),random.nextInt(size));
            return pawn!=null && pawn.equals(pos) ? randomInit(size, pawn) : pos;
            
    }
}

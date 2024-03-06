package e2;

import java.util.LinkedList;
import java.util.List;

public class LogicsImpl implements Logics {
    private int size;
    private int numMines;
    private List<Pair<Integer,Integer>> mines = new LinkedList<>();
    public LogicsImpl(int size, int numMines) {
        this.size=size;
        this.numMines=numMines;
        //chose mine cells
    }

    public Boolean hitMine(Pair<Integer,Integer> pos) {
        return false;
    }
    // private void insertMine(){
    //     for (Pair<Integer,Integer> mine : mines) {
    //         cells[mine.getX()][mine.getY()]='*';
    //     }
    // }
    

}

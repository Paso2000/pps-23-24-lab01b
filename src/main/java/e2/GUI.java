package e2;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.util.Map.Entry;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size, int numMines) {
        this.logics = new LogicsImpl(size, numMines);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener onClick = (e)->{
            final JButton bt = (JButton)e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);
            boolean aMineWasFound = logics.cickedOnAMine(pos.getX(),pos.getY());       
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                drawBoard();            	
            }
            boolean isThereVictory = logics.hasWon(); 
            if (isThereVictory){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    logics.changeFlag(pos.getX(), pos.getY());
                }
                drawBoard(); 
            }
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
    	for (var entry: this.buttons.entrySet()) {
            String str = logics.cickedOnAMine(entry.getValue().getX(),entry.getValue().getY())? "*":  String.valueOf((int)logics.getValueFromGrid(entry.getValue().getX(), entry.getValue().getY())) ;
            entry.getKey().setText(str);
            entry.getKey().setEnabled(false);
    	}
    }

    private void drawBoard() {
        for (var entry: this.buttons.entrySet()) {
            if(logics.isFlaged(entry.getValue().getX(), entry.getValue().getY())){
                logics.isFlaged(entry.getValue().getX(), entry.getValue().getY());
                String str = String.valueOf('F');
                entry.getKey().setText(str);
            }
             else if(logics.isClicked(entry.getValue().getX(), entry.getValue().getY())){
                String str = String.valueOf((int)logics.getValueFromGrid((int)entry.getValue().getX(),entry.getValue().getY()));
                entry.getKey().setText(str);
                entry.getKey().setEnabled(false);

            }else {
                entry.getKey().setText(" ");
            } 
           
    	}
    }
    
}

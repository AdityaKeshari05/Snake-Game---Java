import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SnakeGame extends JFrame {
    int width , height ;

    String difficulty;
    String pas;

    private int isSkin ;

// THE MAIN FRAME OF THE PROJECT THROUGH WHICH THE BOARD IS GETTING OPENED .

    SnakeGame(int width  , int height ,String difficulty,String pas , int  isSkin){

        super("Snake Game");
        this.width = width;
        this.height = height;
        this.difficulty= difficulty;
        this.pas = pas;
        this.isSkin = isSkin;

        // adding board .
        add(new Board(width,height,difficulty,pas,isSkin));
        pack();

        // Frame details .
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        new SnakeGame(0,0 ,"","",0).setVisible(true);
    }

}

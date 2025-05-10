import javax.swing.*;
import java.awt.*;


// Its the frame which will show the leagues panel that's it.
public class LeagueUI extends JFrame{

    LeagueUI(){


        // Frame details
        setTitle("Leagues");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,700);
        // Adding league panel .
        Leagues panel = new Leagues("Gold");
        add(panel);
        setResizable(false);
        setLocation(890,120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LeagueUI();
    }
}

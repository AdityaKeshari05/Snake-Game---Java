import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;

public class Profile extends JFrame implements ActionListener {
    String pas,name;

    JButton backButton;

    Profile(String pas){
        this.pas = pas;


        setLayout(null);
        // Exception Handling .
        try {
                // setting connection to fetch output and fill up the details of the user in the profile section .
                Conn conn = new Conn();
                String query = "select userName from signupS  where Password = '"+pas+"'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    JLabel naam = new JLabel( rs.getString("UserName"));
                    naam.setBounds(70, 15, 200, 25);
                    naam.setForeground(Color.CYAN);
                    naam.setFont(new Font("Arial Black",Font.BOLD,15));
                    add(naam);

                    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("backGround/image.png"));
                    Image i2 = i1.getImage();
                    ImageIcon i3 = new ImageIcon(i2);
                    JLabel image = new JLabel(i3);
                    image.setBounds(10,10,50,50);
                    add(image);

                }else { // if user is not login means hitting the guest button then also a dashboard will appear but this time ,  it will so the label error .
                    JLabel error = new JLabel("User not found or wrong password!");
                    error.setBounds(50, 20, 300, 25);
                    error.setForeground(Color.RED);
                    add(error);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            // this will show tee points of the user .
            try{
                Conn conn =  new Conn();
                String query = "select points from credentials  where pass = '"+pas+"'";
                ResultSet rs =  conn.s.executeQuery(query);
                if(rs.next()){
                    JLabel point = new JLabel("Points : "+rs.getString("points"));
                    point.setBounds(80, 45, 200, 25);
                    point.setForeground(Color.CYAN);
                    point.setFont(new Font("Arial Black",Font.BOLD,15));
                    add(point);

                }else{
                    JLabel error = new JLabel("wrong password!");
                    error.setBounds(70, 60, 300, 25);
                    error.setForeground(Color.RED);
                    add(error);
                }
            }catch (Exception e){

            }

            // back button .
            backButton = new JButton("Back");
            backButton.setBounds(100, 130, 100, 30);
            backButton.setBackground(Color.BLACK);
            backButton.setForeground(Color.CYAN);
            backButton.addActionListener(this);
            backButton.setFocusable(false);
            add(backButton);

            // Frame details .
            setSize(300,200);
            setLocation(1200,230);
            setUndecorated(true);
            getContentPane().setBackground(Color.BLACK);
            setVisible(true);
        }
        // Action performed function .
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == backButton) {
                setVisible(false);
                ; // Or change to your home screen class
            }
        }
    public static void main(String[] args) {
        new Profile("");
    }

}

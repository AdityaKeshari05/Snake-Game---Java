import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Locale;


public class Login extends JFrame implements ActionListener {
    String pas ,name;

    JTextField userField;

    JPasswordField passField;

    JButton loginButton;

    private int score ;
    Login(){
        setLayout(null);
        this.score =score;


        // user name label  and its respected textField .
        JLabel username = new JLabel("Username:");
        username.setBounds(50, 50, 100, 25);
        username.setForeground(Color.cyan);
        add(username);

        userField = new JTextField();
        userField.setBounds(150, 50, 150, 25);
        userField.setFont(new Font("Arial Black" , Font.BOLD,20 ));
        add(userField);

        //  Password label and its respected password field .
        JLabel password = new JLabel("Password:");
        password.setBounds(50, 100, 100, 25);
        password.setForeground(Color.cyan);
        add(password);

        passField = new JPasswordField();
        passField.setBounds(150, 100, 150, 25);
        add(passField);

        // Login button  .
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.CYAN);
        loginButton.addActionListener(this);
        add(loginButton);

        // Frame details .
        setSize(400, 300);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(520, 330);
        setVisible(true);
    }

    // Action performed function .
    public void actionPerformed(ActionEvent ae){
        // action when user press login button after filling the details .
        if(ae.getSource() == loginButton){
            Conn conn = new Conn();
            name = userField.getText();
            pas = passField.getText();

            String query = "select * from signupS where Password = '"+pas+"'";
            try{
                ResultSet rs =conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Dashboard(pas,score).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                    System.out.println(name + "" + pas);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

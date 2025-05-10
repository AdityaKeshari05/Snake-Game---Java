import com.mysql.cj.protocol.ResultsetRows;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;





public class SignUpPage extends JFrame implements ActionListener {
    Image background;

    JTextField username , emailTextField ;

    JPasswordField password , reEnterPassword;

    JComboBox ageBox ;

    JButton backButton , next;

    String pas;
    SignUpPage(){
        // backGround image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("backGround/back.png"));
        background = i1.getImage();
        ImageIcon i2 = new ImageIcon(background);
        JLabel back = new JLabel(i2);
        back.setBounds(0,0,800,400);
        add(back);

        // Battle snake logo .
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("backGround/battlesnakelogo.png"));
        background = i3.getImage();
        ImageIcon i4 = new ImageIcon(background);
        JLabel logo = new JLabel(i4);
        logo.setBounds(20,10,100,100);
        back.add(logo);

        // heading text
        JLabel heading = new JLabel("Welcome to the Battle Snake");
        heading.setFont(new Font("Arial Black", Font.BOLD, 20));
        heading.setBounds(200,10,400,70);
        heading.setForeground(Color.CYAN);
        back.add(heading);

        // UserName text and its text Field
        JLabel userName = new JLabel("UserName : ");
        userName.setFont(new Font("Arial Black", Font.BOLD, 22));
        userName.setBounds(130,100,200,50);
        userName.setForeground(Color.CYAN);
        back.add(userName);

        username = new JTextField("  ");
        username.setBounds(320,110,300,40);
        username.setBackground(Color.BLACK);
        username.setForeground(Color.CYAN);
        username.setFont(new Font("Arial Black" , Font.BOLD,20 ));
        back.add(username);

        // Password and its text field
        JLabel pass = new JLabel("Password : ");
        pass.setFont(new Font("Arial Black", Font.BOLD, 22));
        pass.setBounds(130,160,300,50);
        pass.setForeground(Color.CYAN);
        back.add(pass);

        password = new JPasswordField("");
        password.setBounds(320,170,300,40);
        password.setBackground(Color.BLACK);
        password.setForeground(Color.CYAN);
        password.setFont(new Font("Arial Black" , Font.BOLD,20 ));
        back.add(password);

        // re-enter password and its textField
        JLabel repass = new JLabel("Re-Enter Password : ");
        repass.setFont(new Font("Arial Black", Font.BOLD, 22));
        repass.setBounds(130,225,300,50);
        repass.setForeground(Color.CYAN);
        back.add(repass);

        reEnterPassword = new JPasswordField("");
        reEnterPassword.setBounds(420,230,300,40);
        reEnterPassword.setBackground(Color.BLACK);
        reEnterPassword.setForeground(Color.CYAN);
        reEnterPassword.setFont(new Font("Arial Black" , Font.BOLD,20 ));
        back.add(reEnterPassword);

        // email and textField
        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Arial Black", Font.BOLD, 22));
        email.setBounds(130,280,300,50);
        email.setForeground(Color.CYAN);
        back.add(email);

        emailTextField= new JTextField(" ");
        emailTextField.setBounds(250,290,500,40);
        emailTextField.setBackground(Color.BLACK);
        emailTextField.setForeground(Color.CYAN);
        emailTextField.setFont(new Font("Arial Black" , Font.BOLD,20 ));
        back.add(emailTextField);

        // Age and its ComboBox
        JLabel age = new JLabel("Age : ");
        age.setFont(new Font("Arial Black", Font.BOLD, 22));
        age.setBounds(130,340,300,50);
        age.setForeground(Color.CYAN);
        back.add(age);

        String arr[] = { " ","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40"};
        ageBox = new JComboBox(arr);
        ageBox.setBounds(240,350,200,40);
        ageBox.setBackground(Color.BLACK);
        ageBox.setForeground(Color.CYAN);
        ageBox.setFocusable(false);
        ageBox.setFont(new Font("Arial Black", Font.BOLD, 20));
        back.add(ageBox);

        // back button
        backButton= new JButton("BACK");
        backButton.setBounds(20,410,100,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.CYAN);
        backButton.setFont(new Font("Arial Black", Font.BOLD, 10));
        backButton.setFocusPainted(false);
        backButton.addActionListener(this);
        back.add(backButton);

        // next Button
        next= new JButton("NEXT");
        next.setBounds(675,410,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.CYAN);
        next.setFont(new Font("Arial Black", Font.BOLD, 10));
        next.setFocusPainted(false);
        next.addActionListener(this);
        back.add(next);

        // Frame details .
        setSize(800,500);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setVisible(true);

    }
    // Action performed function  .
    public void actionPerformed(ActionEvent ae){

        //  Action on the back button
        if(ae.getSource() == backButton){
            setVisible(false);
            new HomePage(0).setVisible(true);
        }
        // Action on the next button
        if(ae.getSource() == next) {
            String name = username.getText();
            pas = password.getText();
            String mail = emailTextField.getText();
            String age = ageBox.getSelectedItem().toString();
            try {
                if (username.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username Required");
                } else if (!password.getText().equals(reEnterPassword.getText())) {
                    JOptionPane.showMessageDialog(null, "Both passwords are not same enter again !! ");
                } else if (emailTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Email Required");
                } else {
                    Conn conn = new Conn();
                    String query = "INSERT INTO signupS VALUES ('" +name+ "','" + pas + "','" + mail + "','" + age + "')";
                    String query2 = "INSERT INTO Score VALUES ('" + "0" + "','" + pas + "')";
                    String query3 = "INSERT INTO credentials VALUES ('" + "0" + "','"+"0"+"','" + pas + "','"+name+"')";
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);

                }
            } catch (Exception e) {
                System.out.println(e);

            }
            new Dashboard(pas,0).setVisible(true);
        }
    }
    public static void main(String[] args) {
            new SignUpPage();
    }
}

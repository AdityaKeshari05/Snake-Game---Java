import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;



public class HomePage extends JFrame implements ActionListener {
    Image background , logo , settingsLogo ;

    JButton login, signup , guest ,leaderboard , exit , settingButton;

    JComboBox<String> difficulty;

    String selectedDifficulty = "Easy" ;


    int width = 500;
    int height =300;

    private int score =0;

    HomePage(int score){
        this.score = score;
        // Function to init the components .
        initComponents();

        // adding BackGround
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("backGround/back.png"));
        background = i1.getImage();
        ImageIcon i2 = new ImageIcon(background);
        JLabel back = new JLabel(i2);
        back.setBounds(0,0,800,400);
        add(back);


        // adding main  Logo
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("backGround/SnakeLogo.png"));
        logo = i3.getImage();
        ImageIcon i4 = new ImageIcon(logo);
        JLabel logoS = new JLabel(i4);
        logoS.setBounds(295,5,180,200);
        back.add(logoS);

        // adding settings logo
        ImageIcon  i5 = new ImageIcon(ClassLoader.getSystemResource("backGround/settings.png"));
        settingsLogo  = i5.getImage();
        ImageIcon i6 = new ImageIcon(settingsLogo);
        settingButton = new JButton(i6);
        settingButton.setBounds(20,20,50,50);
        settingButton.setBorderPainted(false);
        settingButton.setContentAreaFilled(false);
        settingButton.setFocusPainted(false);

        // Add action listener to open settings dialog
            settingButton.addActionListener(qe -> {
            JDialog settingsDialog = new JDialog(this, "Settings", true);
            settingsDialog.setSize(300, 200);
            settingsDialog.setLocationRelativeTo(this); // Center relative to HomePage
            settingsDialog.setLayout(new GridLayout(3, 1));
            settingsDialog.getContentPane().setBackground(Color.BLACK);
            settingsDialog.setUndecorated(true);

            // CheckBox to on or off the sound
            JCheckBox soundCheck = new JCheckBox("Enable Sound");
            soundCheck.setBackground(Color.BLACK);
            soundCheck.setForeground(Color.CYAN);
            soundCheck.setFont(new Font("Arial Black", Font.BOLD, 16));
            soundCheck.setFocusPainted(false);
            // CheckBox to on or off the music .
            JCheckBox musicCheck = new JCheckBox("Background Music");
            musicCheck.setForeground(Color.CYAN);
            musicCheck.setBackground(Color.BLACK);
            musicCheck.setFont(new Font("Arial Black", Font.BOLD, 16));
            musicCheck.setFocusPainted(false);



            // Button to close the dialog box .
            JButton closeBtn = new JButton("Close");
            closeBtn.addActionListener(ev -> settingsDialog.dispose());
            closeBtn.setForeground(Color.CYAN);
            closeBtn.setBackground(Color.BLACK);
            closeBtn.setBounds(5,100,60,20);
            closeBtn.setFont(new Font("Arial Black", Font.BOLD, 16));
            closeBtn.setFocusPainted(false);

            // Adding all those .
            settingsDialog.add(soundCheck);
            settingsDialog.add(musicCheck);

            settingsDialog.add(closeBtn);
            settingsDialog.setVisible(true);
        });
        back.add(settingButton);




        // now adding the buttons
        // login button
        login = new JButton("LOGIN");
        login.setBounds(235,240,300,50);
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.CYAN);
        login.setFont(new Font("Arial Black", Font.BOLD, 18));
        login.setFocusPainted(false);
        login.addActionListener(this);
        back.add(login);

        // sign up button
        signup = new JButton("SIGN-UP");
        signup.setBounds(235,300,300,50);
        signup.setBackground(Color.DARK_GRAY);
        signup.setForeground(Color.CYAN);
        signup.setFont(new Font("Arial Black", Font.BOLD, 18));
        signup.setFocusPainted(false);
        signup.addActionListener(this);
        back.add(signup);

        // Play as a guest
        guest = new JButton("PLAY AS A GUEST");
        guest.setBounds(235,360,300,50);
        guest.setBackground(Color.DARK_GRAY);
        guest.setForeground(Color.CYAN);
        guest.setFont(new Font("Arial Black", Font.BOLD, 18));
        guest.setFocusPainted(false);
        guest.addActionListener(this);
        back.add(guest);

        // Exit Button
        exit= new JButton("EXIT");
        exit.setBounds(20,410,100,30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.CYAN);
        exit.setFont(new Font("Arial Black", Font.BOLD, 10));
        exit.setFocusPainted(false);
        exit.addActionListener(this);
        back.add(exit);

        // a combo box of difficulty level
        String arr[] = {"DIFFICULTIES","EASY" , "MEDIUM","HARD"};
        difficulty = new JComboBox<>(arr);
        difficulty.setBounds(625,15,150,30);
        difficulty.setBackground(Color.BLACK);
        difficulty.setForeground(Color.CYAN);
        difficulty.setFocusable(false);
        difficulty.setFont(new Font("Arial Black", Font.BOLD, 10));
        difficulty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                selectedDifficulty = (String)difficulty.getSelectedItem();

            }
        });
        difficulty.addActionListener(this);
        back.add(difficulty);

        // Frame details .
        setSize(800,500);
        setLocation(400,200);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    // Action Performed Function .
    public void actionPerformed(ActionEvent ae){

        // Action on exit button ,  through this the whole system will get close .
        if(ae.getSource() == exit){
            System.exit(0);
        }
        // Action on play as a guest button  .
        if(ae.getSource() ==guest) {
            if (selectedDifficulty.equals("EASY")) {
                width = 500;
                height = 300;
            } else if (selectedDifficulty.equals("MEDIUM")) {
                width = 500;
                height = 300;
            } else if (selectedDifficulty.equals("HARD")) {
                width = 500;
                height = 300;
            }
            // ← THIS IS THE FIX

            // Naya game window open karo
            new SnakeGame(width, height, selectedDifficulty, "",0).setVisible(true);
        }
        // Action on sign-up button
        if(ae.getSource() ==signup){
            setVisible(false);
            new SignUpPage().setVisible(true);
        }
        // Action on Login button .
        if(ae.getSource() == login){
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new HomePage(0);
    }

    // Function to show  a message  that how much score the user got from the last played game .
    public void initComponents(){
            System.out.println("Received Score from Game: " + score);

        }
    }


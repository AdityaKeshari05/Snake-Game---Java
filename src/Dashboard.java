import com.mysql.cj.protocol.ResultsetRows;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.sql.ResultSet;



public class Dashboard extends JFrame implements ActionListener{

    Image background;

    JButton play , termsCondition , leagues ,backButton,profile,fetch, refresh,leaderboard , feedBack , store , pinChange;

    String pas ,name;

    JComboBox difficulty;

    String selectedDifficulty = "Easy";

    JLabel coin ;

    int point , coins ;


    int width = 500;
    int height =300;

    private int score ;

    int isSkin = 0 ;

    JTextArea text ;

    Dashboard(String pas,int score){
        this.pas = pas;
        this.name = name;
        this.score  = score;



        // background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("backGround/back.png"));
        background = i1.getImage();
        ImageIcon i2 = new ImageIcon(background);
        JLabel back = new JLabel(i2);
        back.setBounds(0,0,800,400);
        add(back);

        // battle snake logo
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("backGround/battlesnakelogo.png"));
        background = i3.getImage();
        ImageIcon i4 = new ImageIcon(background);
        JLabel logo = new JLabel(i4);
        logo.setBounds(20,10,100,100);
        back.add(logo);

        // heading label
        JLabel heading = new JLabel("DashBoard");
        heading.setFont(new Font("Arial Black", Font.BOLD, 30));
        heading.setBounds(290,10,400,70);
        heading.setForeground(Color.CYAN);
        back.add(heading);

        // play button
        play = new JButton("PLAY");
        play.setBounds(240,220,300,60);
        play.setBackground(Color.BLACK);
        play.setForeground(Color.CYAN);
        play.setFocusable(false);
        play.addActionListener(this);
        back.add(play);

        // profile button
        profile = new JButton("PROFILE");
        profile.setBounds(650,20,100,30);
        profile.setBackground(Color.BLACK);
        profile.setForeground(Color.CYAN);
        profile.setFocusable(false);
        profile.addActionListener(this);
        back.add(profile);

        // terms and Conditions Button
        termsCondition = new JButton("Terms & Condition");
        termsCondition.setBounds(255,320,150,30);
        termsCondition.setBackground(Color.BLACK);
        termsCondition.setFont(new Font("Ink Free" , Font.BOLD,12));
        termsCondition.setForeground(Color.CYAN);
        termsCondition.setFocusable(false);
        termsCondition.addActionListener(this);
        back.add(termsCondition);

        // lEAgUE Button
        leagues= new JButton("LEAGUES");
        leagues.setBounds(420,320,100,30);
        leagues.setBackground(Color.BLACK);
        leagues.setFont(new Font("Ink Free" , Font.BOLD,12));
        leagues.setForeground(Color.CYAN);
        leagues.setFocusable(false);
        leagues.addActionListener(this);
        back.add(leagues);

        // back button
        backButton= new JButton("BACK");
        backButton.setBounds(20,440,100,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.CYAN);
        backButton.setFont(new Font("Arial Black", Font.BOLD, 10));
        backButton.setFocusPainted(false);
        backButton.addActionListener(this);
        back.add(backButton);





        // String array for the difficulties comboBox .
        String arr[] = {"DIFFICULTIES","EASY" , "MEDIUM","HARD"};

        // ComboBox for choosing difficulties .
        difficulty = new JComboBox<>(arr);
        difficulty.setBounds(620,60,150,30);
        difficulty.setBackground(Color.BLACK);
        difficulty.setForeground(Color.CYAN);
        difficulty.setFocusable(false);
        difficulty.setFont(new Font("Arial Black", Font.BOLD, 10));
        difficulty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                selectedDifficulty = (String) difficulty.getSelectedItem();

            }
        });
        difficulty.addActionListener(this);
        back.add(difficulty);

        // Leaderboards Button .
        leaderboard = new JButton("LEADERBOARDS");
        leaderboard.setBounds(620,100,150,30);
        leaderboard.setBackground(Color.BLACK);
        leaderboard.setForeground(Color.CYAN);
        leaderboard.setFont(new Font("Arial Black", Font.BOLD, 10));
        leaderboard.setFocusPainted(false);
        leaderboard.addActionListener(this);
        back.add(leaderboard);


        // Image for Coins .
        ImageIcon coinIcon = new ImageIcon(ClassLoader.getSystemResource("backGround/star.png"));

        // Label for coins.
        coin = new JLabel(""+coins ,coinIcon,JLabel.RIGHT);
        coin.setBounds(620,160,150,50);
        coin.setForeground(Color.WHITE);
        back.add(coin);

        // Convert button to convert the score to Points and Coins whenever the user wants ,  especially designed to click when the user wants to close the game .
        fetch = new JButton("CONVERT");
        fetch.setBounds(20,160,100,30);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.cyan);
        fetch.addActionListener(this);
        fetch.setFocusable(false);
        fetch.setFocusPainted(false);
        back.add(fetch);

        // Store button
        store = new JButton("STORE");
        store.setBounds(20,200,100,30);
        store.setBackground(Color.BLACK);
        store.setForeground(Color.cyan);
        store.addActionListener(this);
        store.setFocusable(false);
        store.setFocusPainted(false);
        back.add(store);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setBounds(20,280,100,30);
        pinChange.setBackground(Color.BLACK);
        pinChange.setFont(new Font("",Font.BOLD,10));
        pinChange.setForeground(Color.cyan);
        pinChange.addActionListener(this);
        pinChange.setFocusable(false);
        pinChange.setFocusPainted(false);
        back.add(pinChange);
        pinChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setLayout(null);

                // heading
                JLabel heading = new JLabel("Enter your Email");
                heading.setBounds(170,10,200,30);
                heading.setFont(new Font("Arial"  , Font.BOLD,18));
                heading.setBackground(Color.white);
                heading.setForeground(Color.white);
                frame.add(heading);

                //  email textField
                JTextField emailTextfield=  new JTextField();
                emailTextfield.setBounds(150,50,200,25);
                emailTextfield.setFont(new Font("Arial"  , Font.BOLD,13));
                frame.add(emailTextfield);

                JLabel enterNewPassword = new JLabel("Enter new Password : ");
                enterNewPassword.setBounds(10,100,200,30);
                enterNewPassword.setFont(new Font("Arial"  , Font.BOLD,15));
                enterNewPassword.setForeground(Color.white);
                frame.add(enterNewPassword);
                enterNewPassword.setVisible(false);

                JTextField newPasTextField = new JTextField();
                newPasTextField.setBounds(190,105,100,20);
                newPasTextField.setFont(new Font("Arial"  , Font.BOLD,12));
                frame.add(newPasTextField);
                newPasTextField.setVisible(false);

                JLabel reEnterNewPassword = new JLabel("Re-Enter new Password : ");
                reEnterNewPassword.setBounds(10,180,200,30);
                reEnterNewPassword.setFont(new Font("Arial"  , Font.BOLD,15));
                reEnterNewPassword.setForeground(Color.white);
                frame.add(reEnterNewPassword);
                reEnterNewPassword.setVisible(false);

                JTextField reNewPasTextField = new JTextField();
                reNewPasTextField.setBounds(200,185,100,20);
                reNewPasTextField.setFont(new Font("Arial"  , Font.BOLD,12));
                frame.add(reNewPasTextField);
                reNewPasTextField.setVisible(false);

                JButton next = new JButton("Next");
                next.setBounds(370,220,100,30);
                next.setBackground(Color.BLACK);
                next.setForeground(Color.white);
                frame.add(next);
                next.setVisible(false);
                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!newPasTextField.getText().equals(reNewPasTextField.getText())) {
                            JOptionPane.showMessageDialog(null, "Password do not match");
                        } else {
                            String newPass = newPasTextField.getText();
                            String email = emailTextfield.getText();
                            try {
                                Conn conn = new Conn();
                                String query = "update signupS set Password = '"+newPass+"' where Email = '"+email+"'";
                                String query2 = "update Score set pasWord ='"+newPass+"' where pasWord ='"+pas+"'";
                                String query3 = "update credentials set pass ='"+newPass+"' where pass ='"+pas+"'";
                                String query4 = "update skin set pass ='"+newPass+"' where pass ='"+pas+"'";
                                String query5 = "update feedback set pass ='"+newPass+"' where pass ='"+pas+"'";




                                conn.s.executeUpdate(query);
                                conn.s.executeUpdate(query2);
                                conn.s.executeUpdate(query3);
                                conn.s.executeUpdate(query4);
                                conn.s.executeUpdate(query5);
                                JOptionPane.showMessageDialog(null, "Password Changed Successfully");
                                frame.setVisible(false);
                            } catch (Exception ae) {
                                ae.printStackTrace();
                            }
                        }
                    }
                });


                JButton verify = new JButton("Verify");
                verify.setBounds(380,90,100,30);
                verify.setFont(new Font("Arial"  , Font.BOLD,14));
                verify.setBackground(Color.BLACK);
                verify.setForeground(Color.white);
                verify.setFocusPainted(false);
                frame.add(verify);
                verify.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String email = emailTextfield.getText();
                        try{
                            Conn conn = new Conn();
                            String query = "select Email from signupS where Password = '"+pas+"'";
                            ResultSet rs = conn.s.executeQuery(query);
                            if(rs.next()){
                                if(rs.getString("Email").equals(email)){
                                    JOptionPane.showMessageDialog(null,"Email verified Successfully ");
                                    enterNewPassword.setVisible(true);
                                    newPasTextField.setVisible(true);
                                    reEnterNewPassword.setVisible(true);
                                    reNewPasTextField.setVisible(true);
                                    next.setVisible(true);
                                }else{
                                    JOptionPane.showMessageDialog(null,"Wrong Email");
                                }
                            }
                        }catch (Exception ae){

                        }
                    }
                });









                frame.setLocation(550,310);
                frame.setSize(500,300);
                frame.getContentPane().setBackground(Color.BLACK);

                frame.setVisible(true);
            }
        });


        // Feedback Button
        feedBack = new JButton("FEEDBACK");
        feedBack.setBounds(20,240,100,30);
        feedBack.setBackground(Color.BLACK);
        feedBack.setForeground(Color.cyan);
        feedBack.addActionListener(this);
        feedBack.setFocusable(false);
        feedBack.setFocusPainted(false);
        back.add(feedBack);
        feedBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setBounds(0,0,800,500);
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("backGround/back.png"));
                background = i1.getImage();
                ImageIcon i2 = new ImageIcon(background);
                JLabel back = new JLabel(i2);
                back.setBounds(0,0,800,500);
                frame.add(back);

                JLabel feed = new JLabel("FEEDBACK : ");
                feed.setBounds(10,10,200,40);
                feed.setBackground(Color.black);
                feed.setForeground(Color.cyan);
                feed.setFont(new Font("Ink Free" ,Font.BOLD,16));
                back.add(feed);

                text = new JTextArea();
                text.setBounds(20,70,600,350);
                text.setFont(new Font("Arial" , Font.BOLD,22));
                back.add(text);



                JButton enter = new JButton("ENTER");
                enter.setBounds(650,400,100,30);
                enter.setBackground(Color.black);
                enter.setForeground(Color.cyan);
                enter.setFont(new Font("Arial Black" , Font.BOLD,12));
                enter.setFocusPainted(false);
                back.add(enter);
                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(text.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null,"Message box is Empty");
                        }else {
                            String feed = text.getText();
                            try{
                                Conn conn = new Conn();
                                String query = "insert into feedback values ('"+pas+"' , '"+feed+"')";
                                conn.s.executeUpdate(query);
                            }catch (Exception ae){
                                ae.printStackTrace();
                            }
                            JOptionPane.showMessageDialog(null, "Feedback posted successfully ");
                            frame.setVisible(false);
                        }
                    }
                });

                frame.setLocation(400,200);
                frame.setVisible(true);
            }
        });


        // Refresh Button
        refresh = new JButton("REFRESH");
        refresh.setBounds(20,120,100,30);
        refresh.setBackground(Color.BLACK);
        refresh.setForeground(Color.cyan);
        refresh.addActionListener(this);
        refresh.setFocusable(false);
        refresh.setFocusPainted(false);
        back.add(refresh);



        // Frame settings .
        setSize(800,500);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }
    // Action performed function .
    public void actionPerformed(ActionEvent ae){
        // Action fot the back button .
        if(ae.getSource() == backButton){
            setVisible(false);

        }
        // Action for convert button  .
        if(ae.getSource() == fetch){
            // Making two variables to store the last  updated coins and points from the database .
            int prevCoins =0;
            int prevPoint = 0;
            // Exception Handling .
            try{
                // Setting up connection with the database to get the coins and points .
                Conn conn = new Conn();
                String query = "SELECT coins FROM credentials WHERE pass = '"+pas+"'";

                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                     prevCoins = rs.getInt("coins");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // for points
            try{
                Conn conn = new Conn();
                String query = "SELECT points FROM credentials WHERE pass = '"+pas+"'";
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    prevPoint = rs.getInt("points");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // getting the last updated score .
            try {
                Conn con = new Conn(); // your database connection class

                // Step 1: Fetch current coins from database
                String query = "SELECT score FROM Score WHERE pasWord = '"+pas+"'";
                ResultSet rs = con.s.executeQuery(query);
                // updating the remaining score after the conversion of coins and points .
                if(rs.next()){
                    int currentScore = rs.getInt("score");


                    // Step 2: Check if score is greater than 50
                    if(currentScore >= 50){
                        int coinsToAdd = currentScore / 50;
                        prevCoins+= currentScore / 50;
                        prevPoint+= currentScore/2 ;
                        currentScore -= (coinsToAdd * 50);

                        // Step 3: Update the database
                        String updateQuery = "UPDATE Score SET score = "+currentScore+" WHERE pasWord = '"+pas+"'";


                        con.s.executeUpdate(updateQuery);

                        String updateCredentials = "UPDATE credentials SET coins = "+prevCoins+", points = "+prevPoint+" WHERE pass = '"+pas+"'";
                        con.s.executeUpdate(updateCredentials);

                        coin.setText(""+prevCoins);
                        coins = prevCoins;

                        JOptionPane.showMessageDialog(null, "Coins updated by " + coinsToAdd + " coins!");
                    }else{
                        JOptionPane.showMessageDialog(null,"Not Enough Score");
                    }

                }

                // After updating, go back to HomePage

            } catch (Exception e){
                e.printStackTrace();
            }
        }
        // Action for profile button  .
        if(ae.getSource() == profile){
            new Profile(pas).setVisible(true);
        }
        // Action when user hits the play button .
        if(ae.getSource() == play) {
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
            try{
                Conn conn = new Conn();
                String query = "select selected from skin where pass ='"+pas+"'";
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    if(rs.getString("selected").equalsIgnoreCase("1")){
                        isSkin = 1;
                    }else if(rs.getString("selected").equalsIgnoreCase("0")){
                        isSkin = 0;
                    }else if(rs.getString("selected").equalsIgnoreCase("2")){
                        isSkin = 2;
                    }else if(rs.getString("selected").equals("3")){
                        isSkin = 3;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            new SnakeGame(width, height, selectedDifficulty, pas,isSkin).setVisible(true);
        }
        //  Action when user hits leagues button .
        if(ae.getSource() == leagues){
            new LeagueUI().setVisible(true);
        }
        // Action when user hits refresh button .
        if(ae.getSource() == refresh){
            // Fetching the last updated coins so that ,  can show how many coins the user currently have .
            try {
                Conn conn = new Conn();
                String query = "SELECT coins FROM credentials WHERE pass = '"+pas+"'";
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    coins = rs.getInt("coins"); // update local variable too
                    coin.setText("" + coins);   // update the coin label
                    JOptionPane.showMessageDialog(null, "Coins refreshed!");
                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }

        // Action if user hits store button .
        if(ae.getSource() == store){
            new Store(coins,pas).setVisible(true);
        }
        if(ae.getSource() == leaderboard){
            new LeaderboardWindow().setVisible(true);
        }
        if(ae.getSource() ==  termsCondition){
            new TermsCondition().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Dashboard("",0);
    }
}

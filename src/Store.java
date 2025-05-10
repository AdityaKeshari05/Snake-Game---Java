import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Store extends JFrame implements ActionListener {
    Image background;

    JLabel back;

    JButton forFirst ,select,backButton , defaultSkin , select2 , forSecond , forThird , select3 , forFourth , select4;

    int coins ;

    String pas;

    private int  isAlternateSkin = 0;

    Store(int coins,String pas) {
        this.coins = coins;
        this.pas= pas;

        // backGround Image .
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("backGround/back.png"));
        background = i1.getImage();
        ImageIcon i2 = new ImageIcon(background);
        back = new JLabel(i2);
        back.setBounds(0,0,800,500);
        add(back);

        // Load the image ,  new skin image .

        fisrtSkin();
        setfirstSkinButton();
        secondSkin();
        setSecondSkinButton();
        thirdSkin();
        setThirdSkinButton();
        fourthSkin();
        setFourthSkinButton();
        //first button for first skin  .
        // heading
        JLabel  heading = new JLabel("STORE :");
        heading.setBounds(10,10,100,30);
        heading.setBackground(Color.BLACK);
        heading.setForeground(Color.cyan);
        heading.setFont(new Font("Arial Black",Font.BOLD,20));
        back.add(heading);


        // second heading .
        JLabel  skinHeading = new JLabel("SKINS :");
        skinHeading.setBounds(15,50,100,30);
        skinHeading.setBackground(Color.BLACK);
        skinHeading.setForeground(Color.cyan);
        skinHeading.setFont(new Font("Ink Free",Font.BOLD,20));
        back.add(skinHeading);

        forFirst = new JButton("25 Coins");
        forFirst.setBounds(90,200,100,30);
        forFirst.setBackground(Color.BLACK);
        forFirst.setForeground(Color.YELLOW);
        forFirst.setFocusPainted(false);
        forFirst.setFont(new Font("Arial Black",Font.BOLD,12));
        forFirst.addActionListener(this);
        back.add(forFirst);

        // select button  .


        // back button  .
        backButton = new JButton("BACK");
        backButton.setBounds(20,420,100,30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.CYAN);
        backButton.setFont(new Font("Arial Black", Font.BOLD, 10));
        backButton.setFocusPainted(false);
        backButton.addActionListener(this);
        back.add(backButton);


        //  defaultSkin button
        defaultSkin = new JButton("DEFAULT");
        defaultSkin.setBounds(680,10,100,30);
        defaultSkin.setBackground(Color.BLACK);
        defaultSkin.setForeground(Color.CYAN);
        defaultSkin.setFont(new Font("Arial Black", Font.BOLD, 10));
        defaultSkin.setFocusPainted(false);
        defaultSkin.addActionListener(this);
        back.add(defaultSkin);

        try{
            Conn conn = new Conn();
            String query = "select firstSkin from skin where pass ='"+pas+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                if(rs.getString("firstSkin").equalsIgnoreCase("1")){
                    forFirst.setVisible(false);
                    select.setVisible(true);
                }else{
                    forFirst.setVisible(true);
                    select.setVisible(false);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Conn conn = new Conn();
            String query = "select secondSkin from skin where pass ='"+pas+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                if(rs.getString("secondSkin").equalsIgnoreCase("2")){
                    forSecond.setVisible(false);
                    select2.setVisible(true);
                }else{
                    forSecond.setVisible(true);
                    select2.setVisible(false);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            Conn conn = new Conn();
            String query = "select thirdSkin from skin where pass ='"+pas+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                if(rs.getString("thirdSkin").equalsIgnoreCase("3")){
                    forThird.setVisible(false);
                    select3.setVisible(true);
                }else{
                    forThird.setVisible(true);
                    select3.setVisible(false);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            Conn conn = new Conn();
            String query = "select fourthSkin from skin where pass ='"+pas+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next()){
                if(rs.getString("fourthSkin").equalsIgnoreCase("4")){
                    forFourth.setVisible(false);
                    select4.setVisible(true);
                }else{
                    forFourth.setVisible(true);
                    select4.setVisible(false);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM skin WHERE pass = '" + pas + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                String selected = rs.getString("selected");
                if (selected.equals("1")) {
                    select.setText("Selected");
                    select2.setText("Select");
                    select3.setText("Select");
                    select4.setText("Select");

                } else if (selected.equals("2")) {
                    select2.setText("Selected");
                    select.setText("Select");
                    select3.setText("Select");
                    select4.setText("Select");
                } else if(selected.equals("3")){
                    select3.setText("Selected");
                    select.setText("Select");
                    select2.setText("Select");
                    select4.setText("Select");
                }else if(selected.equals("4")){
                    select4.setText("Selected");
                    select.setText("Select");
                    select2.setText("Select");
                    select3.setText("Select");
                }
                else {
                    select.setText("Select");
                    select2.setText("Select");
                    select3.setText("Select");
                    select4.setText("Select");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the frame size and properties
        setSize(800, 500);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setLayout(null);  // Use null layout for custom positioning
        setVisible(true);
    }
    public void fisrtSkin(){
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Snake/more1.png"));




        // Create a custom JPanel to display the image.

        JPanel first = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the panel's background to black
                setBackground(Color.BLACK);
                // Draw the image on the panel, scaled to fit 100x100
                g.drawImage(i3.getImage(), 0, 0, 100, 100, this); // Top-left corner of the panel
            }

        };
        // Set the panel size to exactly 100x100
        first.setPreferredSize(new Dimension(100, 100));
        first.setOpaque(true);  // Ensure the background color is visible

        // Set a white border around the panel
        first.setBorder(new LineBorder(Color.WHITE, 5));  // 5 is the border thickness

        // Set the panel's position at the top-left corner of the frame
        first.setBounds(90, 90, 100, 100);  // 100x100 size for the panel

        // Add the panel to the frame
        back.add(first);
    }
    public void secondSkin(){
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Snake/skin2.png"));




        // Create a custom JPanel to display the image.

        JPanel first = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the panel's background to black
                setBackground(Color.BLACK);
                // Draw the image on the panel, scaled to fit 100x100
                g.drawImage(i3.getImage(), 0, 0, 100, 100, this); // Top-left corner of the panel
            }
        };


        // Set the panel size to exactly 100x100
        first.setPreferredSize(new Dimension(100, 100));
        first.setOpaque(true);  // Ensure the background color is visible

        // Set a white border around the panel
        first.setBorder(new LineBorder(Color.WHITE, 5));  // 5 is the border thickness

        // Set the panel's position at the top-left corner of the frame
        first.setBounds(230, 90, 100, 100);  // 100x100 size for the panel

        // Add the panel to the frame
        back.add(first);
    }
    public void thirdSkin(){
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Snake/diamond2.png"));

        // Create a custom JPanel to display the image.

        JPanel first = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the panel's background to black
                setBackground(Color.BLACK);
                // Draw the image on the panel, scaled to fit 100x100
                g.drawImage(i3.getImage(), 0, 0, 100, 100, this); // Top-left corner of the panel
            }
        };


        // Set the panel size to exactly 100x100
        first.setPreferredSize(new Dimension(100, 100));
        first.setOpaque(true);  // Ensure the background color is visible

        // Set a white border around the panel
        first.setBorder(new LineBorder(Color.WHITE, 5));  // 5 is the border thickness

        // Set the panel's position at the top-left corner of the frame
        first.setBounds(370, 90, 100, 100);  // 100x100 size for the panel

        // Add the panel to the frame
        back.add(first);
    }
    public void fourthSkin(){
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Snake/block.png"));

        // Create a custom JPanel to display the image.

        JPanel first = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the panel's background to black
                setBackground(Color.BLACK);
                // Draw the image on the panel, scaled to fit 100x100
                g.drawImage(i3.getImage(), 0, 0, 100, 100, this); // Top-left corner of the panel
            }
        };


        // Set the panel size to exactly 100x100
        first.setPreferredSize(new Dimension(100, 100));
        first.setOpaque(true);  // Ensure the background color is visible

        // Set a white border around the panel
        first.setBorder(new LineBorder(Color.WHITE, 5));  // 5 is the border thickness

        // Set the panel's position at the top-left corner of the frame
        first.setBounds(510, 90, 100, 100);  // 100x100 size for the panel

        // Add the panel to the frame
        back.add(first);
    }

    public void setfirstSkinButton(){
        select = new JButton("Select");
        select.setBounds(90,200,100,30);
        select.setBackground(Color.BLACK);
        select.setForeground(Color.YELLOW);
        select.setFocusPainted(false);
        select.setFont(new Font("Arial Black",Font.BOLD,12));
        select.addActionListener(this);
        select.setVisible(false);
        back.add(select);
    }
    public void setSecondSkinButton(){
        forSecond = new JButton("50 Coins");
        forSecond.setBounds(230,200,100,30);
        forSecond.setBackground(Color.BLACK);
        forSecond.setForeground(Color.YELLOW);
        forSecond.setFocusPainted(false);
        forSecond.setFont(new Font("Arial Black",Font.BOLD,12));
        forSecond.addActionListener(this);
        back.add(forSecond);

        select2 = new JButton("Select");
        select2.setBounds(230,200,100,30);
        select2.setBackground(Color.BLACK);
        select2.setForeground(Color.YELLOW);
        select2.setFocusPainted(false);
        select2.setFont(new Font("Arial Black",Font.BOLD,12));
        select2.addActionListener(this);
        select2.setVisible(false);
        back.add(select2);
    }
    public void setThirdSkinButton(){
        forThird = new JButton("100 Coins");
        forThird.setBounds(370,200,100,30);
        forThird.setBackground(Color.BLACK);
        forThird.setForeground(Color.YELLOW);
        forThird.setFocusPainted(false);
        forThird.setFont(new Font("Arial Black",Font.BOLD,11));
        forThird.addActionListener(this);
        back.add(forThird);

        select3 = new JButton("Select");
        select3.setBounds(370 ,200,100,30);
        select3.setBackground(Color.BLACK);
        select3.setForeground(Color.YELLOW);
        select3.setFocusPainted(false);
        select3.setFont(new Font("Arial Black",Font.BOLD,12));
        select3.addActionListener(this);
        select3.setVisible(false);
        back.add(select3);
    }
    public void setFourthSkinButton(){
        forFourth = new JButton("200 Coins");
        forFourth.setBounds(510,200,100,30);
        forFourth.setBackground(Color.BLACK);
        forFourth.setForeground(Color.YELLOW);
        forFourth.setFocusPainted(false);
        forFourth.setFont(new Font("Arial Black",Font.BOLD,11));
        forFourth.addActionListener(this);
        back.add(forFourth);

        select4 = new JButton("Select");
        select4.setBounds(510 ,200,100,30);
        select4.setBackground(Color.BLACK);
        select4.setForeground(Color.YELLOW);
        select4.setFocusPainted(false);
        select4.setFont(new Font("Arial Black",Font.BOLD,12));
        select4.addActionListener(this);
        select4.setVisible(false);
        back.add(select4);
    }

    // Action performed function .
    public void actionPerformed(ActionEvent ae){
        // Action for the 25-coins button .
        if(ae.getSource() == forFirst){
            if(coins >= 4) {
                forFirst.setVisible(false);
                select.setVisible(true);
                int coin = coins-4;


                try{
                    Conn conn = new Conn();
                    String query = "update skin set firstSkin = 1 where pass = '"+pas+"'";
                    String query2 = "insert into skin values ('"+1+"','"+pas+"','"+1+"','"+-1+"','"+-1+"','"+-1+"')";
                    String query3 = "update credentials  set coins = '"+coin+"' where pass ='"+pas+"'";
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);

                }catch (Exception e){
                    e.printStackTrace();
                }

            }else{
                JOptionPane.showMessageDialog(null,"Insufficient coins");
            }
        }
        if(ae.getSource() == forSecond){
            try{
                Conn conn = new Conn();
                String query = "select firstSkin from skin where pass ='"+pas+"'";
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    if(rs.getString("firstSkin").equals("1")){
                        if(coins >=4) {
                            forSecond.setVisible(false);
                            select2.setVisible(true);
                            int coin = coins-4;

                            try{
                                Conn con = new Conn();
                                String query1 = "update skin set secondSkin = 2 where pass = '"+pas+"'";
                                String query2 = "insert into skin values ('"+2+"','"+pas+"','"+1+"','"+2+"','"+-1+"','"+-1+"')";
                                String query3 = "update credentials  set coins = '"+coin+"' where pass ='"+pas+"'";
                                con.s.executeUpdate(query1);
                                con.s.executeUpdate(query2);
                                con.s.executeUpdate(query3);

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            System.out.println("Snake skin selected");
                        }else{
                            JOptionPane.showMessageDialog(null,"Insufficient coins");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"You need to purchase the first skin before this .");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(ae.getSource() == forThird){
            try{
                Conn conn = new Conn();
                String query = "select secondSkin from skin where pass ='"+pas+"'";
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    if(rs.getString("secondSkin").equals("2")){
                        if(coins >=4) {
                            forThird.setVisible(false);
                            select3.setVisible(true);
                            int coin = coins-4;

                            try{
                                Conn con = new Conn();
                                String query1 = "update skin set thirdSkin = 3 where pass = '"+pas+"'";
                                String query2 = "insert into skin values ('"+3+"','"+pas+"','"+1+"','"+2+"','"+3+"','"+-1+"')";
                                String query3 = "update credentials  set coins = '"+coin+"' where pass ='"+pas+"'";
                                con.s.executeUpdate(query1);
                                con.s.executeUpdate(query2);
                                con.s.executeUpdate(query3);

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            System.out.println("Snake skin selected");
                        }else{
                            JOptionPane.showMessageDialog(null,"Insufficient coins");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"You need to purchase the second skin before this . ");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(ae.getSource() == forFourth){
            try{
                Conn conn = new Conn();
                String query = "select thirdSkin from skin where pass ='"+pas+"'";
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    if(rs.getString("thirdSkin").equals("3")){
                        if(coins >=4) {
                            forFourth.setVisible(false);
                            select4.setVisible(true);
                            int coin = coins-4;

                            try{
                                Conn con = new Conn();
                                String query1 = "update skin set fourthSkin = 4 where pass = '"+pas+"'";
                                String query2 = "insert into skin values ('"+4+"','"+pas+"','"+1+"','"+2+"','"+3+"','"+4+"')";
                                String query3 = "update credentials  set coins = '"+coin+"' where pass ='"+pas+"'";
                                con.s.executeUpdate(query1);
                                con.s.executeUpdate(query2);
                                con.s.executeUpdate(query3);

                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            System.out.println("Snake skin selected");
                        }else{
                            JOptionPane.showMessageDialog(null,"Insufficient coins");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"You need to purchase the third skin before this . ");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        if(ae.getSource() == defaultSkin){
            select.setText("Select");
            select2.setText("Select");
            select3.setText("Select");
            select4.setText("Select");
            try{
                Conn conn = new Conn();
                String query = "update skin set selected  = 0 where pass = '"+pas+"'";
                conn.s.executeUpdate(query);
            }catch (Exception e){

            }
        }

        // Action for the select button .
        if(ae.getSource() == select){
            select.setText("Selected");
            select2.setText("Select");
            select3.setText("Select");
            select4.setText("Select");
            isAlternateSkin = 1;

            try{
                Conn conn = new Conn();
                String query = "update skin set selected  = 1 where pass = '"+pas+"'";
                conn.s.executeUpdate(query);

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("First Snake skin selected ");
        }
        if(ae.getSource() == select2){
            select2.setText("Selected");
            select.setText("Select");
            select3.setText("Select");
            select4.setText("Select");
            isAlternateSkin = 2;

            try{
                Conn conn = new Conn();
                String query = "update skin set selected  = 2 where pass = '"+pas+"'";
                conn.s.executeUpdate(query);

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Second Snake skin selected ");
        }
        if(ae.getSource() == select3){
            select3.setText("Selected");
            select.setText("Select");
            select2.setText("Select");
            select4.setText("Select");
            isAlternateSkin = 3;

            try{
                Conn conn = new Conn();
                String query = "update skin set selected  = 3 where pass = '"+pas+"'";
                conn.s.executeUpdate(query);

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Third Snake skin selected ");
        }
        if(ae.getSource() == select4){
            select4.setText("Selected");
            select.setText("Select");
            select2.setText("Select");
            select3.setText("Select");
            isAlternateSkin = 4;

            try{
                Conn conn = new Conn();
                String query = "update skin set selected  = 4 where pass = '"+pas+"'";
                conn.s.executeUpdate(query);

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("" +
                    "Fourth Snake skin selected ");
        }





        // Action for the back button .
        if(ae.getSource() == backButton){
            setVisible(false);
        }


        Board board = new Board(500,300,"Easy",pas,isAlternateSkin);
        SnakeGame snake =  new SnakeGame(500,300,"Easy",pas,isAlternateSkin);
    }

    public static void main(String[] args) {
        new Store(0,"");
    }
}
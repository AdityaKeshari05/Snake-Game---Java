import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.a.result.NativeResultset;

import javax.swing. *;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class LeaderboardWindow extends JFrame {

    public LeaderboardWindow() {
        setTitle("Leaderboard");
        setSize(500, 400);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("backGround/back.png")); // <-- Your image file
        JLabel background = new JLabel(bgIcon);
        background.setLayout(new BorderLayout());
        setContentPane(background);

        JButton back =  new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.cyan);
        back.setBounds(20,340,100,30);
        back.setFocusPainted(false);
        background.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 50, 10));

        background.add(scrollPane , BorderLayout.CENTER);

        try {
            Conn conn  = new Conn();
            String query = "SELECT username, points FROM credentials ORDER BY points DESC";
            ResultSet rs = conn.s.executeQuery(query);
            int userCount= 1;
            while (rs.next()) {
                String username = rs.getString("username");
                int points = rs.getInt("points");

                JButton label = new JButton(userCount+".)"+" Username: " + username + " | Points: " + points);
                label.setFont(new Font("Arial", Font.PLAIN, 20));
                label.setBackground(Color.BLACK);
                label.setFocusPainted(false);
                label.setForeground(Color.cyan);
                label.setAlignmentX(Component.LEFT_ALIGNMENT);
                label.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            Conn conn = new Conn();
                            String query = "select Password from signupS where UserName = '"+username+"' ";
                            ResultSet rs = conn.s.executeQuery(query);
                            if(rs.next()){
                                String pas =  rs.getString("Password");
                                new Profile(pas).setVisible(true);
                            }
                        }catch (Exception ae){
                            ae.printStackTrace();
                        }
                    }
                });
                panel.add(label);
                panel.add(Box.createVerticalStrut(20));
                userCount++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        setUndecorated(true);
        setVisible(true);
        setLocation(950,350);
    }

    public static void main(String[] args) {
        new LeaderboardWindow();
    }
}
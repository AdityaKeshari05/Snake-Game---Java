import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TermsCondition extends JFrame {

    TermsCondition() {
        setTitle("Terms and Conditions");
        setSize(400, 600);
        setLocation(5, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // Absolute positioning

        // Background
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("backGround/back.png"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 400, 600);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);

        // Terms content panel
        JPanel termsPanel = new JPanel();
        termsPanel.setLayout(new BoxLayout(termsPanel, BoxLayout.Y_AXIS));
        termsPanel.setOpaque(false);

        String[] terms = {
                "The game has 3 difficulty levels: Easy, Medium, and Hard.",
                "",
                "There are 5 leagues: Bronze, Silver, Gold, Platinum, and Diamond.",
                "",
                "To give suggestions or feedback, use the Feedback option in the Dashboard.",
                "",
                "If you forget your password or want to change your PIN, use Forgot Password on the Home Page or Change PIN in the Dashboard.",
                "",
                "You can earn coins by playing the game and use them to unlock skins and backgrounds in the Store .",
                "",
                "Leaderboard rankings are based on the highest points.",
                "",
                "There is a Convert option in the dashboard through which you can convert your scores into points and coins",
                "",
                "Through the refresh option you can see how many coins you have , which is set to zero by default when you logged in .",
                "",
                "Whenever you are entering your email to reset or change your password enter it after giving one space to avoid errors .",
                "",
                "Please do not misuse or try to hack the game system.",
                "",
                "All user data is stored securely in the database.",
                "",
                "The developer is not responsible for any loss due to bugs or crashes.",
                "",
                "Enjoy the game and have fun competing with your friends!"
        };

        for (String term : terms) {
            JLabel label = new JLabel("<html><p style='width:350px'>" + term + "</p></html>");
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setForeground(Color.CYAN);
            label.setAlignmentX(Component.LEFT_ALIGNMENT);
            termsPanel.add(Box.createVerticalStrut(10)); // spacing
            termsPanel.add(label);
        }

        // ScrollPane setup
        JScrollPane scrollPane = new JScrollPane(termsPanel);
        scrollPane.setBounds(10, 10, 360, 470);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        backgroundLabel.add(scrollPane);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 500, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.CYAN);
        backButton.setFocusPainted(false);
        backgroundLabel.add(backButton);

        backButton.addActionListener(e -> dispose());
        getContentPane().setBackground(Color.BLACK);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TermsCondition::new);
    }
}
import javax.swing.*;
import java.awt.*;



public class Leagues extends JPanel {


    public Leagues(String currentLeague) {
        // Panel setting
        setLayout(new GridLayout(5, 1, 10, 10));
        setBackground(Color.BLACK);

        // Array for league name
        String leagues[] = {"  Bronze   :    Earn 500 Points ", "  Silver     :     Earn 1000 Points", "  Gold      :      Earn 1500 Points", "  Platinum      :      Earn 2000 Points", "  Diamond      :      Earn 3000 Points"};

        // Array for all the league icons
        String icons[] = {
                "src/ranks/bronze.png",
                "src/ranks/silver.png.jpg",
                "src/ranks/gold.png.jpg",
                "src/ranks/platinum.png.jpg",
                "src/ranks/diamond.png.jpg"
        };

        // Array for the description  .
        String Description[] = {
                "Earn 500 Points to access Bronze League" +
                        "Rewards  =  25 Coins", "Earn 1000 Points to access Silver League" +
                "Rewards = 50 Coins", "Earn 1500 Points to access Gold League" +
                "Rewards = 100 Coins", "Earn 2000 Points to access Platinum League" +
                "Rewards = 250 Coins", "Earn 3000 Points to access Diamond League" +
                "Rewards = 500 Coins"
        };

        // In a for loop making a checkBox .
        for (int i = 0; i < leagues.length; i++) {
            JCheckBox cb = new JCheckBox(leagues[i], getScaledIcon(icons[i], 100, 122));
            cb.setHorizontalTextPosition(SwingConstants.RIGHT);
            cb.setVerticalTextPosition(SwingConstants.CENTER);
            cb.setBackground(Color.WHITE);
            cb.setForeground(Color.WHITE);
            cb.setFocusPainted(false);
            cb.setBorderPainted(false);
            cb.setContentAreaFilled(false);
            cb.setFont(new Font("Arial", Font.BOLD, 16));

            // Highlight if current
            if (leagues[i].equalsIgnoreCase(currentLeague)) {
                cb.setSelected(true);
            }
            add(cb);
        }
    }

    // Function to get the image position .
    public ImageIcon getScaledIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}


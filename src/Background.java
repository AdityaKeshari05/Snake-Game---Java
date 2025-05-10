import javax.swing.*;
import java.awt.*;

public class Background {
    private Image backgroundImage;

    public Background(String imagePath) {
        // Load the background image
        backgroundImage = new ImageIcon(ClassLoader.getSystemResource("backGround/firstBackground.png")).getImage();
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }
}
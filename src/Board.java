
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Random;


public class Board extends JPanel implements ActionListener {
    private boolean buttonsAdded  = false;

    private Image apple;
    private Image dot;
    private Image head;
    private Image goldenApple ;
    private Image poisonousApple ;


    private final int All_DOTS = 900;
    private final int DOT_SIZE = 10;
    private final int Random_Position = 29;


    private int apple_x;
    private int apple_y;
    private int goldenAppleX, goldenAppleY;
    private int poisonAppleX, poisonAppleY;

    private final int x[] = new int[All_DOTS];
    private final int y[] = new int[All_DOTS];

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;


    private Timer timer;
    private int dots;
    private int score = 0;

    private boolean inGame = true;
    private boolean showGoldenApple = false;
    private boolean showPoisonApple = false;

    private JButton restart;
    private JButton backButton;
    int width, height;

    private int frameWidth, frameHeight;

    private int useAlternateSkin =  0;

    String difficulty;
    String pas;

    int finalScore=0;
    int totalScore;

    private long appleSpawnTime ;

    private boolean showWall = false;
    private boolean isWallVertical;
    private int wallPosition;

    private int bombX, bombY;
    private boolean showBomb = false;
    private long bombSpawnTime;
    private final int BOMB_WIDTH = 20;
    private final int BOMB_HEIGHT = 20;




    Image bombImage ;


    public void setAlternateSkin(int useAlternateSkin) {
        this.useAlternateSkin = useAlternateSkin;

        if (useAlternateSkin == 0) {
            loadImages();
        } else if(useAlternateSkin == 1) {
            loadImages2();
        }else if(useAlternateSkin == 2){
            loadImages3();
        }else if(useAlternateSkin == 3){
            loadImages4();
        }else if(useAlternateSkin == 4){
            loadImages5();
        }
        repaint();
    }
    public void spawnBomb() {
        Random rand = new Random();

        // Drop from top, random X
        bombX = rand.nextInt(frameWidth / DOT_SIZE) * DOT_SIZE;
        bombY = 0;
        showBomb = true;
        bombSpawnTime = System.currentTimeMillis();
    }
    public void moveBomb() {
        if(difficulty.equals("MEDIUM") || difficulty.equals("HARD")) {
            if (showBomb) {
                bombY += DOT_SIZE / 2;

                // Respawn bomb if it reaches bottom
                if (bombY > frameHeight) {
                    showBomb = false;
                }

                // Collision with snake head
                for (int i = 0; i < dots; i++) {
                    if (Math.abs(x[i] - bombX) < DOT_SIZE && Math.abs(y[i] - bombY) < DOT_SIZE) {
                        inGame = false;
                        timer.stop();
                        break;
                    }
                }
                Rectangle bombRect = new Rectangle(bombX, bombY, DOT_SIZE, DOT_SIZE);
                for (int i = 0; i < dots; i++) {
                    Rectangle snakeRect = new Rectangle(x[i], y[i], DOT_SIZE, DOT_SIZE);
                    if (bombRect.intersects(snakeRect)) {
                        inGame = false;
                        timer.stop();
                        break;
                    }
                }

            } else {
                // Random chance to spawn new bomb every few moves
                if (new Random().nextInt(100) < 2) { // 20% chance
                    spawnBomb();
                }
            }
        }
    }

    Board(int width, int height, String difficulty,String pas, int selectedSkin) {
        this.frameWidth = width;
        this.frameHeight = height;
        this.difficulty =difficulty;
        this.score = score;
        this.pas =pas;
        this.useAlternateSkin = selectedSkin;

        // adding that TAdapter class in the board to make that work .
        addKeyListener(new TAdapter());

        // adding a restart button to restart the game

        restart = new JButton("Restart");

        // function call  to load the skin of the snake .
        setAlternateSkin(useAlternateSkin);

        ImageIcon bomb = new ImageIcon(ClassLoader.getSystemResource("Snake/bomb.png"));
        bombImage = bomb.getImage();


        // function call  to start the game .
        initGame();

        //
        setupButtons();

        // Exception Handling for inserting the score of user into the database .


        // Data related with the main board class


        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setFocusable(true);
        requestFocusInWindow();
    }


    // for skin of the snake i.e , default skin .

    public void loadImages() {
        // image for the apple .
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Snake/apple.png"));
        apple = i1.getImage();
        // image for the body of the snake
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Snake/dot.png"));
        dot = i2.getImage();
        // image for the head of the snake
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Snake/head.png"));
        head = i3.getImage();
        // image for the golden apple
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("backGround/goldenApple.png"));
        goldenApple = i4.getImage();
        // image for the poisonous apple
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("backGround/poisonous.png"));
        poisonousApple = i5.getImage();
    }


    // for another skin yet to be done .
    public void loadImages2() {
        // image for the apple .
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Snake/apple.png"));
        apple = i1.getImage();
        // image for the body of the snake
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Snake/head1.png"));
        dot = i2.getImage();
        // image for the head of the snake
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Snake/head1.png"));
        head = i3.getImage();
        // image for the golden apple
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("backGround/goldenApple.png"));
        goldenApple = i4.getImage();
        // image for the poisonous apple
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("backGround/poisonous.png"));
        poisonousApple = i5.getImage();
    }

    public void loadImages3() {
        // image for the apple .
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Snake/apple.png"));
        apple = i1.getImage();
        // image for the body of the snake
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Snake/leopardskin.png"));
        dot = i2.getImage();
        // image for the head of the snake
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Snake/leopardskin.png"));
        head = i3.getImage();
        // image for the golden apple
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("backGround/goldenApple.png"));
        goldenApple = i4.getImage();
        // image for the poisonous apple
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("backGround/poisonous.png"));
        poisonousApple = i5.getImage();
    }
    public void loadImages4() {
        // image for the apple .
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Snake/apple.png"));
        apple = i1.getImage();
        // image for the body of the snake
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("backGround/diamond.png"));
        dot = i2.getImage();
        // image for the head of the snake
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("backGround/diamond.png"));
        head = i3.getImage();
        // image for the golden apple
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("backGround/goldenApple.png"));
        goldenApple = i4.getImage();
        // image for the poisonous apple
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("backGround/poisonous.png"));
        poisonousApple = i5.getImage();
    }
    public void loadImages5() {
        // image for the apple .
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Snake/apple.png"));
        apple = i1.getImage();
        // image for the body of the snake
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("backGround/purpleStone.png"));
        dot = i2.getImage();
        // image for the head of the snake
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("backGround/purpleStone.png"));
        head = i3.getImage();
        // image for the golden apple
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("backGround/goldenApple.png"));
        goldenApple = i4.getImage();
        // image for the poisonous apple
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("backGround/poisonous.png"));
        poisonousApple = i5.getImage();
    }

    // function to  start the game
    public void initGame() {
        // starting with the dots  = 3 ,  and as the snake will eat more apple it will get extend .
        dots = 3;

        // setting the position of the dots and the head .
        for (int i = 0; i < dots; i++) {
            y[i] = 50;
            x[i] = 50 - i * DOT_SIZE;
        }
        // function call to put random apples on the board .
        locateApple();



        // initializing a variable to store delay timings .
        int delay ;

        // applying switch cases in accordance with the difficulty level selected by the user
        switch (difficulty.toLowerCase()) {
            case "easy":
                delay = 90;  // Slow
                break;
            case "medium":
                delay = 70;  // Faster
                break;
            case "hard":
                delay = 60;   // Fastest
                break;
            default:
                delay = 100;  // Default to easy
        }

        // if the statement will work fine the printing another statement that will tell that yes difficulty chosen by the user is "Easy" and timer delay set to "140" is in Milliseconds .
        System.out.println("Difficulty: " + difficulty + ", Timer delay set to: " + delay);

        // making a timer variable and passing delay variable
        timer = new Timer(delay,this);
        // starting the timer
        timer.start();
    }



    // function that will generate apple randomly on the board .
    public void locateApple(){

        int maxX = (frameWidth / DOT_SIZE) - 1;
        int maxY = (frameHeight / DOT_SIZE) - 1;

        // Randomly choose which type of apple to spawn (0 = normal, 1 = golden, 2 = poisonous)
        int appleType = new Random().nextInt(10);  // 0-9

        // Reset all apple flags
        showGoldenApple = false;
        showPoisonApple = false;

        appleSpawnTime = System.currentTimeMillis();

        if (appleType == 0) {
            // 10% chance - golden apple
            goldenAppleX = new Random().nextInt(maxX) * DOT_SIZE;
            goldenAppleY = new Random().nextInt(maxY) * DOT_SIZE;
            showGoldenApple = true;
        } else if (appleType == 1) {
            // 10% chance - poisonous apple
            poisonAppleX = new Random().nextInt(maxX) * DOT_SIZE;
            poisonAppleY = new Random().nextInt(maxY) * DOT_SIZE;
            showPoisonApple = true;
        } else {
            // 80% chance - regular apple
            do {
                apple_x = new Random().nextInt(maxX) * DOT_SIZE;
                apple_y = new Random().nextInt(maxY) * DOT_SIZE;
            } while (apple_y < 30);  // Prevent overlap with score text
        }

        if(difficulty.equals("HARD")){
            generateWall();
        }
    }
    public void generateWall (){

            Random rand = new Random();
            if (rand.nextInt(10) < 2) {
                showWall = true;
                isWallVertical = rand.nextBoolean();

                if (isWallVertical) {
                    wallPosition = rand.nextInt((frameWidth / DOT_SIZE) - 1) * DOT_SIZE;
                } else {
                    wallPosition = rand.nextInt((frameHeight / DOT_SIZE) - 1) * DOT_SIZE;
                }
            } else {
                showWall = false;
                wallPosition = -1 ;
            }

    }

    //  This function is for actually drawing all the images in the board .
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        
        draw(g);
    }

    // Part of the drawing function
    public void draw(Graphics g){
       //  if inGame variable is true means when i user is hitting the play button then it should draw all the images .
       if(inGame){
           // drawing the positions of the apples .

           // a loop for drawing the snake head and body  .
           for(int i=0;i<dots;i++){
               // if i = 0  ,  defines that the head should be in the top .

               if(showGoldenApple){
                   g.drawImage(goldenApple,goldenAppleX,goldenAppleY,this);
               }
               else if(showPoisonApple){
                   g.drawImage(poisonousApple,poisonAppleX,poisonAppleY,this);
               }else {
                   g.drawImage(apple,  apple_x , apple_y ,this);
               }
               if(i == 0){
                   g.drawImage(head , x[i], y[i] ,this);

                   //  and after that body should be there .
               }else{

                   g.drawImage(dot, x[i], y[i], this);
                   }
               if(showWall){
                   g.setColor(Color.RED);
                   if(isWallVertical){
                       g.fillRect(wallPosition ,0,4,frameHeight);
                   }else{
                       g.fillRect(0,wallPosition,frameWidth,4);
                   }
               }

           }
           if (showBomb) {
               g.drawImage(bombImage, bombX, bombY, BOMB_WIDTH, BOMB_HEIGHT, this);
           }
           // Toolkit is something necessary for syncing .
           Toolkit.getDefaultToolkit().sync();

       // and if the snake is got hit by the wall then in the else condition calling the  game over function
       }else{
           gameOver(g);
       }
       // Graphics to show  coloring , score label etc .
       g.setColor(Color.white);
       g.setFont(new Font("Arial",Font.BOLD,14));
       g.drawString("Score " +score  ,10,20);
    }

    //  functions to set buttons after game over i.e ,  a back button and a restart button .
    public void setupButtons(){

        //  functions and designing  of the restart button declared previously .
        restart.setBounds((frameWidth - 100) / 2, (frameHeight / 2) + 30, 100, 30);
        restart.setFocusable(false);
        restart.setBackground(Color.BLACK);
        restart.setForeground(Color.white);
        restart.setVisible(false);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                restartGame();
                finalScore +=getScore();
            }
        });
        add(restart);


        // Back Button declaration and functions .
        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(10, frameHeight - 40, 80, 30);
        backButton.setVisible(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // taking a final score variable to store it when a user hits back button after playing the game .
                finalScore += getScore();
                // disposing the frame after hitting back button .
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(Board.this);
                topFrame.dispose();

                //  Exception handling for updating the score in the database  as the user keep playing the game .
                try {
                    Conn con = new Conn();

                    // First get the old score
                    String query1 = "SELECT score FROM Score WHERE pasWord = '" + pas + "'";
                    // make a result set and store the value of the last score updated .
                    ResultSet rs = con.s.executeQuery(query1);
                    // after getting the last score saving that into a new variable.
                    if (rs.next()) {
                        int oldScore = rs.getInt("score");
                        // after storing that adding the last updated score with the current earned score .
                        totalScore = oldScore + finalScore;
                    } else {
                        // If no record found (very rare if registration is correct), set totalScore = finalScore
                        totalScore = finalScore;
                    }

                    // Now update the score again  .
                    String query2 = "UPDATE Score SET score = '" + totalScore + "' WHERE pasWord = '" + pas + "'";
                    con.s.executeUpdate(query2);
                    // and opening the dashboard after hitting the back button .


                } catch (Exception ae) {
                    ae.printStackTrace();
                }

            }
        });
        add(backButton);
    }

    // function for game over .
    public void gameOver(Graphics g){
        // String to be used to show the text Game over as well as score message .
        String msg = "Game over";
        String scoreMsg = "Score: " + score;

        // setting font and colors
        Font font = new Font("SAN_SERIF",Font.BOLD,14);
        FontMetrics metrices  = getFontMetrics(font);
        g.setColor(Color.white);
        g.setFont(font);

        // declaring where to show the message after game gets over .
        int msgX = (getWidth() - metrices.stringWidth(msg)) / 2;
        int msgY = getHeight()/2 -  30;  // Y axis thoda upar .

        // Score message - thoda neeche
        int scoreX = (getWidth() - metrices.stringWidth(scoreMsg)) / 2;
        int scoreY = msgY + 30;
        int buttonWidth = 100;
        int buttonHeight = 30;
        int centerX = (getWidth() - buttonWidth) / 2;
        int buttonY = scoreY + 30; // Below the score
        restart.setBounds(centerX, buttonY, buttonWidth, buttonHeight);
        backButton.setBounds(10, getHeight() - 40, 80, 30); // Bottom-left corner
        g.drawString(msg,msgX,msgY);
        g.drawString(scoreMsg,scoreX,scoreY);

        restart.setVisible(true);
        backButton.setVisible(true);

    }
    // Function to move the snake  ,  increasing the snake body as it eats the apples .
    public void move(){
        for(int i = dots ; i>0;i--){
            x[i]  = x[i-1];
            y[i] = y[i-1];
        }
        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }
        if (rightDirection) {
            x[0] += DOT_SIZE;
        }
        if (upDirection) {
            y[0] -= DOT_SIZE;
        }
        if (downDirection) {
            y[0] += DOT_SIZE;
        }

    }
    // functions to check that snake has eaten the apple or not  ,  if yes increasing the snake body and increasing score by 10 for eating each  apple .
    public void checkApple(){
        if(x[0] == apple_x && y[0] == apple_y){
            dots+=1;
            score+=1;
            // again calling locate apple  function , so that after eating an  apple ,  the function will automatically generate new ones .
            locateApple();
        }else if(showGoldenApple && x[0] == goldenAppleX && y[0] == goldenAppleY){
            dots+=2;
            score+=2;
            showGoldenApple = false;
            locateApple();
        }else if(showPoisonApple && x[0] == poisonAppleX && y[0] == poisonAppleY){
            dots-=4;
            score-=4;
            showPoisonApple = false;
            locateApple();
        }

    }

    // Function  checking that if the  snake head is getting collided with body or not , if collided means the game over .
    public  void checkCollison(){
        for(int i = dots;i>0;i--){
            if(i > 4 && x[0] == x[i] && y[0] == y[i]){
                inGame = false ;
            }
        }
        if(y[0] >=getHeight()){
            inGame =false;
        }
        if(x[0] >= getWidth()){
            inGame =false;
        }
        if(y[0] <0){
            inGame =false;
        }
        if(x[0]<0){
            inGame =false;
        }

        if(!inGame){
            timer.stop();
        }
    }
    public void checkWallCollision(){

            if (!showWall || wallPosition == -1) return;

            if (isWallVertical && x[0] == wallPosition) {
                inGame = false;
            } else if (!isWallVertical && y[0] == wallPosition) {
                inGame = false;
            }

    }
    // Function for restarting the game and setting back the snake position .
    public void restartGame() {
        leftDirection = false;
        rightDirection = true;
        upDirection = false;
        downDirection = false;
        inGame = true;
        dots = 3;
        score = 0;

        for (int i = 0; i < dots; i++) {
            y[i] = 50;
            x[i] = 50 - i * DOT_SIZE;
        }

        locateApple();
        timer.start();

        restart.setVisible(false);
        backButton.setVisible(false);

        repaint();

    }
    // Action performed function  .
    public void actionPerformed(ActionEvent ae) {

        // Exception handling for inGame = true .
        try {
            if (inGame) {
                checkApple();
                move();
                moveBomb();
                checkCollison();
                checkWallCollision();


            }
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - appleSpawnTime >= 5000) {
            locateApple();
        }
    }


    // Class to set functions on left , right , up and down button with the help of KeyAdapter .
    public class TAdapter extends KeyAdapter  {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_UP && (!downDirection)) {
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }

            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }

        }

    }
    // Function to get score at the end of each game .
    public int getScore(){
        return score;
    }

}

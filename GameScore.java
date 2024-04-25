// code for printing out the score in the frame

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Random;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;


public class GameScore extends JFrame {

    public static int score;
    public static JFrame frame;
    public static ArrayList<JButton> buttonNum;
    public static ArrayList<Integer> buttonColor;
    public static final int FRAME_WIDTH = 300;
    public static final int FRAME_HEIGHT = 300;
    public static JLabel label;

public static void main(String[] args) {
        buttonNum = new ArrayList<JButton>();
        buttonColor = new ArrayList<Integer>();
        score = 10;
        frame = new JFrame();
        label = new JLabel();
        frame.setTitle("" + score);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        GamePanel gp = new GamePanel(2);
        frame.add(gp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
}
    
    
}

// code for the whole game frame which takes the user inputs for clicking buttons and calculating scores using these inputs.

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Random;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GamePanel extends JPanel{

    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JButton button4;
    public static int r;
    public int button1Color;
    public int button2Color;
    public int button3Color;
    public int button4Color;
    public static ArrayList<JButton> buttonNum;
    public static ArrayList<Integer> buttonColor;
    public static int score;
    public static JFrame frame;
    public static JLabel label;
    public static final int FRAME_WIDTH = 300;
    public static final int FRAME_HEIGHT = 300;

    public boolean isSameColor(JButton button1, JButton button2, JButton button3, JButton button4) {
            if((buttonColor.get(buttonNum.indexOf(button1)) == buttonColor.get(buttonNum.indexOf(button2)) && buttonColor.get(buttonNum.indexOf(button3)) == buttonColor.get(buttonNum.indexOf(button4))) && buttonColor.get(buttonNum.indexOf(button1)) == buttonColor.get(buttonNum.indexOf(button3))) {
                return true;
            }
            return false;
        }

        public boolean isOver() {
            if(score == 0) {return true;}
            for(int i = 0; i < buttonNum.size()-3; i = i + 4) {
                if(!isSameColor(buttonNum.get(i), buttonNum.get(i+1), buttonNum.get(i+2), buttonNum.get(i+3))) {
                    return false;
                }
            }
            return true;
        }

    public GamePanel(int depth) {
        this.setLayout(new GridLayout(2,2));
        Random random = new Random();

        if(depth == 0) {
            button1 = new JButton("");
            button2 = new JButton("");
            button3 = new JButton("");
            button4 = new JButton("");

            ActionListener listener = new ClickListener();
            button1.addActionListener(listener);
            button2.addActionListener(listener);
            button3.addActionListener(listener);
            button4.addActionListener(listener);

            r = random.nextInt(3);
            
            if(r == 0) 
            {
                button1.setBackground(Color.BLUE);
                button1Color = 0;
            }
            else if(r == 1) 
            {
                button1.setBackground(Color.GREEN);
                button1Color = 1;
            }
            else 
            {
                button1.setBackground(Color.RED);
                button1Color = 2;
            }

            r = random.nextInt(3);

            if (r == 0) 
            {
                button2.setBackground(Color.BLUE);
                button2Color = 0;
            }
            else if (r == 1) 
            {
                button2.setBackground(Color.GREEN);
                button2Color = 1;
            }
            else 
            {
                button2.setBackground(Color.RED);
                button2Color = 2;
            }

            r = random.nextInt(3);

            if(r == 0) 
            {
                button3.setBackground(Color.BLUE);
                button3Color = 0;
            }
            else if(r == 1) 
            {
                button3.setBackground(Color.GREEN);
                button3Color = 1;
            }
            else 
            {
                button3.setBackground(Color.RED);
                button3Color = 2;
            }

            r = random.nextInt(3);

            if(r == 0) 
            {
                button4.setBackground(Color.BLUE);
                button4Color = 0;
            }
            else if(r == 1) 
            {
                button4.setBackground(Color.GREEN);
                button4Color = 1;
            }
            else 
            {
                button4.setBackground(Color.RED);
                button4Color = 2;
            }

            this.add(button1);
            this.add(button2);
            this.add(button3);
            this.add(button4);

            buttonNum.add(button1);
            buttonNum.add(button2);
            buttonNum.add(button3);
            buttonNum.add(button4);

            buttonColor.add(button1Color);
            buttonColor.add(button2Color);
            buttonColor.add(button3Color);
            buttonColor.add(button4Color);

            if(isSameColor(button1, button2, button3, button4)) { 
                button1.setBackground(Color.GRAY);
                button2.setBackground(Color.GRAY);
                button3.setBackground(Color.GRAY);
                button4.setBackground(Color.GRAY);
                score = score + 10;
                frame.setTitle("" + score);
            }

        }
        else if(depth > 0) {
            GamePanel g1 = new GamePanel(depth-1);
            GamePanel g2 = new GamePanel(depth-1);
            GamePanel g3 = new GamePanel(depth-1);
            GamePanel g4 = new GamePanel(depth-1);

            this.add(g1);
            this.add(g2);
            this.add(g3);
            this.add(g4);
        }

    }

class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Random random = new Random();

            if(event.getSource() == button1) {
                r = random.nextInt(3);
            
                if(r == 0) 
                {
                    button1.setBackground(Color.BLUE);
                    int indx = buttonNum.indexOf(button1);
                    buttonColor.set(indx, 0);
                }
                else if(r == 1) 
                {
                    button1.setBackground(Color.GREEN);
                    int indx = buttonNum.indexOf(button1);
                    buttonColor.set(indx, 1);
                }
                else 
                {
                    button1.setBackground(Color.RED);
                    int indx = buttonNum.indexOf(button1);
                    buttonColor.set(indx, 2);
                }

                if(isSameColor(button1, buttonNum.get(buttonNum.indexOf(button1) + 1), buttonNum.get(buttonNum.indexOf(button1) + 2), buttonNum.get(buttonNum.indexOf(button1) + 3))) {
                    button1.setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button1) + 1).setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button1) + 2).setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button1) + 3).setBackground(Color.GRAY);
                    score = score + 10;
                    frame.setTitle("" + score);
                    button1.removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button1) + 1).removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button1) + 2).removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button1) + 3).removeActionListener(this);
                }
                else {
                    score = score - 1;
                    frame.setTitle("" + score);
                }

            }
            else if(event.getSource() == button2) {
                r = random.nextInt(3);

                 if (r == 0) 
                {
                    button2.setBackground(Color.BLUE);
                    int indx = buttonNum.indexOf(button2);
                    buttonColor.set(indx, 0);
                }
                else if (r == 1) 
                {
                    button2.setBackground(Color.GREEN);
                    int indx = buttonNum.indexOf(button2);
                    buttonColor.set(indx, 1);
                }
                else 
                {
                    button2.setBackground(Color.RED);
                    int indx = buttonNum.indexOf(button2);
                    buttonColor.set(indx, 2);
                }

                if(isSameColor(buttonNum.get(buttonNum.indexOf(button2) - 1), button2, buttonNum.get(buttonNum.indexOf(button2) + 1), buttonNum.get(buttonNum.indexOf(button2) + 2))) {
                    button2.setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button2) - 1).setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button2) + 1).setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button2) + 2).setBackground(Color.GRAY);
                    score = score + 10;
                    frame.setTitle("" + score);
                    button2.removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button2) - 1).removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button2) + 1).removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button2) + 2).removeActionListener(this);
                }
                else {
                    score = score - 1;
                    frame.setTitle("" + score);
                }

            }
            else if(event.getSource() == button3) {
                 r = random.nextInt(3);

                if(r == 0) 
                {
                    button3.setBackground(Color.BLUE);
                    int indx = buttonNum.indexOf(button3);
                    buttonColor.set(indx, 0);
                }
                else if(r == 1) 
                {
                    button3.setBackground(Color.GREEN);
                    int indx = buttonNum.indexOf(button3);
                    buttonColor.set(indx, 1);
                }
                else 
                {
                    button3.setBackground(Color.RED);
                    int indx = buttonNum.indexOf(button3);
                    buttonColor.set(indx, 2);
                }

                if(isSameColor(buttonNum.get(buttonNum.indexOf(button3) - 2), buttonNum.get(buttonNum.indexOf(button3) - 1), button3, buttonNum.get(buttonNum.indexOf(button3) + 1))) {
                    button3.setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button3) - 2).setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button3) - 1).setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button3) + 1).setBackground(Color.GRAY);
                    score = score + 10;
                    frame.setTitle("" + score);
                    button3.removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button3) - 2).removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button3) - 1).removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button3) + 1).removeActionListener(this);
                }
                else {
                    score = score - 1;
                    frame.setTitle("" + score);
                }

            }
            else if(event.getSource() == button4){
                r = random.nextInt(3);

                 if(r == 0) 
                {
                    button4.setBackground(Color.BLUE);
                    int indx = buttonNum.indexOf(button4);
                    buttonColor.set(indx, 0);
                }
                else if(r == 1) 
                {
                    button4.setBackground(Color.GREEN);
                    int indx = buttonNum.indexOf(button4);
                    buttonColor.set(indx, 1);
                }
                else 
                {
                    button4.setBackground(Color.RED);
                    int indx = buttonNum.indexOf(button4);
                    buttonColor.set(indx, 2);
                }

                if(isSameColor(buttonNum.get(buttonNum.indexOf(button4) - 3), buttonNum.get(buttonNum.indexOf(button4) - 2), buttonNum.get(buttonNum.indexOf(button4) - 1), button4)) {
                    button4.setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button4) - 3).setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button4) - 2).setBackground(Color.GRAY);
                    buttonNum.get(buttonNum.indexOf(button4) - 1).setBackground(Color.GRAY);
                    score = score + 10;
                    frame.setTitle("" + score);
                    button4.removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button4) - 3).removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button4) - 2).removeActionListener(this);
                    buttonNum.get(buttonNum.indexOf(button4) - 1).removeActionListener(this);
                }
                else {
                    score = score - 1;
                    frame.setTitle("" + score);
                }

            }

                    if(isOver()) {
                        int choice = JOptionPane.showConfirmDialog(frame,"Play Again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if(choice == JOptionPane.YES_OPTION)
                        {
                            frame.setVisible(false);
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
                        else if (choice == JOptionPane.NO_OPTION)
                        {
                            System.exit(0);
                        }
                    }

}
}
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

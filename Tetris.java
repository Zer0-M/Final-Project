import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Tetris extends JFrame implements ActionListener{
  private Container pane;
  private JTextField score;
  private Board matrix;
  public Tetris(){
    this.setTitle("Tetris");
    this.setSize(500,250);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
  }
  public int getScore(){
    return score.getText();
  }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Tetris extends JFrame{
  private Container pane;
  private JTextField score;
  // private Board  matrix;
  private JPanel sidebar;
  public Tetris(){
    this.setTitle("Tetris");
    this.setSize(1000,700);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new GridLayout());
    score=new JTextField("0",20);
    score.setEditable(false);
    sidebar=new JPanel();
    // matrix=new Board(500,700);
    //pane.add(matrix);
    pane.add(sidebar);
    sidebar.add(score);


  }
  public String getScore(){
    return score.getText();
  }
  public static void main(String[] args){
    Tetris t=new Tetris();
    t.setVisible(true);
  }
}

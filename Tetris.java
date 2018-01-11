import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Tetris extends JFrame{
  private Container pane;
  private JLabel  score;
  private Board  matrix;
  private JPanel sidebar;
  public Tetris(){
    this.setTitle("Tetris");
    this.setSize(800,800);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new GridLayout());
    score=new JLabel("0");
    sidebar=new JPanel();
    score.setFont(new Font("Serif",Font.PLAIN,30));
    matrix=new Board();
    pane.add(matrix);
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

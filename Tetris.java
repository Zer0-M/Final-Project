import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Tetris extends JFrame implements ActionListener{
  private Container pane;
  private Timer timer;
  private JLabel  score;
  private JButton pause;
  private JButton play;
  private JButton restart;
  private JButton start;
  private Board  matrix;
  private Board matrix1;
  private JPanel sidebar;
  public Tetris(){
    this.setTitle("Tetris");
    this.setSize(800,800);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    start=new JButton("START");
    restart=new JButton("restart");
    pause=new JButton("pause");
    play=new JButton("play");
    start.addActionListener(this);
    restart.addActionListener(this);
    pause.setFocusable(false);
    play.setFocusable(false);
    start.setFocusable(false);
    restart.setFocusable(false);
    pause.addActionListener(this);
    play.addActionListener(this);
    pane = this.getContentPane();
    start.setPreferredSize(new Dimension(200, 100));
    pane.setLayout(new FlowLayout());
    score=new JLabel("0");
    sidebar=new JPanel();

    sidebar.setVisible(false);
    sidebar.add(play);
    sidebar.add(restart);
    sidebar.add(pause);
    sidebar.add(score);

    score.setFont(new Font("Serif",Font.PLAIN,30));
    matrix=new Board();
    matrix.setVisible(false);
    pane.add(start);
    pane.add(matrix);
    pane.add(sidebar);

  }
  public void gameOver(){
    if(matrix.end()){
      matrix.restart();
      matrix.setVisible(false);
      sidebar.setVisible(false);
      pane.add(start);
    }
  }
  public void actionPerformed(ActionEvent e){
    String s=e.getActionCommand();
    System.out.println(matrix.end());
    System.out.println(s);
    if(s.equals("START")){
	    pane.setLayout(new GridLayout());
	    pane.remove(start);
	    matrix.setVisible(true);
	    matrix.requestFocus();
	    sidebar.setVisible(true);
    }
    if(s.equals("restart")){
      matrix.restart();
    }
    if(s.equals("pause")){
	    matrix.pause();
    }
    else if(s.equals("play")){
	    matrix.play();
    }


  }
  public String getScore(){
    return score.getText();
  }
  public static void main(String[] args){
    Tetris t=new Tetris();
    t.setVisible(true);
  }
}

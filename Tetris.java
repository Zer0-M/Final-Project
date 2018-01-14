import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Tetris extends JFrame implements ActionListener{
    private Container pane;
    private JLabel  score;
    private Timer timer;
    private JLabel  gameover;
    private JButton pause;
    private JButton play;
    private JButton start;
    private JButton restart;
    private Board  matrix;
    private JPanel sidebar;
    public Tetris(){
	this.setTitle("Tetris");
	this.setSize(800,1000);
	this.setLocation(100,0);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	start=new JButton("START");
	pause=new JButton("pause");
	play=new JButton("play");
	timer=new Timer(500,this);
	timer.setActionCommand("gameover?");
	timer.start();
	restart=new JButton("restart");
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
	pane.setLayout(new GridBagLayout());
	score=new JLabel("Score:0");
	gameover=new JLabel("GAMEOVER");
	gameover.setFont(new Font("Serif",Font.PLAIN,100));
	gameover.setForeground(Color.RED);
	sidebar=new JPanel();

	score.setFont(new Font("Serif",Font.PLAIN,30));
	matrix=new Board(this);
	pane.add(start, new GridBagConstraints());

	pane.add(matrix);
	pane.add(sidebar);
	matrix.setVisible(false);
	sidebar.setVisible(false);
	sidebar.add(restart);
	sidebar.add(play);
	sidebar.add(pause);
	sidebar.add(score);
    }
    public void gameOver(){
    	matrix.setVisible(false);
	sidebar.setVisible(false);
	pane.setLayout(new FlowLayout());
	pane.add(gameover);
     	pane.add(start);
    }
    public void actionPerformed(ActionEvent e){
	String s=e.getActionCommand();
	if(s.equals("gameover?")){
	    if(matrix.end()){
		gameOver();

	    }
	}
	if(s.equals("START")){
	    pane.remove(gameover);
	    matrix.restart();
	    pane.setLayout(new GridLayout());
	    pane.remove(start);
	    matrix.setVisible(true);
	    matrix.requestFocus();
	    sidebar.setVisible(true);
	}
	if(s.equals("pause")){
	    matrix.pause();
	}
	if(s.equals("restart")){
	    matrix.restart();
	}
	else if(s.equals("play")){
	    matrix.play();
	}
    }
    public JLabel getScore(){
	return score;
    }
    public static void main(String[] args){
	Tetris t=new Tetris();
	t.setVisible(true);
    }
}

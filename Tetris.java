import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Tetris extends JFrame implements ActionListener{
    private Container pane;
    private JLabel  score;
    private JButton pause;
    private JButton play;
    private JButton start;
    private Board  matrix;
    private JPanel sidebar;
    public Tetris(){
	this.setTitle("Tetris");
	this.setSize(800,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	start=new JButton("START");
	pause=new JButton("pause");
	play=new JButton("play");
	start.addActionListener(this);
	pause.setFocusable(false);
	play.setFocusable(false);
	start.setFocusable(false);
	pause.addActionListener(this);
	play.addActionListener(this);
	pane = this.getContentPane();
	start.setPreferredSize(new Dimension(200, 100));
	pane.setLayout(new FlowLayout());
	score=new JLabel("0");
	sidebar=new JPanel();

	score.setFont(new Font("Serif",Font.PLAIN,30));
	matrix=new Board();
	pane.add(start);
	pane.add(matrix);
	pane.add(sidebar);
	matrix.setVisible(false);
	sidebar.setVisible(false);
	sidebar.add(play);
	sidebar.add(pause);
	sidebar.add(score);
    }
    public void actionPerformed(ActionEvent e){
	String s=e.getActionCommand();
	if(s.equals("START")){
	    pane.setLayout(new GridLayout());
	    pane.remove(start);
	    matrix.setVisible(true);
	    matrix.requestFocus();
	    sidebar.setVisible(true);
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

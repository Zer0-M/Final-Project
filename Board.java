import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Board extends JPanel implements ActionListener{
    public Timer timer;
    private int xcor;
    private int ycor;
    public boolean moving;
    public int[][][] curShape;
    public Board() {
	setBackground(Color.WHITE);
        timer=new Timer(500, this);
	timer.start();
	xcor = 160;
	ycor = 0;
	moving = false;
    }	
    public void paint(Graphics g){
	super.paintComponent(g);
	Tetrimino t = new Tetrimino();
	int row = xcor;
	int col = ycor;
	int[][][] shape;
	if(!moving){
	    shape = t.randGen();
	    curShape = shape;
	    moving = true;
	}else{
	    shape = curShape;
	}
	for(int i=0; i<t.getLen(shape, 1); i++){
	    for(int j=0; j<t.getWid(shape, 1); j++){
		if(t.getSquare(shape,1,i,j) == 1){
		    g.drawRect(row,col,40,40);
		    g.drawRect(row-1,col-1,40,40);
		    g.setColor(t.getCol(shape));
		    g.fillRect(row,col,40,40);
		    g.setColor(Color.BLACK);
		}
		row += 40;
	    }
	    col += 40;
	    row = 160;
	}
	ycor += 40;
    }
    public void actionPerformed(ActionEvent e){
	ycor += 40;
	repaint();
    }
    private boolean movePiece(){
	return false;
    }
    private boolean stopPiece(){
	return false;
    }
    private boolean pieceOutside(){
	return false;
    }
    private boolean isFilled(){
	return false;
    }
    public void clearRow(int row){

    }
    public void start(){

    }
    public void end(){

    }
}

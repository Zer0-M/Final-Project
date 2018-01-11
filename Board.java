import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
public class Board extends JPanel implements ActionListener{
    public Timer timer;
    private int xcor;
    private int ycor;
    private int orientation;
    private boolean moving;
    private int[][][] curShape;
    private int[][] coordTable;
    private Tetrimino t;
    public Board() {
	t = new Tetrimino();
	setBackground(Color.WHITE);
	coordTable = new int[10][20];
	timer=new Timer(200, this);
	timer.start();
	xcor = 4;
	ycor = 0;
	orientation = 0;
	moving = false;
    }
    public void paint(Graphics g){
	super.paintComponent(g);
	int row = xcor*40;
	int col = ycor*40;
	int ori = orientation;
	int[][][] shape;
	if(!moving){
	    shape = t.randGen();
	    this.curShape = shape;
	    moving = true;
	}else{
	    shape = curShape;
	}
	for(int i=0; i<t.getLen(shape, ori); i++){
	    for(int j=0; j<t.getWid(shape, ori); j++){
		if(t.getSquare(shape,ori,i,j) == 1){
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
	ycor++;
    }
    public void actionPerformed(ActionEvent e){
	if(curShape != null){
	   if(!tryMovePiece()){
		moving = false;
	   }
	}
	if(!moving){
	    xcor = 4;
	    ycor = 0;
	    orientation = 0;
	    moving = false;
	}
	repaint();
    }
    private boolean tryMovePiece(){
	if(t.getLen(curShape, orientation) + ycor > 20){
	    return false;
	}
	return true;
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

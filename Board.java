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
	coordTable = new int[20][10];
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
		    g.setColor(t.getCol(shape));
		    g.fillRect(row,col,40,40);
		    g.setColor(Color.BLACK);
		    g.drawRect(row,col,40,40);
		}
		row += 40;
	    }
	    col += 40;
	    row = xcor*40;
	}
	for(int y=0; y<20; y++){
	    for(int x=0; x<10; x++){
		if(coordTable[y][x] > 0){
		    g.setColor(t.getCol(coordTable[y][x]));
		    g.fillRect(x*40,y*40,40,40);
		    g.setColor(Color.BLACK);
		    g.drawRect(x*40,y*40,40,40);
		    g.drawRect((row*40)+1,(col*40)+1,40,40);
		}
	    }
	}
	ycor++;
    }
    public void actionPerformed(ActionEvent e){
	if(curShape != null){
	   if(!tryMovePiece()){
		moving = false;
	   }
	}
	if(!moving && curShape != null){
	    int ori = orientation;
	    int tempx = xcor;
	    for(int i=0; i<t.getLen(curShape, ori); i++){
		for(int j=0; j<t.getWid(curShape, ori); j++){
		    if(t.getSquare(curShape,ori,i,j) == 1){
			coordTable[ycor-1][xcor] = t.getNum(curShape);
		    }
		    xcor++;
		}
		ycor++;
		xcor = tempx;
	    }
	    xcor = 4;
	    ycor = 0;
	    orientation = 0;
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
public class Board extends JPanel implements ActionListener, KeyListener{
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
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
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
	    if(!tryMoveDown()){
		moving = false;
	    }
	}
	if(!moving  && curShape != null){
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
    private boolean tryMoveDown(){
	if(stopPiece() || t.getLen(curShape, orientation) + ycor > 20 || t.getWid(curShape, orientation) + xcor > 10){
	    return false;
	}
	return true;
    }
    public void keyReleased(KeyEvent e){
	if(e.getKeyCode() == KeyEvent.VK_UP){
	    rotateR();
	}
	if(e.getKeyCode() == KeyEvent.VK_DOWN){
	    rotateR();
	}
	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
	    moveR();
	}
	if(e.getKeyCode() == KeyEvent.VK_LEFT){
	    moveL();
	}
    }
    public void keyTyped(KeyEvent e){
    }
    public void keyPressed(KeyEvent e){
    }
    private void rotateR(){
	System.out.println(ycor);
	int len = t.getWid(curShape, (orientation+1) % t.getOris(curShape));
	if(len + xcor < 10 && xcor - len >= 0){
	    ycor += (t.getLen(curShape, orientation+1) - t.getLen(curShape, orientation));
	    orientation = (orientation+1) % t.getOris(curShape);
	}
    }
    private void rotateL(){
	int len = t.getWid(curShape, ((orientation+t.getOris(curShape)-1) % t.getOris(curShape)));
	if(len + xcor < 10 && xcor - len >= 0){
	    orientation = (orientation+t.getOris(curShape)-1) % t.getOris(curShape);
	}
    }
    private void moveR(){
	boolean canMove = true;
	if(t.getWid(curShape, orientation) + xcor < 10){
	    int x = xcor + t.getLen(curShape, orientation);
	    for(int y=ycor; y< ycor + t.getLen(curShape, orientation); y++){
		if(coordTable[y][x] >= 1 || (y < 19 && coordTable[y+1][x] >= 1)){
		    canMove = false;
		}
	    }
	    if(canMove){
		xcor++;
	    }
	}
    }
    private void moveL(){
	boolean canMove = true;
	if(xcor - t.getWid(curShape, orientation) >= -(t.getWid(curShape, orientation))+1){
	    for(int y=ycor; y< ycor + t.getLen(curShape, orientation); y++){
		if(coordTable[y][xcor-1] >= 1 || (y < 19 && coordTable[y+1][xcor-1] >= 1)){
		    canMove = false;
		}
	    }
	    if(canMove){
		xcor--;
	    }
	}
    }
    private boolean stopPiece(){
	int y=ycor+t.getLen(curShape, orientation)-3;
	int i = 0;
	for(int x=xcor; x<t.getWid(curShape, orientation) + xcor; x++){
	    int curSquare = t.getSquare(curShape, orientation, t.getLen(curShape, orientation)-1, i);
	    if(curSquare == 0 && coordTable[y][x] >= 1){
		return true;
	    }
	    if(y < 18 && curSquare == 1 && coordTable[y+2][x] >= 1){
		return true;
	    }
	}
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

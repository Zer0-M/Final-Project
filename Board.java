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
    private int displacement;
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
	displacement = 0;
	moving = false;
	addKeyListener(this);
	setFocusable(true);
	setFocusTraversalKeysEnabled(false);
    }
    public void paint(Graphics g){
	super.paintComponent(g);
	int row = xcor*40;
	int col = ycor*40+displacement;
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
	if(displacement == 0){
	    ycor++;
	}
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
	isFilled();
	if(!end()){
	    repaint();
	}
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
	if(e.getKeyCode() == KeyEvent.VK_SPACE){
	    speedUp();
	}
    }
    private void rotateR(){
	boolean canRotate = true;
	int wid = t.getWid(curShape, (orientation+1) % t.getOris(curShape));
	int len = t.getLen(curShape, (orientation+1) % t.getOris(curShape));
	if(wid + xcor < 11 && len + ycor < 21){
	    int ori = (orientation+1) % t.getOris(curShape);
	    for(int y = ycor+1; y<t.getLen(curShape, ori); y++){
		for(int x = xcor; x<t.getWid(curShape, ori); x++){
		    if(coordTable[y][x] >= 1 || (y < 18 && coordTable[y+1][x] >= 1)){
			canRotate = false;
		    }
		}	
	    }
	    if(canRotate){
		orientation = ori;
	    }
	}
    }
    private void rotateL(){
	boolean canRotate = true;
	int wid = t.getWid(curShape, ((orientation+t.getOris(curShape)-1) % t.getOris(curShape)));
	int len = t.getLen(curShape, (orientation+1) % t.getOris(curShape));
	if(wid + xcor < 11 && len + ycor < 21){
	    int ori = (orientation+t.getOris(curShape)-1) % t.getOris(curShape);
	    for(int y = ycor+1; y<t.getLen(curShape, ori); y++){
		for(int x = xcor; x<t.getWid(curShape, ori); x++){
		    if(coordTable[y][x] >= 1 || (y < 18 && coordTable[y+1][x] >= 1)){
			canRotate = false;   
		    }
		}
	    }
	    if(canRotate){
		orientation = ori;
	    }
	}

    }
    private void moveR(){
	boolean canMove = true;
	if(t.getWid(curShape, orientation) + xcor < 10){
	    int x = xcor + t.getLen(curShape, orientation)-1;
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
		if(coordTable[y][xcor-1] >= 1 || (y<19 && coordTable[y+1][xcor-1] >= 1)){
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
	    int testY = t.getLen(curShape, orientation)-1;
	    int curSquare = t.getSquare(curShape, orientation, testY, i);
	    if(curSquare == 0 && t.getSquare(curShape, orientation, testY-1, i) == 0){
		curSquare = t.getSquare(curShape, orientation, testY-2, i);
	    }
	    if(y < 18 && (curSquare == 0 && coordTable[y+1][x] >= 1 || curSquare == 1 && coordTable[y+2][x] >= 1)){
		return true;
	    }
	    i++;
	}
	return false;
    }
    public void pause(){
	timer.stop();
    }
    public void play(){
	timer.start();
    }
    private void isFilled(){
	for(int y=19; y>=0; y--){
	    boolean filled = true;
	    for(int x=0; x<10; x++){
		if(coordTable[y][x] == 0){
		    filled = false;
		}
	    }
	    if(filled){
		clearRow(y);
		filled = false;
	    }
	}
    }
    public void clearRow(int y){
	for(int x=0; x<10; x++){
	    coordTable[y][x] = 0;
	}
	moveDown(y);
    }
    public void moveDown(int y){
	while(y>0){
	    for(int x=0; x<10; x++){
		coordTable[y][x] = coordTable[y-1][x];
	    }
	    y--;
	}
    }
    public void speedUp(){
	if(ycor + t.getLen(curShape, orientation) < 20){
	    boolean canMove = true;
	    for(int y=ycor+2; y<ycor + 2  + t.getLen(curShape, orientation); y++){
		for(int x=xcor; x<xcor + t.getWid(curShape, orientation); x++){
		    if(y<20 && coordTable[y][x] >= 1){
			canMove = false;
		    }
		}
	    }
	    if(canMove){
		for(int i=0; i<5; i++){
		    try{
			if(i>0){
			    Thread.sleep(50);
			}
		    }catch(InterruptedException e){
			Thread.currentThread().interrupt();
		    }
		    repaint();
		    displacement += 20;
		}
		displacement = 0;
	    }
	}
    }
    public void start(){
    }
    public boolean end(){
	if(coordTable[1][4] >= 1){
	    timer.stop();
	    return true;
	}
	return false;
    }
}

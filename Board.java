import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Board extends JPanel implements KeyListener{
  public Timer timer;
    public Board() {
	setBackground(Color.WHITE);
  timer=new Timer();
    }
    public void paint(Graphics g){
	super.paintComponent(g);
	Tetrimino t = new Tetrimino();
	int row = 160;
	int col = 0;
	for(int x=0; x<20; x++){
	    int[][][] shape = t.randGen();
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
	}
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

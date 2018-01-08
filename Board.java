import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Board extends JPanel{
    public Board() {
	setBackground(Color.WHITE);
    }
    public void paint(Graphics g){
	super.paintComponent(g);
	Tetrimino t = new Tetrimino();
	int row = 0;
	int col = 0;
	int shape = 0;
	for(int x=0; x<7; x++){
	    shape=t.randGen();
	    for(int i=1; i<3; i++){
		for(int j=0; j<t.getLen(shape); j++){
		    if(t.getCoor(shape,i,j) == 1){
			g.drawRect(row,col,20,20);
			g.drawRect(row-1,col-1,20,20);
			g.setColor(t.getCol(shape));
			g.fillRect(row,col,20,20);
			g.setColor(Color.BLACK);
		    }
		    row += 20;
		}
		col += 20;
		row = 0;
	    }
	    col += 10;
	}
    }
}

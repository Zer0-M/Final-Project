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
	for(int x=0; x<7; x++){
	    for(int i=1; i<3; i++){
		for(int j=0; j<t.getLen(x); j++){
		    if(t.getCoor(x,i,j) == 1){
			g.drawRect(row,col,20,20);
			g.drawRect(row-1,col-1,20,20);
			g.setColor(t.getCol(x));
			g.fillRect(row,col,20,20);
			g.setColor(Color.BLACK);
		    }
		    col += 20;
		}
		row += 20;
		col = 0;
	    }
	    row += 10;
	}
    }
}

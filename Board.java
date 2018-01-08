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
	int row = 160;
	int col = 0;
	int shape = 0;
	for(int x=0; x<20; x++){
	    shape=t.randGen();
	    for(int i=1; i<3; i++){
		for(int j=0; j<t.getLen(shape); j++){
		    if(t.getShape(shape,i,j) == 1){
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
}

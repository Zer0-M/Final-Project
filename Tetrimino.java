import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Tetrimino{
    private int[][][] shapes;
    private Color[] colors;
    public Tetrimino(){
	colors = new Color[] {Color.CYAN,Color.YELLOW,Color.MAGENTA,Color.GREEN,Color.RED,Color.BLUE,Color.ORANGE};
	shapes = new int[][][] {
	    {{0},
	     {1,1,1,1},
	     {0,0,0,0}
	    },
	    {{1},
	     {0,1,1,0},
	     {0,1,1,0}
	    },
	    {{2},
	     {0,1,0},
	     {1,1,1}
	    },
	    {{3},
	     {0,1,1},
	     {1,1,0}
	    },
	    {{4},
	     {1,1,0},
	     {0,1,1}
	    },
	    {{5},
	     {1,0,0},
	     {1,1,1}
	    },
	    {{6},
	     {0,0,1},
	     {1,1,1}
	    }
	};
    }
    public int getCoor(int shape, int x, int y){
	return shapes[shape][x][y];
    }
    public int getLen(int shape){
	return shapes[shape][1].length;
    }
    public Color getCol(int shape){
	return colors[shape];
    }
    public static void main(String[]args){
	Tetrimino t = new Tetrimino();
    }
}    
    

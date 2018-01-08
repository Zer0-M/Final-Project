import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
public class Tetrimino{
    private int[][][] shapes;
    private Color[] colors;
    private ArrayList<Integer> shapeGen;
    private Integer[] newGen;
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
	newGen = new Integer[] {0,0,1,1,2,2,3,3,4,4,5,5,6,6};
	shapeGen = new ArrayList<Integer> ();
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
    public int randGen(){
	if(shapeGen.size() == 0){
	    shapeGen.addAll(Arrays.asList(newGen));
	}
	return shapeGen.remove((int)(Math.random()*shapeGen.size()));
    }
    public static void main(String[]args){
	Tetrimino t = new Tetrimino();
    }
}    
    

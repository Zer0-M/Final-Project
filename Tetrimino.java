import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
public class Tetrimino{
    private int[][][][] shapes;
    private int[][][] I;
    private int[][][] O;
    private int[][][] T;
    private int[][][] S;
    private int[][][] Z;
    private int[][][] J;
    private int[][][] L;
    private int[][] coords;
    private ArrayList<Integer> shapeGen;
    private Integer[] newGen;
    public Tetrimino(){
	I = new int[][][] {
	    {
		{Color.CYAN.getRGB()}
	    },
	    {
		{1,1,1,1}
	    },
	    {
		{1},
		{1},
		{1},
		{1}
	    }
	};
	O = new int[][][]{
	    {
		{Color.YELLOW.getRGB()}
	    },
	    {
		{0,1,1,0},
		{0,1,1,0}
	    }
	};
	T = new int[][][]{
	    {
		{Color.MAGENTA.getRGB()}
	    },	
	    {
		{0,1,0},
		{1,1,1}
	    },
	    {
		{1,0},
		{1,1},
		{1,0},
	    },
	    {
		{1,1,1},
		{0,1,0}
	    },
	    {
		{0,1},
		{1,1},
		{0,1},
	    }
	};
	S = new int[][][] {
	    {
		{Color.GREEN.getRGB()}
	    },
	    {
		{0,1,1},
		{1,1,0}
	    },
	    {
		{1,0},
		{1,1},
		{0,1}
	    },
	};
	Z = new int[][][] {
	    {
		{Color.RED.getRGB()}
	    },
	    {
		{1,1,0},
		{0,1,1}
	    },
	    {
		{0,1},
		{1,1},
		{1,0}
	    }
	};
	J = new int[][][] {
	    {
		{Color.BLUE.getRGB()}
	    },
	    {
		{1,0,0},
		{1,1,1}
	    },
	    {
		{1,1},
		{1,0},
		{1,0},
	    },
	    {
		{1,1,1},
		{0,0,1}
	    },
	    {
		{0,1},
		{0,1},
		{1,1}
	    }
	};
	L = new int[][][] {
	    {
		{Color.ORANGE.getRGB()}
	    },
	    {
		{0,0,1},
		{1,1,1}
	    },
	    {
		{1,0},
		{1,0},
		{1,1}
	    },
	    {
		{1,1,1},
		{1,0,0}
	    },
	    {
		{1,1},
		{0,1},
		{0,1}
	    }
	};
	shapes = new int[][][][] {I,O,T,S,Z,J,L};
	newGen = new Integer[] {0,0,1,1,2,2,3,3,4,4,5,5,6,6};
	shapeGen = new ArrayList<Integer> ();
	coords = new int[10][20];
    }
    public int getSquare(int[][][] shape,int orientation, int x,int y){
	return shape[orientation][x][y];
    }
    public int getWid(int[][][] shape, int orientation){
	return shape[orientation][0].length;
    }
    public int getLen(int[][][] shape, int orientation){
	return shape[orientation].length;
    }
    public Color getCol(int[][][] shape){
	return new Color(shape[0][0][0]);
    }
    public int[][][] randGen(){
	if(shapeGen.size() == 0){
	    shapeGen.addAll(Arrays.asList(newGen));
	}
	return shapes[shapeGen.remove((int)(Math.random()*shapeGen.size()))];
    }
    
    public static void main(String[]args){
	Tetrimino t = new Tetrimino();
    }
}    
    

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
    private ArrayList<Integer> shapeGen;
    private Integer[] newGen;
    public Tetrimino(){
	I = new int[][][] {
	    {
		{1,1,1,1}
	    },
	    {
		{1},
		{1},
		{1},
		{1}
	    },
	    {
		{1}
	    },
	    {
		{Color.CYAN.getRGB()}
	    }
	};
	O = new int[][][]{
	    {
		{1,1},
		{1,1}
	    },
	    {
		{2}
	    },
	    {
		{Color.YELLOW.getRGB()}
	    }
	};
	T = new int[][][]{
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
	    },
	    {
		{3}
	    },
	    {
		{Color.MAGENTA.getRGB()}
	    }
	};
	S = new int[][][] {
	    {
		{0,1,1},
		{1,1,0}
	    },
	    {
		{1,0},
		{1,1},
		{0,1}
	    },
	    {
		{4}
	    },
	    {
		{Color.GREEN.getRGB()}
	    }   
	};
	Z = new int[][][] {
	    {
		{1,1,0},
		{0,1,1}
	    },
	    {
		{0,1},
		{1,1},
		{1,0}
	    },
	    {
		{5}
	    },
	    {
		{Color.RED.getRGB()}
	    }
	};
	J = new int[][][] {
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
	    },
	    {
		{6}
	    },
	    {
		{Color.BLUE.getRGB()}
	    }
	};
	L = new int[][][] {
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
	    },
	    {
		{7}
	    },
	    {
		{Color.ORANGE.getRGB()}
	    }
	};
	shapes = new int[][][][] {I,O,T,S,Z,J,L};
	newGen = new Integer[] {0,0,1,1,2,2,3,3,4,4,5,5,6,6};
	shapeGen = new ArrayList<Integer> ();
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
	return new Color(shape[shape.length-1][0][0]);
    }
    public Color getCol(int shape){
	return getCol(shapes[shape-1]);
    }
    public int getNum(int[][][] shape){
	return shape[shape.length-2][0][0];
    }
    public int getOris(int[][][] shape){
	return shape.length-2;
    }
    public int[][][] randGen(){
	if(shapeGen.size() == 0){
	    shapeGen.addAll(Arrays.asList(newGen));
	}
	return shapes[shapeGen.remove((int)(Math.random()*shapeGen.size()))];
    }
    public int getYCor(){
	return 0;
    }
    public int getXCor(){
	return 0;
    }
    public void setXCor(){
    
    }
    public void setYCor(){
    
    }    
    public static void main(String[]args){
	Tetrimino t = new Tetrimino();
    }
}    
 
    

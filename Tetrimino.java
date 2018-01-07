import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Tetrimino{
    private int[][][] shapes;
    public Tetrimino(){
	shapes = new int[][][] {
	{{1,1,1,1},
	 {0,0,0,0}
	},
	{{0,1,1,0},
	 {0,1,1,0}
	},
	{{0,1,0},
	 {1,1,1}
	},
	{{0,1,1},
	 {1,1,0}
	},
	{{1,1,0},
	 {0,1,1}
	},
	{{1,0,0},
	 {1,1,1}
	},
	{{0,0,1},
	 {1,1,1}
	}
    };
    }
    public int getCoor(int shape, int x, int y){
	return shapes[shape][x][y];
    }
    public static void main(String[]args){
	Tetrimino t = new Tetrimino();
    }
}    
    

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Board extends JFrame{
    public Board(){
	setSize(400,400);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocation(100,100);
	setVisible(true);
    }
    public static void main(String[]args){
	new Board();
    }
    public void paint(Graphics g){
	g.drawRect(50,50,20,20);
	g.drawRect(49,49,20,20);
	g.setColor(Color.RED);
	g.fillRect(50,50,20,20);
	
    }
}
	

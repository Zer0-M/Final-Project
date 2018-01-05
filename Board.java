import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Board extends JPanel{
    public Board(){
	setSize(500,700);
       	setBackground(Color.WHITE);
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
	

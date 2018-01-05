import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Board extends JPanel{
    public Board(){
    }
    public void paint(Graphics g){
	g.drawRect(50,50,20,20);
	g.drawRect(49,49,20,20);
	g.drawRect(50,50,300,500);
	g.setColor(Color.RED);
	g.fillRect(50,50,20,20);
    }
}
	

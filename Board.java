import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
public class Board extends JPanel{
	public Board() {
		setBackground(Color.WHITE);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
  public void paint(Graphics g){
    super.paintComponent(g);
    g.drawRect(0,0,20,20);
    g.drawRect(-1,-1,20,20);
    g.setColor(Color.RED);
    g.fillRect(0,0,20,20);
  }
}
	

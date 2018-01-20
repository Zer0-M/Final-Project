import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
public class startScreen  extends JPanel{
  private Image backgroundImg;
  public startScreen(String fileName){
    try {
          backgroundImg = ImageIO.read(new File(fileName));
       } catch (IOException e) {

       }
    setPreferredSize(new Dimension(800,1000));
    setLayout(new GridBagLayout());
  }

  public void paintComponent(Graphics g) {
    super.paintComponent( g );
    g.drawImage(backgroundImg, 0, 0, null);
    setOpaque(false);

    setOpaque(true);
  }

}

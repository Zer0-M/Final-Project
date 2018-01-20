import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
public class startScreen  extends JPanel{
  private Image backgroundImg;
  private JLabel logo;
  public GridBagConstraints gbc;
  public startScreen(String fileName){
    try {
          backgroundImg = ImageIO.read(new File(fileName));
    } catch (IOException e) {}
    ImageIcon img=new ImageIcon("tetris-logo.png");
    logo=new JLabel(img);
    gbc=new GridBagConstraints();
    gbc.gridy= 0;
    gbc.weighty=1;
    gbc.anchor=GridBagConstraints.NORTH;
    this.add(logo,gbc);
    setPreferredSize(new Dimension(800,1000));
    setLayout(new GridBagLayout());
  }

  public void paintComponent(Graphics g) {
    super.paintComponent( g );
    g.drawImage(backgroundImg, 0, 0, null);
    setOpaque(false);
  }

}

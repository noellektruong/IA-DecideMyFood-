import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;  
public class Game  extends JPanel implements Runnable, KeyListener{ 
private BufferedImage back;  
private int key;  
public Game() { 
new Thread(this).start(); 
this.addKeyListener(this); 
key =-1;  
} 
public void run() 
   { 
    try 
    { 
    while(true) 
    { 
       Thread.currentThread().sleep(5); 
            repaint(); 
         } 
      } 
    catch(Exception e) 
      { 
      } 
  } 
public void paint(Graphics g){ 
Graphics2D twoDgraph = (Graphics2D) g;  
if( back ==null) 
back=(BufferedImage)( (createImage(getWidth(), getHeight())));  
Graphics g2d = back.createGraphics(); 



g2d.clearRect(0,0,getSize().width, getSize().height); 

g2d.setFont( new Font("Consolas", Font.BOLD, 50)); 
g2d.setColor(Color.WHITE);
g2d.fillOval(500, 200, 150, 100);
g2d.fillOval(500, 200, 600, 300);
g2d.fillOval(510, 100, 45, 200);
g2d.fillOval(590, 100, 45, 200);
g2d.fillOval(1050, 250, 70, 70);
g2d.fillOval(950, 460, 70, 50);
g2d.fillOval(900, 470, 50, 30);
g2d.fillOval(620, 470, 50, 30);
g2d.fillOval(670, 470, 70, 50);

g2d.setColor(Color.blue);
g2d.fillOval(520, 230, 25, 25);
g2d.fillOval(600, 230, 25, 25);


Color mynewColor1 = new Color(107,69,52);
g2d.setColor(mynewColor1);
g2d.fillOval(558, 265, 30, 30);


g2d.setColor(Color.black); 
g2d.drawString("^", 560, 300);
g2d.setFont( new Font("Consolas", Font.BOLD, 35)); 
g2d.drawString("x", 1050, 350);
g2d.fillRect(569, 260, 10, 10);

g2d.setColor(Color.pink); 
g2d.fillOval(520, 260, 20, 15);
g2d.fillOval(600, 260, 20, 15);

Color mynewColor = new Color(107,69,52);
g2d.setColor(mynewColor);
g2d.fillOval(600, 280, 20, 15);
g2d.fillOval(600, 280, 20, 30);
g2d.fillOval(530, 280, 30, 20);
g2d.fillRect(530, 290, 10, 20);
g2d.fillOval(535, 295, 10, 10);
g2d.fillOval(580, 285, 30, 20);



twoDgraph.drawImage(back, null, 0, 0); 
} 
//DO NOT DELETE

@Override 
public void keyTyped(KeyEvent e) { 
// TODO Auto-generated method stub 
} 
//DO NOT DELETE 
@Override 
public void keyPressed(KeyEvent e) { 
// TODO Auto-generated method stub 
key= e.getKeyCode(); 
System.out.println(key); 
} 
//DO NOT DELETE 
@Override 
public void keyReleased(KeyEvent e) { 
} 
} 
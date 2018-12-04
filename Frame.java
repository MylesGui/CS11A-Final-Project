import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
  
import javax.swing.JFrame;
  
public class Frame extends JFrame implements KeyListener{ 
  	Boolean isAlive;
  	Boolean isPause;
  	Panel panel;
  	Character direction;

  
  	public Frame(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(500,500);
    	addKeyListener(this);
    	panel = new Panel();
    	add(panel);
    	setVisible(true);
    	isAlive = true;
    	isPause = false;
    	direction = new Character('d'); 
  	}
  	  
  	public void reset(){
    	panel.reset();
    	isAlive = true;
  	}

  	public void keyTyped(KeyEvent e){   
  	}

  	public void keyPressed(KeyEvent e){
    
    	if(e.getKeyCode()==KeyEvent.VK_W) 
     	direction = 'w';
    
     
    	if(e.getKeyCode()==KeyEvent.VK_S)
     	direction = 's';
    
     
    	if(e.getKeyCode()==KeyEvent.VK_A) 
     	direction = 'a';
    
     
    	if(e.getKeyCode()==KeyEvent.VK_D) 
     	direction = 'd';

     if(e.getKeyCode()==KeyEvent.VK_R) 
      reset();
     
    	if(e.getKeyCode()==KeyEvent.VK_UP) 
     	direction = 'w';
    
     
    	if(e.getKeyCode()==KeyEvent.VK_DOWN)
     	direction = 's';
    
     
    	if(e.getKeyCode()==KeyEvent.VK_LEFT) 
     	direction = 'a';
    
     
    	if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
     	direction = 'd'; 
    
    
    	if(e.getKeyCode()==KeyEvent.VK_ESCAPE) 
     	System.exit(1); 
     
  	}

  	public void keyReleased(KeyEvent e){  
  	}
    
  
  	public void paint(Graphics g){
    	panel.repaint();
  	}

}
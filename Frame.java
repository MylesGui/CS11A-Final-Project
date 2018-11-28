import java.awt.Graphics;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
  
import javax.swing.JFrame;
  
public class Frame extends JFrame implements KeyListener 
{ 
  Boolean isAlive;
  Boolean isPause;
  Panel panel;
  Character direction;
  private static final long serialVersionUID = 1L;
  
  public Frame()
  {
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500,500);
    addKeyListener(this);
    panel = new Panel();
    add(panel);
    setVisible(true);
    isAlive = true;
    isPause = false;
    direction = new Character('d'); 

    MenuBar menuBar = new MenuBar();
    Menu menu = new Menu("menu");
    MenuItem reset = new MenuItem("New Game");
    MenuItem pause= new MenuItem("Pause");
    Menu difficulty= new Menu("Difficulty");
    MenuItem easy= new MenuItem("Easy");
    MenuItem medium= new MenuItem("Medium");
    MenuItem hard= new MenuItem("Hard");
      
    pause.addActionListener(new ActionListener()
    
    {

      public void actionPerformed(ActionEvent e) 
      {
        
        if(!isPause)
         isPause= true;
        else     
         isPause= false; 
      }
        
    }); 
      
    reset.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e) 
      {
        
        reset();
      }
        
    });

    easy.addActionListener(new ActionListener()
    {

      public void actionPerformed(ActionEvent e) 
      {
        
        easy();
      }
        
    });
      
    menu.add(reset);
    menu.add(pause);
    menu.add(difficulty);
    difficulty.add(easy);
    difficulty.add(medium);
    difficulty.add(hard);
    menuBar.add(menu);
    setMenuBar(menuBar);
 
      
  }
    
  public void reset()
  {
    panel.reset();
    isAlive = true;
  }

  public void easy()
  {
    panel.reset();
    isAlive = true;
  }



  public void keyTyped(KeyEvent e) 
  {
    
      
  }

  public void keyPressed(KeyEvent e) 
  {
    
    
    if(e.getKeyCode()==KeyEvent.VK_W) 
     direction = 'w';
    
     
    if(e.getKeyCode()==KeyEvent.VK_S)
     direction = 's';
    
     
    if(e.getKeyCode()==KeyEvent.VK_A) 
     direction = 'a';
    
     
    if(e.getKeyCode()==KeyEvent.VK_D) 
     direction = 'd';
     
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

  public void keyReleased(KeyEvent e) 
  {
    
      
  }
    
  
  public void paint(Graphics g)
  {
    panel.repaint();
  }
  
  
  
  
}
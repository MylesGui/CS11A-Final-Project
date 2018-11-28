import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JPanel; 
 
public class Panel extends JPanel 
 {
  private static final long serialVersionUID = 1L;
  public LinkedList<SnakeBody> snake = new LinkedList<SnakeBody>();
  static final int LINE = 20;
  SnakeBody food = new SnakeBody(-99,-99);
  public Panel() 
  {
    
  }
    
  public void reset()
  {
    snake.clear();  
  }
    
  public void paint(Graphics g)
  {
    g.setColor(Color.black);//background
    g.fillRect(0, 0, getWidth(), getHeight());
    for(SnakeBody sb : snake)
    {
      g.setColor(Color.black);
      g.drawRect(sb.x*getWidth()/LINE,sb.y*getHeight()/LINE,getWidth()/LINE,getHeight()/LINE);
      g.setColor(Color.white);
      g.fillRect(sb.x*getWidth()/LINE,sb.y*getHeight()/LINE,getWidth()/LINE,getHeight()/LINE);
    }
    g.setColor(Color.red);//food
    g.fillRect(food.x*getWidth()/LINE,food.y*getHeight()/LINE,getWidth()/LINE,getHeight()/LINE);
      
  }
}
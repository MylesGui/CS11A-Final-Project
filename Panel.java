import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JPanel; 
 
public class Panel extends JPanel{
  public LinkedList<SnakeBody> snake = new LinkedList<SnakeBody>();
  static final int LINE = 20;
  SnakeBody food = new SnakeBody(-99,-99);
  public Panel(){
  }
  public void reset()
  {
    snake.clear();  
  }
  public void paint(Graphics graph){
    graph.setColor(Color.black);//background
    graph.fillRect(0, 0, getWidth(), getHeight());
    for(SnakeBody sb : snake){
      graph.setColor(Color.black);
      graph.drawRect(sb.x*getWidth()/LINE,sb.y*getHeight()/LINE,getWidth()/LINE,getHeight()/LINE);
      graph.setColor(Color.white);
      graph.fillRect(sb.x*getWidth()/LINE,sb.y*getHeight()/LINE,getWidth()/LINE,getHeight()/LINE);
    }
    graph.setColor(Color.red);//food
    graph.fillRect(food.x*getWidth()/LINE,food.y*getHeight()/LINE,getWidth()/LINE,getHeight()/LINE);
  }
}
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
import java.util.Scanner;
  
public class Launch extends TimerTask{
  Frame frame = new Frame();
  public Launch(){    
  } 
  boolean crashWall(){
    SnakeBody sb = frame.panel.snake.getFirst();
    if((sb.x<0)||(sb.y<0)||(sb.x>=Panel.LINE)||(sb.y>=Panel.LINE)){
      return true;
    } else{
      return false;
    }
  }
  void initial(){ 
    frame.panel.snake.add(newBody());
    frame.panel.food = newBody();  
  }

  
  public void run(){
    if(frame.panel.snake.isEmpty()){
      initial();  
    }
    if(frame.isAlive){
      if(!frame.isPause){
        if(goStraight()){
          frame.isAlive = false;
        }
        frame.repaint(); 
      }
    }
    if(crashWall()){
     frame.isAlive = false;  
    }
  }
  SnakeBody newBody(){
    SnakeBody sb = new SnakeBody();
    boolean overlap = true;
    while(overlap){
      overlap =false;
      sb.x = (int) (Math.random()*(Panel.LINE-2)+1);
      sb.y = (int) (Math.random()*(Panel.LINE-2)+1);
      if(!frame.panel.snake.isEmpty()){
        for(SnakeBody s : frame.panel.snake)
        if(sb.equals(s)){
          overlap =true;
        }
      }   
    } 
    return sb; 
  }   
  void eat(SnakeBody sb){
    frame.panel.snake.addFirst(sb);
  }
  boolean goStraight(){  
    boolean result = false; 
    SnakeBody sb =new SnakeBody(frame.panel.snake.getFirst());
    frame.panel.snake.removeLast();
    if(frame.direction=='w'){
      sb.turnUp();  
    }
    if(frame.direction=='s'){
      sb.turnDown(); 
    }
    if(frame.direction=='a'){
      sb.turnLeft();  
    }
    if(frame.direction=='d'){
      sb.turnRight(); 
    }
    for(SnakeBody s : frame.panel.snake)
    {
      if(sb.equals(s)){
        result = true;
      }  
    }  
    frame.panel.snake.addFirst(sb);
    if(sb.equals(frame.panel.food))
    {  
      if(frame.direction=='w'){
        frame.panel.food.turnUp();  
      }
      if(frame.direction=='s'){
        frame.panel.food.turnDown(); 
      }
      if(frame.direction=='a'){
        frame.panel.food.turnLeft(); 
      }
      if(frame.direction=='d'){
        frame.panel.food.turnRight(); 
      }
      eat(frame.panel.food);
      frame.panel.food = newBody();
    } 
    return result;
  }

  public static void main(String[] args){
    System.out.println("Please type the difficulty: easy, medium, hard. Enter to start. \nControl:\n W or ⬆︎ to go up\n A or ⬅︎ to go left\n S or ⬇︎ to go down\n D or ➔ to go right\n R to restart");
    Scanner scan = new Scanner(System.in);
    String difficulty = scan.nextLine();
    int difficultyInt;
    switch (difficulty){
      case "easy": difficultyInt=500; break;
      case "medium": difficultyInt=250; break;
      case "hard": difficultyInt=100; break;
      default: difficultyInt=500;
    } 
    Launch timertask = new Launch();
    Timer timer = new Timer();
    timer.schedule(timertask,0,difficultyInt);
     
  }
  
}

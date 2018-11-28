class SnakeBody 
 {
    
  int x;
  int y;
    
  public SnakeBody() 
  {
    
    x = 0;
    y = 0;
  }
    
  public SnakeBody(int a,int b)
  {
    x = a;
    y = b;
  }
  
  public SnakeBody(SnakeBody sb)
  {
    this(sb.x,sb.y);
  }
    
  
  
  
  
  public void turnUp()
  {
    y--;
  }
  
  public void turnDown()
  {
    y++;
  }
  
  public void turnLeft()
  {
    x--;
  }
  
  public void turnRight()
  {
    x++;
  }
    
  
  
  
  boolean equals(SnakeBody s)
  {
    
      if((x==s.x)&&(y==s.y)) 
     return true;
    
    
    
    else          
     return false;
  }
  
}
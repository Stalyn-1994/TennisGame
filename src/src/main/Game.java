package src.main;

import src.main.player.Player;

public class Game {
Player player1;
Player player2;

public Game() {
player1=new Player("A");
player2=new Player("B");
}


public void playGame() {
  Player playerwin=validateWin();
  while (playerwin==null){   
    double n=(Math.random());  
    if(n>0.5)
    {
      n=1;
      player1.setPoints(player1.getPoints()+1);
    }   
    else {
      n=0;
      player2.setPoints(player2.getPoints()+1);  
    }
   
  }
  
}

public Player validateWin() {
  boolean n=false;
  if (player1.getPoints()>=4 && (player1.getPoints()-player2.getPoints())>2) {    
    return player1;        
  }
  if (player2.getPoints()>=4 && (player2.getPoints()-player1.getPoints())>2) {
    
    return player2;
  }
  
  return null;
}



}

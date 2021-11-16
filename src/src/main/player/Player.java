package src.main.player;

public class Player {
private Integer points;
private String name;
public Player(String name) {
  super();
  this.points = 0;
  this.name = name;
}
public Integer getPoints() {
  return points;
}
public void setPoints(Integer points) {
  this.points = points;
}
public String getName() {
  return name;
}
public void setName(String name) {
  this.name = name;
}


}

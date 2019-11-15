/////////////////////////////////////////////////
// The Game class represents a video game a 
// player owns. Game stores the necessary 
// information to allow for display and 
// randomization. It stores the game name, the 
// console the player owns it on, what consoles
// can you play crossplay on, whether you can
// play online, and minimum and maximum players.
// Has public set and get methods. Has a 
// toString() method to allow for easy file
// reading. Has an equals() method to check
// if two games are the same game.
/////////////////////////////////////////////////
public class Game{
  private String name;
  private String console;
  private String crossPlay;
  private boolean online;
  private int minPlayers;
  private int maxPlayers;
  public Game(String name, String console, String crossPlay, boolean online, int minPlayers, int maxPlayers){
    this.name = name;
    this.console = console;
    this.online = online;
    this.crossPlay = crossPlay;
    // Makes sure the minimum amount of players is at least 1
    if(minPlayers < 1){
      this.minPlayers = 1;
    }else{
      this.minPlayers = minPlayers;
    }
    this.maxPlayers = maxPlayers;
  }
  public Game(){
    this("Default Game", "N/A", "N/A", false, 1, 1);
  }
  public String getName(){
    return name;
  }
  public String getConsole(){
    return console;
  }
  public String getCrossPlay(){
    return crossPlay;
  }
  public boolean getOnline(){
    return online;
  }
  
  public int getMinPlayers(){
    return minPlayers;
  }
  public int getMaxPlayers(){
    return maxPlayers;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setConsole(String console){
    this.console = console;
  }
  public void setCrossPlay(String crossPlay){
    this.crossPlay = crossPlay;
  }
  public void setOnline(boolean online){
    this.online = online;
  }
  public void setMinPlayers(int minPlayers){
    if(minPlayers < 1){
      this.minPlayers = 1;
    }else{
      this.minPlayers = minPlayers;
    }
  }
  public void setMaxPlayers(int maxPlayers){
    this.maxPlayers = maxPlayers;
  }
  // Formatted string file input and output
  public String formattedString(){
    return name + ", " + console + ", " + online + ", " + crossPlay + ", " + minPlayers + ", " + maxPlayers + ", ";
  }
  // Formatted string for display to the user
  public String toString(){
    return "Name: " + name + ", Console: " + console + ", Online: " + online + ", Cross Play Consoles: " + crossPlay + ", Minimum Players: " + minPlayers + ", Maximum Players: " + maxPlayers;
  }
  public boolean equals(Game game){
    if(name.equals(game.getName()) && console.equals(game.getConsole())){
      return true;
    }else{
      return false;
    }
  }
}
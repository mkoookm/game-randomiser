/////////////////////////////////////////////////
// The Group class represents a group of players
// that want to play together. Group stores an
// array list of players in the group, the name 
// of the group, and necessary variables for file
// input and output. Group imports ArrayList,
// Scanner, File, IOException, FileWriter, and
// BufferedWriter. Has public set and get methods
// for non file input and output variables. Has
// public methods to add a player and list the 
// players in the group. Has private methods to 
// create a file for the group and reading a 
// group file. All groups files will be stored
// in the groups directory found in the root 
// directory
/////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class Group{
  private String name;
  private ArrayList<Player> playerList;
  private String fileSeparator;
  private File file;
  private String relativePath;
  public Group(String name){
    this.name = name;
    this.playerList = new ArrayList<Player>(0);
    // Stores the file seperator of the OS
    this.fileSeparator = System.getProperty("file.separator");
    // Stores relative path of the group file
    // System.getProperty("user.dir") returns the current directory the file is in
    this.relativePath = System.getProperty("user.dir") + fileSeparator + "groups" + fileSeparator + name + ".txt";
    // Tries startup file methods and prints the IOEcpetion if it is caught
    try{
      // If else checks if the file exists, if it doesn't create the file and store it in file variable
      // if it does read the existing file and store it in the file variable
      if(createFile()){ // Checks if file creation is successfull
        this.file = new File(relativePath);
      }else{
        this.file = new File(relativePath);
        // Reads the file at the relative path
        readFile();
      }
    }
    catch(IOException e){
      // Prints error message
      System.out.println(e);
    }
  }
  public Group(){
    this("Default Group");
  }
  public String getName(){
    return name;
  }
  public ArrayList getPlayerList(){
    return playerList;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setPlayerList(ArrayList<Player> playerList){
    this.playerList = playerList;
  }
  // Adds the player to the group's player list
  public void addToPlayerList(Player player) throws IOException {
    playerList.add(player);
    // BufferedWriter provides efficient writing
    FileWriter fr = new FileWriter(relativePath, true); // Creates a file writer at the group file and appends the data at the end of the file
    BufferedWriter bw = new BufferedWriter(fr); // BufferedWriter accepts a Writer for constructor
    // Formatted writing to allow for easy reading of the file
    bw.newLine();
    bw.write(player.getName());
    bw.close();
  }
  // listPlayers() lists all of the players in a group and their games
  public void listPlayers(){
    for(Player p: playerList){
      System.out.println(p.getName());
      p.listGames();
    }
  }
  // createFile checks if the file already exists and creates a new one
  private boolean createFile() throws IOException{
    // Stores the directory where group files are stored
    File textFile = new File(System.getProperty("user.dir") + fileSeparator + "groups");
    // Checks if the directory already exists
    if(!textFile.exists()){
      // Checks if directory was made successfully
      if(textFile.mkdir()){
        System.out.println("Directory is created!");
      }else{
        // Throws IOEception if it failed
        throw new IOException("Directory couldn't be created");
      }
    }
    // Stores relative path of the new file
    String relPath = System.getProperty("user.dir") + fileSeparator + "groups" + fileSeparator + name + ".txt";
    // Store the new file
    textFile = new File(relPath);
    // Creates the file and returns true if it works and false if it doesn't
    return textFile.createNewFile();
  }
  // readFile reads the formatted text file and stores
  private void readFile() throws IOException{
    Scanner sc = new Scanner(file);
    while(sc.hasNextLine()){
      Player player = new Player(sc.nextLine());
      // Adds the player to the list if it's name is not an empty string
      if(!player.getName().equals("")){
        playerList.add(player);
      }
    }
  }
}
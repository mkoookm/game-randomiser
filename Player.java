/////////////////////////////////////////////////
// The Player class represents a player that owns 
// games. Player stores an array list of games 
// the player owns, the name of the group, and 
// necessary variables for file input and output. 
// Player imports ArrayList, Scanner, File, 
// IOException, FileWriter, and BufferedWriter. 
// Has public set and get methods for non file 
// input and output variables. Has public methods 
// to add a game and list the games the player 
// owns. Has private methods to create a file for 
// the player and reading a player file. All 
// player files will be stored in the players 
// directory found in the root directory.
/////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class Player{
  private String name;
  private ArrayList<Game> gameList;
  private String fileSeparator;
  private File file;
  private String relativePath;
  public Player(String name){
    this.name = name;
    this.gameList = new ArrayList<Game>(0);
    // Stores the file seperator of the OS
    this.fileSeparator = System.getProperty("file.separator");
    // Stores relative path of the group file
    // System.getProperty("user.dir") returns the current directory the file is in
    this.relativePath = System.getProperty("user.dir") + fileSeparator + "players" + fileSeparator + name + ".txt";
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
  public Player(){
    this("Default Player");
  }
  public String getName(){
    return name;
  }
  public ArrayList getGameList(){
    return gameList;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setGameList(ArrayList<Game> gameList){
    this.gameList = gameList;
  }
  // Adds the game to the player's game list
  public void addToGameList(Game game) throws IOException {
    gameList.add(game);
    // BufferedWriter provides efficient writing
    FileWriter fr = new FileWriter(relativePath, true); // Creates a file writer at the group file and appends the data at the end of the file
    BufferedWriter bw = new BufferedWriter(fr); // BufferedWriter accepts a Writer for constructor
    // Formatted writing to allow for easy reading of the file
    bw.write(game.formattedString());
    bw.newLine();
    bw.close();
  }
  // listGames() lists all of the games the player owns
  public void listGames(){
    for(Game g: gameList){
      System.out.println(g.toString());
    }
  }
  // createFile checks if the file already exists and creates a new one
  private boolean createFile() throws IOException{
    // Stores the directory where player files are stored
    File textFile = new File(System.getProperty("user.dir") + fileSeparator + "players");
    if (!textFile.exists()){
      // Checks if the directory already exists
      if (textFile.mkdir()){
        System.out.println("Directory is created!");
      } else {
        // Throws IOEception if it failed
        throw new IOException("Directory couldn't be created");
      }
    }
    // Stores relative path of the new file
    String relPath = System.getProperty("user.dir") + fileSeparator + "players" + fileSeparator + name + ".txt";
    // Store the new file
    textFile = new File(relPath);
    // Creates the file and returns true if it works and false if it doesn't
    return textFile.createNewFile();
  }
  // readFile reads the formatted text file and stores
  private void readFile() throws IOException{
    Scanner sc = new Scanner(file);
    while(sc.hasNextLine()){
      sc.useDelimiter(", "); // Custom delimeter used because of Game class's formatted toString()
      // Creates a game from information stored in the file
      Game game = new Game(sc.next(), sc.next(), sc.next(), Boolean.getBoolean(sc.next()), Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
      gameList.add(game);
      sc.nextLine();
    }
  }
}
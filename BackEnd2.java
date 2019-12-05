//DNF
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class BackEnd2
{
/**
* A method that list currently registered groups
*/
   public static void main (String [] args)
   {
      BackEnd2.currRegisteredGroups();
      BackEnd2.inputHandler();
   }
   
   public static void inputHandler()
   {
      ArrayList<Group> groups = startup();
      Scanner sc = new Scanner(System.in);
      System.out.println("'pick' to pick a group/player");
      System.out.println("'list' to list all current groups");
      System.out.println("'new' to create a new group/player/game");
      String input = sc.nextLine();
      String [] seperated = input.split(" ", 2);
      String command = seperated[0].toLowerCase();
      String arg = "";
      if(seperated.length>1){
         arg = seperated[1];
      }
      Player curPlayer = null;
      Group curGroup = null;
      boolean inGroup = false;
      boolean inPlayer = false;
      
      while(!(command.equals("quit") || command.equals("exit"))){
         if(command.equals("pick") && seperated.length>1){
            if(inPlayer){
               if(arg.equals("back")){
                  System.out.println("Moving out of: Player " + curPlayer.getName());
                  curPlayer = null;
                  inPlayer = false;
                  for(Player p: curGroup.getPlayerList()){
                     System.out.println(p.getName());
                  }
               }
            }else if(inGroup){
               if(arg.equals("back")){
                  System.out.println("Moved out of: Group " + curGroup.getName());
                  curGroup = null;
                  inGroup = false;
                  for(Group group: groups){
                     System.out.println(group.getName());
                  }
               }else{
                  for(Player p: curGroup.getPlayerList()){
                     if(arg.equals(p.getName())){
                        curPlayer = p;
                        inPlayer = true;
                        System.out.println(curPlayer.getName());
                        curPlayer.listGames();
                        break;
                     }
                  }
                  if(curPlayer==null){
                     System.out.println("Player not found");
                  }
               }
            }else{
               for(Group group: groups){
                  if(arg.equals(group.getName())){
                     curGroup = group;
                     inGroup = true;
                     System.out.println("Moved into group " + curGroup.getName());
                     for(Player p:curGroup.getPlayerList()){
                        System.out.println(p.getName());
                     }
                     break;
                  }
               }
               if(curGroup==null){
                  System.out.println("Group not found");
               }
            }
         }
         if(command.equals("list")){
            if(inPlayer){
               curPlayer.listGames();
            }else if(inGroup){
               for(Player p:curGroup.getPlayerList()){
                  System.out.println(p.getName());
               }
            }else{
               for(Group group: groups){
                  System.out.println(group.getName());
               }
            }
         }
         if(command.equals("new")){
            if(inPlayer){
               String name = "";
               String console = "";
               String online = "";
               String min = "";
               String max = "";
               System.out.println("Please input name: ");
               name = sc.nextLine();
               while(name.equals("")||name.indexOf(',') != -1){
                  System.out.println("Please provide a name without commas");
                  name = sc.nextLine();
               }
               System.out.println("Please input console name: ");
               console = sc.nextLine();
               while(console.equals("")||console.indexOf(',') != -1){
                  System.out.println("Please provide a name without commas");
                  console = sc.nextLine();
               }
               System.out.println("Please input online functionality: ");
               online = sc.nextLine();
               online = online.toLowerCase();
               while((online.equals("")||name.indexOf(',') != -1)||!(online.equals("yes")||online.equals("no")||online.equals("true")||online.equals("false"))){
                  System.out.println("Please provide yes, no, true, or false");
                  online = sc.nextLine();
               }
               boolean o = false;
               if(online.equals("yes")||online.equals("true")){
                  o = true;
               }
               System.out.println("Please input minimum number of players: ");
               min = sc.nextLine();
               boolean badInt = true;
               while(badInt){
                  try{
                     Integer.parseInt(min);
                     badInt = false;
                  }catch(NumberFormatException e){
                     System.out.println("Please provide a valid integer");
                     min = sc.nextLine();
                  }
               }
               int minP = Integer.parseInt(min);
               System.out.println("Please input maximum number of players: ");
               max = sc.nextLine();
               badInt = true;
               while(badInt){
                  try{
                     Integer.parseInt(max);
                     badInt = false;
                  }catch(NumberFormatException e){
                     System.out.println("Please provide a valid integer");
                     max = sc.nextLine();
                  }
               }
               int maxP = Integer.parseInt(max);
               try{
                  curPlayer.addToGameList(new Game(name,console,o,minP,maxP));
                  System.out.println(name + " game created");
               }catch(IOException e){
                  System.out.println(e);
               }
            }else if(inGroup){
               if(!arg.equals("")){
                  try{
                     curGroup.addToPlayerList(new Player(arg));
                     System.out.println(arg + " player created");
                  }catch(IOException e){
                     System.out.println(e);
                  }
               }
            }else{
               if(!arg.equals("")){
                  groups.add(new Group(arg));
                  System.out.println(arg + " group created");
               }
            }
         }
         if(command.equals("rndm")){
            String [] rand = arg.split(" ", 2);
            int num = -1;
            if(rand.length>1){
               num = Integer.parseInt(rand[1]);
            }
            arg = rand[0].toLowerCase();
            if(inPlayer){
               if(num>0){
                  if(arg.equals("random")){
                     System.out.println("Random game in current player to specified number of players: ");
                     System.out.println(Random.randomGameInPlayer(curPlayer, num));
                  }else if(arg.equals("online")){
                     System.out.println("Random online game in current player to specified number of playerquis: ");
                     System.out.println(Random.randomOnlineGameInPlayer(curPlayer, num));
                  }
               }else{
                  if(arg.equals("random")){
                     System.out.println("Random game in current player: ");
                     System.out.println(Random.randomGameInPlayer(curPlayer));
                  }else if(arg.equals("online")){
                     System.out.println("Random online game in current player: ");
                     System.out.println(Random.randomOnlineGameInPlayer(curPlayer));
                  }else if(arg.equals("oturns")){
                     System.out.println("Random online game in current player and you take turns: ");
                     System.out.println(Random.randomOnlineGameInPlayerTurns(curPlayer));
                  }
                  else if(arg.equals("turns")){
                     System.out.println("Random online game in current player and you take turns: ");
                     System.out.println(Random.randomGameInPlayerTurns(curPlayer));
                  }
               }
            }else if(inGroup){
               if(num>0){
                  if(arg.equals("random")){
                     System.out.println("Random game in current group to specified number of players: ");
                     System.out.println(Random.randomGameInGroup(curGroup, num));
                  }else if(arg.equals("online")){
                     System.out.println("Random online game in current group to specified number of players: ");
                     System.out.println(Random.randomOnlineGameInGroup(curGroup, num));
                  }
               }else{
                  if(arg.equals("random")){
                     System.out.println("Random game in current group: ");
                     System.out.println(Random.randomGameInGroup(curGroup));
                  }else if(arg.equals("online")){
                     System.out.println("Random online game in current group: ");
                     System.out.println(Random.randomOnlineGameInGroup(curGroup));
                  }else if(arg.equals("oturns")){
                     System.out.println("Random online game in current group and you take turns: ");
                     System.out.println(Random.randomOnlineGameInGroupTurns(curGroup));
                  }
                  else if(arg.equals("turns")){
                     System.out.println("Random game in current group and you take turns: ");
                     System.out.println(Random.randomGameInGroupTurns(curGroup));
                  }
               }
            }else{
               System.out.println("Must be in a group or player");
            }
         }
         input = sc.nextLine();
         seperated = input.split(" ", 2);
         command = seperated[0].toLowerCase();
         arg = "";
         if(seperated.length>1){
            arg = seperated[1];
         }
      }
   }
   public static void currRegisteredGroups()
   {
      ArrayList<Group> groups = startup();
      System.out.println("Groups currently registered:");
      for(Group group: groups){
         System.out.println(group.getName());
      }
   }
   /**
   * private helper method that stores the directory of the textfile with group names and returns the array of the groups
   */
   private static ArrayList<Group> startup(){
      String fileSeparator = System.getProperty("file.separator");
      String relativePath = System.getProperty("user.dir") + fileSeparator + "groups";
      File dir = new File(relativePath);
      File[] files = dir.listFiles();
      ArrayList<Group> groups = new ArrayList<Group>();
      String groupName;
      for(int i = 0; i<files.length;i++){
         groupName = files[i].getName();
         groups.add(new Group(groupName.substring(0, groupName.length() - 4)));
      }
      return groups;
   }

}



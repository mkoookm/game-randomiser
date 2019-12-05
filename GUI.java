import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends JFrame implements ActionListener, ItemListener{
  //declares all the items needed
  private JPanel front;
  
  private JLabel numPlayers;
  private JLabel group;
  private JLabel online;
  private JLabel result;
  private JLabel type;
  private JLabel inputPlayer;
  private JLabel inputGroup;
  private JLabel inputOS;
  private JLabel inputGames;
  private JLabel selectMain;
  private JLabel selectChange;
  private JLabel selectInput;
  private JLabel inputMax;
  private JLabel inputMin;
  private JLabel inputOnline;
  
  private JTextField textPlayer;
  private JTextField textGroup;
  private JTextField textOS;
  private JTextField textGames;
  private JTextField textInput;
  private JTextField textOnline;
  private JTextField textMin;
  private JTextField textMax;
  
  private JButton randomize;
  private JButton clearEntry;
  private JButton switchAdd;
  private JButton switchInfo;
  private JButton switchMain;
  private JButton submit;
  private JButton remove;
  
  private JComboBox mainPlayers;
  private JComboBox mainGroup;
  private JComboBox mainOnline;
  private JComboBox infoType;
  private JComboBox infoChange;
  private JComboBox addGroup;
  private JComboBox addPlayer;
  private JComboBox addGame;
  
  //array of items for adding things
  private String [] items = {"Group","Player","Game"};
  
  //constructor for the GUI
  public GUI(){
    //create a frame for the front panel
    JFrame window = new JFrame("Game Randomizer");
    
    //setting up the panel
    front = new JPanel();
    front.setLayout(null);
    window.setSize(800,400);
    
    //setting up the labels
    numPlayers = new JLabel("Number of Players");
    numPlayers.setBounds(50,50,200,20);
    group = new JLabel("Group");
    group.setBounds(230,50,200,20);
    online = new JLabel("Online");
    online.setBounds(370,50,200,20);
    result = new JLabel("Result");
    result.setBounds(500,50,200,20);
    
    inputPlayer = new JLabel("Input Name");
    inputPlayer.setBounds(300,50,200,20);
    inputGroup = new JLabel("Input Group Name");
    inputGroup.setBounds(300,50,200,20);
    inputOS = new JLabel("Input Console Type");
    inputOS.setBounds(520,50,200,20);
    inputGames = new JLabel("Input Game Title");
    inputGames.setBounds(300,50,200,20);
    inputMax = new JLabel("Input Max Players");
    inputMax.setBounds(520,150,200,20);
    inputMin = new JLabel("Input Min Players");
    inputMin.setBounds(300,150,200,20);
    inputOnline = new JLabel("Online?");
    inputOnline.setBounds(300,250,200,20);
    
    selectMain = new JLabel("Select data to change");
    selectMain.setBounds(50,50,200,20);
    selectChange = new JLabel("Select what to change");
    selectChange.setBounds(200,50,200,20);
    selectInput = new JLabel("Input how to change it");
    selectInput.setBounds(350,50,200,20);
    type = new JLabel("Type to add");
    type.setBounds(50,25,125,20);
    
    //setting up the buttons
    randomize = new JButton("Randomize");
    clearEntry = new JButton("Clear");
    switchAdd = new JButton("Add");
    switchInfo = new JButton("Change");
    switchMain = new JButton("Go Back");
    submit = new JButton("Submit");
    
    switchInfo.addActionListener(this);
    switchMain.addActionListener(this);
    randomize.addActionListener(this);
    clearEntry.addActionListener(this);
    switchAdd.addActionListener(this);
    submit.addActionListener(this);
    
    randomize.setBounds(525,300,100,20);
    clearEntry.setBounds(650,300,100,20);
    switchAdd.setBounds(50,300,100,20);
    switchInfo.setBounds(175,300,100,20);
    switchMain.setBounds(100,300,100,20);
    submit.setBounds(525,300,100,20);
    
    //setting up the text fields
    textPlayer = new JTextField();
    textPlayer.setBounds(300,100,200,20);
    textGroup = new JTextField();
    textGroup.setBounds(300,100,200,20);
    textOS = new JTextField();
    textOS.setBounds(520,100,150,20);
    textGames = new JTextField();
    textGames.setBounds(300,100,200,20);
    textInput = new JTextField();
    textInput.setBounds(350,100,200,20);
    textMin = new JTextField();
    textMin.setBounds(300,200,200,20);
    textMax = new JTextField();
    textMax.setBounds(520,200,200,20);
    textOnline = new JTextField();
    textOnline.setBounds(300,300,200,20);
    
    //setting up the drop down lists
    mainPlayers = new JComboBox();
    mainPlayers.setBounds(50,100,75,20);
    mainGroup = new JComboBox();
    mainGroup.setBounds(180,100,150,20);
    mainOnline = new JComboBox();
    mainOnline.setBounds(370,100,50,20);
    infoType = new JComboBox();
    infoType.setBounds(50,100,125,20);
    infoChange = new JComboBox();
    infoChange.setBounds(200,100,125,20);
    addGroup = new JComboBox(items);
    addGroup.setBounds(50,50,200,20);
    addPlayer = new JComboBox();
    addPlayer.setBounds(50,100,200,20);
    addGame = new JComboBox();
    addGame.setBounds(50,150,200,20);
    
    mainPlayers.addItemListener(this);
    mainGroup.addItemListener(this);
    mainOnline.addItemListener(this);
    infoType.addItemListener(this);
    infoChange.addItemListener(this);
    addPlayer.addItemListener(this);
    addGroup.addItemListener(this);
    addGame.addItemListener(this);
    
   
    //adding the items to the front panel
    front.add(switchAdd);
    front.add(randomize);
    front.add(clearEntry);
    front.add(numPlayers);
    front.add(group);
    front.add(online);
    front.add(inputPlayer);
    front.add(inputGroup);
    front.add(inputGames);
    front.add(inputOS);
    //front.add(switchInfo);
    front.add(switchMain);
    front.add(submit);
    front.add(selectMain);
    front.add(selectChange);
    front.add(selectInput);
    front.add(textPlayer);
    front.add(textGroup);
    front.add(textOS);
    front.add(textGames);
    front.add(textInput);
    front.add(result);
    front.add(mainPlayers);
    front.add(mainGroup);
    front.add(mainOnline);
    front.add(infoChange);
    front.add(infoType);
    front.add(addPlayer);
    front.add(type);
    front.add(addGroup);
    front.add(inputMin);
    front.add(inputMax);
    front.add(inputOnline);
    front.add(textOnline);
    front.add(textMin);
    front.add(textMax);
    
    //add panel to frame
    window.add(front);
    
    //set visiblity of these items to be true
    window.setVisible(true);
    front.setVisible(true);
    
    //set visiblity of these items to false so that they don't appear until a button is clicked
    result.setVisible(false);
    inputPlayer.setVisible(false);
    inputGames.setVisible(false);
    inputOS.setVisible(false);
    inputGroup.setVisible(false);
    switchMain.setVisible(false);
    selectMain.setVisible(false);
    selectChange.setVisible(false);
    selectInput.setVisible(false);
    textPlayer.setVisible(false);
    textGroup.setVisible(false);
    textOS.setVisible(false);
    textGames.setVisible(false);
    textInput.setVisible(false);
    infoType.setVisible(false);
    infoChange.setVisible(false);
    submit.setVisible(false);
    addPlayer.setVisible(false);
    type.setVisible(false);
    addGroup.setVisible(false);
    inputMax.setVisible(false);
    inputMin.setVisible(false);
    inputOnline.setVisible(false);
    textOnline.setVisible(false);
    textMax.setVisible(false);
    textMin.setVisible(false);
    
  }
  //method so buttons and drop down list work
  public void actionPerformed(ActionEvent e){
    //if the button clicked is randomize do the following
    if(e.getSource() == randomize){
      if(randomize.getText().equals("Reset")){
        randomize.setText("Randomize");
        result.setVisible(false);
      }
      else{
        randomize.setText("Reset");
        result.setVisible(true);
        //add randomize method and print result
      }
    }
    //if the button is the add button then change the visiblity of everything to create a new screen
    if(e.getSource() == switchAdd){
      numPlayers.setVisible(false);
      group.setVisible(false);
      online.setVisible(false);
      switchAdd.setVisible(false);
      switchInfo.setVisible(false);
      inputGroup.setVisible(true);
      textGroup.setVisible(true);
      mainPlayers.setVisible(false);
      mainGroup.setVisible(false);
      mainOnline.setVisible(false);
      switchMain.setVisible(true);
      randomize.setVisible(false);
      submit.setVisible(true);
      addGroup.setVisible(true);
      type.setVisible(true);
    }
    //reset the menu to show the beginning
    if(e.getSource() == switchMain){
      numPlayers.setVisible(true);
      group.setVisible(true);
      online.setVisible(true);
      switchAdd.setVisible(true);
      switchInfo.setVisible(true);
      switchMain.setVisible(false);
      inputPlayer.setVisible(false);
      inputGames.setVisible(false);
      inputOS.setVisible(false);
      inputGroup.setVisible(false);
      selectMain.setVisible(false);
      selectChange.setVisible(false);
      selectInput.setVisible(false);
      textPlayer.setVisible(false);
      textGroup.setVisible(false);
      textOS.setVisible(false);
      textGames.setVisible(false);
      textInput.setVisible(false);
      textPlayer.setText("");
      textGroup.setText("");
      textOS.setText("");
      textGames.setText("");
      textInput.setText("");
      textOnline.setText("");
      textMax.setText("");
      textMin.setText("");
      infoType.setVisible(false);
      infoChange.setVisible(false);
      mainPlayers.setVisible(true);
      mainGroup.setVisible(true);
      mainOnline.setVisible(true);
      randomize.setVisible(true);
      submit.setVisible(false);
      addPlayer.setVisible(false);
      type.setVisible(false);
      addGroup.setVisible(false);
      inputOnline.setVisible(false);
      inputMax.setVisible(false);
      inputMin.setVisible(false);
      textOnline.setVisible(false);
      textMax.setVisible(false);
      textMin.setVisible(false);
    }
    if(e.getSource() == switchInfo){
      numPlayers.setVisible(false);
      group.setVisible(false);
      online.setVisible(false);
      switchAdd.setVisible(false);
      switchInfo.setVisible(false);
      switchMain.setVisible(true);
      selectMain.setVisible(true);
      selectChange.setVisible(true);
      selectInput.setVisible(true);
      mainPlayers.setVisible(false);
      mainGroup.setVisible(false);
      mainOnline.setVisible(false);
      infoType.setVisible(true);
      infoChange.setVisible(true);
      textInput.setVisible(true);
      randomize.setVisible(false);
      submit.setVisible(true);
    }
    //clear every text field
    if(e.getSource() == clearEntry){
      textPlayer.setText("");
      textGroup.setText("");
      textOS.setText("");
      textGames.setText("");
      textInput.setText("");
      textOnline.setText("");
      textMax.setText("");
      textMin.setText("");
    }
    if(e.getSource() == submit);
    //add data to backend
  }
  //method to change menu when scrolling through drop boxes
  public void itemStateChanged(ItemEvent e){
    //if the drop down boxes are from the add menu
    if(e.getSource() == addGroup){
      //if group is selected in drop box
      if(addGroup.getSelectedItem().equals("Group")){
        inputGroup.setVisible(true);
        inputPlayer.setVisible(false);
        inputGames.setVisible(false);
        inputOS.setVisible(false);
        addPlayer.setVisible(false);
        addGame.setVisible(false);
        textGroup.setVisible(true);
        textPlayer.setVisible(false);
        textGames.setVisible(false);
        textOS.setVisible(false);
        textGroup.setText("");
        textPlayer.setText("");
        textOS.setText("");
        textGames.setText("");
        textOnline.setText("");
        textMax.setText("");
        textMin.setText("");
        inputOnline.setVisible(false);
        inputMax.setVisible(false);
        inputMin.setVisible(false);
        textOnline.setVisible(false);
        textMax.setVisible(false);
        textMin.setVisible(false);
      }
      //if player is selected in drop box
      if(addGroup.getSelectedItem().equals("Player")){
        inputGroup.setVisible(false);
        inputPlayer.setVisible(true);
        inputGames.setVisible(false);
        inputOS.setVisible(false);
        addPlayer.setVisible(true);
        addGame.setVisible(false);
        textGroup.setVisible(false);
        textGames.setVisible(false);
        textOS.setVisible(false);
        textPlayer.setVisible(true);
        textGroup.setText("");
        textPlayer.setText("");
        textOS.setText("");
        textGames.setText("");
        textOnline.setText("");
        textMax.setText("");
        textMin.setText("");
        inputOnline.setVisible(false);
        inputMax.setVisible(false);
        inputMin.setVisible(false);
        textOnline.setVisible(false);
        textMax.setVisible(false);
        textMin.setVisible(false);
        
      }
      //if game is selected in drop boxes
      if(addGroup.getSelectedItem().equals("Game")){
        addPlayer.setVisible(true);
        addGame.setVisible(true);
        inputPlayer.setVisible(false);
        inputGroup.setVisible(false);
        inputGames.setVisible(true);
        inputOS.setVisible(true);
        textGroup.setVisible(false);
        textPlayer.setVisible(false);
        textOS.setVisible(true);
        textGames.setVisible(true);
        textGroup.setText("");
        textPlayer.setText("");
        textOS.setText("");
        textGames.setText("");
        textOnline.setText("");
        textMax.setText("");
        textMin.setText("");
        inputPlayer.setVisible(false);
        inputOnline.setVisible(true);
        inputMax.setVisible(true);
        inputMin.setVisible(true);
        textOnline.setVisible(true);
        textMax.setVisible(true);
        textMin.setVisible(true);
      }
    }
  }
  
  public static void main(String [] args){
    new GUI();
  }
  
}
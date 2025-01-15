import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
    //System.out.println(colorByPercent(0, 20));
    //System.out.println(colorByPercent(12, 20));
    //System.out.println(colorByPercent(18, 20));
    /*ArrayList<Adventurer> people = new ArrayList<Adventurer>(3);
    people.add(new CodeWarrior("Bob"));
    people.add(new CodeWarrior("Tim"));
    people.add(new CodeWarrior("Ben"));
    people.get(0).setHP(5);
    Text.clear();
    drawScreen(people, people);*/
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    drawText(Text.colorize("                                                                                ", BORDER_BACKGROUND), 1, 1);

    for (int i = 2; i < 30; i++){
      drawText(Text.colorize(" ", BORDER_BACKGROUND), i, 1);
      drawText(Text.colorize(" ", BORDER_BACKGROUND), i, 80);
      if (!(i > 5 && i < 23) && i < 27){
        drawText(Text.colorize(" ", BORDER_BACKGROUND), i, 27);
        drawText(Text.colorize(" ", BORDER_BACKGROUND), i, 53);
      } else if (i < 27){
        drawText(Text.colorize(" ", BORDER_BACKGROUND), i, 40);
      }
      //drawText(Text.colorize("                                                                                ", BORDER_BACKGROUND), i, 1);
    }

    drawText(Text.colorize("                                                                                ", BORDER_BACKGROUND), 5, 1);
    drawText(Text.colorize("                                                                                ", BORDER_BACKGROUND), 23, 1);
    drawText(Text.colorize("                                                                                ", BORDER_BACKGROUND), 27, 1);
    drawText(Text.colorize("                                                                                ", BORDER_BACKGROUND), 30, 1);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Text.go(startRow, startCol);
    System.out.print(s);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    while (height > 0){
      if (text.length() > width){
        drawText(text.substring(0, width), row, col);
        text = text.substring(width);
        row++; height--;
      }
      else {
        for (int i = height; i > 0; i--){
          for (int k = width; k > 0; k--){
            drawText(" ", row+i-1, col+k-1);
          }
        }
        drawText(text, row, col);
        break;
      }
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }




    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      Random random = new Random();
      int randomInt = random.nextInt(3);
      if (randomInt == 0) {
        return new CodeWarrior("Bob", 25);
      }
      else if (randomInt == 1) {
        //return new Necromancer("Tim", 15);
      }
      else {
        //return new Priest("Ben", 20);
      }
      return new CodeWarrior("Bob", 25);
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){

      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
      for(int i = 0; i < party.size(); i++) {
        Adventurer current = party.get(i);
        drawText(current.getName(), startRow, 26 * i + 3);
        drawText("HP: " + colorByPercent(current.getHP(), current.getmaxHP()), startRow + 1, 26 * i + 3);
        String special = current.getSpecialName() + ": " + current.getSpecial();
        drawText(special, startRow + 2, 26 * i + 3);

      }

      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    String red = Text.colorize("" +hp, Text.RED + Text.BRIGHT);
    String yellow = Text.colorize("" +hp, Text.YELLOW + Text.BRIGHT);
    String white = Text.colorize("" +hp, Text.WHITE);
    float percent = (float) hp / maxHP;
    if (percent < 0.25) {
      return String.format("%2s", red+"")+"/"+String.format("%2s", maxHP+"");
    }
    else if (percent < 0.75) {
      return String.format("%2s", yellow+"")+"/"+String.format("%2s", maxHP+"");
    }
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> playerParty, ArrayList<Adventurer> enemyParty, String currentTurn, String pastTurn, String pastestTurn){

    drawBackground();

    drawParty(playerParty, 2);

    drawParty(playerParty, 24);

    TextBox(6, 2, 38, 6, currentTurn);

    TextBox(12, 2, 38, 5, pastTurn);

    TextBox(17, 2, 38, 6, pastestTurn);

    Text.go(29, 1);

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(29, 2);

      //show cursor
      Text.showCursor();

      String input = in.nextLine();

      //clear the text that was written
      TextBox(29, 2, 78, 1, "");

      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(30,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    enemies.add(createRandomAdventurer());
    enemies.add(createRandomAdventurer());
    enemies.add(createRandomAdventurer());
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    party.add(createRandomAdventurer());
    party.add(createRandomAdventurer());
    party.add(createRandomAdventurer());
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    String currentTurn = "";
    String pastTurn = "";
    String pastestTurn = "";
    int enemyMove;
    int enemyTarget;
    Random rand = new Random();
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party, enemies, currentTurn, pastTurn, pastestTurn);//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String prompt = "Enter command for "+party.get(whichPlayer)+": attack/support/special/quit";
    TextBox(28, 2, 78, 1, prompt);

    game:
    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      //TextBox(10,2,30,5,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.equals("attack") || input.equals("a")){

          prompt = "Who will "+party.get(whichPlayer)+" attack?";
          TextBox(28, 2, 78, 1, prompt);

          attack:
          while (true){
            input = userInput(in);
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")){ break game; }

            for (Adventurer target : enemies){
              if(input.equals(target.getName())){
                pastestTurn = pastTurn;
                pastTurn = currentTurn;
                currentTurn = party.get(whichPlayer).attack(target);
                break attack;
              }
            }

            prompt = "Please enter a valid enemy name";
            TextBox(28, 2, 78, 1, prompt);
          }

        }
        else if(input.equals("special") || input.equals("sp")){

          prompt = "Who will "+party.get(whichPlayer)+" special attack?";
          TextBox(28, 2, 78, 1, prompt);

          specialattack:
          while (true){
            input = userInput(in);
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")){ break game; }

            for (Adventurer target : enemies){
              if(input.equals(target.getName())){
                pastestTurn = pastTurn;
                pastTurn = currentTurn;
                currentTurn = party.get(whichPlayer).specialAttack(target);
                break specialattack;
              }
            }
            
            prompt = "Please enter a valid enemy name";
            TextBox(28, 2, 78, 1, prompt);
          }

        }
        else if(input.equals("su") || input.equals("support")){

          prompt = "Who will "+party.get(whichPlayer)+" support?";
          TextBox(28, 2, 78, 1, prompt);

          support:
          while (true){
            input = userInput(in);
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")){ break game; }

            for (Adventurer target : enemies){
              if(input.equals(target.getName())){
                pastestTurn = pastTurn;
                pastTurn = currentTurn;
                currentTurn = party.get(whichPlayer).support(target);
                break support;
              }
            }

            prompt = "Please enter a valid ally name";
            TextBox(28, 2, 78, 1, prompt);
          }

        }
        else if (! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
          prompt = "Invalid command. Enter command for "+party.get(whichPlayer)+": attack/support/special/quit";
          TextBox(28, 2, 78, 1, prompt);
          continue game;
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        drawScreen(party, enemies, currentTurn, pastTurn, pastestTurn);
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          prompt = "Enter command for "+party.get(whichPlayer)+": attack/support/special/quit";
          TextBox(28, 2, 78, 1, prompt);

        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          prompt = "Press enter to see monster's turn";
          TextBox(28, 2, 78, 1, prompt);

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        enemyMove = rand.nextInt(3);

        if (enemyMove == 0){
          enemyTarget = rand.nextInt(party.size());

          pastestTurn = pastTurn;
          pastTurn = currentTurn;
          currentTurn = enemies.get(whichOpponent).attack(party.get(enemyTarget));
        }
        else if (enemyMove == 1){
          enemyTarget = rand.nextInt(enemies.size());

          pastestTurn = pastTurn;
          pastTurn = currentTurn;
          currentTurn = enemies.get(whichOpponent).support(enemies.get(enemyTarget));
        }
        else {
          enemyTarget = rand.nextInt(party.size());

          pastestTurn = pastTurn;
          pastTurn = currentTurn;
          currentTurn = enemies.get(whichOpponent).specialAttack(party.get(enemyTarget));
        }
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        prompt = "Press enter to see next turn";
        TextBox(28, 2, 78, 1, prompt);

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
        TextBox(28, 2, 78, 1, prompt);
      }

      //display the updated screen after input has been processed.
      drawScreen(party, enemies, currentTurn, pastTurn, pastestTurn);

    }//end of main game loop


    //After quit reset things:
    quit();
  }
}

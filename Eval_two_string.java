import Scanner Keyboard.io;

public class Eval_two_string{
  public static void main (String args[]){
    Scanner keyboard = new Scanner(System.in);
    thing_one = keyboard.nextLine();
    thing_two = keyboard.nextLine();
    if thing_one.isEqual(thing_two){ //INCORRECT
      System.out.println("This two strings are the same!");
    } else if !(thing_one.isEqual(thing_two)){ //INCORRECT
      System.out.println("This two strings are not the same :(");
    }
  }
}

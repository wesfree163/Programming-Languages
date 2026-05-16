import java.util.*;
import java.util.Scanner;

public class ArrayWFreeman
{
  private int arrayWF[] = new int[20];
  private int value;
  private int x;

  public void storeWF(){
    Scanner kb = new Scanner(System.in);
    for(int i = 0; i < 10; i ++)
    {
      System.out.println("Enter a value for element #" + i);
      value = kb.nextInt();
      arrayWF[i] = value;
    }
  }

  public void printWF(){
    System.out.println("\n============================== \n\n");
    System.out.println("Print out all values of array");
    for(int i = 0; i < 10; i ++)
    {
      System.out.println(arrayWF[i]);
    }
  }

  public void printEvenWF(){
    System.out.println("\n============================== \n\n");
    System.out.println("Print all even values of array");
    for(int i = 0; i < 10; i ++)
    {
      if((arrayWF[i] % 2) == 0)
      {
        System.out.println(arrayWF[i]);
      }
    }
  }

  public void printOddWF(){
    System.out.println("\n============================== \n\n");
    System.out.println("Print all odd values in array");
    for(int i = 0; i < 10; i ++){
      if((arrayWF[i] % 2) != 0){
        System.out.println(arrayWF[i]);
      }
    }
  }

  public boolean searchArrayWF(boolean find){
    System.out.println("\n============================== \n\n");
    System.out.println("Search array for a value");
    Scanner kb = new Scanner(System.in);
    System.out.println("Search: ");
    int ele = kb.nextInt();
    System.out.println("");
    System.out.println("searching...");
    while(!find && x < 10){
      if(ele == arrayWF[x]){
        find = true;
        System.out.println(find);
      }
      x++;
    }
    if(!find){
      System.out.println(find);
    }
    return find;
  }
}

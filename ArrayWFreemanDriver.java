import java.util.*;
import java.util.Scanner;

public class ArrayWFreemanDriver{
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    System.out.println("local auto update for jgrasp");
    ArrayWFreeman arrayWF = new ArrayWFreeman();

    arrayWF.storeWF();
    arrayWF.printWF();
    arrayWF.printEvenWF();
    arrayWF.printOddWF();
    arrayWF.searchArrayWF(false);
  }
}

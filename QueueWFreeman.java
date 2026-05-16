import java.io.*;
import java.util.*;
public class QueueWFreeman{
  final private int size = 10;
  private String storeString;
  private String arrayQueue[] = new String[size];
  private String tempQueue[] = new String[size];
  private int count = 0, frontQ = 0, backQ = 0, index = 0;
  Scanner kb = new Scanner(System.in);

  public void storeQ()throws IOException{
    Scanner reader = new Scanner(new File("inputs.txt"));
    for(; reader.hasNext() && backQ < 6; backQ++){
      arrayQueue[backQ] = reader.nextLine();
    }
  }
  public void addQ(){
    arrayQueue[backQ] = kb.nextLine();
  }
  public void printQ(){
    for(; frontQ <= backQ-1; frontQ++){
      System.out.println(arrayQueue[frontQ]);
      tempQueue[frontQ] = arrayQueue[frontQ];
    }
  }
}

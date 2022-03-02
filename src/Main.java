import java.io.*;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
      String name, deadline, dueDate;
      int priority, count = 0;
      Task[] taskList = new Task[10];
      Scanner keyboard = new Scanner(System.in);
      File binaryFile = new File("Task.dat") ;
        System.out.println("Previously saved Tasks from binary file:");
        if(binaryFile.exists()&& binaryFile.length()>1L)
        {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                //Read the entire array into dogPound
                //readObject returns object
                taskList =(Task[]) fileReader.readObject();
                //Loop through the array and print out all numbers
                while(taskList[count]!= null)
                    System.out.println(taskList[count++]);
                fileReader.close();
            } catch (IOException | ClassNotFoundException e)
            {
                System.out.println("Error: "+ e.getMessage());
            }
        }
        else
            System.out.println("[None, please enter new Tasks]");
        do
        {
            System.out.println("Please enter name (or \"quit\" to exit): ");
            name = keyboard.nextLine();
            if(name.equalsIgnoreCase("quit"))
                break;
            System.out.println("Please enter the Deadline: ");
             deadline= keyboard.nextLine();
            System.out.println("Please enter the DueDate: ");
            dueDate = keyboard.nextLine();
            System.out.println("Please enter the priority: ");
            priority = keyboard.nextInt();

            taskList[count++] = new Task(name,deadline,dueDate,priority);

            //get rid of dangling
            keyboard.nextLine();
        }while(true);
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(taskList);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }
}

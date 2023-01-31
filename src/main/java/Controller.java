import StorageEngineComponents.StorageEngine;
import StorageEngineComponents.Utilities.Tuple;

import java.io.*;
import java.util.Scanner;

public class Controller {

    final private InputStream in;
    final private PrintStream out;

    public Controller(InputStream in, PrintStream out){
        this.in = in;
        this.out = out;
    }


    public void Go(StorageEngine storageEngine){
        Scanner scanner = new Scanner(in);

        System.out.print("See help for list of following commands.");
        while(true){

            System.out.println("\n\nEnter cmd.");
            String cmd = scanner.nextLine();

            switch(cmd) {

                case "help":
                    this.out.println("search | insert | output entries | generate random entries | load file");
                    break;

                case "search":
                    this.out.println("Enter value to search:");
                    Tuple<Float, Object> res = storageEngine.Search((float) scanner.nextInt());
                    this.out.println(res != null? res.key + " : " + res.value : "Not Found");
                    break;

                case "insert":
                    this.out.println("Enter value to insert");
                    Tuple<Float, Object> value = new Tuple<>((float) Integer.parseInt(scanner.nextLine()), "sup");
                    storageEngine.Insert(value);
                    break;

                case "output entries":
                    storageEngine.OutputEntries();
                    break;

                case "generate random entries":
                    storageEngine.CreateNodes();
//                  Grab from BST into PQ
                    break;

                case "load file":
                    storageEngine.LoadFile("/Users/rajeevhegde/Desktop/Implementation-of-LSM-storage-engine/TestFiles/Test1");
                    break;

                case "exit":
                    System.exit(0);
            }
        }

    }
}

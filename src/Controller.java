import Utilities.Node;
import Utilities.Tuple;

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

        while(true){

            System.out.println("\nEnter cmd");
            String cmd = scanner.nextLine();

            switch(cmd) {

                case "search":
                    this.out.println("Enter value to search:");
                    Node node = storageEngine.Search((float) scanner.nextInt());
                    this.out.println(node != null? node.val.key + " : " + node.val.value : "Not Found");
                    break;

                case "insert":
                    this.out.println("Enter value to insert");
                    Tuple<Float, Object> value = new Tuple<>((float) Integer.parseInt(scanner.nextLine()), "sup");
                    storageEngine.Insert(value);
                    break;

                case "output nodes":
                    storageEngine.OutputNodes();
                    break;

                case "create nodes":
                    storageEngine.CreateNodes();
                    break;

                case "load file":
                    storageEngine.LoadFile();
                    break;

                case "exit":
                    System.exit(0);
            }
        }

    }
}

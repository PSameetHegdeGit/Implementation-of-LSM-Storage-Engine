import Utilities.Node;
import Utilities.Tuple;

import java.io.*;

public class Controller {

    final private InputStream in;
    final private PrintStream out;

    public Controller(InputStream in, PrintStream out){
        this.in = in;
        this.out = out;
    }


    public void Go(StorageEngine storageEngine){
        while(true){
            BufferedReader in = new BufferedReader(new InputStreamReader(in));
            String cmd;

            System.out.println("\nEnter cmd");
            try{
                cmd = in.readLine();
            }
            catch(IOException e){
                continue;
            }

            switch(cmd) {

                case "search":
                    System.out.println("Enter value to search:\n");
                    try{
                        Node node = storageEngine.Search((float) Integer.parseInt(in.readLine()));
                        System.out.println(node != null? node.val.key + " : " + node.val.value : "Not Found");
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    break;

                case "insert":
                    System.out.println("Enter value to insert");
                    try{
                        Tuple<Float, Object> value = new Tuple<>((float) Integer.parseInt(in.readLine()), "sup");
                        storageEngine.Insert(value);
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
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

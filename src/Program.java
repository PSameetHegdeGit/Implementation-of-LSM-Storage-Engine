import Interfaces.Memtable;
import SortingStructures.BST;
import Utilities.Node;
import Utilities.NodeGenerator;
import Utilities.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {


    public static void main(String [] args){
        Memtable memtable = new BST();
        NodeGenerator.CreateInstances(memtable);
        Controller(memtable);
    }


    static void Controller(Memtable memtable){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cmd;

        while (true){
            System.out.println("\nEnter cmd");
            try{
                cmd = in.readLine();
            }
            catch(IOException e){
                continue;
            }
            switch(cmd) {
                case "search":
                    System.out.println("Enter value to search for: ");
                    try{
                        Node node = memtable.Search((float) Integer.parseInt(in.readLine()));
                        if (node == null){
                            System.out.println("null");
                        }
                        else{
                            System.out.println(node.val.key + ":" + node.val.value);
                        }
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }

                    break;
                case "insert":
                    memtable.Insert(new Tuple<>((float) 10, "Sup"));
                    break;
                case "output nodes":
                    memtable.OutputNodes();
                    break;
                case "exit":
                    System.exit(0);
            }

        }
    }

}

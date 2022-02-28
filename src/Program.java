import Interfaces.IWalManager;
import SortingStructures.Memtable;
import SortingStructures.BST;
import Utilities.FileLoader;
import Utilities.Node;
import Utilities.NodeGenerator;
import Utilities.Tuple;
import WriteAheadLog.BaseWalManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {


    public static void main(String [] args){
        Memtable memtable = new BST();
        BaseWalManager walManager = new BaseWalManager("WriteAheadLog.txt");
        Controller(memtable, walManager);
    }


    private static void Controller(Memtable memtable, IWalManager walManager){
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
                        System.out.println(node != null? node.val.key + ":" + node.val.value: "Not Found");
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
                case "insert":
                    walManager.UpdateWal(new Tuple<>((float) 10, "Sup"));
                    memtable.Insert(new Tuple<>((float) 10, "Sup"));
                    break;
                case "output nodes":
                    memtable.OutputNodes();
                    break;
                case "create nodes":
                    NodeGenerator.CreateInstances(memtable);
                case "load file":
                    FileLoader fileLoader = new FileLoader("/Users/rajeevhegde/Desktop/Implementation-of-LSM-storage-engine/TestFiles/Test1");
                    walManager.UpdateWal(fileLoader.GetData());
                    NodeGenerator.CreateInstances(memtable, fileLoader.GetData());
                    break;
                case "exit":
                    System.exit(0);
            }

        }
    }

}
/*
    TO DO:
        (1) load file to Memtable
        (2) Implement Deletion in BST
        (3) Implement AvlTree and RedBlackTree
        (4) Implement Write Ahead Log
        (5) Implement Seg Dump
        (6) Implement Compaction + Merge
 */

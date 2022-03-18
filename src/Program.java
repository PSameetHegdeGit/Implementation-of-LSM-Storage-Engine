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
        StorageEngine storageEngine = new StorageEngine(memtable, walManager);
        new Controller(System.in, System.out).Go(storageEngine);
    }


    private static void Controller(Memtable memtable, IWalManager walManager){

    }

}


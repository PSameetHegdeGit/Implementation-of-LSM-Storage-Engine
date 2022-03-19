import SortingStructures.Memtable;
import SortingStructures.BST;
import WriteAheadLog.BaseWalManager;


public class Program {


    public static void main(String [] args){
        Memtable memtable = new BST();
        BaseWalManager walManager = new BaseWalManager("WriteAheadLog.txt");
        StorageEngine storageEngine = new StorageEngine(memtable, walManager);
        new Controller(System.in, System.out).Go(storageEngine);
    }


}


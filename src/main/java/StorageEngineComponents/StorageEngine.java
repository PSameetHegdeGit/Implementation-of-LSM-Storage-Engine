package StorageEngineComponents;

import StorageEngineComponents.Configs.StorageEngineConfig;
import StorageEngineComponents.MemtableComponents.L1Memtable.PriorityQueue;
import StorageEngineComponents.MemtableComponents.L2Memtable.L2SearchTable;
import StorageEngineComponents.MemtableComponents.L2Memtable.L2SearchTableFactory;
import StorageEngineComponents.Utilities.FileLoader;
import StorageEngineComponents.Utilities.NodeGenerator;
import StorageEngineComponents.Utilities.Tuple;
import StorageEngineComponents.WriteAheadLog.WalManager;
import org.json.simple.parser.ParseException;

import java.io.IOException;


public class StorageEngine implements IStorageEngine {

    private L2SearchTable l2SearchTable;
    private WalManager walManager;
    private PriorityQueue l1Memtable;

    private StorageEngineConfig config;

    public StorageEngine(String configPath){

        try{
            config = new StorageEngineConfig(configPath);

            this.walManager =  new WalManager(config.WriteAheadLogPath);
            this.l1Memtable = new PriorityQueue(config.PriorityQueueSize);
            this.l2SearchTable = L2SearchTableFactory.GetSearchTable(config.SearchTreeMemTableType);

            LoadFile(config.WriteAheadLogPath);
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public Tuple<Float, Object> Search(float key){
            Tuple<Float, Object> result = (Tuple<Float, Object>) l1Memtable.Search(key);

            if(result == null){
                result = (Tuple<Float, Object>) l2SearchTable.Search(key);
                l1Memtable.Enqueue(result);
            }

            if(result == null){
//                look for result in DB
            }

            return result;
    }

    public void Insert(Tuple<Float, Object> entry){
        walManager.UpdateWal(entry);
        l1Memtable.Enqueue(entry);
        l2SearchTable.Insert(entry);
    }

    public void OutputEntries(){
        System.out.println("Entries of L1Memtable");
        l1Memtable.OutputEntries();
        System.out.println();
        System.out.println("Entries of L2Memtable");
        l2SearchTable.OutputEntries();
    }

    public void CreateNodes(){
        NodeGenerator.CreateInstances(walManager, l2SearchTable);
    }

    public void LoadFile(String filePath){
        FileLoader fileLoader = new FileLoader(filePath);

        if(filePath != config.WriteAheadLogPath)
            walManager.UpdateWal(fileLoader.GetData());

        NodeGenerator.CreateInstances(l2SearchTable, fileLoader.GetData());
    }
}

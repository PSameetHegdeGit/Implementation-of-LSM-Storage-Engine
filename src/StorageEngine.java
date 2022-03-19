import SortingStructures.Memtable;
import Utilities.FileLoader;
import Utilities.Node;
import Utilities.NodeGenerator;
import Utilities.Tuple;
import WriteAheadLog.BaseWalManager;


public class StorageEngine {

    private Memtable memtable;
    private BaseWalManager walManager;

    public StorageEngine(Memtable memtable, BaseWalManager walManager){
        this.memtable = memtable;
        this.walManager = walManager;
    }

    public Node Search(float value){
            Node node = memtable.Search(value);
            return node;
    }

    public void Insert(Tuple<Float, Object> value){
        walManager.UpdateWal(value);
        memtable.Insert(value);
    }


    public void OutputNodes(){
        memtable.OutputNodes();
    }

    public void CreateNodes(){
        NodeGenerator.CreateInstances(memtable);
    }

    public void LoadFile(){
        FileLoader fileLoader = new FileLoader("/Users/rajeevhegde/Desktop/Implementation-of-LSM-storage-engine/TestFiles/Test1");
        walManager.UpdateWal(fileLoader.GetData());
        NodeGenerator.CreateInstances(memtable, fileLoader.GetData());
    }


}

import StorageEngineComponents.StorageEngine;

public class Program {

    public static void main(String [] args){

        try{
            StorageEngine storageEngine = new StorageEngine("src/main/java/StorageEngineConfig.json");
            new Controller(System.in, System.out).Go(storageEngine);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}



/*
TODO:
(1) Finish Delete for memtable
(2) Dump memtable on max size? have background proc/thread dump after sleep period?
(3) Compaction
(4) Implement Priority Queue Cache
(5) Implement BST search on Priority Queue missing
(6) Implement DB search on not existing on BST
(7) Separate StorageEngine into its own package
(8) Add unit tests for Storage Engine


Node --> Check size of node and size of memtable --> if size of memtable + node size > MAX_SIZE then lock
 */
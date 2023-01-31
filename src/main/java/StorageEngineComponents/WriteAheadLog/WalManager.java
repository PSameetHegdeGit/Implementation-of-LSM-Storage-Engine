package StorageEngineComponents.WriteAheadLog;

import StorageEngineComponents.FileManager;
import StorageEngineComponents.Utilities.Tuple;

import java.io.*;
import java.util.HashMap;


public class WalManager extends FileManager {
    /**
     * Defines functionality to implement a write ahead log
     */
    private File wal;

    public WalManager(String path){
        this.wal = new File(path);
    }

    public void UpdateWal(HashMap<Float, Object> data) {
        super.UpdateSegment(data, wal);
    }

    public void UpdateWal(Tuple<Float, Object> data) {
        super.UpdateSegment(data, wal);

    }
}

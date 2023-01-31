package StorageEngineComponents.MemtableComponents.L2Memtable;

import StorageEngineComponents.Utilities.Node;
import StorageEngineComponents.Utilities.Tuple;

public abstract class L2SearchTable {

    protected Node root;
    public abstract Tuple<?, ?> Search(Float key);
    public abstract void Insert(Tuple<Float, Object> val);
    public abstract void Delete(Float key);
    public abstract void OutputEntries();
}

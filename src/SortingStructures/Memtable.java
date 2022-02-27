package SortingStructures;

import Utilities.Node;
import Utilities.Tuple;

import java.util.HashMap;
import java.util.Map;

public abstract class Memtable {

    protected Node node;

    public abstract Node Search(Float key);
    public abstract void Insert(Tuple<Float, Object> val);
    public abstract void Delete(Float key);
    public abstract void OutputNodes();
}

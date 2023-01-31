package StorageEngineComponents;

import StorageEngineComponents.Utilities.Tuple;

public interface IStorageEngine {
    Tuple<Float, Object> Search(float value);
    void Insert(Tuple<Float, Object> value);
    void OutputEntries();
    void CreateNodes();
    void LoadFile(String filePath);
}

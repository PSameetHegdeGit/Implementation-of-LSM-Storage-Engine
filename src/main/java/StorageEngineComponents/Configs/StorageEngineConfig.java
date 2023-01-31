package StorageEngineComponents.Configs;

import java.io.FileReader;
import java.io.IOException;


import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class StorageEngineConfig {

    public StorageEngineConfig(String configPath) throws IOException, ParseException {

        JSONObject json = (JSONObject) new JSONParser().parse(new FileReader(configPath));

        WriteAheadLogPath = (String) json.get("WriteAheadLogPath");
        SearchTreeMemTableType = (String) json.get("SearchTreeMemTableType");
        SegmentCreationFrequencyPerMinute = ((Long) json.get("SegmentCreationFrequencyPerMinute")).intValue();
        PriorityQueueSize = ((Long) json.get("PriorityQueueSize")).intValue();
    }

    public String WriteAheadLogPath;
    public String SearchTreeMemTableType;
    public int SegmentCreationFrequencyPerMinute;
    public int PriorityQueueSize;
}

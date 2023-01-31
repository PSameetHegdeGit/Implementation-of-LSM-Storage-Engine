package StorageEngineComponents;

import StorageEngineComponents.Utilities.Tuple;

import java.io.*;
import java.util.Map;

public class FileManager {

    /**
     * Creates Segment from data source
     * @param data A Key Value pair
     */
    public void UpdateSegment(Tuple<Float, Object> data, File sink){

        BufferedWriter bw = null;
        String formattedData = String.format("%s,%s\n", data.key, data.value);

        try{
            bw = new BufferedWriter(new FileWriter(sink, true));
            bw.write(formattedData);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (bw != null){
                try{
                    bw.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Creates segment from data source
     * @param data A key value store
     */
    public void UpdateSegment(Map<Float, Object> data, File sink){

        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(sink, true));
            for (Map.Entry<Float, Object> entry : data.entrySet()){
                float key = entry.getKey();
                Object value = entry.getValue();
                String formattedData = String.format("%s,%s\n", key, value);
                bw.write(formattedData);
            }
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}


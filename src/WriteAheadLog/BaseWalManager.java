package WriteAheadLog;

import Interfaces.IWalManager;
import Utilities.Tuple;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class BaseWalManager implements IWalManager {

    /*
        Manages Read and Writes to Write ahead log
     */
    private File wal;

    public BaseWalManager(String path){
        this.wal = new File(path);
    }

    public void UpdateWal(Tuple<Float, Object> data){

        BufferedWriter bw = null;
        String formattedData = String.format("%s,%s\n", data.key, data.value);

        try{
            bw = new BufferedWriter(new FileWriter(wal, true));
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

    public void UpdateWal(HashMap<Float, Object> data){

        for (Map.Entry<Float, Object> entry : data.entrySet()){
            float key = entry.getKey();
            Object value = entry.getValue();
            UpdateWal(new Tuple<> (key, value));
        }
    }

}

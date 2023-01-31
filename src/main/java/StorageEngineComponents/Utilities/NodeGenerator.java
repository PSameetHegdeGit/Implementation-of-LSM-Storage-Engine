package StorageEngineComponents.Utilities;

import StorageEngineComponents.MemtableComponents.L2Memtable.*;
import StorageEngineComponents.WriteAheadLog.WalManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class NodeGenerator {

    public static void CreateInstances(WalManager wal, L2SearchTable l2SearchTable){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter number of Node Instances: ");
        int noOfInstances = 0;
        try{
            noOfInstances = Integer.parseInt(in.readLine());
        }
        catch(IOException e){
            e.printStackTrace();
        }


        for(int i = 0; i <= noOfInstances; i++){
            Float key = (float) Math.floor(Math.random() * 100);
            Tuple<Float, Object> entry = new Tuple<> (key, "Value Exists");

            wal.UpdateWal(entry);
            l2SearchTable.Insert(entry);
        }

    }

    public static void CreateInstances(L2SearchTable l2SearchTable, HashMap<Float, Object> data){
        for (Map.Entry<Float, Object> entry : data.entrySet()){
            float key = entry.getKey();
            Object value = entry.getValue();
            l2SearchTable.Insert(new Tuple<> (key, value));
        }
    }

}

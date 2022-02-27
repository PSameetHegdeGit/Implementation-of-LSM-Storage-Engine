package Utilities;

import SortingStructures.Memtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class NodeGenerator {

    public static void CreateInstances(Memtable memtable){
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
            memtable.Insert(new Tuple<> (key, "Value Exists"));
        }

    }

    public static void CreateInstances(Memtable memtable, HashMap<Float, Object> data){
        for (Map.Entry<Float, Object> entry : data.entrySet()){
            float key = entry.getKey();
            Object value = entry.getValue();
            memtable.Insert(new Tuple<> (key, value));
        }
    }

}

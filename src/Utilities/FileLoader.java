package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class FileLoader {

    private String path;

    public FileLoader(String path){
        this.path = path;
    }

    public HashMap<Float, Object> GetData(){
        HashMap<Float, Object> data = new HashMap<>();
        PutFileIntoHashmap(data);

        return data;
    }

    private void PutFileIntoHashmap(HashMap<Float, Object> data){
        BufferedReader in = null;
        try{
            File file = new File(path);
            in = new BufferedReader(new FileReader(file));
            String line;
            while((line = in.readLine()) != null){
                String[] parts = line.split(",");
                Float key = Float.parseFloat(parts[0].trim());
                Object value = parts[1].trim();
                data.put(key, value);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (in != null){
                try {
                    in.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}

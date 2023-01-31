package StorageEngineComponents;

public class SegmentCreator extends FileManager{
    //Periodically takes contents of BST and stores in new segment
    String PATHFORDBSTORE = "~/Desktop/.dbstore/";

    public SegmentCreator(int segmentCreationFrequencyPerMinute){

    }

    private void SetupDbStore(){
        /*
        (1) Check if folder exists, if not create folder
        (2) Create FileWriter for .dbstore

        - What do we do about file names of segments
        - Do I take the entire BST and store in segment?
         */
    }

}

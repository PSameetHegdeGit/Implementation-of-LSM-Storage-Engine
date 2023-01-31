package StorageEngineComponents.MemtableComponents.L1Memtable;


import StorageEngineComponents.Utilities.Tuple;

public class PriorityQueue {

    private final Tuple<?,?>[] priorityQueue;
    private int length;
    private final int maxSize;

    public PriorityQueue(int sizeOfL1Cache){

        this.priorityQueue = new Tuple[sizeOfL1Cache];
        maxSize = sizeOfL1Cache;
        length = 0;

    }

    public Tuple<?,?> Search(Float key){
        for(int i = 0; i < length; i++){
            if(priorityQueue[i].key.equals(key)){
                BringToFront(i);
                return priorityQueue[0];
            }
        }

        return null;
    }

    public void Enqueue(Tuple<Float, Object> entry){
        length++;

        if (length >= maxSize){
            priorityQueue[maxSize - 1] = entry;
        }
        else{
            priorityQueue[length - 1] = entry;
        }

        BringToFront(length - 1);
    }

    public void Dequeue(){
        if(length > 0){
            priorityQueue[length - 1] = null;
            length--;
        }
    }

    private void BringToFront(int pos){
        while(pos > 0){
            int next = pos / 2;
            Tuple<?, ?> temp = priorityQueue[pos];
            priorityQueue[pos] = priorityQueue[next];
            priorityQueue[next] = temp;
            pos = next;

        }
    }

    public void OutputEntries(){
        for (int i=0; i < length; i++){
            Tuple<Float, String> entry = (Tuple<Float, String>) priorityQueue[i];
            System.out.print(entry.key + " ");
        }
    }


}

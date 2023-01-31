package StorageEngineComponents.Utilities;

public class Tuple <I, J> {
    public I key;
    public J value;

    public Tuple(I key, J value){
        this.key = key;
        this.value = value;
    }

}

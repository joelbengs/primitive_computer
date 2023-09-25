package computer;

public class Memory {
private Word[] memoryList;
private WordFactory factory;

    public Memory(int size, WordFactory factory) {
        this.factory = factory;
        this.memoryList = new Word[size];
        for(int i = 0; i < size; i++) {
            memoryList[i] = this.factory.defaultWord();
        }
    }

    public Word wordAt(int position){
        return memoryList[position];
    }
}
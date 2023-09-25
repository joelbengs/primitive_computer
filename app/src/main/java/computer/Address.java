package computer;

public class Address implements Operand {
    private int address;

    public Address(int address) {
        this.address = address;
    }

    @Override
    public Word getWord(Memory memory) {
        return memory.wordAt(address);
    }
}

package computer;

public abstract class Word implements Operand {
    @Override
    public Word getWord(Memory memory) {
        return this;
    }

    public abstract void add(Word other, Word result);

    public abstract void mul(Word other, Word result);

    public abstract void print();

    public abstract boolean equals(Object other);

    public abstract void copy(Word source);
}

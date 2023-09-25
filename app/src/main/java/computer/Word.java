package computer;

public abstract class Word {
    public Word getWord(Memory mem) {
        return null;
    }

    public abstract void add(Word other, Word result);

    public abstract void mul(Word other, Word result);

    public abstract void print();

    public abstract boolean equals(Object other);

    public abstract void copy(Word source);
}

package computer.longword;

import computer.Word;
import exceptions.*;
import exceptions.WordMismatchException;

public class LongWord extends Word {
    private long l;

    public LongWord(long l) {
        this.l = l;
    }

    public void add(Word other, Word result) {
        if (!(other instanceof LongWord && result instanceof LongWord)) {
            throw new WordMismatchException();
        }
        ((LongWord) result).l = (this.l + ((LongWord) other).l);
    }

    public void mul(Word other, Word result) {
        if (!(other instanceof LongWord && result instanceof LongWord)) {
            throw new WordMismatchException();
        }
        ((LongWord) result).l = (this.l * ((LongWord) other).l);
    }

    @Override
    public boolean equals(Word other) {
        if (!(other instanceof LongWord)) {
            throw new WordMismatchException();
        } else {
            return (((LongWord) other).l == this.l);
        }
    }

    public void print() {
        System.out.println(l);
    }

    public static void copyStatic(Word source, Word destination) {
        if (source instanceof LongWord && destination instanceof LongWord) {
            ((LongWord) destination).l = ((LongWord) source).l;
        }
    }

    public void copy(Word other) {
        if (!(other instanceof LongWord)) {
            throw new WordMismatchException();
        }
        this.l = ((LongWord) other).l;
    }
}

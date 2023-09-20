package computer.longword;

import computer.Word;
import exceptions.WordMismatchException;
import exceptions.*;

public class LongWord extends Word{
    private long l;

    public LongWord(String s) {
        
    }

    public void add(Word other, Word result) {
        result.copy(this.getWord(null) + other.getWord(null));
    }

    public void mul(Word other, Word result) {}

    public boolean equals(Word other) {}

    public void print() {}

    public static void copyStatic(Word source, Word destination) {
        if(source instanceof LongWord && destination instanceof LongWord){
            ((LongWord) destination).l = ((LongWord) source).l;
        }
    }

     public void copy(Word other) {
        if(!(other instanceof LongWord)){
            throw new WordMismatchException();
        }
            this.l = ((LongWord) other).l;
        }
    }

}

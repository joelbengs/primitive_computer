package computer.longword;

import java.util.function.BinaryOperator;

import computer.Word;
import exceptions.WordMismatchException;

public class LongWord extends Word{
    private long l;

    public LongWord(String s) {
        
    }
    private void calculate(Word other, Word result, BinaryOperator<Long> operator) {
        if (!(other instanceof LongWord) || !(result instanceof LongWord)) {
            throw new WordMismatchException();
        }
        var otherLongWord = (LongWord) other;
        var resultLongWord = (LongWord) result;
        resultLongWord.l = operator.apply(otherLongWord.l,this.l);
    }

    public void add(Word other, Word result) {
        calculate(other, result, (x, y) -> (long) (x + y));
    }
    

    public void mul(Word other, Word result) {
        calculate(other, result, (x, y) -> (long) (x * y));
    }
    @Override
    public boolean equals(Word other) {
        if (!(other instanceof LongWord)){
            throw new WordMismatchException();
        }else{
        return (((LongWord) other).l == this.l);
        }
    }

    public void print() {
        System.out.println(l);
    }

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

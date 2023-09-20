package computer.byteword;

import computer.Word;
import exceptions.WordMismatchException;
import java.util.function.BinaryOperator;

public class ByteWord extends Word {
    private byte b;

    public ByteWord(Byte b) {
        this.b = b;
    }

    private void calculate(Word other, Word result, BinaryOperator<Byte> operator) {
        if (!(other instanceof ByteWord) || !(result instanceof ByteWord)) {
            throw new WordMismatchException();
        }
        var otherByteWord = (ByteWord) other;
        var resultByteWord = (ByteWord) result;
        resultByteWord.b = operator.apply(otherByteWord.b, this.b);
    }

    @Override
    public void add(Word other, Word result) {
        calculate(other, result, (x, y) -> (byte) (x + y));
    }

    @Override
    public void mul(Word other, Word result) {
        calculate(other, result, (x, y) -> (byte) (x * y));
    }

    @Override
    public void print() {
        System.out.println(b);
    }

    @Override
    public boolean equals(Word other) {
        if (!(other instanceof ByteWord)) {
            throw new WordMismatchException();
        }
        var otherByteWord = (ByteWord) other;
        return this.b == otherByteWord.b;
    }

    public void copy(Word source) {
        this.b = ((ByteWord) source).b;
    }
}

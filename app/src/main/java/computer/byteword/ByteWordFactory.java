package computer.byteword;

import computer.Word;
import computer.WordFactory;

public class ByteWordFactory implements WordFactory {

    @Override
    public ByteWord word(String s) {
        try {
            byte b = Byte.parseByte(s);
            return new ByteWord(b);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Word defaultWord() {
        return new ByteWord((byte) 0);
    }
}

package computer.byteword;

import computer.WordFactory;

public class ByteWordFactory implements WordFactory {

    public ByteWord word(String s) {
        try {
            byte b = Byte.parseByte(s);
            return new ByteWord(b);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

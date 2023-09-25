package computer.longword;

import computer.WordFactory;

public class LongWordFactory implements WordFactory {

    @Override
    public LongWord word(String s) {
        try {
            long l = Long.parseLong(s);
            return new LongWord(l);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}

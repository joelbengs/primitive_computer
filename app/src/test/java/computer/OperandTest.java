package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import computer.longword.LongWordFactory;
import org.junit.jupiter.api.Test;

public class OperandTest {

    @Test
    void canGetWordFromWord() {
        var memory = new Memory(1024, new LongWordFactory());
        var lwf = new LongWordFactory();
        var word = lwf.word("12");
        assertEquals(lwf.word("12"), word.getWord(memory));
    }

    @Test
    void canGetWordFromAddress() {
        var lwf = new LongWordFactory();
        var memory = new Memory(1024, lwf);
        var word = memory.wordAt(5);
        word.copy(lwf.word("12"));

        memory.wordAt(6).copy(lwf.word("13"));

        var address1 = new Address(5);
        var address2 = new Address(6);

        assertEquals(lwf.word("12"), address1.getWord(memory));
        assertEquals(lwf.word("13"), address2.getWord(memory));
    }
}

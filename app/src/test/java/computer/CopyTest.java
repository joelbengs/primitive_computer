package computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import computer.byteword.ByteWordFactory;
import instructions.Copy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CopyTest {
    static ByteWordFactory bwf;
    static Memory memory;

    @BeforeAll
    static void setup() {
        bwf = new ByteWordFactory();
        memory = new Memory(256, new ByteWordFactory());
    }

    @Test
    void copyWordToAdress() {
        assertNotEquals(bwf.word("42"), memory.wordAt(5));
        Copy copyObj = new Copy(bwf.word("42"), new Address(5));
        copyObj.execute(memory, new InstructionCounter());

        assertEquals(bwf.word("42"), memory.wordAt(5));
    }
}

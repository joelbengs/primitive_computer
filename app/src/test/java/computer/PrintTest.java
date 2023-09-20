package computer;

import static org.junit.jupiter.api.Assertions.*;

import computer.byteword.ByteWord;
import computer.longword.LongWord;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrintTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /*
     * Redirecting stdout to allow for unit testing the Word.print method
     */

    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testByteWordPrint() {
        new ByteWord("12").print();
        assertEquals("12", outContent.toString());
    }

    @Test
    void testLongWordPrint() {
        new LongWord("120").print();
        assertEquals("120", outContent.toString());
    }
}

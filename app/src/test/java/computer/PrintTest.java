package computer;

import static org.junit.jupiter.api.Assertions.*;

import computer.byteword.ByteWordFactory;
import computer.longword.LongWordFactory;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrintTest {
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;
    static LongWordFactory lwf;
    static ByteWordFactory bwf;

    /*
     * Redirecting stdout to allow for unit testing the Word.print method,
     * and creating ByteWord and LongWord factories.
     */

    @BeforeAll
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        lwf = new LongWordFactory();
        bwf = new ByteWordFactory();
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testByteWordPrint() {
        bwf.word("12").print();
        assertEquals("12", outContent.toString());
    }

    @Test
    void testLongWordPrint() {
        lwf.word("120").print();
        assertEquals("120", outContent.toString());
    }
}

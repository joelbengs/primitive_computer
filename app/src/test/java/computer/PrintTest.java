package computer;

import static org.junit.jupiter.api.Assertions.*;

import computer.byteword.ByteWordFactory;
import computer.longword.LongWordFactory;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrintTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    static LongWordFactory lwf;
    static ByteWordFactory bwf;

    /*
     * Redirecting stdout to allow for unit testing the Word.print method,
     * and creating ByteWord and LongWord factories.
     */

    @BeforeAll
    static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        lwf = new LongWordFactory();
        bwf = new ByteWordFactory();
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @BeforeEach
    void cleanUpsStream() {
        outContent.reset();
    }

    @Test
    void testByteWordPrint() {
        bwf.word("12").print();
        assertEquals("12\n", outContent.toString());
    }

    @Test
    void testLongWordPrint() {
        lwf.word("120").print();
        assertEquals("120\n", outContent.toString());
    }
}

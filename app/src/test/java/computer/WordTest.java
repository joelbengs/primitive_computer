package computer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import computer.byteword.*;
import computer.longword.*;
import exceptions.WordMismatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordTest {
    Word lw1;
    Word lw2;
    Word lw3;

    Word bw1;
    Word bw2;
    Word bw3;

    WordFactory lwf;
    WordFactory bwf;

    /*
     * Create some word factories
     */

    @BeforeAll
    void createWordFactories() {
        this.lwf = new LongWordFactory();
        this.bwf = new ByteWordFactory();
    }

    /*
     * Create some words to be used for testing
     */

    @BeforeEach
    void createWords() {
        this.lw1 = lwf.word("12");
        this.lw2 = lwf.word("12");
        this.lw3 = lwf.word("11");

        this.bw1 = bwf.word("1");
        this.bw2 = bwf.word("2");
        this.bw3 = bwf.word("3");
    }

    /*
     * Tests for creating valid and invalid words
     */

    @Test
    void canCreateValidWords() {
        assertDoesNotThrow(
                () -> {
                    lwf.word("12");
                    bwf.word("100");
                });
    }

    @Test
    void cantCreateInvalidWords() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    lwf.word("Hejsan");
                });
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    lwf.word("9223372036854775808");
                });
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    bwf.word("Hejsan");
                });
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    lwf.word("128");
                });
    }

    /*
     * Tests for checking the Word.equals method
     */

    @Test
    void equalWordsAreEqual() {
        assertEquals(lwf.word("12"), lwf.word("12"));
        assertEquals(lwf.word("-100"), lwf.word("-100"));
        assertEquals(bwf.word("2"), bwf.word("2"));
        assertEquals(bwf.word("-120"), bwf.word("-120"));
    }

    @Test
    void notEqualWordsAreNotEqual() {
        assertNotEquals(lwf.word("12"), lwf.word("13"));
        assertEquals(lwf.word("-100"), lwf.word("-99"));
        assertEquals(bwf.word("2"), bwf.word("3"));
        assertEquals(bwf.word("-120"), bwf.word("-119"));
    }

    /*
     * Tests for the Word.add method
     */

    @Test
    void addBwStoreAtBw() {
        bw1.add(bw3, bw2);
        assertEquals(bw2, bwf.word("4"));
        assertEquals(bw1, bwf.word("1"));
        assertEquals(bw3, bwf.word("3"));
    }

    @Test
    void addLwStoreAtLw() {
        lw1.add(lw3, lw2);
        assertEquals(bw2, bwf.word("21"));
        assertEquals(bw1, bwf.word("12"));
        assertEquals(bw3, bwf.word("11"));
    }

    @Test
    void addWrongWordTypeBw() {
        assertThrows(
                WordMismatchException.class,
                () -> {
                    bw1.add(lw1, bw2);
                });
    }

    @Test
    void addWrongWordTypeStoreBw() {
        assertThrows(
                WordMismatchException.class,
                () -> {
                    bw1.add(bw1, lw2);
                });
    }

    @Test
    void addWrongWordTypeLw() {
        assertThrows(
                WordMismatchException.class,
                () -> {
                    lw1.add(bw1, lw2);
                });
    }

    @Test
    void addWrongWordTypeStoreLw() {
        assertThrows(
                WordMismatchException.class,
                () -> {
                    lw1.add(lw1, bw2);
                });
    }

    /*
     * Tests that addition will overflow correctly
     */

    @Test
    void addTwoBwThatOverflows() {
        var testBw1 = bwf.word("127");
        var testBw2 = bwf.word("1");
        var testBw3 = bwf.word("0");
        testBw1.add(testBw2, testBw3);
        assertEquals(testBw3, bwf.word("0"));
    }

    @Test
    void addTwoLwThatOverflows() {
        var testLw1 = lwf.word("9223372036854775807");
        var testLw2 = lwf.word("1");
        var testLw3 = lwf.word("0");
        testLw1.add(testLw2, testLw3);
        assertNotEquals(testLw3, lwf.word("9223372036854775808"));
    }

    @Test
    void EqualsLongWord() {
        assertTrue(lw1.equals(lw2));
        assertFalse(lw1.equals(lw3));
    }

    @Test
    void EqualsByteWord() {
        var word = bwf.word("3");
        assertTrue(bw3.equals(word));
        assertFalse(bw2.equals(word));
    }

    @Test
    void EqualsLongWordByteWord() {
        assertThrows(
                WordMismatchException.class,
                () -> {
                    bw1.equals(lw1);
                });
    }

    /*
     * Tests for the Word.mul method
     */

    @Test
    void canMulTwoByteWords() {
        var word = bwf.word("5");
        bw2.mul(bw3, word);
        assertEquals(bwf.word("6"), word);

        bw3.mul(bw1, word);
        assertEquals(bwf.word("3"), word);
    }

    @Test
    void canMulTwoLongWords() {
        var word = lwf.word("5");
        lw1.mul(lwf.word("2"), word);
        assertEquals(lwf.word("24"), word);

        lw1.mul(lw2, word);
        assertEquals(lwf.word("144"), word);
    }

    @Test
    void mulByteWordLongWord() {

        var word = bwf.word("5");
        bw1.mul(bwf.word("2"), word);
        assertEquals(bwf.word("2"), word);

        bw2.mul(bw3, word);
        assertEquals(bwf.word("6"), word);
    }

    @Test
    void copyByteWord() {
        // copy argument onto this, overwrite this
        bw1.copy(bw2);
        assertEquals(bw1, bwf.word("2"));
        assertEquals(bw2, bwf.word("2"));
    }

    @Test
    void copyLongWord() {
        // copy argument onto this, overwrite this
        lw1.copy(lw3);
        assertEquals(lw1, lwf.word("11"));
        assertEquals(lw3, lwf.word("11"));
    }
}

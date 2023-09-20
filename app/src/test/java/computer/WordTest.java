package computer;

import static org.junit.jupiter.api.Assertions.*;

import computer.byteword.ByteWord;
import computer.longword.LongWord;
import exceptions.WordMismatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordTest {
    LongWord lw1;
    LongWord lw2;
    LongWord lw3;

    ByteWord bw1;
    ByteWord bw2;
    ByteWord bw3;

    /*
     * Create some words to be used for testing
     */

    @BeforeEach
    void createWords() {
        this.lw1 = new LongWord("12");
        this.lw2 = new LongWord("12");
        this.lw3 = new LongWord("11");

        this.bw1 = new ByteWord("1");
        this.bw2 = new ByteWord("2");
        this.bw3 = new ByteWord("3");
    }

    /*
     * Tests for creating valid and invalid words
     */

    @Test
    void canCreateValidWords() {
        assertDoesNotThrow(
                () -> {
                    new LongWord("12");
                    new ByteWord("100");
                });
    }

    @Test
    void cantCreateInvalidWords() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new LongWord("Hejsan");
                });
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new LongWord("9223372036854775808");
                });
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new ByteWord("Hejsan");
                });
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new LongWord("128");
                });
    }

    /*
     * Tests for checking the Word.equals method
     */

    @Test
    void equalWordsAreEqual() {
        assertEquals(new LongWord("12"), new LongWord("12"));
        assertEquals(new LongWord("-100"), new LongWord("-100"));
        assertEquals(new ByteWord("2"), new ByteWord("2"));
        assertEquals(new ByteWord("-120"), new ByteWord("-120"));
    }

    @Test
    void notEqualWordsAreNotEqual() {
        assertNotEquals(new LongWord("12"), new LongWord("13"));
        assertEquals(new LongWord("-100"), new LongWord("-99"));
        assertEquals(new ByteWord("2"), new ByteWord("3"));
        assertEquals(new ByteWord("-120"), new ByteWord("-119"));
    }

    /*
     * Tests for the Word.add method
     */

    @Test
    void addBwStoreAtBw() {
        bw1.add(bw3, bw2);
        assertEquals(bw2, new ByteWord("4"));
        assertEquals(bw1, new ByteWord("1"));
        assertEquals(bw3, new ByteWord("3"));
    }

    @Test
    void addLwStoreAtLw() {
        lw1.add(lw3, lw2);
        assertEquals(bw2, new ByteWord("21"));
        assertEquals(bw1, new ByteWord("12"));
        assertEquals(bw3, new ByteWord("11"));
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
        var testBw1 = new ByteWord("127");
        var testBw2 = new ByteWord("1");
        var testBw3 = new ByteWord("0");
        testBw1.add(testBw2, testBw3);
        assertEquals(testBw3, new ByteWord("0"));
    }

    @Test
    void addTwoLwThatOverflows() {
        var testLw1 = new LongWord("9223372036854775807");
        var testLw2 = new LongWord("1");
        var testLw3 = new LongWord("0");
        testLw1.add(testLw2, testLw3);
        assertNotEquals(testLw3, new LongWord("9223372036854775808"));
    }

    @Test
    void EqualsLongWord() {
        assertTrue(lw1.equals(lw2));
        assertFalse(lw1.equals(lw3));
    }

    @Test
    void EqualsByteWord() {
        var word = new ByteWord("3");
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
        var word = new ByteWord("5");
        bw2.mul(bw3, word);
        assertEquals(new ByteWord("6"), word);

        bw3.mul(bw1, word);
        assertEquals(new ByteWord("3"), word);
    }

    @Test
    void canMulTwoLongWords() {
        var word = new LongWord("5");
        lw1.mul(new LongWord("2"), word);
        assertEquals(new LongWord("24"), word);

        lw1.mul(lw2, word);
        assertEquals(new LongWord("144"), word);
    }

    @Test
    void mulByteWordLongWord() {

        var word = new ByteWord("5");
        bw1.mul(new ByteWord("2"), word);
        assertEquals(new ByteWord("2"), word);

        bw2.mul(bw3, word);
        assertEquals(new ByteWord("6"), word);
    }

    @Test
    void copyByteWord() {
        // copy argument onto this, overwrite this
        bw1.copy(bw2);
        assertEquals(bw1, new ByteWord("2"));
        assertEquals(bw2, new ByteWord("2"));
    }

    @Test
    void copyLongWord() {
        // copy argument onto this, overwrite this
        lw1.copy(lw3);
        assertEquals(lw1, new ByteWord("11"));
        assertEquals(lw3, new ByteWord("11"));
    }
}

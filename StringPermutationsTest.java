import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class StringPermutationsTest {

    @Test
    void testPermutationsOfThreeCharacterString() {
        List<String> expected = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        List<String> actual = StringPermutations.generatePermutations("abc");
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    void testPermutationsOfTwoCharacterString() {
        List<String> expected = Arrays.asList("ab", "ba");
        List<String> actual = StringPermutations.generatePermutations("ab");
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    void testPermutationsOfSingleCharacterString() {
        List<String> expected = Arrays.asList("a");
        List<String> actual = StringPermutations.generatePermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyString() {
        List<String> expected = Arrays.asList();
        List<String> actual = StringPermutations.generatePermutations("");
        assertEquals(expected, actual);
    }

    @Test
    void testNullString() {
        List<String> expected = Arrays.asList();
        List<String> actual = StringPermutations.generatePermutations(null);
        assertEquals(expected, actual);
    }

    @Test
    void testDuplicateCharacters() {
        List<String> expected = Arrays.asList("aab", "aba", "baa");
        List<String> actual = StringPermutations.generatePermutations("aab");
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    void testPermutationsOfFourCharacterString() {
        List<String> actual = StringPermutations.generatePermutations("abcd");
        assertEquals(24, actual.size());  // 4! = 24 permutations
    }
}
import org.junit.jupiter.api.*;
import java.io.File;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveFileSearchTest {

    private static final String TEST_DIR = "testDirectory";
    private static final String SUB_DIR = "testDirectory/subDirectory";
    private static final String FILE_NAME = "testFile.txt";
    private static final String NON_EXISTENT_FILE = "nonExistentFile.txt";
    
    @BeforeAll
    static void setUp() throws Exception {
        // Create test directories and files
        Files.createDirectories(Paths.get(SUB_DIR));
        Files.createFile(Paths.get(TEST_DIR, FILE_NAME));
        Files.createFile(Paths.get(SUB_DIR, FILE_NAME));
    }
    
    @AfterAll
    static void tearDown() throws Exception {
        // Clean up test files and directories
        Files.deleteIfExists(Paths.get(SUB_DIR, FILE_NAME));
        Files.deleteIfExists(Paths.get(TEST_DIR, FILE_NAME));
        Files.deleteIfExists(Paths.get(SUB_DIR));
        Files.deleteIfExists(Paths.get(TEST_DIR));
    }
    
    @Test
    void testFileFoundInRootDirectory() {
        assertTrue(RecursiveFileSearch.searchFile(new File(TEST_DIR), FILE_NAME));
    }

    @Test
    void testFileFoundInSubDirectory() {
        assertTrue(RecursiveFileSearch.searchFile(new File(TEST_DIR), FILE_NAME));
    }

    @Test
    void testFileNotFound() {
        assertFalse(RecursiveFileSearch.searchFile(new File(TEST_DIR), NON_EXISTENT_FILE));
    }

    @Test
    void testInvalidDirectoryPath() {
        assertFalse(RecursiveFileSearch.searchFile(new File("invalidDirectory"), FILE_NAME));
    }

    @Test
    void testEmptyDirectory() throws Exception {
        Path emptyDir = Paths.get(TEST_DIR, "emptySubDir");
        Files.createDirectory(emptyDir);
        assertFalse(RecursiveFileSearch.searchFile(new File(emptyDir.toString()), FILE_NAME));
        Files.deleteIfExists(emptyDir);
    }
}

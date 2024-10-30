import java.io.File;

public class RecursiveFileSearch {
    
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java RecursiveFileSearch <directoryPath> <fileName>");
            return;
        }
        String directoryPath = args[0];
        String fileName = args[1];

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified directory does not exist or is not a directory.");
            return;
        }

        boolean fileFound = searchFile(directory, fileName);
        if (!fileFound) {
            System.out.println("File not found.");
        }
    }

    // Recursive method to search for the file
    public static boolean searchFile(File directory, String fileName) {
        File[] files = directory.listFiles();
        if (files == null) return false;

        for (File file : files) {
            if (file.isDirectory()) {
                if (searchFile(file, fileName)) return true;
            } else if (file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getAbsolutePath());
                return true;
            }
        }
        return false;
    }
}
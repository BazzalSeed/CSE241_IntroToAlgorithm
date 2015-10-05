package lab2;

import java.io.*;

/**
 * Reads in a sequence from a file
 *
 * The file is assumed to contain a single sequence, possibly split across
 * multiple lines.  Case is not preserved.
 */
public class SeqReader {

    private SeqReader() {
        /* Static class */
    }

    /**
     * Takes a file and returns the pattern that it reads from it.
     *
     * @param fileName path to file
     * @return String pattern in the file
     */
    public static String readSeq(String fileName) {
        BufferedReader reader;

        // Create a reader for the file
        try {
            InputStream inputStream = new FileInputStream(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            System.out.println("IOException while opening " + fileName + "\n" +
                e);
            return null;
        }

        StringWriter buffer = new StringWriter();

        // Accumulate each line of the file (minus surrounding whitespace)
        // sequentially in a string buffer.  Convert to lower case as we read.
        try {
            String nextLine = reader.readLine();
            while (nextLine != null) {
                buffer.write(nextLine.trim().toLowerCase());
                nextLine = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("IOException while reading sequence from " +
                fileName + "\n" + e);
            return null;
        }

        return buffer.toString();
    }
}
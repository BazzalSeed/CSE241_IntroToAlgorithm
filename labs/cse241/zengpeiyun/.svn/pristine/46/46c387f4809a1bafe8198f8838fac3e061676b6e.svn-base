package lab2;

/**
 * Lab2
 *
 * Sequence matching driver for CSE 241
 * 
 * SYNTAX: java Lab2 <match Length> <corpus file> <pattern file> <output file>
 *                  [ <mask file> ]
 *
 * This sequence matching program reads two sequences, a corpus and a pattern,
 * from files on disk and finds all strings of a given length that occur in
 * both corpus and pattern.  Matching substrings are printed in the form
 * <index 1> <index 2> <substring> where the two indices are the offsets of
 * the match within the corpus and pattern, respectively, and <substring> is
 * the actual matching string.  All output is copied into the file
 * <transcript file> for later review.
 *
 * As an optional fifth argument, the program can take a file containing a
 * mask sequence.  Substrings of the mask sequence are considered
 * "uninteresting" and so must not be reported by the matching code.  To
 * implement this requirement, we delete any occurances of substrings in
 * the mask sequence from our pattern table before performing the search.
 */
public class Lab2 {

    /**
     * Main method
     */
    public static void main(String args[]) {
        if (args.length < 4) {
            System.out.println("Syntax: java Lab2 <match length>" +
                "<corpus file> <pattern file> " + "<output file> " +
                "[<mask file>]");
            System.exit(0);
        }
        int matchLength = 0;
        try {
            matchLength = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse integer from string \"" +
                args[0] + "\"\n" + e);
            System.exit(0);
        }
        String corpusSeq = SeqReader.readSeq(args[1]);
        String patternSeq = SeqReader.readSeq(args[2]);
        Terminal.startTranscript(args[3]);
        Terminal.println("CORPUS: " + corpusSeq.length() + " bases");
        Terminal.println("PATTERN: " + patternSeq.length() + " bases");
        StringTable table = createTable(patternSeq, matchLength);
        if (args.length > 4){
            String maskSeq = SeqReader.readSeq(args[4]);
            Terminal.println("MASK: " + maskSeq.length() + " bases");
            maskTable(table, maskSeq, matchLength)
        }
        findMatches(table, corpusSeq, matchLength);
        Terminal.stopTranscript();
    }

    /**
     * Create a new StringTable containing all substrings of the pattern
     * sequence.
     *
     * @param patternSeq String pattern sequence
     * @param matchLength length of the matches we are looking for.
     */
    private static StringTable createTable(String patternSeq, int matchLength) {
        StringTable table = new StringTable();
        for (int j = 0; j < patternSeq.length() - matchLength + 1; j++) {
            String key = patternSeq.substring(j, j + matchLength);
            Record rec = table.find(key);
            if (rec == null) {
                // Not found, need a new Record
                rec = new Record(key);
                if (!table.insert(rec)) {
                    System.out.println("Error (insert): hash table is full!\n");
                }
            }
            rec.addPosition(new Integer(j));
        }
        return table;
    }

    /**
     * Remove all substrings in the mask sequence from a StringTable
     *
     * @param table StringTable to remove sequence from
     * @param maskSeq sequence to remove from table
     * @param matchLength length of the matches
     */
    private static void maskTable(StringTable table, String maskSeq,
        int matchLength) {
        for (int j = 0; j < maskSeq.length() - matchLength + 1; j++) {
            String key = maskSeq.substring(j, j + matchLength);
            Record rec = table.find(key);
            if (rec != null)
                table.remove(rec);
            }
    }

    /**
     * Find and print all matches between the corpus sequence and any string
     * in a StringTable.
     *
     * @param table StringTable to match
     * @param corpusSeq total corpus
     * @param matchLength length of the matches
     */
    private static void findMatches(StringTable table, String corpusSeq,
        int matchLength) {
        for (int j = 0; j < corpusSeq.length() - matchLength + 1; j++) {
            String key = corpusSeq.substring(j, j + matchLength);
            Record rec = table.find(key);
            if (rec != null) {
                for (int k = 0; k < rec.getPositionsCount(); k++) {
                    Terminal.println(j + " " + rec.getPosition(k) + " " +
                        key);
                }
            }
        }
    }
}
package lab2;

// LAB2.JAVA
// Sequence matching driver for CSE 241 Lab 2
//
// SYNTAX: java Lab2 <match length> <corpus file> <pattern file> <output file>
//                 [ <mask file> ]
//
// This sequence matching program reads two sequences, a CORPUS and a
// PATTERN, from files on disk and finds all strings of a given length
// that occur in both corpus and pattern.  Matching substrings are
// printed in the form <index 1> <index 2> <substring> where the two
// indices are the offsets of the match within the corpus and pattern,
// respectively, and <substring> is the actual matching string.  All
// output is copied into the file <transcript file> for later review.
//
// As an optional fifth argument, the program can take a file containing a
// MASK sequence.  Substrings of the mask sequence are considered
// "uninteresting" and so must not be reported by the matching code.
// To implement this requirement, we delete any occurrences of substrings
// in the mask sequence from our pattern table before performing the search.
//

public class Lab2 {

    public static void main(String args[]) {
        String corpusSeq  = null;
        String patternSeq = null;
        String maskSeq  = null;
        int matchLength = 0;
        if (args.length < 4) {
            System.out.println("Syntax: java Lab2 <match length>" +
                "<corpus file> <pattern file> " + "<output file> " +
                "[<mask file>]");
            System.exit(0);
        }

        try {
            matchLength = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse integer from string \"" +
                args[0] + "\"\n" + e);
            System.exit(0);
        }
        corpusSeq = SeqReader.readSeq(args[1]);
        patternSeq = SeqReader.readSeq(args[2]);
        Terminal.startTranscript(args[3]);
        Terminal.println("CORPUS: " + corpusSeq.length() + " bases");
        Terminal.println("PATTERN: " + patternSeq.length() + " bases");
        if (args.length > 4){
            maskSeq = SeqReader.readSeq(args[4]);
            Terminal.println("MASK: " + maskSeq.length() + " bases");
        }

        StringTable table = createTable(patternSeq, matchLength);

        if (maskSeq != null) {
            maskTable(table, maskSeq, matchLength);
        }

        findMatches(table, corpusSeq, matchLength);

        Terminal.stopTranscript();
    }


    // Create a new StringTable containing all substrings of the pattern
    // sequence.
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


    // Remove all substrings in the mask sequence from a StringTable.
    private static void maskTable(StringTable table, String maskSeq,
        int matchLength) {
        for (int j = 0; j < maskSeq.length() - matchLength + 1; j++) {
            String key = maskSeq.substring(j, j + matchLength);

            Record rec = table.find(key);
            if (rec != null)
                table.remove(rec);
            }
    }


    // Find and print all matches between the corpus sequence and any
    // string in a StringTable.
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
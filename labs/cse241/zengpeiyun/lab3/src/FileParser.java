package lab3;

import java.io.*;
import java.util.*;

/**
 * Parse a text file in as sane a way as Java will permit.
 * 
 * We open the file in the constructor, then repeatedly
 * call readWord() to get strings and readInt() to get integers
 * until we reach eof.  Call isEof() to see if we're there yet.
 */
class FileParser {
    private StreamTokenizer tokenizer;
    private boolean eof;

    /**
     * Constructs the FileParser and opens the file
     */
    public FileParser(String fileName) {
        try {
            InputStream is = new FileInputStream(fileName);
            Reader r = new BufferedReader(new InputStreamReader(is));
            tokenizer = new StreamTokenizer(r);
            tokenizer.eolIsSignificant(true);
        }
        catch (IOException e) {
            System.out.println("IOException opening command file " + fileName
                + "\n" + e);
        }
        eof = false;
    }

    /**
     * Return true iff we have received an EOF from the file
     *
     * @return boolean EOF
     */
    boolean isEof() {
        return eof;
    }


    /**
     * Read an integer from the file, skipping any intervening tokens.
     * 
     * @return int representing the read bytes.
     */
    public int readInt() {
        scanTo(StreamTokenizer.TT_NUMBER);
        return (int) tokenizer.nval;
    }

    /**
     * Read a String from the file, skipping any intervening numeric tokens
     *
     * @return String representing read bytes.
     */
    public String readWord() {
        scanTo(StreamTokenizer.TT_WORD);
        if (tokenizer.sval != null) {
           return(tokenizer.sval);
        }
        else {
           return "" + (char) tokenizer.ttype;
       }
    }


    /**
     * Read the next token of type tokenType
     */
    void scanTo(int tokenType) {
        // scans to a given token type:
        // TT_NUMBER or TT_WORD
        try {
            while (true) {
                int ttype = tokenizer.nextToken();
                if (ttype == tokenType) {
                    return;
                } else if (ttype == StreamTokenizer.TT_EOF) {
                    eof = true;
                    return;
                } else if (ttype == StreamTokenizer.TT_EOL) {
                    // skip over end of line
                } else if ((tokenType == StreamTokenizer.TT_WORD) 
                    && (ttype != StreamTokenizer.TT_NUMBER)) {
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException while scanning for input.");
        }
    }
}

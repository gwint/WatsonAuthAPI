package driver;

import util.StdoutDisplayInterface;
import java.io.File;
import java.io.IOException;
import util.FileProcessor;
import util.MyLogger;
import java.util.List;
import java.util.ArrayList;
import util.TokenRequester;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.ProtocolException;

/**
 * @author Gregory Wint
 *
 */

public class Driver {
    /**
     * Makes an http request to retrieve a token that can be used to access
     * the IBM Watson Tone-Analyzer API
     *
     * @return No return value.
     */
    public static void main(String[] args)
        throws ClassNotFoundException, MalformedURLException, IOException, ProtocolException {
/*
    // Read in debug level
    CharSequence debugValueStr = args[0];
    int debugValue = -1;

    try {
      debugValue = Integer.parseInt(debugValueStr.toString());
      if(debugValue < 0 || debugValue > 4) {
        throw new IllegalArgumentException("The debug value must be an integer falling between 0 and 4, inclusive.");
      }
    }
    catch(NumberFormatException e) {
      System.err.println("The debug value must be an integer");
      System.err.println(e);
      System.exit(1);
    }
    finally {}

    MyLogger.setDebugValue(debugValue);
*/
    System.out.println(TokenRequester.getToken());

    }
}

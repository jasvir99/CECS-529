/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleengine;

import java.io.*;
import java.util.*;

/**
Reads tokens one at a time from an input stream. Returns tokens with minimal
processing: removing all non-alphanumeric characters, and converting to 
lowercase.
*/
public class SimpleTokenStream implements TokenStream {
   private Scanner mReader;

   /**
   Constructs a SimpleTokenStream to read from the specified file.
     * @param fileToOpen
     * @throws java.io.FileNotFoundException
   */
   public SimpleTokenStream(File fileToOpen) throws FileNotFoundException {
      mReader = new Scanner(new FileReader(fileToOpen));
   }
   
   /**
   Constructs a SimpleTokenStream to read from a String of text.
     * @param text
   */
   public SimpleTokenStream(String text) {
      mReader = new Scanner(text);
   }

   /**
   Returns true if the stream has tokens remaining.
   */
   @Override
   public boolean hasNextToken() {
      return mReader.hasNext();
   }

   /**
   Returns the next token from the stream, or null if there is no token
   available.
   */
   @Override
   public String nextToken() {
      if (!hasNextToken())
         return null;
      
      String next = mReader.next().replaceAll("\\W", "").toLowerCase();
      return next.length() > 0 ? next : 
       hasNextToken() ? nextToken() : null;
   }
}
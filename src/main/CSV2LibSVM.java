package main;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * @author: nayef
 * <a href=https://nayefreza.wordpress.com/2013/09/18/converting-csv-file-to-libsvm-compatible-data-file-using-java/> source </a>
 * provide arguments:
 * 1) input.csv
 * 2) output.libsvm
 */
public class CSV2LibSVM {
   public static void main(String[] args) throws IOException {
      
      //args provided
      System.out.println("args provided:");
      for (String s : args) {
         System.out.println(s);
         if (s == null) {
            System.out.println("\nUsage: ./csv2libsvm <input.csv> <output.arff>\n");
            System.exit(1);
         }
      }

      if (args.length != 3) {
         System.out.println("\nUsage: ./csv2libsvm <input.csv> <output.arff>\n");
         System.exit(1);
      }

      
      String input = args[0];
      String output = args[1];
      StringBuffer sb = new StringBuffer();
      BufferedReader br = new BufferedReader(new FileReader(input));

      String line = br.readLine();
      Scanner scanner;

      while (line != null) {
          int indexCount = 1;
          scanner = new Scanner(line);
          scanner.useDelimiter(",");
          sb.append(scanner.next());
          while (scanner.hasNext()) {

              sb.append(" " + indexCount + ":" + scanner.next());
              indexCount++;
          }

          sb.append("\n");
          line = br.readLine();

      }

      FileWriter fw = new FileWriter(new File(output));
      fw.write(sb.toString());
      fw.flush();

  }
}

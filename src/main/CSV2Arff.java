package main;

import java.io.File;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class CSV2Arff {
   /**
    * takes 2 arguments:
    * - CSV input file
    * - ARFF output file
    */
   public static void main(String[] args) throws Exception {

      //args provided
      System.out.println("args provided:");
      for (String s : args) {
         System.out.println(s);
         if (s == null) {
            System.out.println("\nUsage: ./csv2arff.sh <input.csv> <output.arff>\n");
            System.exit(1);
         }
      }

      if (args.length != 2) {
         System.out.println("\nUsage: ./csv2arff.sh <input.csv> <output.arff>\n");
         System.exit(1);
      }



      // load CSV
      CSVLoader loader = new CSVLoader();
      loader.setSource(new File(args[0]));
      Instances data = loader.getDataSet();

      // save ARFF
      ArffSaver saver = new ArffSaver();
      saver.setInstances(data);
      saver.setFile(new File(args[1]));
      saver.setDestination(new File(args[1]));
      saver.writeBatch();
   }
}

package discretize;

import java.io.*;

import weka.core.*;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;

public class Discretizer {
   private static final int CLASS_INDEX = 37;
   
   /**
    * loads the given ARFF file and sets the class attribute as the last
    * attribute.
    *
    * @param filename    the file to load
    * @throws Exception  if somethings goes wrong
    */
   protected static Instances load(String filename) throws Exception {
     Instances       result;
     BufferedReader  reader;
 
     reader = new BufferedReader(new FileReader(filename));
     result = new Instances(reader);
     result.setClassIndex(CLASS_INDEX);
     reader.close();
 
     return result;
   }
 
   /**
    * saves the data to the specified file
    *
    * @param data        the data to save to a file
    * @param filename    the file to save the data to
    * @throws Exception  if something goes wrong
    */
   protected static void save(Instances data, String filename) throws Exception {
     BufferedWriter  writer;
 
     writer = new BufferedWriter(new FileWriter(filename));
     writer.write(data.toString());
     writer.newLine();
     writer.flush();
     writer.close();
   }
 
   /**
    * Takes four arguments:
    * <ol>
    *   <li>input train file</li>
    *   <li>input test file</li>
    *   <li>output train file</li>
    *   <li>output test file</li>
    * </ol>
    *
    * @param args        the commandline arguments
    * @throws Exception  if something goes wrong
    */
   public static void main(String[] args) throws Exception {
     Instances     inputTrain;
     Instances     outputTrain;
     Discretize    filter;
     
     if (args.length != 2) {
        System.out.println("usage: ./discretize.sh <input.arff> <output.arff>");
        return;
     }
     
     String inputPath = args[0];
     String outputName = args[1];
     
     // load data (class attribute is assumed to be last attribute)
     inputTrain = load(inputPath);
//     inputTest  = load(args[1]);
 
     // setup filter
     filter = new Discretize();
     filter.setInputFormat(inputTrain);
 
     // apply filter
     outputTrain = Filter.useFilter(inputTrain, filter);
 
     // save output
     save(outputTrain, outputName);
   }

}

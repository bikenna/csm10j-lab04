import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.*;
import java.text.DecimalFormat;

public class Lab04 {
    public static double computeMean(Scanner input){
        int numbers = 0, add = 0, counter = 0;
        double mean;
        System.out.print("Input: ");
        
        while(input.hasNext()){
            numbers = input.nextInt();
            add += numbers;
            //System.out.print(numbers + " ");
            counter++;
        }
        if(counter != 0 ){
            mean = add/counter;
        return mean;
        }
        else 
            return 0;
    }
    public static double computeStandardDeviation(Scanner file, double mean){
        double sum = 0, stdDev;
        int number = 0, count = 0;
        
        while(file.hasNext()){
            number = file.nextInt();
            sum += Math.pow(((double)number - mean), 2);
            count++;
        }
        stdDev = Math.sqrt(sum/(double)count);
        return stdDev;
    }
    public static void main(String [] args){
        try{
               Scanner inputFile = new Scanner(new FileReader("input.txt")); //I don't think you can reset the scanner
               Scanner file = new Scanner(new FileReader("input.txt")); // I made a second scanner object
               Scanner file_main = new Scanner(new FileReader("input.txt"));
               
               DecimalFormat round = new DecimalFormat("0.00");
               
               double mean = computeMean(inputFile);
               while(file_main.hasNext()){
                   int values = file_main.nextInt();
                   System.out.print(values + " ");
               }
               
               inputFile.close();
               
               System.out.print("\nMean: " + round.format(mean) + "\n");
                 
               System.out.print("StdDev: " + round.format(computeStandardDeviation(file, mean)) + "\n");
               file.close();
        }
        catch(FileNotFoundException e){
             System.out.println("File not found");
       }
    }
}

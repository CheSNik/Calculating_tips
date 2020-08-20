import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Assignment 4 P5.13
 * @author Sergei Chekhonin
 * This program computes tips for a restaurant
 */

public class Main {
    /**
     * reflects level of customers satisfaction
     */
    private static String satLevel = "";

    public static void main(String[] args) {
        PrintWriter out = null;
        try {
            out = new PrintWriter("Assignment4_P5.13output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String input = JOptionPane.showInputDialog("Enter cost of order in US dollars:");
        /**
         * stores input cost of dinner
         */
        double costOfDinner = parseDouble(input);

        input = JOptionPane.showInputDialog("Enter your satisfaction level (from 1 to 3):");
        /**
         * stores input rank of satisfaction
         */
        int satisfactionRank = parseInt(input);


        double tips = computeTips(costOfDinner, satisfactionRank);
        int tipsDols = (int)tips;
        int tipsCents = (int)((tips - tipsDols)*100);

        out.println(dtf.format(now));
        out.printf("Cost of dinner is: $%.2f\n", costOfDinner);
        out.println("Satisfaction level is:" + satLevel);
        out.printf("Suggested tips for the dinner are $%d and %d cents\n", tipsDols,tipsCents );

        out.close();
    }

    /***
     *
     * @param costOfDinner input cost of Dinner
     * @param rank input rank of satisfaction
     * @return amount of tips
     */
    public static double computeTips(double costOfDinner, int rank)
    {
        double tips=0;

        switch (rank){
            case 1: satLevel = "Totally satisfied"; tips = costOfDinner*0.2; break;
            case 2: satLevel = "Satisfied"; tips = costOfDinner*0.15; break;
            case 3: satLevel = "Distisfied"; tips = costOfDinner*0.1; break;
        }

        return tips;

    }
}

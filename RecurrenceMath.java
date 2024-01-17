import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

public class RecurrenceMath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your recurrence relation degree (1 OR 2):");
        int opt = input.nextInt();
        if(opt == 1){
            Degree1();
        } else if(opt == 2){
            Degree2();
        } else {
            System.exit(0);
        }
    }

    public static void Degree1(){
        Scanner input = new Scanner(System.in);
        double[] sequence = new double[51];

        System.out.print("Enter a0 : ");
        double a0 = input.nextDouble();
        sequence[0] = a0;

        System.out.print("Enter c : ");
        double c = input.nextDouble();

        double an = c * a0;
        sequence[1] = an;

        for (int n = 2; n < 51; n++) {
            an = c * an;
            sequence[n] = an;
        }

        try {
            FileWriter writer = new FileWriter("sequencefiledegree1.txt");
            for (int n = 0; n < 51; n++) {
                writer.write("n:" + n + "\t" + sequence[n] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Your sequence generated and written in sequencefiledegree1");

        String increasing;
        String decreasing;
        if(sequence[50] > sequence[0]) {
            increasing = "yes";
            decreasing = "no";
        } else {
            increasing = "no";
            decreasing = "yes";
        }

        String constant = "yes";
        for (int n = 1; n < 51; n++) {
            if(sequence[n] != sequence[n-1]){
                constant = "no";
                break;
            }
        }

        String upDown;
        if((sequence[1] > sequence[2] && sequence[3] > sequence[2]) ||
                (sequence[1] < sequence[2] && sequence[3] < sequence[2]))
            upDown = "yes";
        else
            upDown = "no";

        String diverging = "";
        String converging = "";
        for (int i = 1; i < sequence.length; i++) {
            double diff = Math.abs(sequence[i] - sequence[i - 1]);
            if (diff >= 0.0000000000001) {
                diverging = "yes";
                converging = "no";
            } else {
                diverging = "no";
                converging = "yes";
            }
        }

        System.out.println("Increasing: " + increasing);
        System.out.println("Decreasing: " + decreasing);
        System.out.println("Constant: " + constant);
        System.out.println("Up-Down: " + upDown);
        System.out.println("Diverging: " + diverging);
        System.out.println("Converging: " + converging);
    }

    public static void Degree2(){
        Scanner input = new Scanner(System.in);
        double[] sequence = new double[51];

        System.out.print("Enter c1 : ");
        double c1_d2 = input.nextDouble();

        System.out.print("Enter c2 : ");
        double c2_d2 = input.nextDouble();

        System.out.print("Enter a0 : ");
        double a0_d2 = input.nextDouble();

        System.out.print("Enter a1 : ");
        double a1_d2 = input.nextDouble();

        sequence[0] = a0_d2;
        sequence[1] = a1_d2;

        for (int i = 2; i < 51; i++) {
            sequence[i] = c1_d2 * sequence[i - 1] + c2_d2 * sequence[i - 2];
        }
        try {
            FileWriter writer = new FileWriter("sequencefiledegree2.txt");
            for (int n = 2; n < 51; n++) {
                writer.write("n:" + n + "\t" + sequence[n] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Your sequence generated and written in sequencefiledegree2.txt");

        String increasing;
        String decreasing;
        if(sequence[50] > sequence[0]) {
            increasing = "yes";
            decreasing = "no";
        } else {
            increasing = "no";
            decreasing = "yes";
        }

        String constant = "yes";
        for (int n = 1; n < 51; n++) {
            if(sequence[n] != sequence[n-1]){
                constant = "no";
                break;
            }
        }

        String upDown;
        if((sequence[1] > sequence[2] && sequence[3] > sequence[2]) ||
                (sequence[1] < sequence[2] && sequence[3] < sequence[2]))
            upDown = "yes";
        else
            upDown = "no";

        String diverging = "";
        String converging = "";
        for (int i = 1; i < sequence.length; i++) {
            double diff = Math.abs(sequence[i] - sequence[i - 1]);
            if (diff >= 0.0000000000001) {
                diverging = "yes";
                converging = "no";
            } else {
                diverging = "no";
                converging = "yes";
            }
        }

        System.out.println("Increasing: " + increasing);
        System.out.println("Decreasing: " + decreasing);
        System.out.println("Constant: " + constant);
        System.out.println("Up-Down: " + upDown);
        System.out.println("Diverging: " + diverging);
        System.out.println("Converging: " + converging);
        
    }
}
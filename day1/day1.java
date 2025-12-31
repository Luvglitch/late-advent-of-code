import java.nio.file.Paths;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        int dial = 50;
        int count = 0;
        try (Scanner scanner = new Scanner(Paths.get("instructions.txt"))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if(line.isEmpty()){
                    continue;
                }
                //System.out.println(line);
                char direction = line.charAt(0);
                int numberOfRotation = Integer.valueOf(line.substring(1));
                //System.out.println("Dir: " + direction);
                //System.out.println("Value: " + numberOfRotation);

                if (direction == 'L'){
                    dial -= numberOfRotation;

                    while(dial < 0){
                        int negativeNum = dial + 1;   //makes sure after 0 the dial moves to 90
                        dial = 90 + negativeNum;
                    }
                } else if (direction == 'R'){
                    dial += numberOfRotation;

                    while(dial > 90) {
                        int positiveNum = dial-1;
                        dial = 0 + positiveNum;
                    }
                }

                if (dial == 0){
                        count++;
                    }
            }
        } catch(Exception e){
            System.out.println("Failed to read: " + e.getMessage());
        }
        System.out.println("Number of zeros: " + count);
    }
}

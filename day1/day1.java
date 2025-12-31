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
                    for(int i = 0; i < numberOfRotation; i++){
                        dial--;
                        //System.out.println("Dial value: " + dial);
                        if(dial < 0){
                            dial = 99;
                            //System.out.println("Dial value: " + dial);
                        }
                    }
                } else if (direction == 'R'){
                    for(int i = 0; i < numberOfRotation; i++){
                        dial++;
                        //System.out.println("Dial value: " + dial);
                        if(dial > 99){
                            dial = 0;
                            //System.out.println("Dial value: " + dial);
                        }
                    }
                }
                //System.out.println("Line: "+line);
                //System.out.println("Dial at each line: "+dial);
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

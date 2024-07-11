package drawer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        FootShape fs = new FootShape();
        System.out.println("What to draw ? 1. Ellipse   2. Rectangle");
        String input = scan.nextLine();

        switch (input.toLowerCase()) {
            case "1":
            case "ellipse":
                fs.drawAsEllipse(new Ellipse());
                break;
            case "2":
            case "rectangle":
                fs.drawAsRectangle(new Rectangle());
                break;
            default:
                System.out.println("Please input as 1, 2, Ellipse or Reactangle")
                break;
        }

        scan.close();
    }
}

package footballwobserver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String evt_name = "update-football-score";

        Subject sbj = new Subject();
        ctmObserver obs1 = sbj.register(evt_name, System.out::println);
        ctmObserver obs2 = sbj.register(evt_name, System.out::println);

        Scanner scan = new Scanner(System.in);

        String input = "";

        do {
            System.out.print("Enter Score : ");
            input = scan.nextLine();
            sbj.notifyObservers(evt_name, input);
        } while (input != "");

        scan.close();
    }
}
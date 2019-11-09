import main.java.rfid.RFIDReaderInterface;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in); // TODO Remove temporary Scanner in Main Class
    public static RFIDReaderInterface device = new RFIDReaderInterface();
    public static void main(String[] args) throws InterruptedException {
        int menuState = 0;

        while (menuState != -1) {
            if (menuState == 0) {
                System.out.println("[MENU]");
                System.out.println("1 - Basic Scan");
                System.out.println("2 - Challenge");

                menuState = Integer.parseInt(sc.nextLine());
            }
            else if (menuState == 1) {
                String serialNumber = device.scan();
                device.clearLastStringRead();
                System.out.println("[Basic Scan]");
                System.out.println("Serial Number: " + serialNumber);
                menuState = 0;
            }
            else if (menuState == 2) {
                System.out.print("Enter passcode : ");
                boolean challengeResult = device.challenge(sc.nextLine());
                if (challengeResult) {
                    System.out.println("Challenge passed");
                }
                else {
                    System.out.println("Challenge failed");
                }
                menuState = 0;
            }
            else {
                System.out.println("Invalid Menu Option");
                menuState = 0;
            }
        }
    }
}
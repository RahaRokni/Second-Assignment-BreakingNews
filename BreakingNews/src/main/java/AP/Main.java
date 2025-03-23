
package AP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String APIKEY = "c3c81a0c9b494735b607c446b4a8b4e8";
        Infrastructure infrastructure = new Infrastructure( APIKEY);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("\n--- News Menu ---");
        while (!exit) {
            System.out.println("\n");
            infrastructure.displayNewsList();
            System.out.println("0. Exit");
            System.out.print("Select a news article to read more (1-20): ");

            int choice = scanner.nextInt();
            if (choice == 0) {
                exit = true;
            } else if (choice > 0 && choice <= infrastructure.getNewsList().size()) {
                News selectedNews = infrastructure.getNewsList().get(choice - 1);
                selectedNews.displayNews();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }
}

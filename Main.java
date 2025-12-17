import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VotingService service = new VotingService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== ONLINE VOTING SYSTEM =====");
            System.out.println("1. Register Voter");
            System.out.println("2. Vote");
            System.out.println("3. Show Results");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Voter ID: ");
                    String voterId = sc.nextLine();
                    service.registerVoter(voterId);
                    break;

                case 2:
                    System.out.print("Enter Voter ID: ");
                    String id = sc.nextLine();
                    service.showCandidates();
                    System.out.print("Choose Candidate ID: ");
                    int cid = sc.nextInt();
                    service.vote(id, cid);
                    break;

                case 3:
                    service.showResults();
                    break;

                case 4:
                    System.out.println("Thank you for voting!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

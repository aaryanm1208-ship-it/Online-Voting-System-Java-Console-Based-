import java.util.*;

public class VotingService {

    HashMap<String, Voter> voters = new HashMap<>();
    ArrayList<Candidate> candidates = new ArrayList<>();

    public VotingService() {
        candidates.add(new Candidate(1, "Candidate A"));
        candidates.add(new Candidate(2, "Candidate B"));
        candidates.add(new Candidate(3, "Candidate C"));
    }

    public void registerVoter(String voterId) {
        if (voters.containsKey(voterId)) {
            System.out.println("Voter already registered!");
        } else {
            voters.put(voterId, new Voter(voterId));
            System.out.println("Voter registered successfully.");
        }
    }

    public void vote(String voterId, int candidateId) {
        if (!voters.containsKey(voterId)) {
            System.out.println("Voter not registered.");
            return;
        }

        Voter voter = voters.get(voterId);

        if (voter.hasVoted) {
            System.out.println("You have already voted!");
            return;
        }

        for (Candidate c : candidates) {
            if (c.id == candidateId) {
                c.votes++;
                voter.hasVoted = true;
                System.out.println("Vote cast successfully!");
                return;
            }
        }
        System.out.println("Invalid candidate.");
    }

    public void showCandidates() {
        System.out.println("\nCandidates List:");
        for (Candidate c : candidates) {
            System.out.println(c.id + ". " + c.name);
        }
    }

    public void showResults() {
        System.out.println("\nVoting Results:");
        for (Candidate c : candidates) {
            System.out.println(c.name + " -> " + c.votes + " votes");
        }
    }
}

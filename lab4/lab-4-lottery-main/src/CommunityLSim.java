import java.util.*;

/**
 * A class that represents the community and simulates
 * the running of the lottery.
 */
public final class CommunityLSim {

    ArrayList<CommunityMember> communityMembers;
    Random random = new Random();
    //you will need to add more instance variables

    /**
     * Creates a new Community with the specified number of people
     * @param numP The number of people in the community
     */
    public CommunityLSim( int numP) {
        //create the players
        this.communityMembers = new ArrayList<>();

        for (int i = 0; i < numP; i++) {
            if (i < numP /2.0)
                this.communityMembers.add(new CommunityMember(CMemberKind.POORLY_PAID, (float)(99+Math.random())));
            else
                this.communityMembers.add(new CommunityMember(CMemberKind.WELL_PAID, (float)(100.1+Math.random())));
        }

    }

    public int getSize() {
        return this.communityMembers.size();
    }

    public CommunityMember getPlayer(int i) {
        return this.communityMembers.get(i);
    }

    /**
     * Give each community member some pocket change.
     * Give POORLY_PAID community members 0.03f, and give
     * WELL_PAID community members 0.1f.
     */
    // TODO: Implement this method.
    public void addPocketChange() {
        for (CommunityMember member: communityMembers) {
            if(member.getKind() == CMemberKind.WELL_PAID){
                member.setMoney(member.getMoney() + 0.1f);
            }else{
                member.setMoney(member.getMoney() + 0.03f);
            }

        }
    }

    // TODO: Write a method that computes a new list of lottery players,
    //  choosing from the list of community members.
    //  You will likely want to change this method signature.
    private Set<Integer> reDoWhoPlays() {
        int poorHalf = communityMembers.size()/2;
        int poorPlayers = (int) Math.round(poorHalf * 0.6);
        Set<Integer> whoPlays = new HashSet<Integer>();
        Random random = new Random();
        for (int i = 0; i < poorPlayers ; i++) {
                Integer a  = random.nextInt(poorHalf);
                if (!whoPlays.contains(a)){
                    whoPlays.add(a);
                }
                else{
                    i--;
                }
        }
        int richPlayers = (int) Math.round(poorHalf * 0.4);
        for (int i = 0; i < richPlayers ; i++) {
            Integer a  = random.nextInt(poorHalf) + poorHalf;
            if (!whoPlays.contains(a)){
                whoPlays.add(a);
            }
            else{
                i--;
            }
        }
        return whoPlays;
    }
    public int scholarshipWinner() {
        int poorHalf = communityMembers.size()/2;
        int poorPlayers = (int) Math.round(poorHalf * 0.3);
        Set<Integer> whoPlays = new HashSet<Integer>();
        Random random = new Random();
        for (int i = 0; i < poorPlayers + 1; i++) {
            Integer a  = random.nextInt(poorHalf);
            if (!whoPlays.contains(a)){
                whoPlays.add(a);
            }
            else{
                i--;
            }
        }
        int richPlayers = (int) Math.round(poorHalf * 0.7);
        for (int i = 0; i < richPlayers + 1; i++) {
            Integer a  = random.nextInt(poorHalf) + poorHalf;
            if (!whoPlays.contains(a)){
                whoPlays.add(a);
            }
            else{
                i--;
            }
        }
        Random rndm = new Random();
        Integer[] arrayNumbers = whoPlays.toArray(new Integer[whoPlays.size()]);
//        System.out.println(whoPlays);
//        System.out.println(arrayNumbers[rndm.nextInt(whoPlays.size())]);
        return arrayNumbers[rndm.nextInt(whoPlays.size())];
    }

    /* generate some random indices for who might play the lottery
        in a given range of indices */

    /**
     * Generate a number of random indices within an interval
     * @param numI The number of random unique indices to generate
     * @param startRange The lower bound of the interval, inclusive
     * @param endRange The upper bound of the interval, exclusive
     */
    // TODO: Implement this method. You will likely want to change this
    //  method signature.
    public void randomUniqIndx(int numI, int startRange, int endRange) {
        //just did this in the other function
    }

    public void simulateYears(int numYears) {
        // Simulate the lottery (see steps below)
        for (int year=0; year < numYears; year++) {
            this.addPocketChange();
            // TODO Re-compute the players who are playing the lottery in the current year.
            // TODO Simulate the lottery for those players.
            Game newGame = new Game();
            Set<Integer> newPlayers = reDoWhoPlays();
            for (Integer player: newPlayers
                 ) {
                CommunityMember memb = communityMembers.get(player);
                float newMoney = newGame.getWinnings(memb.playRandom(), this);
                memb.setMoney(newMoney + memb.getMoney());
            }


            // 4. Update everyone's money for that year.
            for (CommunityMember cm : this.communityMembers) {
                cm.updateMoneyEachYear();
            }

            System.out.print("After year: ");
            System.out.println(year);
            float maxMoney = 0f;
            for (CommunityMember cm : this.communityMembers) {
                if(cm.getMoney() >maxMoney){
                    maxMoney = cm.getMoney();
                }
            }
            System.out.print("The person with the most money has: ");
            System.out.println(maxMoney);
            float minMoney = 999999999999f;
            for (CommunityMember cm : this.communityMembers) {
                if(cm.getMoney() <minMoney){
                    minMoney = cm.getMoney();
                }
            }
            System.out.print("The person with the least money has: ");
            System.out.println(minMoney);

        }
    }

}

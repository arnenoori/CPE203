import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {
    private final Set<Integer> wNumbers = winningLotNumber(); //CommunityMember.playRandom();
    public Game(){

    }
    public float getWinnings(Set<Integer> nums, CommunityLSim sim) {

        float winnings = -1f;
        int matches = matches(nums);
        switch(matches){
            case 0:
                winnings = -1f;
                sim.getPlayer(sim.scholarshipWinner()).addOneToMoney();
                break;
            case 1:
                winnings = -1f;
                sim.getPlayer(sim.scholarshipWinner()).addOneToMoney();
                break;
            case 2: winnings = 1f; break;
            case 3: winnings = 10.86f; break;
            case 4: winnings = 197.53f; break;
            case 5: winnings = 212534.83f; break;
        }
        return winnings;
    }
    public Set<Integer> getwNumbers() {
        return wNumbers;
    }

    public int matches(Set<Integer> nums){
        int ret = 0;
        for(Integer i: nums){
            if(this.wNumbers.contains(i)){ret++;}
        }
        return ret;
    }
    public Set<Integer> winningLotNumber() {
        Set<Integer> LottoNums = new HashSet<Integer>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Integer a  = random.nextInt(43)+1;
            if (!LottoNums.contains(a)){
                LottoNums.add(a);
            }
            else{
                i--;
            }
        }
        return LottoNums;
    }

}

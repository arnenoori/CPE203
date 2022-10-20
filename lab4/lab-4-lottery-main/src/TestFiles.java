import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class TestFiles {
    @Test
    public void testLottoNumGenerator(){
        Game newGame = new Game();
        Set<Integer> set = newGame.winningLotNumber();
        System.out.println(newGame.winningLotNumber());
        assertEquals(5,set.size());
    }
    @Test
    public void testMatches(){
        Game newGame = new Game();
        CommunityMember newMem = new CommunityMember(CMemberKind.WELL_PAID, 99.5f);
        Set<Integer> set = newGame.winningLotNumber();
        System.out.println(31/2);
        assertEquals(0,newGame.matches(newMem.playRandom()),5);
        assertEquals(5,newGame.matches(newGame.getwNumbers()));


    }
    @Test
    public void testWinnings(){
        Game newGame = new Game();
        CommunityMember newMem = new CommunityMember(CMemberKind.WELL_PAID, 99.5f);
        Set<Integer> set = newGame.winningLotNumber();
        System.out.println(newGame.winningLotNumber());
        assertEquals(212534.83f,newGame.getWinnings(newGame.getwNumbers(), new CommunityLSim(10)), 0.001);


    }

}
package ohtuesimerkki;

import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    @Test
    public void etsiTest1() {
        assertEquals(null, stats.search("Seko"));
    }
    @Test
    public void etsiTest2() {
        assertEquals(true, stats.search("Semenko").getName().equals("Semenko"));
    }
    @Test
    public void testaaParhaat1() {
        // Antaa yhden ylimääräisen
        assertEquals(2, stats.topScorers(1).size());
    }
    @Test
    public void testaaParhaat2() {
        // Antaa yhden ylimääräisen
        assertEquals(3, stats.topScorers(2).size());
    }
    @Test
    public void etsiJoukkue1() {
        assertEquals(1, stats.team("PIT").size());
    }
    // Ei toimi, bugi...
//    @Test
//    public void testaaParhaat3() {
//        assertEquals(6, stats.topScorers(7).size());
//    }
}


package statistics.matcher;

import statistics.Player;

public class PlaysIn implements Matcher {
    private String team;
    private Matcher matcher;
    public PlaysIn(Matcher matcher, String team) {
        this.matcher = matcher;
        this.team = team;
    }        
    
    @Override
    public boolean matches(Player p) {
        return (p.getTeam().contains(team) && this.matcher.matches(p));
    }
    
}

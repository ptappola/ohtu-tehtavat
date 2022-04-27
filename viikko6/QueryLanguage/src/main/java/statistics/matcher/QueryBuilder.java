package statistics.matcher;
import statistics.Player;
public class QueryBuilder {
    Matcher matcher;
    public QueryBuilder() {
        this.matcher = new All();
    }
    public QueryBuilder playsIn(String team) {
        this.matcher = new PlaysIn(matcher, team);
        return this;
    }
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new HasAtLeast(matcher, value, category);
        return this;
    }
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new HasFewerThan(matcher, value, category);
        return this;
    }
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    public Matcher build() {
        Matcher m = this.matcher;
        this.matcher = new All();
        return m;
    }
}

package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getNationality() {
        return this.nationality;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String paluu = name + "                         ";
        paluu = paluu.substring(0, 30);
        paluu += team + " : ";
        if (goals < 10) {
            paluu += " ";
        }
        paluu += goals + " + ";
        if (assists < 10) {
            paluu += " ";
        }
        paluu += assists + " = " + (goals + assists);
        return paluu; 
    }
    @Override
    public int compareTo(Player toinen) {
//        Player toinen = (Player)verrattava;
        if ((this.goals + this.assists) < (toinen.goals + toinen.assists)) {
            return 1;
        } else if ((this.goals + this.assists) == (toinen.goals + toinen.assists)) {
            return 0;
        } else {
            return -1;
        }
    }
}

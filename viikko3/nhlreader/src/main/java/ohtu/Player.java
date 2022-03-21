
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private String team;

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
        return name + " " + team;
    }
      
}

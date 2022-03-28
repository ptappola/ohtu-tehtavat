package ohtu;

public class TennisGame {
    
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (player1Score == player2Score)
        {
            score = even(player1Score);
        }
        else if (player1Score >= 4 || player2Score >= 4)
        {
            int difference = player1Score - player2Score;
            if (difference == 1) score ="Advantage player1";
            else if (difference == -1) score ="Advantage player2";
            else if (difference >= 2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            score = points(player1Score) + "-" + points(player2Score);
        }
        return score;
    }
    private String points(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
    private String even(int score) {
        switch (score) {
            case 0:
            case 1:
            case 2:
            case 3:
                return points(score) + "-All";
            default:
                return "Deuce";
        }
    }
}
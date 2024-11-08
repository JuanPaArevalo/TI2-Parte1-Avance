package model;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    private Referee centralReferee;
    private Referee assistantReferee1;
    private Referee assistantReferee2;

    // Constructor to initialize teams for the match
    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;  // Default score is 0 since its not played yet
        this.awayScore = 0;
        this.centralReferee = null;
        this.assistantReferee1 = null;
        this.assistantReferee2 = null;
    }

    // Getters and Setters for the match details
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public Referee getCentralReferee() {
        return centralReferee;
    }

    public void setCentralReferee(Referee centralReferee) {
        this.centralReferee = centralReferee;
    }

    public Referee getAssistantReferee1() {
        return assistantReferee1;
    }

    public void setAssistantReferee1(Referee assistantReferee1) {
        this.assistantReferee1 = assistantReferee1;
    }

    public Referee getAssistantReferee2() {
        return assistantReferee2;
    }

    public void setAssistantReferee2(Referee assistantReferee2) {
        this.assistantReferee2 = assistantReferee2;
    }

    public void registerScore(int homeScore, int awayScore){
        this.homeScore=homeScore;
        this.awayScore=awayScore;
    }

    // Method to display match information in a readable format
    public String displayMatchInfo() {
        return "Match: " + homeTeam.getName() + " vs " + awayTeam.getName() +
               "\nScore: " + homeScore + " - " + awayScore +
               "\nReferees: " + (centralReferee != null ? centralReferee.getName() : "Not Assigned") +
               " (Central), " + (assistantReferee1 != null ? assistantReferee1.getName() : "Not Assigned") +
               " (Assistant 1), " + (assistantReferee2 != null ? assistantReferee2.getName() : "Not Assigned") +
               "\n";
    }
}

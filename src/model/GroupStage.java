package model;

public class GroupStage {
    private Team[] teams;
    private String[] matches;
    private String[] dates;

    public GroupStage() {
        this.matches = new String[12]; // Assuming 4 teams per group, so 6 matches per group * 2 groups = 12 matches
        this.dates = new String[12];
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public String createMatches() {
        int matchIndex = 0;
        String result = "Group Stage Matches:\n";
        
        for (int i = 0; i < teams.length; i++) {
            if (teams[i] != null) {
                for (int j = i + 1; j < teams.length; j++) {
                    if (teams[j] != null) {
                        matches[matchIndex] = teams[i].getName() + " vs " + teams[j].getName();
                        dates[matchIndex] = "Date for match " + (matchIndex + 1);
                        result += matches[matchIndex] + " on " + dates[matchIndex] + "\n";
                        matchIndex++;
                    }
                }
            }
        }
        return result;
    }
}

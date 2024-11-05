package model;

import java.util.Random;

public class GroupStage {
    private Team[] groupA;
    private Team[] groupB;
    private String[] matchesA;
    private String[] matchesB;
    private String[] datesA;
    private String[] datesB;

    public GroupStage() {
        this.groupA = new Team[4];
        this.groupB = new Team[4];
        this.matchesA = new String[6];  // Cada grupo tendrá 6 partidos (4 equipos, todos contra todos)
        this.matchesB = new String[6];
        this.datesA = new String[6];
        this.datesB = new String[6];
    }

    public void setTeams(Team[] teams) {
        if (teams.length < 8) {
            throw new IllegalArgumentException("Se necesitan exactamente 8 equipos para la fase de grupos.");
        }
        
        // Distribuir equipos aleatoriamente en dos grupos
        Random random = new Random();
        boolean[] assigned = new boolean[8];  // Para rastrear los equipos ya asignados
        int indexA = 0, indexB = 0;

        while (indexA < 4 || indexB < 4) {
            int randIndex = random.nextInt(8);
            if (!assigned[randIndex]) {
                if (indexA < 4) {
                    groupA[indexA++] = teams[randIndex];
                } else if (indexB < 4) {
                    groupB[indexB++] = teams[randIndex];
                }
                assigned[randIndex] = true;
            }
        }
    }

    public String createMatches() {
        String result = "Group Stage Matches:\n";

        result += "\n--- Group A Matches ---\n";
        result += createGroupMatches(groupA, matchesA, datesA);

        result += "\n--- Group B Matches ---\n";
        result += createGroupMatches(groupB, matchesB, datesB);

        return result;
    }

    private String createGroupMatches(Team[] group, String[] matches, String[] dates) {
        int matchIndex = 0;
        String result = "";

        // Generar partidos de todos contra todos en el grupo
        for (int i = 0; i < group.length; i++) {
            for (int j = i + 1; j < group.length; j++) {
                matches[matchIndex] = group[i].getName() + " vs " + group[j].getName();
                dates[matchIndex] = "Date for match " + (matchIndex + 1);  // Se puede personalizar la fecha si se desea
                result += matches[matchIndex] + " on " + dates[matchIndex] + "\n";
                matchIndex++;
            }
        }

        return result;
    }
}

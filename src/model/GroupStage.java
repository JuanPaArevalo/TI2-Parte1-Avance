package model;

import java.util.Random;

public class GroupStage {
    private Team[] groupA;
    private Team[] groupB;
    private String[] matches;
    private String[] dates;

    public GroupStage() {
        this.groupA = new Team[4];
        this.groupB = new Team[4];
        this.matches = new String[12]; // 6 matches per group for a total of 12 matches
        this.dates = new String[12];
    }

    // Método para distribuir aleatoriamente 8 equipos en 2 grupos de 4
    public void setTeams(Team[] teams) {
        Random random = new Random();
        boolean[] assigned = new boolean[teams.length]; // Marcadores para saber si un equipo ya fue asignado
        int countGroupA = 0;
        int countGroupB = 0;

        while (countGroupA < 4 || countGroupB < 4) {
            int rand = random.nextInt(teams.length);

            if (!assigned[rand]) {
                assigned[rand] = true;
                
                if (countGroupA < 4) {
                    groupA[countGroupA] = teams[rand];
                    countGroupA++;
                } else if (countGroupB < 4) {
                    groupB[countGroupB] = teams[rand];
                    countGroupB++;
                }
            }
        }
    }

    // Método para crear los partidos en cada grupo
    public String createMatches() {
        String result = "Group Stage Matches:\n";
        int matchIndex = 0;

        // Generación de partidos para el grupo A
        result += "\nGroup A Matches:\n";
        for (int i = 0; i < groupA.length; i++) {
            for (int j = i + 1; j < groupA.length; j++) {
                matches[matchIndex] = groupA[i].getName() + " vs " + groupA[j].getName();
                dates[matchIndex] = "Date for match " + (matchIndex + 1);
                result += matches[matchIndex] + " on " + dates[matchIndex] + "\n";
                matchIndex++;
            }
        }

        // Generación de partidos para el grupo B
        result += "\nGroup B Matches:\n";
        for (int i = 0; i < groupB.length; i++) {
            for (int j = i + 1; j < groupB.length; j++) {
                matches[matchIndex] = groupB[i].getName() + " vs " + groupB[j].getName();
                dates[matchIndex] = "Date for match " + (matchIndex + 1);
                result += matches[matchIndex] + " on " + dates[matchIndex] + "\n";
                matchIndex++;
            }
        }

        return result;
    }
}
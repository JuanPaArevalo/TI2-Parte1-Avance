package model;

public class Team {
    private String name;
    private String country;
    private String coach;
    private Player[] players;
    private int playerCount;

    public Team(String name, String country, String coach) {
        this.name = name;
        this.country = country;
        this.coach = coach;
        this.players = new Player[20]; // Maximum 20 players per team
        this.playerCount = 0;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Player createPlayer(int number, String name, String country, PlayerPosition position) {
        Player player = new Player(number, name, country, position);
        return player;    
    }

    public String addPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if(players[i] == null) {
                players[i] = player;
                return "Player succesfully added to team";
            }
        }
        return "Cannot add more players to the team.";
    }

    public Player[] getPlayers() {
        return players;
    }
}

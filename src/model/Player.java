package model;

public class Player extends Person implements IWaterDrinker {
    private int playerNumber;
    private PlayerPosition position;
    private int goalsScored;
    private int assists;
    private int yellowCards;
    private int redCards;
    private int matchesPlayed;

    public Player(int playerNumber, String name, String country, PlayerPosition position) {
        super(name, country);
        this.playerNumber = playerNumber;
        this.position = position;
    }

    public Player(int playerNumber, String name, String country, PlayerPosition position, int goalsScored, int yellowCards, int redCards, int matchesPlayed) {
        super(name, country);
        this.playerNumber = playerNumber;
        this.position = position;
        this.goalsScored = goalsScored;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.matchesPlayed = matchesPlayed;
    }

    // Métodos getters y setters
    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    //Método implementado de la interface
    @Override
    public String drinkWater() {
        return "Im drinking water";
    }
}

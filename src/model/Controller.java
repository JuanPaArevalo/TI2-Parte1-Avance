package model;

import model.Team;
import model.Player;
import model.Referee;
import model.PlayerPosition;
import model.RefereeType;

public class Controller {
    private Team[] teams;
    private Referee[] referees;
    private int refereeCount;
    private GroupStage groupStage;

    public Controller() {
        this.teams = new Team[8];
        this.referees = new Referee[12];
        this.refereeCount = 0;
        this.groupStage = new GroupStage();
    }

    /**
     * Description: Creates a new Team instance with provided attributes.
     * @param String name, name of the team. Must not be null or empty.
     * @param String country, country of the team. Must not be null or empty.
     * @param String coach, name of the team's coach. Must not be null or empty.
     * @return Team, returns a new Team instance initialized with provided values.
     */
    public Team createTeam(String name, String country, String coach) {
        Team team = new Team(name, country, coach);
        return team;    
    }

    /**
     * Description: Registers a Team in the array if there is space available.
     * @param Team team, the team object to register. Must not be null.
     * @return String, returns a message indicating success or failure in registering the team.
     */
    public String registerTeam(Team team) {
        for (int i = 0; i < teams.length; i++) {
            if (teams[i] == null) {
                teams[i] = team;
                return "Team registered successfully.";
            }
        } 
        return "Cannot register more teams.";
    }

    /**
     * Description: Searches for a team by name in the teams array.
     * @param String playerTeam, name of the team to search for. Must not be null or empty.
     * @return Team, returns the matching team if found, or null if not found.
     */
    public Team searchTeam(String playerTeam) {
        for(int i = 0; i < teams.length; i++) {
            if(teams[i] != null && teams[i].getName().equalsIgnoreCase(playerTeam)) {
                return teams[i];
            }
        }
        return null;
    }

    /**
     * Description: Registers a player to the specified team by creating and adding a Player.
     * @param Team team, the team to which the player is being added. Must not be null.
     * @param int number, the player's jersey number. Must be unique for each team.
     * @param String name, player's name. Must not be null or empty.
     * @param String country, player's country. Must not be null or empty.
     * @param PlayerPosition position, player's position on the field. Must not be null.
     * @return String, returns the result of the addPlayer method in the Team class.
     */
    public String registerPlayer(Team team, int number, String name, String country, PlayerPosition position) {
        return team.addPlayer(team.createPlayer(number, name, country, position));
    }

    /**
     * Description: Validates and returns the PlayerPosition type based on input string.
     * @param String position, the position name to validate. Acceptable values are "GOALKEEPER", "DEFENDER", "MIDFIELDER", "FORWARD".
     * @return PlayerPosition, returns the matching PlayerPosition enum value or null if invalid input.
     */
    public PlayerPosition selectPlayerPosition(String position) {
        PlayerPosition type = null;
        switch (position) {
            case "GOALKEEPER":
                type = PlayerPosition.GOALKEPEER;
                break;
            case "DEFENDER":
                type = PlayerPosition.DEFENDER;
                break;
            case "MIDFIELDER":
                type = PlayerPosition.MIDFIELDER;
                break;
            case "FORWARD":
                type = PlayerPosition.FORWARD;
                break;
            default:
                type = null;
        }
        return type;
    }

    /**
     * Description: Creates a new Referee instance with provided attributes.
     * @param int id, unique identifier for the referee. Must be positive.
     * @param String name, the name of the referee. Must not be null or empty.
     * @param String country, referee's country. Must not be null or empty.
     * @param RefereeType refType, referee's type (CENTRAL, ASSISTANT). Must not be null.
     * @return Referee, returns a new Referee instance initialized with provided values.
     */
    public Referee createReferee(int id, String name, String country, RefereeType refType) {
        Referee referee = new Referee(id, name, country, refType);
        return referee;    
    }

    /**
     * Description: Registers a referee in the referees array if space is available.
     * @param Referee referee, the referee object to register. Must not be null.
     * @return String, returns a message indicating success or failure in registering the referee.
     */
    public String registerReferee(Referee referee) {
        for (int i = 0; i < referees.length; i++) {
            if (referees[i] == null) {
                referees[i] = referee;
                return "Referee registered successfully.";
            }
        } 
        return "Cannot register referee.";
    }

    /**
     * Description: Validates and returns the RefereeType based on input string.
     * @param String refType, the referee type to validate. Acceptable values are "CENTRAL" and "ASSISTANT".
     * @return RefereeType, returns the matching RefereeType enum value or null if invalid input.
     */
    public RefereeType selectRefereeType(String refType) {
        RefereeType type = null;
        switch (refType) {
            case "CENTRAL":
                type = RefereeType.CENTRAL;
                break;
            case "ASSISTANT":
                type = RefereeType.ASSISTANT;
                break;
            default:
                type = null;
        }
        return type;
    }

    /**
     * Description: Preloads default data for teams, players, and referees.
     * @return String, returns a message indicating successful data preload.
     */
    public String preloadData() {
        Team team1 = createTeam("Barcelona", "Espana", "Hansi Flick");
        registerTeam(team1);
        registerPlayer(team1, 1, "Marc-André ter Stegen", "Alemania", PlayerPosition.GOALKEPEER);
        registerPlayer(team1, 2, "João Cancelo", "Portugal", PlayerPosition.DEFENDER);
        registerPlayer(team1, 3, "Andreas Christensen", "Dinamarca", PlayerPosition.DEFENDER);
        registerPlayer(team1, 4, "Ronald Araújo", "Uruguay", PlayerPosition.DEFENDER);
        registerPlayer(team1, 5, "Inigo Martinez", "Espana", PlayerPosition.DEFENDER);
        registerPlayer(team1, 6, "Gavi", "Espana", PlayerPosition.MIDFIELDER);
        registerPlayer(team1, 7, "Ferran Torres", "Espana", PlayerPosition.FORWARD);
        registerPlayer(team1, 8, "Pedri", "Espana", PlayerPosition.MIDFIELDER);
        registerPlayer(team1, 9, "Robert Lewandowski", "Polonia", PlayerPosition.FORWARD);
        registerPlayer(team1, 10, "Ansu Fati", "Espana", PlayerPosition.FORWARD);
        registerPlayer(team1, 11, "Raphinha", "Brasil", PlayerPosition.FORWARD);
        registerPlayer(team1, 15, "João Félix", "Portugal", PlayerPosition.FORWARD);
        registerPlayer(team1, 16, "Oriol Romeu", "Espana", PlayerPosition.MIDFIELDER);
        registerPlayer(team1, 17, "Marcos Alonso", "Espana", PlayerPosition.DEFENDER);
        registerPlayer(team1, 18, "Alejandro Balde", "Espana", PlayerPosition.DEFENDER);
        registerPlayer(team1, 20, "Sergi Roberto", "Espana", PlayerPosition.MIDFIELDER);
        registerPlayer(team1, 21, "Frenkie de Jong", "Países Bajos", PlayerPosition.MIDFIELDER);
        registerPlayer(team1, 22, "Ilkay Gündogan", "Alemania", PlayerPosition.MIDFIELDER);
        registerPlayer(team1, 23, "Jules Koundé", "Francia", PlayerPosition.DEFENDER);
        registerPlayer(team1, 24, "Inigo Martinez", "Espana", PlayerPosition.DEFENDER);

        Team team2 = createTeam("Real Vadrid", "Espana", "Ancelotti");
        registerTeam(team2);
        registerPlayer(team2, 1, "Thibaut Courtois", "Bélgica", PlayerPosition.GOALKEPEER);
        registerPlayer(team2, 2, "Dani Carvajal", "Espana", PlayerPosition.DEFENDER);
        registerPlayer(team2, 3, "Éder Militão", "Brasil", PlayerPosition.DEFENDER);
        registerPlayer(team2, 4, "David Alaba", "Austria", PlayerPosition.DEFENDER);
        registerPlayer(team2, 5, "Fran García", "Espana", PlayerPosition.DEFENDER);
        registerPlayer(team2, 6, "Eduardo Camavinga", "Francia", PlayerPosition.MIDFIELDER);
        registerPlayer(team2, 7, "Vinícius Jr.", "Brasil", PlayerPosition.FORWARD);
        registerPlayer(team2, 8, "Toni Kroos", "Alemania", PlayerPosition.MIDFIELDER);
        registerPlayer(team2, 9, "Joselu", "Espana", PlayerPosition.FORWARD);
        registerPlayer(team2, 10, "Luka Modrić", "Croacia", PlayerPosition.MIDFIELDER);
        registerPlayer(team2, 11, "Rodrygo", "Brasil", PlayerPosition.FORWARD);
        registerPlayer(team2, 12, "Aurélien Tchouaméni", "Francia", PlayerPosition.MIDFIELDER);
        registerPlayer(team2, 13, "Andriy Lunin", "Ucrania", PlayerPosition.GOALKEPEER);
        registerPlayer(team2, 14, "Brahim Díaz", "Espana", PlayerPosition.MIDFIELDER);
        registerPlayer(team2, 15, "Federico Valverde", "Uruguay", PlayerPosition.MIDFIELDER);
        registerPlayer(team2, 16, "Antonio Rüdiger", "Alemania", PlayerPosition.DEFENDER);
        registerPlayer(team2, 17, "Lucas Vázquez", "Espana", PlayerPosition.DEFENDER);
        registerPlayer(team2, 18, "Ferland Mendy", "Francia", PlayerPosition.DEFENDER);
        registerPlayer(team2, 19, "Alvaro Odriozola", "Espana", PlayerPosition.DEFENDER);
        registerPlayer(team2, 20, "Bellingham", "Inglaterra", PlayerPosition.MIDFIELDER);

        Team team3 = createTeam("Liverpool", "Inglaterra", "Jurgen Kloop");
        registerTeam(team3);
        registerPlayer(team3, 1, "Alisson Becker", "Brasil", PlayerPosition.GOALKEPEER);
        registerPlayer(team3, 2, "Trent Alexander-Arnold", "Inglaterra", PlayerPosition.DEFENDER);
        registerPlayer(team3, 3, "Virgil van Dijk", "Países Bajos", PlayerPosition.DEFENDER);
        registerPlayer(team3, 4, "Ibrahima Konaté", "Francia", PlayerPosition.DEFENDER);
        registerPlayer(team3, 5, "Andy Robertson", "Escocia", PlayerPosition.DEFENDER);
        registerPlayer(team3, 6, "Fabinho", "Brasil", PlayerPosition.MIDFIELDER);
        registerPlayer(team3, 7, "Alexis Mac Allister", "Argentina", PlayerPosition.MIDFIELDER);
        registerPlayer(team3, 8, "Dominik Szoboszlai", "Hungría", PlayerPosition.MIDFIELDER);
        registerPlayer(team3, 9, "Mohamed Salah", "Egipto", PlayerPosition.FORWARD);
        registerPlayer(team3, 10, "Darwin Núñez", "Uruguay", PlayerPosition.FORWARD);
        registerPlayer(team3, 11, "Diogo Jota", "Portugal", PlayerPosition.FORWARD);
        registerPlayer(team3, 12, "Cody Gakpo", "Países Bajos", PlayerPosition.FORWARD);
        registerPlayer(team3, 13, "Stefan Bajcetic", "España", PlayerPosition.MIDFIELDER);
        registerPlayer(team3, 14, "Harvey Elliott", "Inglaterra", PlayerPosition.MIDFIELDER);
        registerPlayer(team3, 15, "Curtis Jones", "Inglaterra", PlayerPosition.MIDFIELDER);
        registerPlayer(team3, 16, "Thiago Alcántara", "España", PlayerPosition.MIDFIELDER);
        registerPlayer(team3, 17, "Joe Gomez", "Inglaterra", PlayerPosition.DEFENDER);
        registerPlayer(team3, 18, "Joel Matip", "Camerún", PlayerPosition.DEFENDER);
        registerPlayer(team3, 19, "Adrián", "España", PlayerPosition.GOALKEPEER);
        registerPlayer(team3, 20, "Kostas Tsimikas", "Grecia", PlayerPosition.DEFENDER);

        Team team4 = createTeam("Manchester United", "Inglaterra", "Eric Tenhag");
        registerTeam(team4);
        registerPlayer(team4, 1, "Andre Onana", "Camerún", PlayerPosition.GOALKEPEER);
        registerPlayer(team4, 2, "Diogo Dalot", "Portugal", PlayerPosition.DEFENDER);
        registerPlayer(team4, 3, "Victor Lindelöf", "Suecia", PlayerPosition.DEFENDER);
        registerPlayer(team4, 4, "Raphaël Varane", "Francia", PlayerPosition.DEFENDER);
        registerPlayer(team4, 5, "Harry Maguire", "Inglaterra", PlayerPosition.DEFENDER);
        registerPlayer(team4, 6, "Lisandro Martínez", "Argentina", PlayerPosition.DEFENDER);
        registerPlayer(team4, 7, "Casemiro", "Brasil", PlayerPosition.MIDFIELDER);
        registerPlayer(team4, 8, "Bruno Fernandes", "Portugal", PlayerPosition.MIDFIELDER);
        registerPlayer(team4, 9, "Christian Eriksen", "Dinamarca", PlayerPosition.MIDFIELDER);
        registerPlayer(team4, 10, "Mason Mount", "Inglaterra", PlayerPosition.MIDFIELDER);
        registerPlayer(team4, 11, "Marcus Rashford", "Inglaterra", PlayerPosition.FORWARD);
        registerPlayer(team4, 12, "Rasmus Højlund", "Dinamarca", PlayerPosition.FORWARD);
        registerPlayer(team4, 13, "Antony", "Brasil", PlayerPosition.FORWARD);
        registerPlayer(team4, 14, "Jadon Sancho", "Inglaterra", PlayerPosition.FORWARD);
        registerPlayer(team4, 15, "Alejandro Garnacho", "Argentina", PlayerPosition.FORWARD);
        registerPlayer(team4, 16, "Scott McTominay", "Escocia", PlayerPosition.MIDFIELDER);
        registerPlayer(team4, 17, "Aaron Wan-Bissaka", "Inglaterra", PlayerPosition.DEFENDER);
        registerPlayer(team4, 18, "Luke Shaw", "Inglaterra", PlayerPosition.DEFENDER);
        registerPlayer(team4, 19, "Sofyan Amrabat", "Marruecos", PlayerPosition.MIDFIELDER);
        registerPlayer(team4, 20, "Tom Heaton", "Inglaterra", PlayerPosition.GOALKEPEER);

        Team team5 = createTeam("Inter de Milan", "Italia", "Simone Inzaghi");
        registerTeam(team5);
        registerPlayer(team5, 1, "Yann Sommer", "Suiza", PlayerPosition.GOALKEPEER);
        registerPlayer(team5, 2, "Matteo Darmian", "Italia", PlayerPosition.DEFENDER);
        registerPlayer(team5, 3, "Francesco Acerbi", "Italia", PlayerPosition.DEFENDER);
        registerPlayer(team5, 4, "Stefan de Vrij", "Países Bajos", PlayerPosition.DEFENDER);
        registerPlayer(team5, 5, "Benjamin Pavard", "Francia", PlayerPosition.DEFENDER);
        registerPlayer(team5, 6, "Alessandro Bastoni", "Italia", PlayerPosition.DEFENDER);
        registerPlayer(team5, 7, "Federico Dimarco", "Italia", PlayerPosition.DEFENDER);
        registerPlayer(team5, 8, "Hakan Çalhanoğlu", "Turquía", PlayerPosition.MIDFIELDER);
        registerPlayer(team5, 9, "Henrikh Mkhitaryan", "Armenia", PlayerPosition.MIDFIELDER);
        registerPlayer(team5, 10, "Davide Frattesi", "Italia", PlayerPosition.MIDFIELDER);
        registerPlayer(team5, 11, "Nicolo Barella", "Italia", PlayerPosition.MIDFIELDER);
        registerPlayer(team5, 12, "Marcus Thuram", "Francia", PlayerPosition.FORWARD);
        registerPlayer(team5, 13, "Lautaro Martínez", "Argentina", PlayerPosition.FORWARD);
        registerPlayer(team5, 14, "Carlos Augusto", "Brasil", PlayerPosition.DEFENDER);
        registerPlayer(team5, 15, "Kristjan Asllani", "Albania", PlayerPosition.MIDFIELDER);
        registerPlayer(team5, 16, "Juan Cuadrado", "Colombia", PlayerPosition.MIDFIELDER);
        registerPlayer(team5, 17, "Denzel Dumfries", "Países Bajos", PlayerPosition.DEFENDER);
        registerPlayer(team5, 18, "Alexis Sánchez", "Chile", PlayerPosition.FORWARD);
        registerPlayer(team5, 19, "Francesco Di Gennaro", "Italia", PlayerPosition.GOALKEPEER);
        registerPlayer(team5, 20, "Emil Audero", "Italia", PlayerPosition.GOALKEPEER);

        Team team6 = createTeam("Inter de Milan", "Italia", "Simone Inzaghi");
        registerTeam(team6);
        registerPlayer(team6, 1, "Wojciech Szczęsny", "Polonia", PlayerPosition.GOALKEPEER);
        registerPlayer(team6, 2, "Danilo", "Brasil", PlayerPosition.DEFENDER);
        registerPlayer(team6, 3, "Gleison Bremer", "Brasil", PlayerPosition.DEFENDER);
        registerPlayer(team6, 4, "Federico Gatti", "Italia", PlayerPosition.DEFENDER);
        registerPlayer(team6, 5, "Alex Sandro", "Brasil", PlayerPosition.DEFENDER);
        registerPlayer(team6, 6, "Manuel Locatelli", "Italia", PlayerPosition.MIDFIELDER);
        registerPlayer(team6, 7, "Adrien Rabiot", "Francia", PlayerPosition.MIDFIELDER);
        registerPlayer(team6, 8, "Filip Kostić", "Serbia", PlayerPosition.MIDFIELDER);
        registerPlayer(team6, 9, "Weston McKennie", "Estados Unidos", PlayerPosition.MIDFIELDER);
        registerPlayer(team6, 10, "Nicolò Fagioli", "Italia", PlayerPosition.MIDFIELDER);
        registerPlayer(team6, 11, "Fabio Miretti", "Italia", PlayerPosition.MIDFIELDER);
        registerPlayer(team6, 12, "Federico Chiesa", "Italia", PlayerPosition.FORWARD);
        registerPlayer(team6, 13, "Dusan Vlahovic", "Serbia", PlayerPosition.FORWARD);
        registerPlayer(team6, 14, "Arkadiusz Milik", "Polonia", PlayerPosition.FORWARD);
        registerPlayer(team6, 15, "Moise Kean", "Italia", PlayerPosition.FORWARD);
        registerPlayer(team6, 16, "Mattia Perin", "Italia", PlayerPosition.GOALKEPEER);
        registerPlayer(team6, 17, "Carlo Pinsoglio", "Italia", PlayerPosition.GOALKEPEER);
        registerPlayer(team6, 18, "Samuel Iling-Junior", "Inglaterra", PlayerPosition.FORWARD);
        registerPlayer(team6, 19, "Paul Pogba", "Francia", PlayerPosition.MIDFIELDER);
        registerPlayer(team6, 20, "Leonardo Bonucci", "Italia", PlayerPosition.DEFENDER);


        Referee referee1 = createReferee(54309, "Gil Manzano", "Espana", RefereeType.CENTRAL);
        registerReferee(referee1);
        Referee referee2 = createReferee(9842, "Juan Joe", "Nigeria", RefereeType.ASSISTANT);
        registerReferee(referee2);
        Referee referee3 = createReferee(82615, "Tomás Jaramillo", "Colombia", RefereeType.ASSISTANT);
        registerReferee(referee3);


        return "Data preloaded successfully.";
    }

    public String generateGroupStage() {
        groupStage.setTeams(teams);
        return groupStage.createMatches();
    }
}

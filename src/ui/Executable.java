package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    // Attributes of the Executable class
    private Scanner reader;
    private Controller cont;
    private static boolean flag;

    // Constructor
    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controller();
    }

    // Main method to run the menu
    public void run(boolean flag) {
        flag = false;

        while (!flag) {
            System.out.println("\n\nWelcome to the soccer tournament menu:");
            System.out.println("Options:\n" 
                                + "1. Register team \n" 
                                + "2. Register player \n"
                                + "3. Register referee \n" 
                                + "4. Preload data \n"
                                + "5. Show group stage draw \n" 
                                + "6. Exit \n");

            int option = reader.nextInt();
            reader.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    registerTeam();
                    break;
                case 2:
                    registerPlayer();
                    break;
                case 3:
                    registerReferee();
                    break;
                case 4:
                    preloadData();
                    break;
                case 5:
                    showGroupStageDraw();
                    break;
                case 6:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    // Method to register a team
    public void registerTeam() {
        System.out.print("Enter team name: ");
        String name = reader.nextLine();
        System.out.print("Enter team's country: ");
        String country = reader.nextLine();
        System.out.print("Enter team coach's name: ");
        String coach = reader.nextLine();

        // Controller call and output message
        System.out.println(cont.registerTeam(cont.createTeam(name, country, coach)));
    }

    // Method to register a player
    public void registerPlayer() {

        System.out.println("Enter the player's team: ");
        String playerTeam = reader.nextLine();

        if(cont.searchTeam(playerTeam)!=null){

        
            System.out.print("Enter player name: ");
            String name = reader.nextLine();
            System.out.print("Enter player's country: ");
            String country = reader.nextLine();
            System.out.print("Enter player's number: ");
            int number = reader.nextInt();
            reader.nextLine(); // Consume newline
            System.out.print("Enter player's position (Goalkeeper, Defender, Midfielder, Forward): ");
            String position = reader.nextLine().toUpperCase();
        

            // Player position validation
            while (cont.selectPlayerPosition(position) == null) {
                System.out.println("Invalid type. Please try again.");
                position = reader.nextLine().toUpperCase();
            }

            // Controller call and output message
            System.out.println(cont.registerPlayer(cont.searchTeam(playerTeam), number, name, country, cont.selectPlayerPosition(position)));
        } else {
            System.out.println("Team not found, please check again");
        }

    }

    // Method to register a referee
    public void registerReferee() {
        System.out.print("Enter referee ID: ");
        int id = reader.nextInt();
        reader.nextLine(); // Consume newline
        System.out.print("Enter referee name: ");
        String name = reader.nextLine();
        System.out.print("Enter referee's country: ");
        String country = reader.nextLine();
        System.out.print("Enter referee type (Central, Assistant): ");
        String refType = reader.nextLine().toUpperCase();

        // Referee type validation
        while (cont.selectRefereeType(refType) == null) {
            System.out.println("Invalid type. Please try again.");
            refType = reader.nextLine().toUpperCase();
        }

        // Controller call and output message
        System.out.println(cont.registerReferee(cont.createReferee(id, name, country, cont.selectRefereeType(refType))));
    }

    // Method to preload data
    public void preloadData() {
        System.out.println(cont.preloadData());
    }

    //Method to show the group stage fixture
    public void showGroupStageDraw() {
        System.out.println(cont.generateGroupStage());
    }

    // Main method
    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }
}

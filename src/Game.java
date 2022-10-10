import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);
    public void start(){

        System.out.println("Welcome to the Adventure Game !");
        System.out.println("Please enter a name: ");
        //String playerName = input.nextLine();
        Player player = new Player("Yunus");
        System.out.println(player.getName() + " welcome !");
        System.out.println("Please select a character: ");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("Locations: ");
            System.out.println();
            System.out.println("1- Safe House");
            System.out.println("2- Store");
            System.out.println("0- Exit --> End the game!");
            System.out.println();
            System.out.println("Please select your location to go : ");
            int selectedLoc = input.nextInt();
            switch (selectedLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player); //Location acts like Safe House , Polymorphism
                    break;
                case 2:
                    location = new ToolStore(player); //Location acts like Tool Store , Polymorphism
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null) {
                System.out.println("Game Over, see you later !");
                break;
            }
            if (!location.onLocation()){
                System.out.println("You are dead , GAME OVER!");
                break;
            }
        }

    }
}

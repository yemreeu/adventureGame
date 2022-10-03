import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);
    public void start(){

        System.out.println("Welcome to the Adventure Game !");
        System.out.println("Please enter a name: ");
        String playerName = input.nextLine();
        Player player = new Player("Yunus");
        System.out.println(player.getName() + " welcome !");
        System.out.println("Please select a character: ");
        player.selectChar();
    }
}

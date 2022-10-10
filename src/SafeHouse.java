public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are at Safe House");
        System.out.println("Your health has just been full");
        return true;
    }
}

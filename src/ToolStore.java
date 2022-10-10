public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-----------Welcome to store ! -----------");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.print("Your choice : ");
            int selectCase = Location.input.nextInt();

            while (selectCase < 1 || selectCase > 3){
                System.out.println("Invalid choice, please try again: ");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you later !");
                    showMenu = false;
                    break;
            }
        }


        return true;
    }
    public void printWeapons(){
        System.out.println();
        System.out.println("----- Weapons ----- ");
        System.out.println();

        for (Weapon w: Weapon.weapons()){
            System.out.println("ID: " + w.getId() +
                    " , Name :"+w.getName() +
                    " , Price : " + w.getPrice()+
                    " , Damage " + w.getDamage()
            );
        }
        System.out.println("0 - Exit");
    }

    public void buyWeapon(){
        System.out.println("Please select a weapon by ID : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Invalid choice, please try again: ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Sorry, you have no enough money to buy this weapon");
                }else {
                    System.out.println(selectedWeapon.getName() + " has been purchased !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Rest of your money: " + this.getPlayer().getMoney());
                    System.out.println("Your previous weapon : " + this.getPlayer().getInventory().getWeapon().getName());

                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }
    public void printArmors(){

        System.out.println();
        System.out.println("----- Armors ----- ");
        System.out.println();

        for (Armor a: Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() + " < Price: " +a.getPrice() +
                    " >"+" < Armor : " + a.getAvoid() +">");
        }
        System.out.println("0 - Exit");
    }

    public void buyArmor(){
        System.out.println("Please select an armor: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID <0 || selectArmorID > Armor.armors().length){
            System.out.println("Invalid value, please try again : ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You have no enoguh money");
                }else {
                    System.out.println(selectedArmor.getName() + " -> you bought this armor");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Rest of your money : " + this.getPlayer().getMoney());

                }
            }
        }
    }
}

import java.util.*;
public class Battle{
    double runHp;
    int playerTurn;
    int alienTurn;
    int run;
    public Battle(Player p, Alien a){
        playerTurn = 1;
        alienTurn = 2;
        run = 2;
        
        while(p.hp>0 && a.hp>0){
            while(playerTurn ==1 && run ==2){    
                System.out.println("It is " + p.Name + "'s turn. Please select an Action");
                System.out.println("1. Attack");
                System.out.println("2. Heal");
                System.out.println("3. Run");
                System.out.println("4. Change Weapons");
                //gets user input and makes sure it is valid
                Scanner input = new Scanner(System.in);
                while(!input.hasNextInt()){
                    System.out.println("Please enter a valid number 1-4");
                    input.nextLine();
                }
                int action = input.nextInt();
                while(action>4 || action<1){
                    System.out.println("Please enter a valid number 1-4");
                    input.nextLine();
                    while(!input.hasNextInt()){
                        System.out.println("Please enter a valid number 1-4");
                        input.nextLine();
                    }
                    action = input.nextInt();
                }

                if(action == 1){
                    if(p.playerAttack() > 0){
                        System.out.println(p.Name + " attacked");
                        a.alienDamaged(p.playerAttack());
                        playerTurn = 2;
                        alienTurn = 1;
                    }

                    if(a.hp<0){
                        a.hp = 0;
                        playerTurn = 2;
                        alienTurn = 2;
                    }
                    System.out.println("alien has " + a.hp + "/" + a.maxHp + "hp");
                }

                if(action == 2){
                    if(p.hp == p.hpMax){
                        System.out.println(p.Name + " already has full hp");
                    }else{
                        //uses the player heal method to add hp
                        p.hp = p.hp+p.playerHeal();
                        if(p.hp>p.hpMax){
                            p.hp = p.hpMax;
                        }
                        playerTurn = 2;
                        alienTurn = 1;
                        System.out.println(p.Name + "'s hp is " + p.hp);
                    }
                }

                if(action == 3){
                    if(p.hp/p.hpMax>.25){
                        runHp = p.hp;//sets a variable to store the player's hp to reset it after the player runs. the hps are set to 0 to break the while loop (Now I know it may have been possible to do this using a break command which I was not aware of while making this
                        p.hp = 0;
                        a.hp = 0;
                        playerTurn = 2;
                        run = 1;
                    }else{
                        System.out.println(p.Name + " is too weak and cannot run away");
                    }
                }

                if(action == 4){
                    int index = 1;//creates an index variable for the player to reference
                    System.out.println("Please enter the weapon you would like to equip");
                    for(Weapon w: p.WeaponList){
                        System.out.print(index + ". " );
                        System.out.println(w.wName + " " + w.ammo + " ammo");
                        index = index + 1;
                    }

                    Scanner equip = new Scanner(System.in);
                    while(!equip.hasNextInt()){
                        System.out.println("Please enter a valid number");
                        equip.nextLine();
                    }
                    int actionEquip = equip.nextInt();
                    while(actionEquip>p.WeaponList.size() || actionEquip<1){
                        System.out.println("Please enter a valid number");
                        equip.nextLine();
                        while(!input.hasNextInt()){
                            System.out.println("Please enter a valid number");
                            equip.nextLine();
                        }
                        actionEquip = equip.nextInt();
                    }
                    int equipIndex = actionEquip - 1;//variable to use to reference the array list. Uses the player's input - 1 so that the player can start with 1 instead of 
                    p.equipWeapon(p.WeaponList.get(equipIndex));
                    System.out.println(p.Name + " equipped " + p.WeaponList.get(0).wName);
                }
            }

            while(alienTurn == 1 && run == 2){
                if(a.hp == a.maxHp){//makes it so the alien will always attack if it is at full hp
                    System.out.println("The alien attacks");
                    p.playerDamaged(a.alienAttack());//uses the alienAttack and playerDamaged methods to decrease the player's hp
                    //if the player's hp goes below 0, it is set to 0 because negative hp is impossible
                    if(p.hp < 0){
                        p.hp = 0;
                    }
                    System.out.println(p.Name + " has " + p.hp + "/" + p.hpMax + "hp");
                    playerTurn=1;
                    alienTurn = 2;
                }else{
                    //if the alien's hp is not full, it has a 15% chance to heal
                    double healChance = Math.random();//generates a random number between 0 and 1
                    if(healChance>.15){//make the alien attack when healChance is greater than .15
                        System.out.println("The alien attacks");
                        p.playerDamaged(a.alienAttack());
                        //if the player's hp goes below 0, it is set to 0 because negative hp is impossible
                        if(p.hp < 0){
                            p.hp = 0;
                        }
                        System.out.println(p.Name + " has " + p.hp + "/" + p.hpMax + "hp");
                        playerTurn=1;
                        alienTurn = 2;
                    }else{//alien heals
                        a.alienHeal();
                        System.out.println("The alien healed and now has " + a.hp + "/" + a.maxHp + "hp");
                        playerTurn=1;
                        alienTurn = 2;
                    }
                }
            }

            if(a.hp == 0 && run == 2){//if the alien runs out of hp, the player wins
                System.out.println(p.Name + " defeated the alien");
                p.money = a.deathCredits + p.money;//gives the player the alien's deathCredits
                System.out.println(p.Name + " gained " + a.deathCredits + " Credits");
                //returns the user to the main menu
                MenuMain.showMenuMain(p);
                MenuMain.menuMainAction(p);
            }
            if(p.hp == 0 && run == 2){//if the player runs out of hp, the player loses
                System.out.println("the alien killed " + p.Name);
                p.hp = p.hpMax;//resets the player's hp
                p.money = p.money-50;//makes the player lose 50 credits
                //ensures the player does not end up with 0 credits
                if(p.money<0){
                    p.money = 0;
                    System.out.println(p.Name + " lost the rest of their credits");
                }else{
                    System.out.println(p.Name + " lost 50 Credits");
                }
                //returns the user to the main menu
                MenuMain.showMenuMain(p);
                MenuMain.menuMainAction(p);
            }
            if(a.hp == p.hp){//earlier in the code, when the player ran, both hps were set to 0. this executes the run code
                p.hp = runHp;//resets the player's hp to the stored value
                System.out.println(p.Name + " successfully ran away");
                //returns the user to the main menu
                MenuMain.showMenuMain(p);
                MenuMain.menuMainAction(p);
            }
        }
    }
}

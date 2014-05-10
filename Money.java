import java.awt.*;
import java.lang.*;
import java.util.*;
import java.util.List;
import java.awt.Color;
import hsa.Console;


public class Money {
    public static double gold = 0;
    public static int rate = 1;
    public static int cooldown = 0;
    public static int qcool = 0;
    public static void main(String args[]) {
	Console con = new Console (41, 100);
	ThreadTest test1 = new ThreadTest();
	ThreadTest2 test2 = new ThreadTest2();
	test1.setConsole(con);
	test2.setConsole(con);
	test1.start();
	test2.start();
    }
}
 
class ThreadTest extends Thread {
    List inv = new ArrayList();
    int maxhp = 100;
    int hp = 0;
    int sword = 1;
    int quest = 0;
    int shop = 0;
    int dead = 0;
    int chest = 0;
    int horn = 0;
    int skull = 0;
    int dust = 0;
    int wosw = 0;
    int lear = 0;
    int irsw = 0;
    int irar = 0;
    int stsw = 0;
    int star = 0;
    int disw = 0;
    int diar = 0;
    Console c; 
    public void setConsole(Console con) {
	c = con;
    }
    public void run() {
	c.println("You currently have: " + Money.gold + " gold");
	c.println("\nWelcome to the world of grind\nThe goal of the game is to amass money and get stuff!");
	while (true){
	    c.println("What would you like to do?\n\n<q>uest | <e>xplore | <s>hop | s<t>ats | <i>nventory | <u>pdate money");
	    String choice = c.readString();
	    if (choice.equalsIgnoreCase("q")){
		if(Money.cooldown <= 0){
		    quest();
		    Money.cooldown = 30;
		}else{
		    c.println("You will have to wait " + Money.cooldown + " seconds until you can quest again.");
		    enter();
		}                    
	    }else if(choice.equalsIgnoreCase("s")){
		shop();
	    }else if(choice.equalsIgnoreCase("t")){
		stats();
	    }else if(choice.equalsIgnoreCase("e")){
		if(Money.qcool <= 0){
		    kill();
		}else{
		    c.println("You will have to wait " + Money.qcool + " seconds until you can explore again.");
		    enter();
		} 
	    }else if(choice.equalsIgnoreCase("i")){
		inventory();
	    }
	    update();
	}
    }
    public void quest(){
	c.clear();
	Random rand = new Random();
	int number1 = (int) (Math.random()*9);
	int number2 = (int) (Math.random()*9);
	int success = (int) (Math.random()*2);
	double reward1 = 0;
	String giver = "";
	String actual = "";
	switch (number1) 
	{
	    case 0: giver = "an old man";
	    reward1 = 0;
	    break;
	    case 1: giver = "a dragon";
	    reward1 = 1;
	    break;
	    case 2: giver = "the king";
	    reward1 = 2;
	    break;
	    case 3: giver = "a god";
	    reward1 = 3;
	    break;
	    case 4: giver = "a bald man";
	    reward1 = 0.5;
	    break;
	    case 5: giver = "your neighbour";
	    reward1 = 0.5;
	    break;
	    case 6: giver = "a princess";
	    reward1 = 1;
	    break;
	    case 7: giver = "a Nigerian king";
	    reward1 = -1;
	    break;
	    case 8: giver = "the Pope";
	    reward1 = 2;
	    break;
	    case 9: giver = "a bearded crusader";
	    reward1 = 1;
	    break;
	}
	switch (number2) 
	{
	    case 0: actual = "get a cat out of a tree";
		    reward1 = reward1 + 0.5;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in getting the cat out of the tree, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + (reward1*50);
		    }else{
			c.println("You accidentally kill the cat, you don't get a reward");
		    }
	    break;
	    case 1: actual = "save the kingdom";
		    reward1 = reward1 + 2;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in saving the kingdom, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly burn the kingdom to the ground, you don't get a reward");
		    }
	    break;
	    case 2: actual = "rescue a princess";
		    reward1 = reward1 + 2;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in rescuing the princess, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly kill the princess, you don't get a reward");
		    }
	    break;
	    case 3: actual = "kill some goblins";
		    reward1 = reward1 + 1;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in killing the goblin, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly join the goblins, you don't get a reward");
		    }
	    break;
	    case 4: actual = "deliver a package";
		    reward1 = reward1 + 1;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in delivering the package, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly burn the package, you don't get a reward");
		    }
	    break;
	    case 5: actual = "slay a dragon";
		    reward1 = reward1 + 2;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in slaying the dragon, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly slay a lizard, you don't get a reward");
		    }
	    break;
	    case 6: actual = "go on a crusade";
		    reward1 = reward1 + 1;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in killing the infidels, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly convert, you don't get a reward");
		    }
	    break;
	    case 7: actual = "rescue some prisoners";
		    reward1 = reward1 + 1;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in saving the prisoners, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly burn the prison to the ground, you don't get a reward");
		    }
	    break;
	    case 8: actual = "escort a lost child";
		    reward1 = reward1;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in escorting the child to its mother, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly lose the child in the woods, oh well, you don't get a reward");
		    }
	    break;
	    case 9: actual = "shut down a brothel";
		    reward1 = reward1 - 1;
		    c.println("You meet " + giver + " who tells you to " + actual + ".");
		    waitz();
		    if(success == 1){
			c.println("You succeed in shutting down the brothel, and are rewarded " + reward1*50 + " gold.");
			Money.gold = Money.gold + reward1*50;
		    }else{
			c.println("You accidentaly become a prostitute, you don't get a reward");
		    }
	    break;
	}
	enter();
	return;
    }
    public void shop(){
	if(Money.gold >= 500 && shop == 0){
	    shop = 1;
	}
	if(Money.gold >= 1000 && shop == 1){
	    shop = 2;
	}
	if(Money.gold >= 2500 && shop == 2){
	    shop = 3;
	}
	while(true){
	    c.clear();
	    c.println("You enter the shop.\nWhat do you want to purchase?\nYou have " + Money.gold + " gold available.\n");
	    if(shop >= 0 && wosw == 0){
		c.println("1 - Wooden sword - 100g");
	    }
	    if(shop >= 0 && lear == 0){
		c.println("2 - Leather armour - 100g");
	    } 
	    if(shop >= 1 && irsw == 0){
		c.println("3 - Iron sword - 500g"); 
	    }
	    if(shop >= 1 && irar == 0){
		c.println("4 - Iron armour - 500g");
	    } 
	    if(shop >= 2 && stsw == 0){
		c.println("5 - Steel sword - 1000g"); 
	    }
	    if(shop >= 2 && star == 0){
		c.println("6 - Steel armor - 1000g"); 
	    }
	    if(shop >= 3 && disw == 0){
		c.println("7 - Diamond sword - 2500g"); 
	    }
	    if(shop >= 3 && diar == 0){
		c.println("8 - Diamond armor - 2500g");
	    }
	    c.println("0 - Quit"); 
	    c.println("\nMore items will appear as you get more money."); 
	    int choice3 = c.readInt();
	    if(choice3 <= (quest+1)*2){
		switch (choice3){
		    case 1: if(Money.gold >= 100){
			    c.println("You purchase the wooden sword for 100 gold");
			    Money.gold = Money.gold - 100;
			    sword++;
			    wosw++;
			    String wosw2 = "Wooden Sword";
			    inv.add(wosw2);
			    }else{
			    c.println("You don't have enough money.");
			    }
			break;
		    case 2: if(Money.gold >= 100){
			    c.println("You purchase the leather armour for 100 gold");
			    Money.gold = Money.gold - 100;
			    maxhp = maxhp + 50;
			    lear++;
			    String lear2 = "Leather Armour";
			    inv.add(lear2);  
			    }else{
			    c.println("You don't have enough money.");
			    }
			break;
		    case 3: if(Money.gold >= 500){
			    c.println("You purchase the iron sword for 500 gold");
			    Money.gold = Money.gold - 500;
			    sword = sword + 3;
			    irsw++;
			    String irsw2 = "Iron Sword";
			    inv.add(irsw2); 
			    }else{
			    c.println("You don't have enough money.");
			    }
			break;
		    case 4: if(Money.gold >= 500){
			    c.println("You purchase the iron armour for 500 gold");
			    Money.gold = Money.gold - 500;
			    maxhp = maxhp + 100;
			    irar++;
			    String irar2 = "Iron Armour";
			    inv.add(irar2); 
			    }else{
			    c.println("You don't have enough money.");
			    }
			break;
		    case 5: if(Money.gold >= 1000){
			    c.println("You purchase the steel sword for 1000 gold");
			    Money.gold = Money.gold - 1000;
			    sword = sword + 5;
			    stsw++;
			    String stsw2 = "Steel Sword";
			    inv.add(stsw2); 
			    }else{
			    c.println("You don't have enough money.");
			    }
			break;
		    case 6: if(Money.gold >= 1000){
			    c.println("You purchase the steel armour for 1000 gold");
			    Money.gold = Money.gold - 1000;
			    maxhp = maxhp + 150;
			    star++;
			    String star2 = "Steel Armour";
			    inv.add(star2); 
			    }else{
			    c.println("You don't have enough money.");
			    }
			break;
		    case 7: if(Money.gold >= 2500){
			    c.println("You purchase the diamond sword for 2500 gold");
			    Money.gold = Money.gold - 2500;
			    sword = sword + 10;
			    disw++;
			    String disw2 = "Diamond Sword";
			    inv.add(disw2); 
			    }else{
			    c.println("You don't have enough money.");
			    }
			break;
		    case 8: if(Money.gold >= 2500){
			    c.println("You purchase the diamond armour for 2500 gold");
			    Money.gold = Money.gold - 2500;
			    maxhp = maxhp + 250;
			    diar++;
			    String diar2 = "Diamond Armour";
			    inv.add(diar2); 
			    }else{
			    c.println("You don't have enough money.");
			    }
			break;
		    case 9: 
			break;
		}
		break;
	    }else{
		continue;
	    }            
	}
	enter();
	return; 
    }
    public void waitz(){
	c.println("You attempt to do the quest.");
	for(int f = 0; f < 100; f = f+1) {
	    c.setTextColor (Color.yellow);
	    c.setTextBackgroundColor (Color.BLACK);
	    try {
		Thread.sleep(39);
	    } catch (InterruptedException e) {
	    }
	    c.setCursor(3,f); 
	    c.println("|");
	}
	c.setTextColor (Color.BLACK);
	c.setTextBackgroundColor (Color.WHITE);
	return;  
    }
    public void kill(){
	while(true){
	    c.clear();
	    c.println("Where do you want to go?(enter the number)"); 
	    c.println("1 - The Peaceful Forest"); 
	    if(quest >= 1){
		c.println("2 - The Goblin Cave"); 
		if(quest >= 2){
		    c.println("3 - The Dark Cave"); 
		    if(quest >= 3){
			c.println("4 - Lair of the Sorceress"); 
		    }
		}
	    }
	    int choice2 = c.readInt();
	    int monran = (int)(Math.random() * 3 + 1);
	    int rewarded = (int)(Math.random() * 2 + 1);
	    hp = maxhp;
	    if(choice2 <= quest+1){
		switch (choice2) 
		{
		    case 1: c.println("You enter The Peaceful Forest. It is very peaceful");
			    for(int o = 0; o < monran; o++){
				fight("a Giant Tree.", (15 + (int)(Math.random() * (35 - 15 + 1))), 1, 40, "It is a big scary tree.");
				if(dead == 1){
				    break;
				}
			    }
			    if(dead == 1){
				    break;
			    }
			    fight("a Unicorn.", (35 + (int)(Math.random() * (55 - 35 + 1))), 1, 100, "It has a very long horn.");
			    if(dead == 1){
				    break;
			    }
			    if(quest == 0){
				quest = 1;
			    }
			    if(rewarded == 2 && horn == 0){
				c.println("You find some unicorn horn dust, which you run on your sword to increase damage");
				sword = sword + 2;
				horn = 1;
				String horn1 = "Unicorn Horn Dust";
				inv.add(horn1);
			    }
		    break;
		    case 2: c.println("You enter The Goblin Cave. It has goblins in it");
			    for(int o = 0; o < monran; o++){
				fight("a Goblin Soldier.", (30 + (int)(Math.random() * (50 - 30 + 1))), 2, 60, "It wields a dangerous looking sword");
				if(dead == 1){
				    break;
				}
			    }
			    if(dead == 1){
				    break;
			    }
			    fight("a Goblin General", (75 + (int)(Math.random() * (75 - 50 + 1))), 3, 200, "It wears a very chestplate");
			    if(dead == 1){
				    break;
			    }
			    if(rewarded == 2 && chest == 0){
				c.println("You take the Goblin Generals chestplate, increasing your health");
				maxhp = maxhp + 100;
				chest = 1;
				String chest1 = "Goblin Chestplate";
				inv.add(chest1);
			    }
			    if(quest == 1){
				quest = 2;
			    }
		    break; 
		    case 3: c.println("You enter The Dark Cave. It seems very ominous");
			    for(int o = 0; o < monran; o++){
				fight("a Ghost.", (50 + (int)(Math.random() * (100 - 50 + 1))), 3, 150, "You can see through it!");
				if(dead == 1){
				    break;
				}
			    }
			    if(dead == 1){
				    break;
			    }
			    fight("a Giant Spooky Skeleton.", (75 + (int)(Math.random() * (150 - 75 + 1))), 4, 350, "It has lots of bones.");
			    if(dead == 1){
				    break;
			    }
			    if(rewarded == 2 && skull == 0){
				c.println("You take the skeletons head, and wear it as a helmet!");
				maxhp = maxhp + 200;
				skull = 1;
				String skull1 = "Giant Skull Helmet";
				inv.add(skull1);
			    }
			    if(quest == 2){
				quest = 3;
			    }
		    break;
		    case 4: c.println("You enter the Sorceress' Lair. It seems very magical");
			    for(int o = 0; o < monran; o++){
				fight("a Wizard.", (75 + (int)(Math.random() * (150 - 75 + 1))), 4, 350, "He has a nice looking beard");
				if(dead == 1){
				    break;
				}
			    }
			    if(dead == 1){
				    break;
			    }
			    fight("an Evil Sorceress", (400 + (int)(Math.random() * (500 - 400 + 1))), 8, 1000, "She has a very nice rod.");
			    if(dead == 1){
				    break;
			    }
			    c.println("The sorceress turns to dust");
			    if(rewarded == 2 && dust == 0){
				c.println("You take the magical dust, which you run on your sword to increase damage!");
				sword = sword + 5;
				dust = 1;
				String dust1 = "Magical Sorceress Dust";
				inv.add(dust1);
			    }
			    c.println("You defeat the final boss! Good job!\n"); 
			    c.println("_________        _______    _______ _       ______  "); 
			    c.println("\\__   __/\\     /(  ____ \\  (  ____ ( (    /(  __  \\ "); 
			    c.println("   ) (  | )   ( | (    \\/  | (    \\/  \\  ( | (  \\  )"); 
			    c.println("   | |  | (___) | (__      | (__   |   \\ | | |   ) |"); 
			    c.println("   | |  |  ___  |  __)     |  __)  | (\\ \\) | |   | |"); 
			    c.println("   | |  | (   ) | (        | (     | | \\   | |   ) |"); 
			    c.println("   | |  | )   ( | (____/\\  | (____/\\ )  \\  | (__/  )"); 
			    c.println("   )_(  |/     \\(_______/  (_______//    )_|______/"); 
			    c.println(""); 
		    break;
		}
		break;
	    }else{
		continue;
	    }
	}
	enter();  
	return;  
    }
    public void inventory(){
	if(inv == null || inv.size() == 0) {
	    c.println("Your inventory is empty!");
	    enter();
	}else{
	    for(int i=0; i<inv.size(); i++){
		c.println(i+1 + ". " + inv.get(i));
	    }
	    enter();
	}
	return;
    }
    public void update(){
	c.clear();
	c.println("You currently have: " + Money.gold + " gold");
	return;
    } 
    
    public void stats(){
	c.clear();
	c.println("Your hp is: " + maxhp +"");
	c.println("Your damage is: " + sword +"");
	c.println("Your money is: " + Money.gold + " gold");
	enter();
	return;
    } 
    
    public void enter(){
	c.println("\nPress ENTER twice to proceed.\n");
	c.readLine();
	return;
    } 
    
    public void fight(String monname, int monhp, int mondmg, int loot, String desc){
	c.println("You encounter " + monname);
	enter();
	do {
	    c.clear();
	    c.println("Your HP: " + hp + "\nYour damage: " + sword + "\n\"It's you.\"\n\n" + monname + "\nIt's HP: " + monhp + "\n\""+ desc + "\"\n");
	    try {
		sleep(100);
	    } catch (InterruptedException e) {
	    }
	    hp = hp - mondmg;
	    monhp = monhp - sword;
	}while(hp > -1 && monhp > -1);
	if(hp <= 0){
	    c.println("You die, but somehow wake up back in town");
	    Money.qcool = 30;
	    dead = 1;
	}else{
	    c.println("You manage to defeat " + monname + " You are rewarded " + loot + " gold!");
	    Money.gold = Money.gold + loot;
	    dead = 0;
	}
	return;
    } 
    
}

class ThreadTest2 extends Thread {
    Console c;
    public void setConsole(Console con) {
	c = con;
    }
    public void run(){
	do
	{
	    Money.gold = Money.gold + 1*Money.rate;
	    Money.cooldown = Money.cooldown - 1;
	    Money.qcool = Money.qcool - 1;
	    try {
		sleep(1000);
	    } catch (InterruptedException e) {
	    }
	}
	while (true); 
    }
}

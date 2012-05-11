package unq.videojuego.scenes;

import java.util.ArrayList;
import java.util.List;

import unq.videojuego.commands.Command;
import unq.videojuego.components.menus.BattleActionShowable;
import unq.videojuego.components.menus.BattleItemShowable;
import unq.videojuego.components.menus.BattleSkillShowable;
import unq.videojuego.components.menus.Showable;
import unq.videojuego.components.menus.Window;

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.items.Consumable;
import com.uqbar.videojuego.skills.Skill;

public class MenuScene extends VideojuegoScene {
	
	public MenuScene(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
		List<Showable> showables1 = new ArrayList<Showable>();
		List<Showable> showables2 = new ArrayList<Showable>();
		List<Showable> showables3 = new ArrayList<Showable>();
		
		
		showables1.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables1.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables1.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables1.add(new BattleItemShowable(new Consumable("HP Potion", 99, 1000)));
		Window win1 = new Window(0, 0, ImageHandler.INSTANCE.getSprite("LongBlueWindow"), showables1);
		
		
		
		showables2.add(new BattleSkillShowable(new Skill("Demon Fang", 20)));
		showables2.add(new BattleSkillShowable(new Skill("Tiger Blade", 40)));
		showables2.add(new BattleSkillShowable(new Skill("Sword Rain", 60)));
		showables2.add(new BattleSkillShowable(new Skill("Indignation", 150)));
		Window win2 = new Window(0, 250, ImageHandler.INSTANCE.getSprite("LongBlueWindow"), showables2);
		

		showables3.add(new BattleActionShowable(new Command("Action")));
		showables3.add(new BattleActionShowable(new Command("Move")));
		showables3.add(new BattleActionShowable(new Command("Wait")));
		showables3.add(new BattleActionShowable(new Command("Run")));
		Window win3 = new Window(0, 500, ImageHandler.INSTANCE.getSprite("BlueWindow"), showables3);
		this.addComponent(win1);
		this.addComponent(win2);
		this.addComponent(win3);
		
	}
}

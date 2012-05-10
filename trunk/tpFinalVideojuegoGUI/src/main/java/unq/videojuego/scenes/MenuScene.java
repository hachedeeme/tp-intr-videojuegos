package unq.videojuego.scenes;

import java.util.ArrayList;
import java.util.List;

import unq.videojuego.commands.Command;
import unq.videojuego.components.menus.BattleActionShowable;
import unq.videojuego.components.menus.BattleSkillShowable;
import unq.videojuego.components.menus.Window;
import unq.videojuego.interfaces.Showable;

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.skills.Skill;

public class MenuScene extends VideojuegoScene {
	
	public MenuScene(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
		List<Showable> showables = new ArrayList<Showable>();
		/*showables.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables.add(new BattleItemShowable(new Consumable("HP Potion", 99, 1000)));
		Window win = new Window(0, 0, ImageHandler.INSTANCE.getSprite("LongBlueWindow"), showables);*/
		/*showables.add(new BattleSkillShowable(new Skill("Demon Fang", 20)));
		showables.add(new BattleSkillShowable(new Skill("Tiger Blade", 40)));
		showables.add(new BattleSkillShowable(new Skill("Sword Rain", 60)));
		showables.add(new BattleSkillShowable(new Skill("Indignation", 150)));
		Window win = new Window(0, 0, ImageHandler.INSTANCE.getSprite("LongBlueWindow"), showables);*/
		showables.add(new BattleActionShowable(new Command("Action")));
		showables.add(new BattleActionShowable(new Command("Move")));
		showables.add(new BattleActionShowable(new Command("Wait")));
		showables.add(new BattleActionShowable(new Command("Run")));
		Window win = new Window(0, 0, ImageHandler.INSTANCE.getSprite("BlueWindow"), showables);
		this.addComponent(win);
		
	}
}

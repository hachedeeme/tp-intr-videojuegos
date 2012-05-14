package unq.videojuego;

import com.uqbar.videojuego.characters.CharEquipment;
import com.uqbar.videojuego.characters.Character;
import com.uqbar.videojuego.characters.Enemy;
import com.uqbar.videojuego.characters.StatsContainer;
import com.uqbar.videojuego.items.EquipType;
import com.uqbar.videojuego.items.Equipment;

public class Test {
	
	public static void main(String[] args) {
		CharEquipment equip = new CharEquipment();
		equip.putEquipment(new Equipment("Sword", EquipType.ONEHANDED, new StatsContainer(0, 0, 2, 4, 1, 0, 0), 1, 100));
		equip.putEquipment(new Equipment("Sword", EquipType.ONEHANDED, new StatsContainer(0, 0, 2, 4, 1, 0, 0), 1, 100));
		//equip.putEquipment(new Equipment("Axe", EquipType.TWOHANDED, new StatsContainer(0, 0, 0, 6, 2, 0, 0), 1, 200));
		System.out.println(equip);
		Character hache = new Character("Hache", new StatsContainer(250, 60, 30, 20, 16, 10, 8),equip);
		Enemy enemy = new Enemy("MoustroNoTanPT", 200, 100, 27, 30, 26, 19, 20);
		for (int i = 0; i < 5; i++) {
			hache.attack(enemy);
			System.out.println(hache.getStats());
			System.out.println(enemy.getStats());
			enemy.attack(hache);
			System.out.println(hache.getStats());
			System.out.println(enemy.getStats());
		}
		System.out.println();
		
	}

}

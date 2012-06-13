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
		equip.putEquipment(new Equipment("Sword", EquipType.ONEHANDED, new StatsContainer(0, 0, 0, 2, 4, 1, 0, 0),1, 1, 100));
		equip.putEquipment(new Equipment("Sword", EquipType.ONEHANDED, new StatsContainer(0, 0, 0, 2, 4, 1, 0, 0),1, 1, 100));
		//equip.putEquipment(new Equipment("Axe", EquipType.TWOHANDED, new StatsContainer(0, 0, 0, 6, 2, 0, 0), 1, 200));
		System.out.println(equip);
		Character hache = new Character("Hache", new StatsContainer(250, 60, 0, 60, 20, 16, 10, 8));
		hache.equip(new Equipment("Sword", EquipType.ONEHANDED, new StatsContainer(0, 0, 0, 2, 4, 1, 0, 0),1, 1, 100));
		hache.equip(new Equipment("Sword", EquipType.ONEHANDED, new StatsContainer(0, 0, 0, 2, 4, 1, 0, 0),1, 1, 100));
		Enemy enemy = new Enemy("MoustroNoTanPT", 200, 100, 0, 27, 30, 26, 19, 20);
		hache.attack(enemy);
		System.out.println(hache.getStats());
		System.out.println(enemy.getStats());
		System.out.println(hache.getMovility());
		hache.equip(new Equipment("Iron Axe", EquipType.TWOHANDED, new StatsContainer(0, 0, 0, 0, 100, 50, 0, 0), 1, 1, 200));
		/*for (int i = 0; i < 5; i++) {
			enemy.attack(hache);
			System.out.println(hache.getStats());
			System.out.println(enemy.getStats());
		}*/
		System.out.println(hache.getEquipment());
		System.out.println(hache.getStats());
		
	}

}

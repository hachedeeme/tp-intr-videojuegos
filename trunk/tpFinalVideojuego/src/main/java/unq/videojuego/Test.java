package unq.videojuego;

import com.uqbar.videojuego.characters.CharEquipment;
import com.uqbar.videojuego.characters.Character;
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
		Character c = new Character("Hache", new StatsContainer(100, 60, 30, 20, 16, 10, 8),equip);
		System.out.println(c.getBasicStats());
		System.out.println(c.getStats());
		
	}

}

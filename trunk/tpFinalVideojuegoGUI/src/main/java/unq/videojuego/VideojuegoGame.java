package unq.videojuego;

import java.awt.Dimension;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.scenes.MainMenuScene;
import unq.videojuego.utils.UnitHandler;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.sound.SoundHandler;
import com.uqbar.videojuego.items.ItemHandler;


public class VideojuegoGame extends Game {
    private int tileSize;
    private int screenWidth;
    private int screenHeight;

    @Override
    public Dimension getDisplaySize() {
        return new Dimension(this.screenWidth, this.screenHeight);
    }

    @Override
    public String getTitle() {
        return "Videojuego";
    }
    
	@Override
	protected void initializeResources() {
		ImageHandler imageH = ImageHandler.INSTANCE;
		imageH.addSprites("BattleMap1", "IsometricLines", "SelectedTile", "BattleBackground", "MainMenuBackground",
				
						  "Tree",
				
						  "pointer", "arrow", "BlueWindow", "BigBlueWindow", "LongBlueWindow", "UnitStatsBack", "HpBar", "MpBar", "HpBarBack",
						  
						  "HP Potion", "MP Potion",  
						  
						  "Dagger",
						  
						  "AngelAvatar", "AshAvatar", "SlimeAvatar",
						  
						  "GameOver", "YouWin");
		
		// Tile Selection 
		imageH.addAnimation(0.15, 1, 900, 50, 100, 50, "TileArea");
		imageH.addAnimation(0.07, 1, 1200, 150, 100, 150, "SelectionCone");
		
		// Attacks
		imageH.addLimitedAnimation(0.1, 1, 324, 100, 81, 100, "attacks/BasicAttack");
		imageH.addLimitedAnimation(0.1, 1, 126, 128, 126, 64, "attacks/Ki");
		imageH.addLimitedAnimation(0.1, 1.5, 560, 104, 80, 104, "attacks/FirePilar");
	
		// Messages
		imageH.addAnimation(0.5, 1, 680, 200, 340, 200, "GoToMainMenu");
		imageH.addAnimation(0.5, 1, 680, 200, 340, 200, "GoToBattle");
		
		SoundHandler soundH = SoundHandler.INSTANCE;
		soundH.addSounds("MainMenuTheme", "BattleTheme", "VictoryTheme", "GameOverTheme", 
						 "Accept", "Cancel", "Select", "StartGame", "Attack", "StrongAttack");
		
		// BattleUnits
		UnitHandler unitH = UnitHandler.INSTANCE;
		ItemHandler itemH = ItemHandler.INSTANCE;
		
		//		 									 Name    Dir         HP   MP   Spd Str Stm Int Wis
		BattleCharacter angel = new BattleCharacter("Angel", UnitDir.Up, 223, 160, 30, 38, 27, 60, 30);
		BattleCharacter ash   = new BattleCharacter("Ash",   UnitDir.Up, 255, 100, 45, 50, 33, 16, 25);
		
		//									 Name     Dir         AttRang mov HP  MP   Spd  Str  Stm  Int Wis
		BattleEnemy slime = new BattleEnemy("Slime", UnitDir.Down,    1,   3, 222,100, 50,  90,  70,  90, 90); 
		
		unitH.addUnits(angel, ash, slime);
		
		/* ITEM EQUIPMENTS LIST
		 * 
		 * WEAPONS: ONE HAND: Dagger, Shortsword, Rod. 
		 * 			TWO HAND: Iron Axe, White Staff.
		 * HEAD: Iron Helm, Wizard's Hat, Tiara.
		 * BODY: Iron Armor, Ninja Gear, White Robe.
		 * HANDS: Armguards, Gauntlets.
		 * BOOTS: Battle Boots, Sprint Shoes, Ninja Tabi.
		 * ACCESORIES: Magic Ring, Amulet.
		 */
		
		angel.equip(itemH.getEquipment("White Staff"),
					itemH.getEquipment("Tiara"),
					itemH.getEquipment("White Robe"),
					itemH.getEquipment("Armguards"),
					itemH.getEquipment("Battle Boots"),
					itemH.getEquipment("Magic Ring")
					);
	
		ash.equip(itemH.getEquipment("Shortsword"),
				  itemH.getEquipment("Dagger"),
				  itemH.getEquipment("Iron Helm"),
				  itemH.getEquipment("Ninja Gear"),
				  itemH.getEquipment("Gauntlets"),
				  itemH.getEquipment("Ninja Tabi"),
				  itemH.getEquipment("Amulet")
				  );
		
		System.out.println(angel);
		System.out.println(ash);
	}

	@Override
	protected void setUpScenes() {
		this.tileSize = 100;
		int tileWidth = 9;
		int tileHeight = 7;
		this.screenWidth = this.tileSize*tileWidth;
		this.screenHeight = this.tileSize*tileHeight;
		
		this.setCurrentScene(new MainMenuScene(this.screenWidth, this.screenHeight, this.tileSize));
		SoundHandler.INSTANCE.playMusic("MainMenuTheme");
	}
	
	public int getScreenWidth() {
		return this.screenWidth;
	}
	
	public int getScreenHeight() {
		return this.screenHeight;
	}
	
	public int getTileSize() {
		return this.tileSize;
	}


    public static void main(String[] args) {
        new DesktopGameLauncher(new VideojuegoGame()).launch();
    }
}
package unq.videojuego.scenes;

import java.util.ArrayList;
import java.util.List;

import unq.videojuego.commands.ActionAction;
import unq.videojuego.commands.AttackAction;
import unq.videojuego.commands.MoveAction;
import unq.videojuego.commands.PassAction;
import unq.videojuego.components.Background;
import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleComponent;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.components.IsometricLines;
import unq.videojuego.components.Obstacle;
import unq.videojuego.components.menus.BattleActionShowable;
import unq.videojuego.components.menus.Showable;
import unq.videojuego.components.menus.UnitStats;
import unq.videojuego.components.menus.Window;

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.appearances.Sprite;

public class BattleScene extends VideojuegoScene {
	private Background background;
	private IsometricLines isometricLines;
	private BattleMap map;
	private int width;
	private int height;
	private int tileSize;
	
	private Window battleCommandsWindow;
	private Window battleActionsWindow;
	//private Window skillsWindow;
	//private Window itemsWindow;
	
	private UnitStats curUnitStats;
	
	public BattleScene(BattleMap map, int tileSize, int width, int height) {
		super(tileSize * width, tileSize * height);
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		this.isometricLines = new IsometricLines(ImageHandler.INSTANCE.getSprite("IsometricLines"));
		this.addComponent(this.isometricLines);
		this.createWindows();
		this.setMap(map);
	}
	
	private void createWindows() {
		Sprite blueWindow = ImageHandler.INSTANCE.getSprite("BlueWindow");
		List<Showable> battleCommands = new ArrayList<Showable>();
		battleCommands.add(new BattleActionShowable(new ActionAction()));
		battleCommands.add(new BattleActionShowable(new MoveAction()));
		battleCommands.add(new BattleActionShowable(new PassAction()));
		this.battleCommandsWindow = new Window(0, this.getScreenHeight() - blueWindow.getHeight(), blueWindow, battleCommands);
		
		List<Showable> battleActions = new ArrayList<Showable>();
		battleActions.add(new BattleActionShowable(new AttackAction()));
		this.battleActionsWindow = new Window(this.battleCommandsWindow.getWidth(), this.getScreenHeight() - blueWindow.getHeight(), blueWindow, battleActions);
		
		this.addActiveWindow(this.battleCommandsWindow);
	}
	
	public void removeActiveWindow(){
		this.removeComponent(this.getActiveWindow());
		this.setActiveWindow(null);
	}

	public void addActiveWindow(Window window){
		this.setActiveWindow(window);
		this.addComponent(window);
	}
	
	public void updateAndShowUnitStats() {
		if (this.curUnitStats == null){
			this.curUnitStats = new UnitStats();
		}
		this.curUnitStats.updateBUnit(this.getMap().getSelectedUnit());
		this.curUnitStats.addToScene(this);
	}
	
	public void removeCurUnitStats(){
		if (this.curUnitStats != null){
			this.curUnitStats.removeFromScene(this);
		}
	}

	public boolean addBattleUnit(BattleUnit comp, int mapX, int mapY){
		boolean added = this.addBattleComponent(comp);
		if (added){
			comp.setMapX(mapX);
			comp.setMapY(mapY);
			this.map.setMapComponentCoords(comp, comp.getMapX(), comp.getMapY());
		}
		return added;
	}
	
	public void addBattleEnemy(BattleEnemy enemy, int mapX, int mapY){
		boolean added = this.addBattleUnit(enemy, mapX, mapY);
		if (added){
			this.map.addEnemy(enemy);
		}
	}
	
	public void addBattleCharacter(BattleCharacter character, int mapX, int mapY){
		boolean added = this.addBattleUnit(character, mapX, mapY);
		if (added){
			this.map.addCharacter(character);
		}
	}
	
	private boolean addBattleComponent(BattleComponent comp) {
		return this.map.addBattleComponent(comp);
	}
	
	public void addObstacle(Obstacle comp){
		boolean added = this.addBattleComponent(comp);
		if (added){
			this.map.setMapComponentCoords(comp, comp.getMapX(), comp.getMapY());
		}
	}

	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public BattleMap getMap() {
		return map;
	}

	public void setMap(BattleMap map) {
		this.map = map;
		this.map.setX(this.width * this.tileSize / 2 - this.map.getWidth() * this.tileSize / 2);
		this.map.setY((this.height - Math.ceil(((float)this.map.getHeight())/2)) * this.tileSize / 2);
		if (this.map.getY() < this.tileSize){
			this.map.setY(this.tileSize);
		}
		if (this.map.getX() < 0){
			this.map.setX(0);
		}
		this.addComponent(this.map);
	}

	public Window getBattleCommandsWindow() {
		return battleCommandsWindow;
	}

	public void setBattleCommandsWindow(Window battleCommandsWindow) {
		this.battleCommandsWindow = battleCommandsWindow;
	}

	public Window getBattleActionsWindow() {
		return battleActionsWindow;
	}

	public void setBattleActionsWindow(Window battleActionsWindow) {
		this.battleActionsWindow = battleActionsWindow;
	}
	
}

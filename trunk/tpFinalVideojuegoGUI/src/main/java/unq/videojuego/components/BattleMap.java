package unq.videojuego.components;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.Sleeping;
import unq.videojuego.states.State;
import unq.videojuego.states.map.MapSelectingUnit;
import unq.videojuego.utils.PathFinder;
import unq.videojuego.utils.TTuple;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.videojuego.characters.Enemy;

public class BattleMap extends GameComponent<BattleScene> {
	private PathFinder pathFinder = PathFinder.INSTANCE;
	private Map<Integer, Map<Integer, BattleComponent>> grid;
	
	private int width;
	private int height;
	private int tileSize;

	private State state = new MapSelectingUnit();
	
	private BattleUnit selectedUnit;
	private List<BattleUnit> units = new ArrayList<BattleUnit>();
	private List<BattleCharacter> characters = new ArrayList<BattleCharacter>();
	private List<BattleEnemy> enemies = new ArrayList<BattleEnemy>();
	
	private List<TileArea> markedTiles = new ArrayList<TileArea>();
	private List<TTuple> areaTuples = new ArrayList<TTuple>();
	private SelectedTile selectedTile = new SelectedTile(this, 0, 0);
	
	public BattleMap(Sprite image, int tileSize, int width, int height) {
		this.setZ(-10);
		this.tileSize = tileSize;
		this.width = width;
		this.height = height;
		this.grid = new HashMap<Integer, Map<Integer,BattleComponent>>();
		
		for (int i = 0; i < width; i++) {
			this.grid.put(i, new HashMap<Integer, BattleComponent>());
		}
		
		this.setAppearance(image);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.state.update(this, deltaState);
	}
	
	public boolean addBattleComponent(BattleComponent comp){
		int x = comp.getMapX();
		int y = comp.getMapY();
		boolean added = false;
		if (this.grid.containsKey(x)){
			if (! this.grid.get(x).containsKey(y)){
				this.getScene().addComponent(comp);
				added = true;
			}
		}
		return added;
	}
	
	public void setGridComponent(BattleComponent comp, int x, int y){
		int oldX = comp.getMapX();
		int oldY = comp.getMapY();
		this.grid.get(oldX).remove(oldY);
		this.grid.get(x).put(y, comp);
	}
	
	public void setMapComponentCoords(BattleComponent comp, int x, int y){
		this.setBattleComponentCoordsInMap(comp, x, y);
		comp.updateZ();
	}
	
	public void setBattleComponentCoordsInMap(BattleComponent comp, int x, int y) {
		this.setGridComponent(comp, x, y);
		
		this.setRealCoords(comp, x, y);
		
		comp.setMapX(x);
		comp.setMapY(y);
	}
	
	public void setBattleComponentCoords(BattleComponent comp, int x, int y) {
		this.setRealCoords(comp, x, y);
		comp.setMapX(x);
		comp.setMapY(y);
	}

	public void setRealCoords(BattleComponent comp, int x, int y) {
		comp.setX(this.getRealXCoord(comp, x, y));
		comp.setY(this.getRealYCoord(comp, x, y));
	}
	
	public double getRealXCoord(BattleComponent comp, int x, int y) {
		double xStart = this.getMapXStart() - comp.getAppearance().getWidth()/2;
		double xPos = (x * this.tileSize/2) - (y * this.tileSize/2);
		return xStart + xPos;
	}
	
	public double getRealYCoord(BattleComponent comp, int x, int y) {
		double yStart = this.getMapYStart() + this.tileSize/2 - comp.getAppearance().getHeight();
		double yPos = (y * this.tileSize/4) + (x * this.tileSize/4);
		return yStart + yPos;
	}

	private double getMapXStart() {
		return this.getScene().getWidth() * this.tileSize/2;
	}
	
	private double getMapYStart() {
		return this.getY();
	}
	
	private List<TTuple> createMovingTileArea(){
		Point startPoint = new Point(this.selectedUnit.getMapX(), this.selectedUnit.getMapY());
		int range = this.selectedUnit.getMovility();
		return this.pathFinder.getAreaWithoutObs(grid, width, height, startPoint, range);
	}

	private List<TTuple> createAttackingTileArea(){
		Point startPoint = new Point(this.selectedUnit.getMapX(), this.selectedUnit.getMapY());
		int range = this.selectedUnit.getAttackRange();
		return this.pathFinder.getAreaWithObs(grid, width, height, startPoint, range);
	}
	
	public void removeArea(){
		this.getScene().removeComponents(this.markedTiles);
		this.markedTiles.clear();
		this.areaTuples.clear();
	}
	
	private void createSelectedUnitArea(){
		for (TTuple tuple : this.areaTuples){
			int x = tuple.getX(); 
			int y = tuple.getY();
			TileArea tileArea = new TileArea(x, y);
			this.setBattleComponentCoords(tileArea, x, y);
			this.markedTiles.add(tileArea);
		}
		this.getScene().addComponents(this.markedTiles);
	}
	
	public void createSelectedUnitMovableArea() {
		this.areaTuples = this.createMovingTileArea();
		this.createSelectedUnitArea();
	}
	
	public void createSelectedUnitAttackableArea() {
		this.areaTuples = this.createAttackingTileArea();
		this.createSelectedUnitArea();
	}
	
	public void addSelectedTileInSelectedUnit(){
		int x = this.selectedUnit.getMapX();
		int y = this.selectedUnit.getMapY();
		this.setSelectedTileCoords(x, y);
		this.getScene().addComponent(this.selectedTile);
		this.getScene().addComponent(this.selectedTile.getSelectionCone());
	}
	
	public void setSelectedTileCoords(int x, int y){
		this.setBattleComponentCoords(this.selectedTile, x, y);
		this.setBattleComponentCoords(this.selectedTile.getSelectionCone(), x, y);
	}
	
	public void removeSelectedTile(){
		this.getScene().removeComponent(this.selectedTile);
		this.getScene().removeComponent(this.selectedTile.getSelectionCone());
		this.selectedTile.setState(new Sleeping());
	}
	
	public void addUnit(BattleUnit unit){
		this.units.add(unit);
	}
	
	public void addCharacter(BattleCharacter character){
		this.characters.add(character);
		this.addUnit(character);
	}
	
	public void addEnemy(BattleEnemy enemy){
		this.enemies.add(enemy);
		this.addUnit(enemy);
	}
	
	public BattleEnemy getEnemy(TTuple tuple) {
		BattleEnemy wantedEnemy = null;
		for (BattleEnemy enemy : this.enemies){
			if (enemy.getMapX() == tuple.getX() && enemy.getMapY() == tuple.getY()){
				wantedEnemy = enemy;
				break;
			}
		}
		return wantedEnemy;
	}
	
	public BattleCharacter getCharacter(TTuple tuple) {
		BattleCharacter wantedCharacter = null;
		for (BattleCharacter character : this.characters){
			if (character.getMapX() == tuple.getX() && character.getMapY() == tuple.getY()){
				wantedCharacter = character;
				break;
			}
		}
		return wantedCharacter;
	}
	
	
	public void nextSelectedUnit(){
		this.selectedUnit = this.units.remove(0);
	}
	
	public boolean isOutOfMap(int x, int y){
		return x < 0 || x >= this.width || y < 0 || y >= this.height;
	}
	
	
	
	///////////////////
	///// GETTERS /////
	///////////////////
	
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

	public BattleUnit getSelectedUnit() {
		return selectedUnit;
	}

	public void setSelectedUnit(BattleUnit selectedUnit) {
		this.selectedUnit = selectedUnit;
	}

	public List<TileArea> getMarkedTiles() {
		return markedTiles;
	}

	public void setMarkedTiles(List<TileArea> markedTiles) {
		this.markedTiles = markedTiles;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<TTuple> getAreaTuples() {
		return areaTuples;
	}

	public void setAreaTuples(List<TTuple> areaTuples) {
		this.areaTuples = areaTuples;
	}

	public SelectedTile getSelectedTile() {
		return selectedTile;
	}

	public void setSelectedTile(SelectedTile selectedTile) {
		this.selectedTile = selectedTile;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}
	
}

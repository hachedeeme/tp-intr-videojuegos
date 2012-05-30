package unq.videojuego.states.character;

import java.util.ArrayList;
import java.util.List;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.State;
import unq.videojuego.states.map.MapSelectingUnit;
import unq.videojuego.utils.TTuple;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class CharWalking extends State {
	private List<TTuple> tuplesPath;
	
	private double xSpeed;
	private double ySpeed;
	private double newRealX;
	private double newRealY;
	private int newMapX;
	private int newMapY;
	private int tileSize;
	
	private boolean moving = false;

	public CharWalking(TTuple selectedTuple, List<TTuple> areaTuples, int tileSize) {
		super("Walking");
		this.tuplesPath = this.createPath(selectedTuple, areaTuples);
		this.tileSize = tileSize;
	}
	
	private void calculateSpeeds(double curX, double curY, double tileSize) {
		int xDir = (curX < this.newRealX) ? 2 : -2;
		int yDir = (curY < this.newRealY) ? 2 : -2;		

		this.xSpeed = tileSize/2 * xDir;
		this.ySpeed = tileSize/4 * yDir;
	}

	private void updateDir(BattleUnit bChar) {
		int curMapX = bChar.getMapX();
		int curMapY = bChar.getMapY();
		boolean changed = false;
		if (this.newMapX > curMapX && bChar.getDir() != UnitDir.Right){
			bChar.setDir(UnitDir.Right);
			changed = true;
		} else if (this.newMapX < curMapX && bChar.getDir() != UnitDir.Left){
			bChar.setDir(UnitDir.Left);
			changed = true;
		} else if (this.newMapY > curMapY && bChar.getDir() != UnitDir.Down){
			bChar.setDir(UnitDir.Down);
			changed = true;
		} else if (this.newMapY < curMapY && bChar.getDir() != UnitDir.Up){
			bChar.setDir(UnitDir.Up);
			changed = true;
		}
		if (changed){
			bChar.updateAppearance();
		}
	}

	private List<TTuple> createPath(TTuple selectedTuple, List<TTuple> areaTuples) {
		List<TTuple> path = new ArrayList<TTuple>();
		path.add(selectedTuple);
		TTuple curTuple = selectedTuple;
		TTuple curAdyacent = selectedTuple;
		
		for (int i = 0; i < selectedTuple.getCounter() - 1; i++) {
			for (TTuple tuple : new ArrayList<TTuple>(areaTuples)){
				if (curTuple.isAdyacent(tuple) && tuple.counterSmaller(curAdyacent)){
					curAdyacent = tuple;
				}
			}
			curTuple = curAdyacent;
			
			path.add(0, curTuple);
		}
		
		return path;
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleUnit bChar = (BattleUnit) comp;
		BattleMap map = bChar.getScene().getMap();
		double delta = deltaState.getDelta();
		if (! this.moving){
			if (this.tuplesPath.isEmpty()){
				BattleScene scene = bChar.getScene();
				bChar.setState(new CharWaiting());
				map.addUnit(bChar);
				map.setState(new MapSelectingUnit());
			} else {
				TTuple firstTuple = this.tuplesPath.remove(0);
				this.newMapX = firstTuple.getX();
				this.newMapY = firstTuple.getY();
				
				this.newRealX = bChar.getScene().getMap().getRealXCoord(bChar, this.newMapX, this.newMapY);
				this.newRealY = bChar.getScene().getMap().getRealYCoord(bChar, this.newMapX, this.newMapY);
				
				double curX = bChar.getX();
				double curY = bChar.getY();
				
				this.calculateSpeeds(curX, curY, this.tileSize);
				this.updateDir(bChar);
				this.moving = true;
			}
		} else if (this.notReachedTile(bChar)){
				bChar.move(this.xSpeed * delta, this.ySpeed * delta);
		} else {
			map.setMapComponentCoords(bChar, this.newMapX, this.newMapY);
			this.moving = false;
		}

	}
	
	private boolean notReachedTile(BattleUnit bChar){
		return 	this.xSpeed > 0 && bChar.getX() < this.newRealX ||
				this.xSpeed < 0 && bChar.getX() > this.newRealX &&
				this.ySpeed > 0 && bChar.getY() < this.newRealY ||
				this.ySpeed < 0 && bChar.getY() > this.newRealY;
	}

}
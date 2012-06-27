package unq.videojuego.states.map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.Sleeping;
import unq.videojuego.states.State;
import unq.videojuego.states.units.UnitAttacking;
import unq.videojuego.states.units.UnitSelected;
import unq.videojuego.states.units.UnitWaiting;
import unq.videojuego.states.units.UnitWalking;
import unq.videojuego.utils.PathFinder;
import unq.videojuego.utils.TTuple;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class MapSelectingUnit extends State {

	public MapSelectingUnit(){
		super("SelectingUnit");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp;
		BattleScene scene = map.getScene();
		map.nextSelectedUnit();
		map.getSelectedUnit().setState(new UnitSelected());
		map.updateHPBars();
		scene.removeCurUnitStats();
		scene.updateAndShowUnitStats();
		
		if (scene.turnJustStarted()){
			scene.removeActiveWindow();
			scene.createCommandsWindowAsActive();
		}
		
		if (map.curIsEnemy()){
			scene.removeComponent(scene.getBattleCommandsWindow());
			map.setState(new Sleeping());
			this.decideEnemyState(map, (BattleEnemy) map.getSelectedUnit());
		} else {
			map.addSelectedTileInSelectedUnit();
			map.setState(new MapWaitingForCommand());
			if (scene.getActiveWindow() == null){
				scene.addActiveWindow(scene.getBattleCommandsWindow());
			}
		}
	}

	private void decideEnemyState(BattleMap map, BattleEnemy enemy) {
		BattleScene scene = map.getScene();
		
		if (map.getEnemyTarget() == null){
			List<BattleCharacter> characters = map.getCharacters();
			int charIndex = new Random().nextInt(characters.size());
			map.setEnemyTarget(characters.get(charIndex));
		}
		
		BattleUnit targetChar = map.getEnemyTarget();
		
		int rangeDif = enemy.getDistance(targetChar);
		
		if (rangeDif > 0){ // Si no llega a atacarlo
			if (scene.isMoved()){ // Si ya se movió
				enemy.setState(new UnitWaiting());
				map.addUnit(enemy);
				map.setState(new MapSelectingUnit());
				map.setEnemyTarget(null);
				scene.resetCommands();
			} else { // El Enemy se mueve
				enemy.setState(new UnitWalking(this.getPathToCharAreas(map, enemy, targetChar), map.getTileSize()));
				map.setState(new Sleeping());
			}
		} else { // El Enemy ataca
			scene.setAttacked(true);
			scene.setMoved(true);
			map.setEnemyTarget(null);
			map.getSelectedUnit().setFacingDir(targetChar);
			map.getSelectedUnit().setState(new UnitAttacking(targetChar));
		}
	}

	private List<TTuple> getPathToCharAreas(BattleMap map, BattleEnemy enemy, BattleUnit targetChar) {
		List<TTuple> areaTuples = map.createFullTileArea(new TTuple(targetChar.getMapX(), targetChar.getMapY()));
		TTuple targetTuple = new TTuple(new Point(targetChar.getMapX(), targetChar.getMapY()));
		TTuple targetTupleWithCounter = targetTuple.getTupleFromCoords(areaTuples);
		
		List<TTuple> pathToTarget = PathFinder.INSTANCE.createPath(targetTupleWithCounter, areaTuples);
		pathToTarget.remove(pathToTarget.size()-1); // saco la tupla del objetivo
		int rangeDif = enemy.getDistance(targetChar);
		int steps = Math.min(rangeDif, enemy.getMovility());
		List<TTuple> realPath = new ArrayList<TTuple>();
		
		for (int i = 0; i < steps; i++) {
			//if (pathToTarget.isEmpty()){
			//	break;
			//} else {
				realPath.add(pathToTarget.remove(0));
			//}
		}
		
		return realPath;
	}

}

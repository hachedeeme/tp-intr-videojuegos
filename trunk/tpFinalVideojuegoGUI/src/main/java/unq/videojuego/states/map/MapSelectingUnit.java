package unq.videojuego.states.map;

import java.util.List;
import java.util.Random;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.BattleMap;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.Sleeping;
import unq.videojuego.states.State;
import unq.videojuego.states.units.CharSelected;
import unq.videojuego.states.units.UnitAttacking;

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
		map.getSelectedUnit().setState(new CharSelected());
		map.updateHPBars();
		scene.removeCurUnitStats();
		scene.updateAndShowUnitStats();
		
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
		List<BattleCharacter> characters = map.getCharacters();
		int charIndex = new Random().nextInt(characters.size());
		BattleCharacter targetChar = characters.get(charIndex);
		
		int rangeDif = enemy.getDistance(targetChar);
		System.out.println(rangeDif);
		if (rangeDif > 0){
			// Mover Enemy
		} else {
			// Atacar al target
			BattleScene scene = map.getScene();
			scene.setAttacked(true);
			scene.setMoved(true);
			map.getSelectedUnit().setFacingDir(targetChar);
			map.getSelectedUnit().setState(new UnitAttacking(targetChar));
		}
		
	}

}

package unq.videojuego.states.character;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.states.State;
import unq.videojuego.states.map.MapSelectingUnit;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.LimitedAnimation;

public class CharAttacking extends State {

	public CharAttacking() {
		super("Attacking");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleUnit unit = (BattleUnit) comp;
		if (((LimitedAnimation) unit.getAppearance()).isAtEnd()){
			BattleMap map = unit.getScene().getMap();
			map.setState(new MapSelectingUnit());
			unit.setState(new CharWaiting());
			map.addUnit(unit);
		}
	}

}

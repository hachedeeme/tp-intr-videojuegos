package unq.videojuego.states.character;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.states.State;
import unq.videojuego.states.map.MapSelectingUnit;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.LimitedAnimation;

public class CharTakingDamage extends State {

	private BattleUnit caster;

	public CharTakingDamage(BattleUnit caster) {
		super("TakingDamage");
		this.caster = caster;
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleUnit caster = (BattleUnit) comp;
		if (((LimitedAnimation) caster.getAppearance()).isAtEnd()){
			caster.setState(new CharWaiting());
			BattleMap map = caster.getScene().getMap();
			map.setState(new MapSelectingUnit());
			caster.setState(new CharWaiting());
			map.addUnit(this.caster);
		}
	}

	public BattleUnit getCaster() {
		return caster;
	}
}

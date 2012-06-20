package unq.videojuego.states.character;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.states.State;
import unq.videojuego.states.map.MapSelectingUnit;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.LimitedAnimation;

public class CharTakingDamage extends State {

	private BattleUnit caster;
	private UnitDir originDir;

	public CharTakingDamage(BattleUnit caster, UnitDir originDir) {
		super("TakingDamage");
		this.caster = caster;
		this.originDir = originDir;
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleUnit target = (BattleUnit) comp;
		if (((LimitedAnimation) target.getAppearance()).isAtEnd()){
			target.setDir(this.originDir);
			target.setState(new CharWaiting());
			BattleMap map = target.getScene().getMap();
			map.setState(new MapSelectingUnit());
			target.setState(new CharWaiting());
			map.addUnit(this.caster);
		}
	}
}

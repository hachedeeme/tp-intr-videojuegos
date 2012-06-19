package unq.videojuego.states.character;

import unq.videojuego.components.AttackComp;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.states.State;
import unq.videojuego.states.map.MapSelectingUnit;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.LimitedAnimation;

public class CharAttacking extends State {
	private BattleUnit target;
	
	public CharAttacking(BattleUnit target) {
		super("Attacking");
		this.target = target;
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleUnit caster = (BattleUnit) comp;
		if (((LimitedAnimation) caster.getAppearance()).isAtEnd()){
			caster.getUnit().attack(this.target.getUnit());
			BattleMap map = caster.getScene().getMap();
			map.setState(new MapSelectingUnit());
			caster.setState(new CharWaiting());
			map.addUnit(caster);
			caster.getScene().addAttack(new AttackComp(target.getMapX(), target.getMapY(), "BasicAttack"));
		}
	}

}

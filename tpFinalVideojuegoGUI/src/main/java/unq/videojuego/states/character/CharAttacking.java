package unq.videojuego.states.character;

import unq.videojuego.components.AttackComp;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.states.State;

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
		UnitDir originDir = this.target.getDir();
		if (((LimitedAnimation) caster.getAppearance()).isAtEnd()){
			caster.getUnit().attack(this.target.getUnit());
			this.target.setOpposedDir(caster.getDir());
			this.target.setState(new CharTakingDamage(caster, originDir));
			caster.setState(new CharWaiting());
			caster.getScene().addAttack(new AttackComp(target.getMapX(), target.getMapY(), "BasicAttack"));
		}
	}

}

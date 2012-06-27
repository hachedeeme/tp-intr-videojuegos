package unq.videojuego.states.units;

import unq.videojuego.components.AttackComp;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.LimitedAnimation;

public class UnitAttacking extends State {
	private BattleUnit target;
	
	public UnitAttacking(BattleUnit target) {
		super("Attacking");
		this.target = target;
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleUnit caster = (BattleUnit) comp;
		if (((LimitedAnimation) caster.getAppearance()).isAtEnd()){
			UnitDir originDir = this.target.getDir();
			caster.getUnit().attack(this.target.getUnit());
			this.target.setOpposedDir(caster.getDir());
			this.target.setState(new UnitTakingDamage(caster, originDir));
			caster.setState(new UnitWaiting());
			caster.getScene().addAttack(new AttackComp(target.getMapX(), target.getMapY(), "BasicAttack"));
			caster.decreaseChargeTime(50);
		}
	}

}

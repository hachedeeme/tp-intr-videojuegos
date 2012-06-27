package unq.videojuego.states.units;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.State;
import unq.videojuego.states.map.MapSelectingUnit;
import unq.videojuego.states.map.MapWaitingForCommand;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.LimitedAnimation;

public class UnitTakingDamage extends State {

	private BattleUnit caster;
	private UnitDir originDir;

	public UnitTakingDamage(BattleUnit caster, UnitDir originDir) {
		super("TakingDamage");
		this.caster = caster;
		this.originDir = originDir;
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleUnit target = (BattleUnit) comp;
		if (((LimitedAnimation) target.getAppearance()).isAtEnd()){
			target.setDir(this.originDir);
			BattleScene scene = target.getScene();
			BattleMap map = scene.getMap();
			if (scene.turnEnded()){
				map.endTurn();
				target.setState(new UnitWaiting());
				map.setState(new MapSelectingUnit());
				map.addUnit(this.caster);
				scene.resetCommands();
			} else {
				scene.getBattleCommandsWindow().removeCurElement();
				target.setState(new UnitSelected());
				map.addSameUnit();
				map.setState(new MapSelectingUnit());
			}
		}
	}
}

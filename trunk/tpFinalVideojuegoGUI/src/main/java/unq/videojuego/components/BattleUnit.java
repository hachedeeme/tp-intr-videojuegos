package unq.videojuego.components;

import unq.videojuego.enums.UnitDir;
import unq.videojuego.states.State;
import unq.videojuego.states.character.CharWaiting;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.characters.Unit;

public abstract class BattleUnit extends BattleComponent {
	private String name;
	private State state = new CharWaiting();
	private UnitDir dir = UnitDir.Down;
	
	public BattleUnit(String name, UnitDir dir){
		super();
		this.name = name;
		this.dir = dir;
		this.createImagesMap();
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.state.update(this, deltaState);
	}

	public void updateAppearance() {
		this.setAppearance(ImageHandler.INSTANCE.getAnimation(this.name + this.state.getName() + this.dir.name()));
	}

	public abstract void createImagesMap();
	
	public abstract int getMovility();
	
	public abstract int getAttackRange();
	
	public UnitDir getDir() {
		return dir;
	}

	public void setDir(UnitDir dir) {
		this.dir = dir;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		this.updateAppearance();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract Unit getUnit();
}

package unq.videojuego.states;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public abstract class State {
	private String name;
	
	protected State(String name) {
		this.name = name;
	}
	
	public abstract void update(GameComponent comp, DeltaState deltaState);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

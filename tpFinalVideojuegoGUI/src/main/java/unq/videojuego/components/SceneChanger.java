package unq.videojuego.components;

import unq.videojuego.scenes.VideojuegoScene;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class SceneChanger extends GameComponent<VideojuegoScene> {
	private State state;
	
	public SceneChanger(State state) {
		this.state = state;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.state.update(this, deltaState);
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}

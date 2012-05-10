package unq.videojuego.components;

import unq.videojuego.enums.CharDir;
import unq.videojuego.scenes.VideojuegoScene;
import unq.videojuego.states.State;
import unq.videojuego.states.character.CharWaiting;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Animation;

public class BattleCharacter extends BattleComponent {
	private String name;
	private State state = new CharWaiting();
	private int range = 4;
	
	private CharDir dir = CharDir.Down; 
	
	public BattleCharacter(String name, int mapX, int mapY) {
		super(mapX, mapY);
		this.name = name;
	}
	
	public BattleCharacter(String name){
		super();
		this.name = name;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.state.update(this, deltaState);
	}

	public void createImagesMap() {		
		// Animaciones mirando hacia abajo
		String waitingDownName = this.name + "Waiting" + CharDir.Down.name();
		Animation waitingDown = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, waitingDownName); 

		String walkingDownName = this.name + "Walking" + CharDir.Down.name();
		Animation walkingDown = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, walkingDownName); 
		
		String selectedDownName = this.name + "Selected" + CharDir.Down.name();
		Animation selectedDown = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, selectedDownName); 
		
		
		// Animaciones mirando hacia la Derecha
		String waitingRightName = this.name + "Waiting" + CharDir.Right.name();
		VideojuegoScene.imageH.addAnimation(waitingRightName, waitingDown.flip());
		
		String walkingRightName = this.name + "Walking" + CharDir.Right.name();
		VideojuegoScene.imageH.addAnimation(walkingRightName, walkingDown.flip());
		
		String selectedRightName = this.name + "Selected" + CharDir.Right.name();
		VideojuegoScene.imageH.addAnimation(selectedRightName, selectedDown.flip());
		
		
		// Animaciones mirando hacia la Izquierda
		String waitingLeftName = this.name + "Waiting" + CharDir.Left.name();
		Animation waitingLeft = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, waitingLeftName); 
		
		String walkingLeftName = this.name + "Walking" + CharDir.Left.name();
		Animation walkingLeft = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, walkingLeftName); 
		
		String selectedLeftName = this.name + "Selected" + CharDir.Left.name();
		Animation selectedLeft = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, selectedLeftName); 
		
		
		// Animaciones mirando hacia Arriba
		String waitingUpName = this.name + "Waiting" + CharDir.Up.name();
		VideojuegoScene.imageH.addAnimation(waitingUpName, waitingLeft.flip());
		
		String walkingUpName = this.name + "Walking" + CharDir.Up.name();
		VideojuegoScene.imageH.addAnimation(walkingUpName, walkingLeft.flip());
		
		String selectedUpName = this.name + "Selected" + CharDir.Up.name();
		VideojuegoScene.imageH.addAnimation(selectedUpName, selectedLeft.flip());
		
		this.updateAppearance();
	}

	public void updateAppearance() {
		this.setAppearance(VideojuegoScene.imageH.getAnimation(this.name + this.state.getName() + this.dir.name()));
	}

	public CharDir getDir() {
		return dir;
	}

	public void setDir(CharDir dir) {
		this.dir = dir;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		this.updateAppearance();
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

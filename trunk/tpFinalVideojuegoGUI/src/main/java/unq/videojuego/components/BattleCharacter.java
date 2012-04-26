package unq.videojuego.components;

import java.util.HashMap;
import java.util.Map;

import unq.videojuego.enums.CharDir;
import unq.videojuego.scenes.VideojuegoScene;
import unq.videojuego.states.CharWaiting;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Animation;

public class BattleCharacter extends BattleComponent {
	private String name;
	private State state = new CharWaiting();
	private int range = 3;
	
	private CharDir dir = CharDir.Down; 
	
	public BattleCharacter(String name, int mapX, int mapY) {
		super(mapX, mapY);
		this.name = name;
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.state.update(this, deltaState);
	}

	public void createImagesMap() {
		Map<CharDir, Map<String, Animation>> charImages = new HashMap<CharDir, Map<String,Animation>>();
		Map<String, Animation> upMap = new HashMap<String, Animation>();
		Map<String, Animation> rightMap = new HashMap<String, Animation>();
		Map<String, Animation> downMap = new HashMap<String, Animation>();
		Map<String, Animation> leftMap = new HashMap<String, Animation>();
		
		// Animaciones mirando hacia abajo
		String waitingDownName = this.name + "Waiting" + CharDir.Down.name();
		Animation waitingDown = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, waitingDownName); 

		String walkingDownName = this.name + "Walking" + CharDir.Down.name();
		Animation walkingDown = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, walkingDownName); 
		
		
		// Animaciones mirando hacia la Derecha
		String waitingRightName = this.name + "Waiting" + CharDir.Right.name();
		VideojuegoScene.imageH.addAnimation(waitingRightName, waitingDown.flip());
		
		String walkingRightName = this.name + "Walking" + CharDir.Right.name();
		VideojuegoScene.imageH.addAnimation(walkingRightName, walkingDown.flip());
		
		
		// Animaciones mirando hacia la Izquierda
		String waitingLeftName = this.name + "Waiting" + CharDir.Left.name();
		Animation waitingLeft = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, waitingLeftName); 
		
		String walkingLeftName = this.name + "Walking" + CharDir.Left.name();
		Animation walkingLeft = VideojuegoScene.imageH.addAnimation(0.10, 1, 600, 120, 100, 120, walkingLeftName); 
		
		
		// Animaciones mirando hacia Arriba
		String waitingUpName = this.name + "Waiting" + CharDir.Up.name();
		VideojuegoScene.imageH.addAnimation(waitingUpName, waitingLeft.flip());
		
		String walkingUpName = this.name + "Walking" + CharDir.Up.name();
		VideojuegoScene.imageH.addAnimation(walkingUpName, walkingLeft.flip());
		
		charImages.put(CharDir.Up, upMap);
		charImages.put(CharDir.Right,rightMap);
		charImages.put(CharDir.Down, downMap);
		charImages.put(CharDir.Left, leftMap);
		
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

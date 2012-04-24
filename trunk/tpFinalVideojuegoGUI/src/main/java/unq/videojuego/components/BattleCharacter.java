package unq.videojuego.components;

import java.util.HashMap;
import java.util.Map;

import unq.videojuego.enums.CharDir;
import unq.videojuego.states.CharWaiting;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Animation;

public class BattleCharacter extends BattleComponent {
	private String name;
	private State state = new CharWaiting();
	
	private CharDir dir = CharDir.Down; 
	private Map<CharDir, Map<String, Animation>> images;
	
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
		
		// Animaciones mirando hacia Arriba

		
		// Animaciones mirando hacia la Derecha
		
		
		// Animaciones mirando hacia abajo
		this.getScene().imageH.addAnimation(0.15, 1, 600, 120, 100, 120, (this.name + "Waiting" + CharDir.Down.name()));
		this.getScene().imageH.addAnimation(0.15, 1, 600, 120, 100, 120, (this.name + "Walking" + CharDir.Down.name()));
		
		
		// Animaciones mirando hacia la Izquierda

		
		charImages.put(CharDir.Up, upMap);
		charImages.put(CharDir.Right,rightMap);
		charImages.put(CharDir.Down, downMap);
		charImages.put(CharDir.Left, leftMap);
		
		this.updateAppearance();
	}

	public void updateAppearance() {
		this.setAppearance(this.getScene().imageH.getAnimation(this.name + this.state.getName() + CharDir.Down.name()));
	}

	public CharDir getDir() {
		return dir;
	}

	public void setDir(CharDir dir) {
		this.dir = dir;
	}

	
	
	
}

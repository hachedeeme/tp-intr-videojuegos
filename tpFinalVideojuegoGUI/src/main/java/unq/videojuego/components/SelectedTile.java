package unq.videojuego.components;

import unq.videojuego.states.Sleeping;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.ImageHandler;

public class SelectedTile extends BattleComponent {
	private SelectionCone selectionCone = new SelectionCone(0, 0);
	
	private State state = new Sleeping();

	private BattleMap battleMap;
	
	public SelectedTile(BattleMap battleMap, int x, int y) {
		super(x, y);
		this.setZ(-1);
		this.battleMap = battleMap;
		this.setAppearance(ImageHandler.INSTANCE.getSprite("SelectedTile"));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.state.update(this, deltaState);
	}
	
	public void updateCone() {
		this.selectionCone.setX(this.getX());
		this.selectionCone.setY(this.getY());
	}
	
	public SelectionCone getSelectionCone() {
		return selectionCone;
	}

	public void setSelectionCone(SelectionCone selectionCone) {
		this.selectionCone = selectionCone;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public BattleMap getBattleMap() {
		return battleMap;
	}

	public void setBattleMap(BattleMap battleMap) {
		this.battleMap = battleMap;
	}
	
	
}

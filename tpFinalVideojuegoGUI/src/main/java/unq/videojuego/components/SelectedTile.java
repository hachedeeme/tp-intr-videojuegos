package unq.videojuego.components;

import com.uqbar.vainilla.DeltaState;

import unq.videojuego.scenes.VideojuegoScene;

public class SelectedTile extends BattleComponent {
	private SelectionCone selectionCone = new SelectionCone(0, 0);
	
	public SelectedTile(int x, int y) {
		super(x, y);
		this.setZ(-1);
		this.setAppearance(VideojuegoScene.imageH.getSprite("SelectedTile"));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
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
	
}

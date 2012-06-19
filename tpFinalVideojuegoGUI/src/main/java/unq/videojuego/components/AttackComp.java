package unq.videojuego.components;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.appearances.LimitedAnimation;

public class AttackComp extends BattleComponent {
	
	public AttackComp(int mapX, int mapY, String imageName) {
		super(mapX, mapY);
		this.updateZ();
		//this.setZ(this.getZ()+1);
		this.setAppearance(ImageHandler.INSTANCE.getAnimation("attacks/" + imageName));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		if (((LimitedAnimation) this.getAppearance()).ended()){
			this.removeFromScene();
		}
	}
}

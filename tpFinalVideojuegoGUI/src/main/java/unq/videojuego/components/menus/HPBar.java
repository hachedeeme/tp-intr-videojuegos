package unq.videojuego.components.menus;

import unq.videojuego.components.BattleUnit;
import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.characters.Unit;

public class HPBar extends GameComponent<BattleScene> {
	private BattleUnit bUnit;
	private BarComp bar;
	
	public HPBar(double scale, BattleUnit bUnit) {
		super();
		this.bUnit = bUnit;
		int unitZ = this.bUnit.getZ()+1;
		this.setZ(unitZ);
		this.bar = new BarComp(scale, 0, 0, unitZ, "HpBar", this.getPerc());
		double dif = Math.ceil(2*scale);
		System.out.println(dif);
		this.bar.changeCoords(this.getRealX() + dif, this.getRealY() + dif);
		this.updateBar();
		this.setAppearance(ImageHandler.INSTANCE.getSprite("HpBarBack").scale(scale));
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.updateCoords();
	}
	
	public void updateCoords() {
		this.setX(this.getRealX());
		this.setY(this.getRealY());
	}

	private double getRealY() {
		return this.bUnit.getY() - this.bar.getFullHeight() - 2;
	}

	private double getRealX() {
		return this.bUnit.getX() + this.bUnit.getAppearance().getWidth()/2 - this.bar.getFullWidth()/2 - 2;
	}

	public void updateBar(){
		this.bar.updateBar(this.getPerc());
	}
	
	public double getPerc(){
		Unit unit = bUnit.getUnit();
		int curHp = unit.getCurrentHp();
		int maxHp = unit.getHp();
		double hpPerc = curHp*100/maxHp;
		return hpPerc/100;
	}
	
	@Override
	public void addToScene(GameScene scene) {
		super.addToScene(scene);
		scene.addComponent(this.bar);
	}
	
	@Override
	public void removeFromScene() {
		this.getScene().removeComponent(this.bar);
		super.removeFromScene();
	}
}

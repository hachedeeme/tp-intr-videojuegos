package unq.videojuego.components.menus;

import java.awt.Color;
import java.awt.Font;

import unq.videojuego.components.BattleUnit;
import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.appearances.Label;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.videojuego.characters.Unit;

public class UnitStats extends GameComponent<VideojuegoScene> {
	private LabelComp name;
	private LabelComp hp;
	private LabelComp mp;
	private GameComponent unitImage;
	private BattleUnit bUnit;
	
	public UnitStats(BattleUnit bUnit) {
		super();
		this.setZ(10);
		this.updateBUnit(bUnit);
	}
	
	public UnitStats(){
		super();
		this.setZ(10);
	}
	
	public void updateBUnit(BattleUnit bUnit){
		this.bUnit = bUnit;
		Unit unit = bUnit.getUnit();
		
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 16);
		this.name = new LabelComp(this.getX() + 105, this.getY() + 5, this.getZ()+2, new Label(font1, Color.WHITE, unit.getName()));
		
		Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 16);
		this.hp = new LabelComp(this.getX() + 105, this.getY() + 60, this.getZ()+2, new Label(font2, Color.WHITE, unit.getCurrentHp() + "/" + unit.getHp()));

		Font font3 = new Font(Font.MONOSPACED, Font.BOLD, 16);
		this.mp = new LabelComp(this.getX() + 105, this.getY() + 100, this.getZ()+2, new Label(font3, Color.WHITE, unit.getCurrentMp() + "/" + unit.getMp()));
		
		this.setAppearance(ImageHandler.INSTANCE.getSprite("LongBlueWindow"));
		
		this.unitImage = new GameComponent(new Rectangle(Color.WHITE, 100, 200), this.getX(), this.getY());
		this.unitImage.setZ(this.getZ()+1);
	}
	
	@Override
	public void addToScene(GameScene scene) {
		super.addToScene(scene);
		scene.addComponent(this.name);
		scene.addComponent(this.hp);
		scene.addComponent(this.mp);
		scene.addComponent(this.unitImage);
	}
	
	@Override
	public void removeFromScene(GameScene scene) {
		super.removeFromScene(scene);
		scene.removeComponent(this.name);
		scene.removeComponent(this.hp);
		scene.removeComponent(this.mp);
		scene.removeComponent(this.unitImage);
	}

	public BattleUnit getbUnit() {
		return bUnit;
	}

	public void setbUnit(BattleUnit bUnit) {
		this.bUnit = bUnit;
	}
	
}

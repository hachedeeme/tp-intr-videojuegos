package unq.videojuego.components.menus;

import java.awt.Color;
import java.awt.Font;

import unq.videojuego.components.BattleUnit;
import unq.videojuego.components.ImageComp;
import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.appearances.Label;
import com.uqbar.videojuego.characters.Unit;

public class UnitStats extends GameComponent<VideojuegoScene> {
	private LabelComp name;
	private LabelComp nameShadow;
	private LabelComp hp;
	private LabelComp hpShadow;
	private BarComp hpBar;
	private LabelComp mp;
	private LabelComp mpShadow;
	private BarComp mpBar;
	private ImageComp unitImage;
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
		int curHp = unit.getCurrentHp();
		int curMp = unit.getCurrentMp();
		int maxHp = unit.getHp();
		int maxMp = unit.getMp();
		
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 25);
		this.name = new LabelComp(this.getX() + 110, this.getY() + 10, this.getZ()+2, new Label(font1, Color.WHITE, unit.getName()));
		this.nameShadow = new LabelComp(this.getX() + 112, this.getY() + 12, this.getZ()+2, new Label(font1, Color.GRAY, unit.getName()));
		
		Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 20);
		this.hp = new LabelComp(this.getX() + 160, this.getY() + 67, this.getZ()+2, new Label(font2, Color.WHITE, curHp + "/" + maxHp));
		this.hpShadow = new LabelComp(this.getX() + 162, this.getY() + 69, this.getZ()+2, new Label(font2, Color.GRAY, curHp + "/" + maxHp));

		this.mp = new LabelComp(this.getX() + 160, this.getY() + 120, this.getZ()+2, new Label(font2, Color.WHITE, curMp + "/" + maxMp));
		this.mpShadow = new LabelComp(this.getX() + 162, this.getY() + 122, this.getZ()+2, new Label(font2, Color.GRAY, curMp + "/" + maxMp));
		
		this.unitImage = new ImageComp(this.getX() + 5, this.getY() + 5, this.getZ()+1, ImageHandler.INSTANCE.getSprite(unit.getName() + "Avatar"));
		double hpPerc = curHp*100/maxHp;
		double mpPerc = curMp*100/maxMp;
		this.hpBar = new BarComp(104, 95, this.getZ()+1, "HpBar", hpPerc/100);
		this.mpBar = new BarComp(104, 148, this.getZ()+1, "MpBar", mpPerc/100);
		
		this.setAppearance(ImageHandler.INSTANCE.getSprite("UnitStatsBack"));
	}
	
	public void updateBUnit(){
		this.updateBUnit(this.bUnit);
	}
	
	@Override
	public void addToScene(GameScene scene) {
		super.addToScene(scene);
		scene.addComponent(this.nameShadow);
		scene.addComponent(this.name);
		scene.addComponent(this.hpShadow);
		scene.addComponent(this.hp);
		scene.addComponent(this.hpBar);
		scene.addComponent(this.mpShadow);
		scene.addComponent(this.mp);
		scene.addComponent(this.mpBar);
		scene.addComponent(this.unitImage);
	}
	
	@Override
	public void removeFromScene(GameScene scene) {
		super.removeFromScene(scene);
		scene.removeComponent(this.nameShadow);
		scene.removeComponent(this.name);
		scene.removeComponent(this.hpShadow);
		scene.removeComponent(this.hp);
		scene.removeComponent(this.hpBar);
		scene.removeComponent(this.mpShadow);
		scene.removeComponent(this.mp);
		scene.removeComponent(this.mpBar);
		scene.removeComponent(this.unitImage);
	}

	public BattleUnit getbUnit() {
		return bUnit;
	}

	public void setbUnit(BattleUnit bUnit) {
		this.bUnit = bUnit;
	}
	
}

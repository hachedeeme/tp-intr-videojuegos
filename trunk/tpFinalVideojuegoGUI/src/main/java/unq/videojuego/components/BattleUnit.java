package unq.videojuego.components;

import unq.videojuego.enums.UnitDir;
import unq.videojuego.states.State;
import unq.videojuego.states.units.UnitWaiting;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.characters.Unit;

public abstract class BattleUnit extends BattleComponent {
	private String name;
	private State state = new UnitWaiting();
	private UnitDir dir = UnitDir.Down;
	private int chargeTime;
	
	public BattleUnit(String name, UnitDir dir){
		super();
		this.name = name;
		this.dir = dir;
		this.createImagesMap();
		this.resetCT();
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.state.update(this, deltaState);
	}

	public void updateAppearance() {
		this.setAppearance(ImageHandler.INSTANCE.getAnimation(this.name + this.state.getName() + this.dir.name()));
	}
	
	public int getDistance(BattleUnit unit){
		int unitX = unit.getMapX();
		int unitY = unit.getMapY();
		
		return Math.abs(unitX - this.getMapX()) + Math.abs(unitY - this.getMapY()) - this.getAttackRange(); 
	}
	
	public void setFacingDir(BattleUnit target) {
        UnitDir wantedDir;
       
        int cx = this.getMapX();
        int cy = this.getMapY();
        int ex = target.getMapX();
        int ey = target.getMapY();

        if (cx < ex){
            wantedDir = UnitDir.Right;
        } else {
            wantedDir = UnitDir.Left;
        }
         
        if (Math.abs(cx - ex) < Math.abs(cy - ey)){
            if (cy < ey){
                wantedDir = UnitDir.Down;
            } else {
                wantedDir = UnitDir.Up;
            }
        }
       
        this.setDir(wantedDir);
    }

	public abstract void createImagesMap();
	
	public abstract int getMovility();
	
	public abstract int getAttackRange();
	
	public abstract Unit getUnit();
	
	public abstract int getSpeed();
	
	public abstract BattleUnit copy();
	
	public UnitDir getDir() {
		return dir;
	}

	public void setDir(UnitDir dir) {
		this.dir = dir;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		this.updateAppearance();
	}

	public String getName() {
		return name;
	}	
	
	public void setOpposedDir(UnitDir aUnitDir){
		this.dir = aUnitDir.getOpposed();
	}
	
	public int getChargeTime() {
		return chargeTime;
	}
	
	public void decreaseChargeTime(int amount){
		if(this.chargeTime > amount)
			this.chargeTime -= amount;
		else
			this.chargeTime = 0;
	}
	
	public void raiseChargeTime(){
		int amount = 15 + this.getSpeed()* 7/100;
		this.chargeTime += amount;
		if(this.chargeTime > 100)
			this.chargeTime = 100;
	}
	
	public boolean isDead(){
		return this.getUnit().isDead();
	}
	
	public void resetCT() {
		this.chargeTime = 100;
	}
	
}

package unq.videojuego.components;

import unq.videojuego.enums.UnitDir;

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.LimitedAnimation;
import com.uqbar.videojuego.characters.Enemy;
import com.uqbar.videojuego.characters.Unit;

public class BattleEnemy extends BattleUnit {
	private Enemy enemy;

	public BattleEnemy(String name, UnitDir dir, 
					   int attackRange, int movility,
					   int hp, int mp,
					   int speed,
					   int strength, int stamina, int intellect, int wisdom ) {
		super(name, dir);
		this.enemy = new Enemy(name, attackRange, movility,
							   hp, mp, speed, strength, stamina, intellect, wisdom);
	}
	
	@Override
	public void createImagesMap() {		
		// Waiting
		String waitingDownName = this.getName() + "Waiting" + UnitDir.Down.name();
		Animation waitingDown = ImageHandler.INSTANCE.addAnimation(0.10, 1, 750, 120, 150, 120, waitingDownName); 

		String waitingRightName = this.getName() + "Waiting" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addAnimation(waitingRightName, waitingDown.flipHorizontally());
		
		String waitingLeftName = this.getName() + "Waiting" + UnitDir.Left.name();
		Animation waitingLeft = ImageHandler.INSTANCE.addAnimation(0.10, 1, 750, 120, 150, 120, waitingLeftName); 

		String waitingUpName = this.getName() + "Waiting" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addAnimation(waitingUpName, waitingLeft.flipHorizontally());
		
		
		// Selected
		String selectedDownName = this.getName() + "Selected" + UnitDir.Down.name();
		Animation selectedDown = ImageHandler.INSTANCE.addAnimation(0.10, 1, 750, 120, 150, 120, selectedDownName); 
		
		String selectedRightName = this.getName() + "Selected" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addAnimation(selectedRightName, selectedDown.flipHorizontally());
		
		String selectedLeftName = this.getName() + "Selected" + UnitDir.Left.name();
		Animation selectedLeft = ImageHandler.INSTANCE.addAnimation(0.10, 1, 750, 120, 150, 120, selectedLeftName); 
		
		String selectedUpName = this.getName() + "Selected" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addAnimation(selectedUpName, selectedLeft.flipHorizontally());

		
		// Walking
		String walkingDownName = this.getName() + "Walking" + UnitDir.Down.name();
		Animation walkingDown = ImageHandler.INSTANCE.addAnimation(0.10, 1, 1050, 120, 150, 120, walkingDownName); 
		
		String walkingRightName = this.getName() + "Walking" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addAnimation(walkingRightName, walkingDown.flipHorizontally());
		
		String walkingLeftName = this.getName() + "Walking" + UnitDir.Left.name();
		Animation walkingLeft = ImageHandler.INSTANCE.addAnimation(0.10, 1, 1050, 120, 150, 120, walkingLeftName); 
		
		String walkingUpName = this.getName() + "Walking" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addAnimation(walkingUpName, walkingLeft.flipHorizontally());

		
		// Attacking
		String attackingDownName = this.getName() + "Attacking" + UnitDir.Down.name();
		Animation attackingDown = ImageHandler.INSTANCE.addLimitedAnimation(0.10, 1, 900, 120, 150, 120, attackingDownName); 
		
		String attackingRightName = this.getName() + "Attacking" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addAnimation(attackingRightName, attackingDown.flipHorizontally());
		
		String attackingLeftName = this.getName() + "Attacking" + UnitDir.Left.name();
		Animation attackingLeft = ImageHandler.INSTANCE.addLimitedAnimation(0.10, 1, 900, 120, 150, 120, attackingLeftName); 
		
		String attackingUpName = this.getName() + "Attacking" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addAnimation(attackingUpName, attackingLeft.flipHorizontally());
		
		// Taking Damage
		String takingDamageDownName = this.getName() + "TakingDamage" + UnitDir.Down.name();
		LimitedAnimation takingDamageDown = ImageHandler.INSTANCE.addLimitedAnimation(0.1, 1, 600, 120, 150, 120, takingDamageDownName); 
		
		String takingDamageRightName = this.getName() + "TakingDamage" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addLimitedAnimation(takingDamageRightName, takingDamageDown.flipHorizontally());
		
		String takingDamageLeftName = this.getName() + "TakingDamage" + UnitDir.Left.name();
		LimitedAnimation takingDamageLeft = ImageHandler.INSTANCE.addLimitedAnimation(0.1, 1, 600, 120, 150, 120, takingDamageLeftName); 
		
		String takingDamageUpName = this.getName() + "TakingDamage" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addLimitedAnimation(takingDamageUpName, takingDamageLeft.flipHorizontally());

		
		this.updateAppearance();
	}
	
	@Override
	public int getMovility() {
		return this.enemy.getMovility();
	}

	@Override
	public int getAttackRange() {
		return this.enemy.getAttackRange();
	}
	
	@Override
	public int getSpeed() {
		return this.enemy.getSpeed();
	}
	
	public Unit getUnit(){
		return this.enemy;
	}
	
}

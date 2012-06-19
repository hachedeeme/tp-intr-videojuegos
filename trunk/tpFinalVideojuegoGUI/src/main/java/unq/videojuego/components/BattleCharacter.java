package unq.videojuego.components;

import unq.videojuego.enums.UnitDir;

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.LimitedAnimation;
import com.uqbar.videojuego.characters.Character;
import com.uqbar.videojuego.characters.StatsContainer;
import com.uqbar.videojuego.characters.Unit;

public class BattleCharacter extends BattleUnit {
	private Character character;

	public BattleCharacter(String name, UnitDir dir) {
		super(name, dir);
		StatsContainer stats = new StatsContainer(40, 20, 0, 30, 30, 30, 10, 8);
		this.character = new Character(name, stats);
		System.out.println(this.character.getStats());
	}

	@Override
	public void createImagesMap() {		
		// Waiting
		String waitingDownName = this.getName() + "Waiting" + UnitDir.Down.name();
		Animation waitingDown = ImageHandler.INSTANCE.addAnimation(0.10, 1, 600, 120, 100, 120, waitingDownName); 

		String waitingRightName = this.getName() + "Waiting" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addAnimation(waitingRightName, waitingDown.flipHorizontally());
		
		String waitingLeftName = this.getName() + "Waiting" + UnitDir.Left.name();
		Animation waitingLeft = ImageHandler.INSTANCE.addAnimation(0.10, 1, 600, 120, 100, 120, waitingLeftName); 

		String waitingUpName = this.getName() + "Waiting" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addAnimation(waitingUpName, waitingLeft.flipHorizontally());
		
		
		// Selected
		String selectedDownName = this.getName() + "Selected" + UnitDir.Down.name();
		Animation selectedDown = ImageHandler.INSTANCE.addAnimation(0.10, 1, 600, 120, 100, 120, selectedDownName); 
		
		String selectedRightName = this.getName() + "Selected" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addAnimation(selectedRightName, selectedDown.flipHorizontally());
		
		String selectedLeftName = this.getName() + "Selected" + UnitDir.Left.name();
		Animation selectedLeft = ImageHandler.INSTANCE.addAnimation(0.10, 1, 600, 120, 100, 120, selectedLeftName); 
		
		String selectedUpName = this.getName() + "Selected" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addAnimation(selectedUpName, selectedLeft.flipHorizontally());

		
		// Walking
		String walkingDownName = this.getName() + "Walking" + UnitDir.Down.name();
		Animation walkingDown = ImageHandler.INSTANCE.addAnimation(0.10, 1, 600, 120, 100, 120, walkingDownName); 
		
		String walkingRightName = this.getName() + "Walking" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addAnimation(walkingRightName, walkingDown.flipHorizontally());
		
		String walkingLeftName = this.getName() + "Walking" + UnitDir.Left.name();
		Animation walkingLeft = ImageHandler.INSTANCE.addAnimation(0.10, 1, 600, 120, 100, 120, walkingLeftName); 
		
		String walkingUpName = this.getName() + "Walking" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addAnimation(walkingUpName, walkingLeft.flipHorizontally());

		
		// Attacking
		String attackingDownName = this.getName() + "Attacking" + UnitDir.Down.name();
		LimitedAnimation attackingDown = ImageHandler.INSTANCE.addLimitedAnimation(0.10, 1, 400, 120, 100, 120, attackingDownName); 
		
		String attackingRightName = this.getName() + "Attacking" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addLimitedAnimation(attackingRightName, attackingDown.flipHorizontally());
		
		String attackingLeftName = this.getName() + "Attacking" + UnitDir.Left.name();
		LimitedAnimation attackingLeft = ImageHandler.INSTANCE.addLimitedAnimation(0.10, 1, 400, 120, 100, 120, attackingLeftName); 
		
		String attackingUpName = this.getName() + "Attacking" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addLimitedAnimation(attackingUpName, attackingLeft.flipHorizontally());

		// Taking Damage
		String takingDamageDownName = this.getName() + "TakingDamage" + UnitDir.Down.name();
		LimitedAnimation takingDamageDown = ImageHandler.INSTANCE.addLimitedAnimation(0.2, 1, 200, 120, 100, 120, takingDamageDownName); 
		
		String takingDamageRightName = this.getName() + "TakingDamage" + UnitDir.Right.name();
		ImageHandler.INSTANCE.addLimitedAnimation(takingDamageRightName, takingDamageDown.flipHorizontally());
		
		String takingDamageLeftName = this.getName() + "TakingDamage" + UnitDir.Left.name();
		LimitedAnimation takingDamageLeft = ImageHandler.INSTANCE.addLimitedAnimation(0.2, 1, 200, 120, 100, 120, takingDamageLeftName); 
		
		String takingDamageUpName = this.getName() + "TakingDamage" + UnitDir.Up.name();
		ImageHandler.INSTANCE.addLimitedAnimation(takingDamageUpName, takingDamageLeft.flipHorizontally());
		
		this.updateAppearance();
	}
	
	@Override
	public int getMovility(){
		return this.character.getMovility();
	}
	
	@Override
	public int getAttackRange() {
		return this.character.getAttackRange();
	}
	
	public Unit getUnit(){
		return this.character;
	}

}

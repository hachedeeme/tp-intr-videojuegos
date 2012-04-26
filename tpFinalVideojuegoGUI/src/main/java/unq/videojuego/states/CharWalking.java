package unq.videojuego.states;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.enums.CharDir;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class CharWalking extends State {
	private double xSpeed;
	private double ySpeed;
	private double newX;
	private double newY;
	private int mapX;
	private int mapY;
	
	public CharWalking(double tileSize, double curX, double curY, double newX, double newY, int mapX, int mapY) {
		super("Walking");
		this.newX = newX;
		this.newY = newY;
		
		this.calculateSpeeds(curX, curY, tileSize);
		
		this.mapX = mapX;
		this.mapY = mapY;
	}

	private void calculateSpeeds(double curX, double curY, double tileSize) {
		int xDir = (curX < this.newX) ? 2 : -2;
		int yDir = (curY < this.newY) ? 2 : -2;		

		this.xSpeed = tileSize/2 * xDir;
		this.ySpeed = tileSize/4 * yDir;
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleCharacter bChar = (BattleCharacter) comp;
		double delta = deltaState.getDelta();
		if (this.xSpeed > 0 && bChar.getX() < this.newX ||
			this.xSpeed < 0 && bChar.getX() > this.newX &&
			this.ySpeed > 0 && bChar.getY() < this.newY ||
			this.ySpeed < 0 && bChar.getY() > this.newY ){
			bChar.move(xSpeed * delta, ySpeed * delta);
		} else {
			bChar.getScene().getMap().setMapComponentCoords(bChar, this.mapX, this.mapY);
			int newX = bChar.getMapX();
			int newY = bChar.getMapY();
			boolean moved = false;
			CharDir newCharDir = bChar.getDir();
			if (deltaState.isKeyBeingHold(Key.UP)) {
				newY--;
				moved = true;
				newCharDir = CharDir.Up;
			} else if (deltaState.isKeyBeingHold(Key.RIGHT)) {
				newX++;
				moved = true;
				newCharDir = CharDir.Right;
			} else if (deltaState.isKeyBeingHold(Key.DOWN)) {
				newY++;
				moved = true;
				newCharDir = CharDir.Down;
			} else if (deltaState.isKeyBeingHold(Key.LEFT)) {
				newX--;
				moved = true;
				newCharDir = CharDir.Left;
			}
			if (moved){
				int tilesize = bChar.getScene().getTileSize();
				double newRealX = bChar.getScene().getMap().getRealXCoord(bChar, newX, newY);
				double newRealY = bChar.getScene().getMap().getRealYCoord(bChar, newX, newY);
				bChar.setDir(newCharDir);
				this.newX = newRealX;
				this.newY = newRealY;
				this.calculateSpeeds(bChar.getX(), bChar.getY(), tilesize);
				this.mapX = newX;
				this.mapY = newY;
				bChar.updateAppearance();
				//bChar.setState(new CharWalking(tilesize, bChar.getX(), bChar.getY(), newRealX, newRealY, newX, newY));
			} else {
				bChar.setState(new CharWaiting());
			}
		}
	}

}

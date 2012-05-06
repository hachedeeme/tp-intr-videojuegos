package unq.videojuego.components;

import com.uqbar.vainilla.appearances.Label;


public class CounterOrnament extends Ornament {
	private int counter;

	public CounterOrnament(int x, int y, int z, int counter) {
		super(x, y, z, null);
		this.setWidth((counter + "").length() * this.getFont().getSize());
		this.counter = counter;
		this.setAppearance(new Label( this.getFont(), this.getColor(), "" + counter));
	}
	
	public void updateAppearance(int aCounter){
		((Label) this.getAppearance()).setText("" + aCounter);
	}
	
	public void increaseCounter(int amount) {
		this.counter += amount;
		this.updateAppearance(this.counter);
	}
	
	public void decreaseCounter(int amount){
		this.counter -= amount;
		this.updateAppearance(this.counter);
	}
}

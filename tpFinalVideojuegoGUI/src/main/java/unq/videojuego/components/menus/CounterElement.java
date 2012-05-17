package unq.videojuego.components.menus;


import com.uqbar.vainilla.appearances.Label;


public class CounterElement extends ListElement {
	private int counter;

	public CounterElement(int x, int y, int z, int counter) {
		super(x, y, z, null);
		Label label = new Label( this.getFont(), this.getColor(), "" + counter); 
		this.setWidth(label.getWidth());
		this.counter = counter;
		this.setAppearance(label);
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

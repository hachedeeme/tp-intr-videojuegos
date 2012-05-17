package unq.videojuego.components.menus;


import com.uqbar.vainilla.appearances.Label;

public class TextElement extends ListElement {
	
	public TextElement(int x, int y, int z, String aText) {
		super(x, y, z, null);
		Label label = new Label(this.getFont(), this.getColor(), aText);
		this.setWidth(label.getWidth());
		this.setAppearance(label);
	}
	
	public void setText(String aText){
		((Label) this.getAppearance()).setText(aText);
	}
	
	public double getHeight(){
		return ((Label) this.getAppearance()).getHeight();
	}
}

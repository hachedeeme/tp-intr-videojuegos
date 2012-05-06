package unq.videojuego.components;

import com.uqbar.vainilla.appearances.Label;

public class TextOrnament extends Ornament {
	
	public TextOrnament(int x, int y, int z, String aText) {
		super(x, y, z, null);
		this.setWidth(aText.length() * this.getFont().getSize());
		this.setAppearance(new Label(this.getFont(), this.getColor(), aText));
	}
	
	public void setText(String aText){
		((Label) this.getAppearance()).setText(aText);
	}
}

package unq.videojuego.components.menus;

import java.awt.Graphics2D;
import java.util.List;

import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class Window extends GameComponent<VideojuegoScene> {
	private List<Showable> elements;
	private Pointer pointer;
	private Sprite image;
	
	public Window(double x, double y, Sprite image, List<Showable> showables) {
		super();
		this.elements = showables;
		this.image = image;
		this.setAppearance(image);
		this.placeWindow(x, y);
		//this.pointer  = new Pointer(x,y);
	}
	
	//***********************//
	//** GAME LOOP METHODS **//
	//***********************//
	/*
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		this.placeWindow(this.getX()+ 200*deltaState.getDelta(), 0);
	}
	*/
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
		for (Showable element : this.elements) {
			element.render(graphics);
		}
	}
	
	//*************//
	//** METHODS **//
	//*************//
	public void placeWindow(){
		this.placeWindow(0, this.getScene().getScreenHeight() - this.getHeight());
	}
	
	public void placeWindow(double x, double y){
		this.setX(x);
		this.setY(y);
		this.setElementsCoords();
	}
	
	public void setElementsCoords(){
		double heightAccum = this.getY() + 22;
		for (Showable elem : this.elements){
			elem.setX(this.getX() + 35, this.getX() + this.getWidth());
			elem.setY(heightAccum);
			heightAccum += elem.getHeight();
		}
	}
	
	public int getHeight(){
		return (int) this.image.getHeight();
	}
	
	public int getWidth(){
		return (int) this.image.getWidth();
	}
	
	public int rigthBorder(){
		return (int) this.getX() + this.getWidth();
	}
	//**************//
	//** ACCESORS **//
	//**************//
	public void addElement(Showable element){
		this.elements.add(element);		
	}
	
	public void addAllElements(List<Showable> elements){
		for (Showable elem : elements){
			this.addElement(elem);
		}
	}
	
	public Sprite getImage() {
		return image;
	}
	
	public Pointer getPointer() {
		return pointer;
	}
}

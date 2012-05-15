package unq.videojuego.components.menus;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import unq.videojuego.components.SimpleComponent;
import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.vainilla.events.constants.Key;

public class Window extends GameComponent<VideojuegoScene> {
	private List<Showable> topElements;
	private List<Showable> elements;
	private List<Showable> botElements;
	
	private Sprite image;
	
	private int maxCurLines;
	private int pointerPos; 
	
	private SimpleComponent topArrow;
	private SimpleComponent botArrow;
	private SimpleComponent pointer;
	
	public Window(double x, double y, Sprite image, List<Showable> showables) {
		super();
		this.topElements = new ArrayList<Showable>();
		this.botElements = new ArrayList<Showable>();
		this.image = image;
		this.setAppearance(image);
		this.topArrow = new SimpleComponent(0, 0, this.getZ()+1, ImageHandler.INSTANCE.getSprite("arrow"));
		this.botArrow = new SimpleComponent(0, 0, this.getZ()+1, ImageHandler.INSTANCE.getSprite("arrow").flipVertically());
		this.pointer = new SimpleComponent(0, 0, this.getZ()+1, ImageHandler.INSTANCE.getSprite("pointer"));
		this.pointerPos = 0;
		double linesRoom =  this.image.getHeight() 
							- this.topArrow.getAppearance().getHeight() 
							- this.botArrow.getAppearance().getHeight();
		this.maxCurLines = (int) Math.floor(linesRoom / showables.get(0).getHeight());
		this.addElements(showables);
		this.placeWindow(x, y);
		this.updatePointer();
	}

	//***********************//
	//** GAME LOOP METHODS **//
	//***********************//
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		if (deltaState.isKeyPressed(Key.UP)){
			if (this.pointerPos > 0){
				this.pointerPos--;
				this.updatePointer();
			} else {
				this.moveToBotElems();
			}
		} else if (deltaState.isKeyPressed(Key.DOWN)){
			if (this.pointerPos < this.maxCurLines-1){
				this.pointerPos++;
				this.updatePointer();
			} else {
				this.moveToTopElems();
			}
		}
	}
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
		for (Showable element : this.elements) {
			element.render(graphics);
		}
		if (! this.topElements.isEmpty()){
			this.topArrow.render(graphics);
		}
		if (! this.botElements.isEmpty()){
			this.botArrow.render(graphics);
		}
		this.pointer.render(graphics);
	}
	
	public void moveToTopElems(){
		if (! this.botElements.isEmpty()){
			this.topElements.add(this.elements.remove(0));
			this.elements.add(this.botElements.remove(0));
			this.updateElementsCoords();
		}
	}
	
	public void moveToBotElems(){
		if (! this.topElements.isEmpty()){
			this.elements.add(0, this.topElements.remove(this.topElements.size()-1));
			this.botElements.add(0, this.elements.remove(this.elements.size()-1));
			this.updateElementsCoords();
		}
	}
	
	
	//*************//
	//** METHODS **//
	//*************//
	
	private void addElements(List<Showable> showables) {
		this.elements = new ArrayList<Showable>();
		for (int i = 0; i < this.maxCurLines; i++) {
			if (showables.isEmpty()){
				break;
			} else {
				this.elements.add(showables.remove(0));
			}
		}
		this.botElements.addAll(showables);
	}
	public void placeWindow(){
		this.placeWindow(0, this.getScene().getScreenHeight() - this.getHeight());
	}
	
	public void placeWindow(double x, double y){
		this.setX(x);
		this.setY(y);
		this.updateElementsCoords();
		this.setArrowsCoords();
	}
	
	public void setArrowsCoords() {
		this.topArrow.setX(this.getX() + this.getWidth() - this.topArrow.getAppearance().getWidth());
		this.topArrow.setY(this.getY());
		this.botArrow.setX(this.getX() + this.getWidth() - this.botArrow.getAppearance().getWidth());
		this.botArrow.setY(this.getY() + this.getHeight() - this.topArrow.getAppearance().getHeight());
	}

	public void updateElementsCoords(){
		double heightAccum = this.getY() + this.topArrow.getAppearance().getHeight();
		for (Showable elem : this.elements){
			elem.setX(this.getX() + this.pointer.getAppearance().getWidth(), this.getX() + this.getWidth());
			elem.setY(heightAccum);
			heightAccum += elem.getHeight();
		}
	}
	
	public void updatePointer(){
		double pointerHeight = this.pointer.getAppearance().getHeight();
		double topArrowHeight = this.topArrow.getAppearance().getHeight();
		this.pointer.setX(this.getX());
		this.pointer.setY(topArrowHeight + (this.pointerPos * pointerHeight));
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
	
}

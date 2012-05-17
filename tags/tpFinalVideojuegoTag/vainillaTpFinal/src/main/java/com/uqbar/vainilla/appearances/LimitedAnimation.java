package com.uqbar.vainilla.appearances;

import java.awt.Graphics2D;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Animation;
import com.uqbar.vainilla.appearances.Sprite;


public class LimitedAnimation extends Animation {
	private int timesLeft;
	private int maxTimes;
	
	public LimitedAnimation(double meantime, Sprite[] sprites) {
		this(meantime, sprites, 1);
	}
	
	public LimitedAnimation(double meantime, Sprite[] sprites, int times) {
		super(meantime, sprites);
		this.timesLeft = times;
		this.maxTimes = times;
	}
	
	public boolean ended(){
		return this.timesLeft == 0 && this.getCurrentIndex() >= this.getSprites().length;
	}
	
	public boolean isAtEnd(){
		return this.timesLeft == 1 && this.getCurrentIndex() == this.getSprites().length;
	}
	
	
	@Override
	protected void advance() {
		if (this.timesLeft > 0){
			if (this.getCurrentIndex() < this.getSprites().length){
				this.setCurrentIndex(this.getCurrentIndex() + 1);
				
				this.setRemainingTime(this.getMeantime() - this.getRemainingTime());
			} else {
				this.timesLeft--;
				this.setRemainingTime(this.getMeantime());
				if (this.timesLeft == 0){
					this.setCurrentIndex(this.getSprites().length);
				} else {
					this.setCurrentIndex(0);
				}
			}
		} 
	}
	
	public void reset(){
		this.setCurrentIndex(0);
		this.timesLeft = this.maxTimes;
	}
	
	@Override
	public LimitedAnimation copy() {
		return new LimitedAnimation(this.getMeantime(), this.getSprites(), this.maxTimes);
	}
	
	@Override
	public LimitedAnimation flipHorizontally() {
		Sprite[] newSprites = new Sprite[this.getSprites().length];
		int i = 0;
		for (Sprite sprite : this.getSprites()){
			newSprites[i] = sprite.flipHorizontally();
			i++;
		}
		return new LimitedAnimation(this.getMeantime(), newSprites);
	} 
	
	@Override
	public LimitedAnimation flipVertically() {
		Sprite[] newSprites = new Sprite[this.getSprites().length];
		int i = 0;
		for (Sprite sprite : this.getSprites()){
			newSprites[i] = sprite.flipVertically();
			i++;
		}
		return new LimitedAnimation(this.getMeantime(), newSprites);
	}
	
	@Override
	public void render(GameComponent<?> component, Graphics2D graphics) {
		if (this.getCurrentIndex() < this.getSprites().length){
			this.getCurrentSprite().render(component, graphics);
		}
	}

	public int getTimesLeft() {
		return timesLeft;
	}

	public void setTimesLeft(int timesLeft) {
		this.timesLeft = timesLeft;
	}

	public int getMaxTimes() {
		return maxTimes;
	}

	public void setMaxTimes(int maxTimes) {
		this.maxTimes = maxTimes;
	}
	


}

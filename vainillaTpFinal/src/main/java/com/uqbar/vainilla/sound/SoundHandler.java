package com.uqbar.vainilla.sound;

import java.util.HashMap;
import java.util.Map;

import com.uqbar.vainilla.sound.Sound;
import com.uqbar.vainilla.sound.SoundBuilder;
import com.uqbar.vainilla.sound.SoundPlay;
import com.uqbar.vainilla.sound.SoundPlayer;

public class SoundHandler extends SoundPlayer{
	private SoundBuilder soundBuilder = new SoundBuilder();
	public static SoundHandler INSTANCE = new SoundHandler();
	private Map<String, Sound> sounds = new HashMap<String, Sound>();
	private SoundPlay pausedSong;
	
	public void playSound(String soundName, float volume){
		if (this.hasMusic() && this.getBuffers().isEmpty()){
			this.setMusic(false);
		}
		this.enqueueSound(this.sounds.get(soundName), volume);
	}
	
	public void playSound(String soundName){
		this.playSound(soundName, 1);
	}
	
	public void playMusic(String soundName, float volume){
		if (this.pausedSong == null){
			this.addSoundAtStart(this.sounds.get(soundName), volume);
		}
	}
	
	public void playMusic(String soundName){
		this.playMusic(soundName, 1);
	}
	
	public void addSound(String soundName){
		Sound sound = this.soundBuilder.buildSound("/sounds/" + soundName + ".wav");
		this.sounds.put(soundName, sound);
	}
	
	public void addSounds(String...soundNames){
		for (String soundName : soundNames) {
			this.addSound(soundName);
		}
	}

	public void stopMusic() {
		if (this.hasMusic()){
			this.getBuffers().remove(0);
			this.setMusic(false);
		}
	}
	
	public void pauseMusic(){
		if (this.hasMusic()){
			SoundPlay soundPlay = this.getBuffers().remove(0);
			this.pausedSong = soundPlay;
			this.setMusic(false);
		}
	}
	
	public void unpauseMusic(){
		if (! this.hasMusic()){
			this.getBuffers().add(0, pausedSong);
			this.pausedSong = null;
			this.setMusic(true);
		}
	}

	public Map<String, Sound> getSounds() {
		return sounds;
	}

	public void setSounds(Map<String, Sound> sounds) {
		this.sounds = sounds;
	}
}

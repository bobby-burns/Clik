package clik.input;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class SoundHandler {
	PApplet p;
	static AudioPlayer player1;
	static AudioPlayer player2;
	
	public SoundHandler(PApplet parent) {
		this.p = parent;
		Minim m = new Minim(parent);
		player1 = m.loadFile("../resources/hit-sound.mp3");
		player2 = m.loadFile("../resources/combo-break.wav");
	}
	
	public void playHitSound() {
		player1.rewind();
		player1.play();
	}
	
	public void playComboBreak() {
		player2.rewind();
		player2.play();
	}
}

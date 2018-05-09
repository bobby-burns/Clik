package clik.input;

import processing.core.PApplet;
import clik.main.Main;
import clik.obj.Note;
public class Keyhandler {
	PApplet p;
	public static SoundHandler s;
	public Keyhandler(PApplet p) {
		this.p = p;
		this.s = new SoundHandler(p);
	}
	//Process note key values
	public void checkKey(char key) {
		//D key pressed
		if(key=='d') {
			//Set the color of the first key to white
			Main.rec1.setColor(p.color(255,255,255));
			// TODO: REMEMBER TO SORRUND THESE WITH TRY CATCH
			for (Note note : Main.notes) {
				//Check if the note is the correct position in first quadrant
				if (note.y <=600&&note.y>=500&&(int)note.pos==0) {
					//Remove key and increase score
					Main.notes.remove(note);
					Main.score++;
					s.playHitSound();
					break;
				} else {
					if (Main.score>= 10) {
						s.playComboBreak();
					}
					//Reset score to 0
					Main.score = 0;
				}
			}
		}
		//F key pressed
		if(key=='f') {
			//Set the color of the second key to white
			Main.rec2.setColor(p.color(255,255,255));
			for (Note note : Main.notes) {
				//Check if the note is the correct position in second quadrant
				if (note.y <=600&&note.y>=500&&(int)note.pos==1) {
					//Remove key and increase score
					Main.notes.remove(note);
					Main.score++;
					s.playHitSound();
					break;
				} else {
					if (Main.score>= 10) {
						s.playComboBreak();
					}
					//Reset score to 0
					Main.score = 0;
				}
			}
		}
		//G key pressed
		if(key=='g') {
			//Set the color of the first third to white
			Main.rec3.setColor(p.color(255,255,255));
			for (Note note : Main.notes) {
				//Check if the note is the correct position in third quadrant
				if (note.y <=600&&note.y>=500&&(int)note.pos==2) {
					//Remove key and increase score
					Main.notes.remove(note);
					Main.score++;
					s.playHitSound();
					break;
				} else {
					if (Main.score>= 10) {
						s.playComboBreak();
					}
					//Reset score to 0
					Main.score = 0;
				}
			}
		}
		//H key pressed
		if(key=='h') {
			//Set the color of the fourth key to white
			Main.rec4.setColor(p.color(255,255,255));
			for (Note note : Main.notes) {
				//Check if the note is the correct position in fourth quadrant
				if (note.y <=600&&note.y>=500&&(int)note.pos==3) {
					//Remove key and increase score
					Main.notes.remove(note);
					Main.score++;
					s.playHitSound();
					break;
				} else {
					if (Main.score>= 10) {
						s.playComboBreak();
					}
					//Reset score to 0
					Main.score = 0;
				}
			}
		}
	}
	//Return the color of the keys to gray
	public void checkRelease(char key) {
		if(key=='d') {
			//Set first key to gray
			Main.rec1.setColor(p.color(150,150,150));
		}
		if(key=='f') {
			//Set second key to gray
			Main.rec2.setColor(p.color(150,150,150));
		}
		if(key=='g') {
			//Set third key to gray
			Main.rec3.setColor(p.color(150,150,150));
		}
		if(key=='h') {
			//Set fourth key to gray
			Main.rec4.setColor(p.color(150,150,150));
		}
	}
}

package clik.input;

import processing.core.PApplet;
import clik.main.Main;
import clik.obj.Note;
public class Keyhandler {
	PApplet p;
	
	public Keyhandler(PApplet p) {
		this.p = p;
	}
	public void checkKey(char key) {
		if(key=='d') {
			Main.rec1.setColor(p.color(255,255,255));
			for (Note note : Main.notes) {
				if (note.y <=600&&note.y>=500&&(int)note.pos==0) {
					Main.notes.remove(note);
					Main.score++;
					break;
				} else {
					Main.score = 0;
				}
			}
		}
		if(key=='f') {
			Main.rec2.setColor(p.color(255,255,255));
			for (Note note : Main.notes) {
				if (note.y <=600&&note.y>=500&&(int)note.pos==1) {
					Main.notes.remove(note);
					Main.score++;
					break;
				} else {
					Main.score = 0;
				}
			}
		}
		if(key=='g') {
			Main.rec3.setColor(p.color(255,255,255));
			for (Note note : Main.notes) {
				if (note.y <=600&&note.y>=500&&(int)note.pos==2) {
					Main.notes.remove(note);
					Main.score++;
					break;
				} else {
					Main.score = 0;
				}
			}
		}
		if(key=='h') {
			Main.rec4.setColor(p.color(255,255,255));
			for (Note note : Main.notes) {
				if (note.y <=600&&note.y>=500&&(int)note.pos==3) {
					Main.notes.remove(note);
					Main.score++;
					break;
				} else {
					Main.score = 0;
				}
			}
		}
	}
	public void checkRelease(char key) {
		if(key=='d') {
			Main.rec1.setColor(p.color(150,150,150));
		}
		if(key=='f') {
			Main.rec2.setColor(p.color(150,150,150));
		}
		if(key=='g') {
			Main.rec3.setColor(p.color(150,150,150));
		}
		if(key=='h') {
			Main.rec4.setColor(p.color(150,150,150));
		}
	}
}

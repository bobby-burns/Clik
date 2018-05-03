package clik.obj;

import javax.swing.Box.Filler;

import org.omg.CORBA.PUBLIC_MEMBER;

import clik.main.Main;
import processing.core.PApplet;

public class Note {
	PApplet p;
	public int y;
	public float pos;
	public Note(PApplet parent,float pos) {
		this.p = parent;
		this.pos = pos;
		y = 0;
	}
	
	public void create() {
		switch ((int)this.pos) {
		
			case 0:
			p.fill(255);
			p.rect(0, y, 90, 30);
			break;
			
			case 1:
			p.fill(255);
			p.rect(100, y, 90, 30);
			break;
				
			case 2:
			p.fill(255);
			p.rect(200, y, 90, 30);
			break;
				
			case 3:
			p.fill(255);
			p.rect(300, y, 90, 30);
			break;
		}
	}
	public Note getNote() {
		return this;
	}
	public void update() {
		this.y += Main.speed * Main.delta;
	}
	
}

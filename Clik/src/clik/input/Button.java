package clik.input;

import clik.main.Main;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;


public class Button {
	PApplet p;
	int w;
	int h;
	int x;
	int y;
	int offsetX;
	int offsetY;
	int difficulty;
	int curColor;
	Boolean song;
	String label;
	
	public Button(PApplet parent,int x,int y,int w,int h,String text,Integer offX,Integer offY, Integer difficulty, Boolean song) {
		this.p = parent;
		this.w = w;
		this.h = h;
		this.x = x;
		this.y = y;
		this.label = text;
		this.offsetX = offX != null ? offX : 0;
		this.offsetY = offY != null ? offY : 0; 
		this.difficulty = difficulty != null ? difficulty : Main.difficulty;
		this.song = song != null ? song : false;
		this.curColor = parent.color(155);
		p.registerMethod("mouseEvent", this);
	}
	
	public void Display() {
		if(Main.selectedButton != this) this.curColor = 150;
		p.fill(curColor);
		p.rect(x, y, w, h);
		p.fill(0);
		p.text(this.label,x+offsetX,y+offsetY);
		p.fill(255);
	}
	public void mouseEvent(MouseEvent e) {
		
		//checks if the user clicked inside the button contraints
		if (e.getX()>=this.x&&e.getX()<=this.x+this.w&&e.getY()>=this.y&&e.getY()<=this.y+this.h&&e.getButton()==p.LEFT) {
			Main.selectedButton = this;
			if (song) {
				Main.songStartTime = p.millis();
				Main.playsong = true;
			}
			Main.difficulty = difficulty;
		}

			

	}
	public void setColor(int color) {
		this.curColor = color;
	}
}


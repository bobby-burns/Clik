package clik.obj;


import processing.core.PApplet;

public class Receptor {
	PApplet p;
	int x;
	int curColor;
	
	public Receptor(PApplet parent,int xpos) {
		this.p = parent;
		this.x = xpos;
		curColor = parent.color(150,150,150);
	}
	public void display() {
		p.rectMode(p.CORNER);
		p.fill(curColor);
		p.rect(x,500,90,100);
	}
	public void setColor(int color) {
		curColor = color;
	}
	
}

package clik.input;

import clik.main.Main;
import processing.core.PApplet;

public class SongLoader {
	PApplet p;
	public static String[] file;
	
	public SongLoader(PApplet parent) {
		this.p = parent;
		file = parent.loadStrings("../resources/song.txt");
	}
}

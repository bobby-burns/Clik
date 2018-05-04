package clik.main;

import java.awt.print.Printable;
import java.util.ArrayList;
import clik.input.Button;
import clik.input.Keyhandler;
import clik.input.SongLoader;
import clik.input.SoundHandler;
import clik.obj.Note;
import clik.obj.Receptor;
import processing.core.*;


public class Main extends PApplet{
	
	//Maximum FPS, does not affect the game unless it goes below 120, can be set to anything above 120 (higher = better, don't go above 200)
	public static final int FPS = 144;
	
	//Gamespeed, the framerate at which the game runs on
	public static final int GAMESPEED = 120;
	
	//main game start/stop
	public static boolean running = false;
	
	//Arraylist containing all notes on screen
	public static ArrayList<Note> notes = new ArrayList<Note>();
	
	//DeltaTime, a calculation used in games so that the game doesn't run based on cpu preformance
	public static float delta;
	
	//other game variables
	public static int difficulty = 150;
	public static int speed = 7;
	public static boolean genstart = true;;
	private Note toRemove;
	public static int score = 0;
	float deltadiv,startTime;
	public static float songStartTime;
	public static boolean playsong = false;

	//obj inits
	public static Receptor rec1,rec2,rec3,rec4;
	Keyhandler handler;
	SongLoader loader;
	Button b1;
	Button b2;
	Button b3;
	Button b4;

	
	public static void main(String[] args) {
		//Initialize processing core with this class
		PApplet.main("clik.main.Main");
	}
	
	public void settings() {
		size(500,600);
	}
	
	public void setup() {
		//set framerate
		frameRate(FPS);
		//loading text
		background(0);
		textSize(36);  
		textAlign(CENTER);
		text("Loading...",width/2,height/2);
		textAlign(CORNER);
		//asign obj's
		rec1 = new Receptor(this, 0);rec2 = new Receptor(this, 100);rec3 = new Receptor(this, 200);rec4 = new Receptor(this, 300);
		handler = new Keyhandler(this);
		
		//Custom made button class,
		b1 = new Button(this,420,80,60,30,"Easy",15,20,500,null); 
		//PARAMS: PApplet parent, x, y, width, height, label, labelOffsetX, labelOffsetY, difficulty (for no offset or difficulty use null)
		
		b2 = new Button(this,420,120,60,30,"Hard",15,20,300,null);
		b3 = new Button(this,420,160,60,30,"Insane",10,20,300,null);
		b4 = new Button(this,420,200,60,30,"Song",15,20,null,true);
		
		loader = new SongLoader(this);
		//start note generation
		thread("gen");
		startTime = millis();
		songStartTime = millis();


		
	}
	
	public void draw() {
		background(0);
		
		//custom DeltaTime calculation
		deltadiv = startTime / millis();
		delta = (120/frameRate) * deltadiv;
		startTime = millis();
		
		//display and update notes
		try {
		for(Note note : notes) { 
			note.create();
			note.update();
			
			if(note.y >= 600) {
				toRemove = note;
				if(score>=10) {
					Keyhandler.s.playComboBreak();
				}
				score = 0;
				thread("deleteNote");
			}
			}}
		catch(Exception e) {
			System.out.println("Overload Warning: May cause flashing!");
		}
		
		//display receptor's
		rec1.display();rec2.display();rec3.display();rec4.display();
		
		//display buttons
		b1.Display();b2.Display();b3.Display();b4.Display();
		
		//display text
		textSize(24);
		textAlign(CENTER);
		text("Combo: "+score,220,200);
		textAlign(CORNER);
		textSize(12);
		text("Debug Stats:", 420, 15);
		text("Array Size: "+notes.size(),420,30);
		text("FPS: "+(int)frameRate,420,45);
		text("Delta: "+String.valueOf(delta).substring(0, 5),420,60);
		
		
	}
	
	public void keyPressed() {
		handler.checkKey(key);
	}
	
	public void keyReleased() {
		handler.checkRelease(key);
	}
	public void gen() {
		int curindex = 0;
		while(genstart) {
			//THIS NEEDS IMPROVEMENT, ITS VERY MESSY
			if(playsong) {
				try {
					if (Float.parseFloat(split(SongLoader.file[curindex],",")[0])>=(millis()-songStartTime) - 10 && Float.parseFloat(split(SongLoader.file[curindex],",")[0])<=(millis()-songStartTime) + 10)
					{
						float pos = Float.parseFloat(split(SongLoader.file[curindex],",")[1]);
						notes.add(new Note(this, pos).getNote());
						curindex++;
					}
				} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Song has ended");
				playsong = false;
			}
		}
		if(!playsong) {
		delay(difficulty);
		notes.add(new Note(this, random(0,4)).getNote());
		}
	}
}
	public void deleteNote() {
		notes.remove(toRemove);
	}

}

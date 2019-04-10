/*
Student Name: Igor Bolek
Student Number: C17487376
*/

package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import processing.core.PVector;

public class UI extends PApplet

{
	public ArrayList<Colour> colours;
	public ArrayList<Resistor> resistors;

	//Colours
	public void loadColours(){
		Table t = loadTable("colours.csv", "header");
		for(TableRow r : t.rows()) {
			Colour colour = new Colour(r);
			colours.add(colour);
		}
	}

	public Colour findColour(int value){
		Colour c = colours.get(value);
		return c;
	}

	public void printColours() {
		for(Colour c : colours){
			System.out.println(c.toString());
		}
	}

	//Resistors
	public void loadResistors(){
		Table t = loadTable("resistors.csv");
		for(TableRow r : t.rows()){
			Resistor res = new Resistor(r.getInt(0));
			resistors.add(res);
		}
	}




	//Processing Main Loop + Settings:
	public void settings() {
		size(500, 800);
	}

	public void setup() {
		colours = new ArrayList<Colour>();
		resistors = new ArrayList<Resistor>();
		loadColours();

		System.out.println("Printing colours:");
		printColours();

		System.out.println("\n\nPrinting resistors (100,10,1):");
		loadResistors();
	}

	public void draw() {
		background(180);

		float offset = 0;

		for(Resistor r : resistors){
			r.render(offset);
			offset += 150;
		}
	}







	public class Resistor{
		public int value;
		public int ones;
		public int tens;
		public int hundreds;
	
		public Resistor(int value) {
			this.value = value;
			hundreds = (value / 100);
			tens = (value - (hundreds * 100)) / 10;
			ones = value - ((hundreds * 100) + (tens * 10));
	
			System.out.print(hundreds + ",");
			System.out.print(tens + ",");
			System.out.println(ones);
		}
	
		public void render(float offset){
			float halfW = width/2;
			float halfH = height/2;
			PVector start = new PVector(halfW-150, halfH * 0.2f + offset);

			Colour h = findColour(hundreds);
			Colour t = findColour(tens);
			Colour o = findColour(ones);

			stroke(0);
			line(start.x, start.y, start.x + 60, start.y);
			noFill();
			square(start.x +60, start.y - 50, 100);
			line(start.x + 160, start.y, start.x + 220, start.y);
			noStroke();
			fill(h.r, h.g, h.b);
			rect(start.x +70, start.y -50, 10, 100);
			fill(t.r, t.g, t.b);
			rect(start.x +90, start.y -50, 10, 100);
			fill(o.r, o.g, o.b);
			rect(start.x +110, start.y -50, 10, 100);

			textSize(24);
			fill(0);
			text(value, start.x + 260, start.y + (24/2));
		
			
		}
	}


	public class Colour {
		public int r;
		public int g;
		public int b;
		public int value;
		private String colour;
	
		//Constructors
		public Colour(int r, int g, int b, int value, String colour){
			this.r = r;
			this.g = g;
			this.b = b;
			this.value = value;
			this. colour = colour;
		}
		public Colour(TableRow r){
			this(r.getInt("r"), r.getInt("g"), r.getInt("b"), r.getInt("value"), r.getString("colour"));
		}
	
		public String toString(){
			return colour;
		}
	
		//accessor
		public String getColour() {
			return colour;
		}
	}


}

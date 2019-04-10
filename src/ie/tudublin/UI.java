package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet

{
	public ArrayList<Colour> colours;

	public void separate(int value) {
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100) + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void loadColours(){
		Table t = loadTable("colours.csv", "header");
		for(TableRow r : t.rows()) {
			Colour colour = new Colour(r);
			colours.add(colour);
		}
	}

	public void settings() {
		size(500, 800);

		separate(381);
		separate(1);
		separate(92);
	}

	public void setup() {
		colours = new ArrayList<Colour>();
	}

	public void draw() {
	}


}

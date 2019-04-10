package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;

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
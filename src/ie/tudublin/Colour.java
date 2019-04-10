package ie.tudublin;

import processing.data.Table;
import processing.data.TableRow;

public class Colour {
	public int r;
	public int g;
	public int b;
	public int value;
	private String colour;

	public Colour(TableRow r){
		this.r = r.getInt("r");
		g = r.getInt("g");
		b = r.getInt("b");
		colour = r.getString("colour");
		value = r.getInt("value");
		
	}

	public String toString(){
		return colour;
	}

	//accessor
	public String getColour() {
		return colour;
	}
}
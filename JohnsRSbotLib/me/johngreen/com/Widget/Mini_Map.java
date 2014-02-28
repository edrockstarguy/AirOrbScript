package me.johngreen.com.Widget;

public enum Mini_Map {
	Map(9),
	LoadStone(10),
	Compass(6),
	Toggle_Run(1);
	
	private int componant;
	private Mini_Map(int componant){
		this.componant = componant;
	}
	public int getID(){
		return componant;
	}
}

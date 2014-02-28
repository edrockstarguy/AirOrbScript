package me.johngreen.com;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Tile;

public class Player {
	public static MethodContext ctx;
	
	public static int getX(){
		return ctx.players.local().getLocation().getX();
	}
	public static int getY(){
		return ctx.players.local().getLocation().getY();
	}
	public static Tile getLocation(){
		return ctx.players.local().getLocation();
	}
	public static boolean isBeingAttacked(){
		return ctx.players.local().isInCombat();
	}
	
	public static boolean isMoving(){
		return ctx.players.local().isInMotion();
	}
	
}

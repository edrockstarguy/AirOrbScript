package me.johngreen.com.airorbs;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.CollisionFlag;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

public class PathFinder {

	
	public static int getDistanceTo(MethodContext ctx,Tile t1, Tile t2){
		return ctx.movement.getDistance(t1, t2);
	}
	public static void walkTo(MethodContext ctx,Tile t1){
		if(!ctx.players.local().isInMotion()){
			ctx.movement.stepTowards(t1);
		}
	}
	public static boolean isInRegion(Tile playerLoc,Area a){
		return a.contains(playerLoc);
	}
	public static boolean isInRegion(Tile playerLoc,Tile pos1, Tile pos2){
		  int ax = pos1.getX();
		  int ay = pos1.getY();
		  int bx = pos2.getX();
		  int by = pos2.getY();
		  int px = playerLoc.getX();
		  int py = playerLoc.getY();
		  if(ax>=bx){
			  if(ay>=by){
				  if(px>=bx&&px<=ax&&py>=by&&py<=ay){
					  return true;
				  }else{
					  return false;
				  }
			  }else if(ay<=by){
				  if(px>=bx&&px<=ax&&py<=by&&py>=ay){
					  return true;
				  }else{
					  return false;
				  }
			  }
			  return false;
		  }else{
			  if(ay>=by){
				  if(px<=bx&&px>=ax&&py>=by&&py<=ay){
					  return true;
				  }else{
					  return false;
				  }  
			  }else if(ay<=by){
				  if(px<=bx&&px>=ax&&py<=by&&py>=ay){
					  return true;
				  }else{
					  return false;
				  }
			  }
			  return false;
		  }
	}
}

package JobsAirOrbs;

import me.johngreen.com.Player;
import me.johngreen.com.Teleport;
import me.johngreen.com.airorbs.Settings;

import org.powerbot.script.methods.Bank.Amount;
import org.powerbot.script.methods.Equipment.Slot;
import org.powerbot.script.methods.Lobby.Tab;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.Widgets;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Tile;

import Core.Job;

public class Alter extends Job{

	public Alter(MethodContext ctx) {
		super(ctx);
	}
	@Override
	public boolean validate() {
		if(Player.isBeingAttacked()){
			return false;
		}
		Tile WayToAlterPath1_Pos1 = new Tile(3080,3574,0);
		Tile WayToAlterPath1_Pos2 = new Tile(3091,3566,0);
		if(isInRegion(ctx.players.local().getLocation(), WayToAlterPath1_Pos1,WayToAlterPath1_Pos2)){
		return true;	
		}
		return false;
	}


	public void execute() {
		Tile WayToAlterPath1_Pos1 = new Tile(3080,3574,0);
		Tile WayToAlterPath1_Pos2 = new Tile(3091,3566,0);
		if(isInRegion(ctx.players.local().getLocation(), WayToAlterPath1_Pos1,WayToAlterPath1_Pos2)){
			
			Widgets w = new Widgets(ctx);
			if(!ctx.backpack.select().id(Settings.CosmicRuneID).isEmpty()&&!ctx.backpack.select().id(Settings.OrbID).isEmpty()){
				if(!w.get(1251, 0).isValid()){
					if(!w.get(1370, 20).isValid()){
						w.get(1430, 14).click();
						final GameObject object = ctx.objects.select().id(Settings.Alter).nearest().poll();
						if(object.isInViewport()){
							object.click();
						}
					}else{
						w.get(1370, 20).click();
					}
				}
			}
				
			if(!ctx.backpack.select().id(Settings.AirOrbID).isEmpty()&&!w.get(1251, 0).isValid()){
				
				if(!Teleport.isTeleporting(ctx)){
					Settings.Status ="Clicking EdgeVill";	
					if(Teleport.isTeleportMenuOpen(ctx)){
						Teleport.EDGEVILL.teleport(ctx);
						Settings.Status ="Teleporting";		
					}else{
						Teleport.openMenu(ctx);
						Settings.Status ="Click";	
					}
				}
			

			}
		}
	}
	private static boolean isInRegion(Tile playerLoc,Tile pos1, Tile pos2){
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

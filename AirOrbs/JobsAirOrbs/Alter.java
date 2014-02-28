package JobsAirOrbs;

import java.util.concurrent.Callable;

import me.johngreen.com.Player;
import me.johngreen.com.Widget.Teleport;
import me.johngreen.com.airorbs.PathFinder;
import me.johngreen.com.airorbs.Settings;

import org.powerbot.script.methods.Bank.Amount;
import org.powerbot.script.methods.Equipment.Slot;
import org.powerbot.script.methods.Lobby.Tab;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.Widgets;
import org.powerbot.script.util.Condition;
import org.powerbot.script.util.Random;
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
		if(PathFinder.isInRegion(ctx.players.local().getLocation(), new Area(Settings.Alter_Pos2,Settings.Alter_Pos1))){
		return true;	
		}
		return false;
	}
	private boolean isMakingOrbs(){
		Widgets w = new Widgets(ctx);
		return w.get(1251, 0).isValid();
	}						

	public void execute() {
			Widgets w = new Widgets(ctx);
			if(!ctx.backpack.select().id(Settings.CosmicRuneID).isEmpty()&&!ctx.backpack.select().id(Settings.OrbID).isEmpty()){
				Settings.Status = "1";
				if(!isMakingOrbs()){
					if(!w.get(1370, 20).isValid()){
						w.get(1430, 14).click();
						final GameObject object = ctx.objects.select().id(Settings.Alter).nearest().poll();
						if(object.isInViewport()){
							object.click();
						}
					}else{
						w.get(1370, 20).click();
					}
				}else{
					Condition.wait(new Callable<Boolean>(){
						@Override
						public Boolean call() throws Exception {
							Settings.Status = "AntiBan";
							return !isMakingOrbs();
						}
						
					},1500+Random.nextInt(1, 2000),3);
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

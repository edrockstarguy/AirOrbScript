package JobsAirOrbs;

import java.util.ArrayList;

import me.johngreen.com.Player;
import me.johngreen.com.Widget.Teleport;
import me.johngreen.com.airorbs.PathFinder;
import me.johngreen.com.airorbs.Settings;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Calculations;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

import Core.Job;
import Core.JobContainer;

public class WalkingToAlter extends Job{

	public WalkingToAlter(MethodContext ctx) {
		super(ctx);
	}
	@Override
	public boolean validate() {
		if(Player.isBeingAttacked()&&Player.getHealthPersentage()<50.0){
			Settings.Status = "Teleporting away";
			return false;
		}
		if(PathFinder.isInRegion(ctx.players.local().getLocation(), Settings.Alter_Pos1,Settings.Alter_Pos2)||
		PathFinder.isInRegion(ctx.players.local().getLocation(), Settings.Bank_Pos2, Settings.Bank_Pos1)||
		!ctx.backpack.select().id(Settings.AirOrbID).isEmpty()){
		return false;	
		}
		return true;
	}


	public void execute() {
		Settings.Areas = new ArrayList<String>();
		
		if(!Player.isMoving()&&ctx.players.local().getAnimation()!=828){
			if(PathFinder.isInRegion(Player.getLocation(), Settings.ladder1)){
				Settings.Areas.add("area1");
				Settings.Areas.add("ladder1");
				//ladder shit
				final GameObject LadderOpen = ctx.objects.select().id(Settings.Ladder1ID).nearest().poll();
				final GameObject LadderClosed = ctx.objects.select().id(Settings.Ladder1ID_Closed).nearest().poll();
				if(LadderOpen.isInViewport()){
					ctx.camera.turnTo(LadderOpen);
					LadderOpen.interact("Climb-down");
				}else if(LadderClosed.isInViewport()){
					ctx.camera.turnTo(LadderClosed);
					LadderClosed.interact("Open");
				}
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.area1)){
				Settings.Areas.add("area1");
				//walk to ladder
				PathFinder.walkTo(ctx, Settings.ladder1.getRandomTile());
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.gate1)){
				//ladder shit
				Settings.Areas.add("area2");
				Settings.Areas.add("Gate1");
				final GameObject GateOpen = ctx.objects.select().id(Settings.Gate1_ID1).nearest().poll();
				final GameObject GateClosed = ctx.objects.select().id(Settings.Gate1_ID1_Closed).nearest().poll();
				if(GateOpen.isInViewport()){
					PathFinder.walkTo(ctx, Settings.gate2.getRandomTile());
				}else if(GateClosed.isInViewport()){
					ctx.camera.turnTo(GateClosed);
					GateClosed.interact("Open");
				}
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.area2)){
				Settings.Areas.add("area2");
				//walk to ladder
				PathFinder.walkTo(ctx, Settings.gate1.getRandomTile());
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.gate2)){
				//ladder shit
				Settings.Areas.add("area3");
				Settings.Areas.add("gate2");
				final GameObject GateClosed = ctx.objects.select().id(Settings.Gate2_ID1_Closed).nearest().poll();
				if(GateClosed.isInViewport()){
					GateClosed.interact("Open");
				}
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.area3)){
				Settings.Areas.add("area3");
				//walk to ladder
				PathFinder.walkTo(ctx, Settings.gate2.getRandomTile());
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.halfwaypoint1)){
				PathFinder.walkTo(ctx, Settings.ladder2.getRandomTile());
				Settings.Areas.add("area4");
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.area4)){
				Settings.Areas.add("area4");
				//walk to ladder
				PathFinder.walkTo(ctx, Settings.halfwaypoint1.getRandomTile());
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.ladder2)){
				//ladder shit
				Settings.Areas.add("area5");
				Settings.Areas.add("ladder2");
				final GameObject Ladder2 = ctx.objects.select().id(Settings.Ladder2ID).nearest().poll();
				if(Ladder2.isInViewport()){
					Ladder2.interact("Climb-up");
				}
			}else if(PathFinder.isInRegion(Player.getLocation(), Settings.area5)){
				Settings.Areas.add("area5");
				//walk to ladder
				PathFinder.walkTo(ctx, Settings.ladder2.getRandomTile());
			}
		}
		
	}
	
}

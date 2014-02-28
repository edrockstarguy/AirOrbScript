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
		if(Player.isBeingAttacked()){
			return false;
		}
		Tile WayToAlterPath1_Pos1 = new Tile(3080,3574,0);
		Tile WayToAlterPath1_Pos2 = new Tile(3091,3566,0);
		
		Tile WayToAlterPath2_Pos1 = new Tile(3090,3500,0);
		Tile WayToAlterPath2_Pos2 = new Tile(3099,3487,0);
		if(PathFinder.isInRegion(ctx.players.local().getLocation(), WayToAlterPath1_Pos1,WayToAlterPath1_Pos2)||
		PathFinder.isInRegion(ctx.players.local().getLocation(), WayToAlterPath2_Pos1, WayToAlterPath2_Pos2)||
		!ctx.backpack.select().id(Settings.AirOrbID).isEmpty()){
		return false;	
		}
		return true;
	}


	public void execute() {
		Settings.Areas = new ArrayList<String>();
		Area ladder1 = new Area(new Tile(3097,3467),new Tile(3092,3473));
		Area gate1 = new Area(new Tile(3104,9912),new Tile(3101,9906));
		Area gate2 = new Area(new Tile(3134,9916),new Tile(3130,9914));
		Area halfwaypoint1 = new Area(new Tile(3132,9941),new Tile(3134,9946));
		Area ladder2 = new Area(new Tile(3093,9973),new Tile(3086,9965));
		
		Area area1 = new Area(new Tile(3100,3489),new Tile(3081,3465));
		Area area2 = new Area(new Tile(3104,9915),new Tile(3090,9867));
		Area area3 = new Area(new Tile(3142,9917),new Tile(3104,9907));
		Area area4 = new Area(new Tile(3133,9918),new Tile(3123,9952));
		Area area5 = new Area(new Tile(3122,9948),new Tile(3080,9973));
		
		if(!Player.isMoving()&&ctx.players.local().getAnimation()!=828){
			if(PathFinder.isInRegion(Player.getLocation(), ladder1)){
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
			}else if(PathFinder.isInRegion(Player.getLocation(), area1)){
				Settings.Areas.add("area1");
				//walk to ladder
				PathFinder.walkTo(ctx, ladder1.getRandomTile());
			}else if(PathFinder.isInRegion(Player.getLocation(), gate1)){
				//ladder shit
				Settings.Areas.add("area2");
				Settings.Areas.add("Gate1");
				final GameObject GateOpen = ctx.objects.select().id(Settings.Gate1_ID1).nearest().poll();
				final GameObject GateClosed = ctx.objects.select().id(Settings.Gate1_ID1_Closed).nearest().poll();
				if(GateOpen.isInViewport()){
					PathFinder.walkTo(ctx, gate2.getRandomTile());
				}else if(GateClosed.isInViewport()){
					ctx.camera.turnTo(GateClosed);
					GateClosed.interact("Open");
				}
			}else if(PathFinder.isInRegion(Player.getLocation(), area2)){
				Settings.Areas.add("area2");
				//walk to ladder
				PathFinder.walkTo(ctx, gate1.getRandomTile());
			}else if(PathFinder.isInRegion(Player.getLocation(), gate2)){
				//ladder shit
				Settings.Areas.add("area3");
				Settings.Areas.add("gate2");
				final GameObject GateClosed = ctx.objects.select().id(Settings.Gate2_ID1_Closed).nearest().poll();
				if(GateClosed.isInViewport()){
					GateClosed.interact("Open");
				}
			}else if(PathFinder.isInRegion(Player.getLocation(), area3)){
				Settings.Areas.add("area3");
				//walk to ladder
				PathFinder.walkTo(ctx, gate2.getRandomTile());
			}else if(PathFinder.isInRegion(Player.getLocation(), halfwaypoint1)){
				PathFinder.walkTo(ctx, ladder2.getRandomTile());
				Settings.Areas.add("area4");
			}else if(PathFinder.isInRegion(Player.getLocation(), area4)){
				Settings.Areas.add("area4");
				//walk to ladder
				PathFinder.walkTo(ctx, halfwaypoint1.getRandomTile());
			}else if(PathFinder.isInRegion(Player.getLocation(), ladder2)){
				//ladder shit
				Settings.Areas.add("area5");
				Settings.Areas.add("ladder2");
				final GameObject Ladder2 = ctx.objects.select().id(Settings.Ladder2ID).nearest().poll();
				if(Ladder2.isInViewport()){
					Ladder2.interact("Climb-up");
				}
			}else if(PathFinder.isInRegion(Player.getLocation(), area5)){
				Settings.Areas.add("area5");
				//walk to ladder
				PathFinder.walkTo(ctx, ladder2.getRandomTile());
			}
		}
		
	}
	
}

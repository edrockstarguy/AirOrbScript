package JobsAirOrbs;

import me.johngreen.com.airorbs.PathFinder;
import me.johngreen.com.airorbs.Settings;

import org.powerbot.script.methods.Bank.Amount;
import org.powerbot.script.methods.Equipment.Slot;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Item;
import org.powerbot.script.wrappers.Tile;

import Core.Job;

public class Banking extends Job{

	public Banking(MethodContext ctx) {
		super(ctx);
	}
	private int bankingId  = 0;
	@Override
	public boolean validate() {
		  if(PathFinder.isInRegion(ctx.players.local().getLocation(), Settings.Bank_Pos1, Settings.Bank_Pos2)){
			  return true;
		  }
			  return false;
		  
	}


	public void execute() {
		
		
		
	}

	
}

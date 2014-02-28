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
	@Override
	public boolean validate() {
			Tile WayToAlterPath1_Pos1 = new Tile(3090,3500,0);
			Tile WayToAlterPath1_Pos2 = new Tile(3099,3487,0);
		  if(PathFinder.isInRegion(ctx.players.local().getLocation(), WayToAlterPath1_Pos1, WayToAlterPath1_Pos2)){
			  return true;
		  }else{
			  return false;
		  }
	}


	public void execute() {
		boolean isInBank = ctx.bank.isOpen();
		int exuipmentCount = ctx.equipment.count();
		Item wepon = ctx.equipment.getItemAt(Slot.MAIN_HAND);
		Settings.Status = "Banking";
		
	}

	
}

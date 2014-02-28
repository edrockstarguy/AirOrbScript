package JobsAirOrbs;

import me.johngreen.com.Player;
import me.johngreen.com.airorbs.Settings;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Item;

import Core.Job;

public class AvoidDeath extends Job{

	public AvoidDeath(MethodContext ctx) {
		super(ctx);
	}
	@Override
	public boolean validate() {
		return true;
	}


	public void execute() {
		if(Player.isBeingAttacked()&&!ctx.backpack.select().id(Settings.CamalotTeleportID).isEmpty()){
			final Item item = ctx.backpack.select().id(Settings.CamalotTeleportID).poll();
			item.click();
		}
	}
	
}
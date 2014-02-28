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
		if(!isInBank){
			if(wepon.getId() == Settings.AirBattleStaffID||wepon.getId() == Settings.StaffOfAirID){
				if(ctx.backpack.getItemAt(0)!=null&&ctx.backpack.getItemAt(1)!=null&&ctx.backpack.getItemAt(2)!=null){
					Item i1 = ctx.backpack.getItemAt(0);
					Item i2 = ctx.backpack.getItemAt(1);
					Item i3 = ctx.backpack.getItemAt(2);
					if(i1.getId()!=Settings.CosmicRuneID||i2.getId()!=Settings.CamalotTeleportID||i3.getId()!=Settings.OrbID){
						ctx.bank.open();
						System.out.println("6");
					}else{
						if(!ctx.backpack.select().id(Settings.AirOrbID).isEmpty()){
							ctx.bank.open();
							System.out.println("5");
						}else{
							if(i1.getStackSize()!=78){
							ctx.bank.open();
							System.out.println("4");
							}else{
								Item i28 = ctx.backpack.getItemAt(27);
									//ready to walk
									System.out.println("Ready");
									Area area = new Area(new Tile(3090,3471,0),new Tile(3099,3465,0));
									if(!ctx.players.local().isInMotion()){
										ctx.movement.stepTowards(area.getRandomTile().getLocation());
										Settings.Status = "Moving to ladder";
									}
								
							}
						}
					}
				}else{
					ctx.bank.open();
					System.out.println("2");
				}
			}else{
				ctx.bank.open();
				System.out.println("1");
			}
		}else{
			if(wepon!=null){
				if(wepon.getId() != Settings.AirBattleStaffID&&wepon.getId() != Settings.StaffOfAirID){
					if(!ctx.bank.select().id(Settings.AirBattleStaffID).isEmpty()){
						ctx.bank.withdraw(Settings.AirBattleStaffID, 1);
					}else if(!ctx.bank.select().id(Settings.StaffOfAirID).isEmpty()){
						ctx.bank.withdraw(Settings.StaffOfAirID, 1);
					}else{
						System.out.println("No Staffs");
					}
				}
			}
			if(!ctx.backpack.select().id(Settings.AirOrbID).isEmpty()){
				ctx.bank.depositInventory();
				return;
			}else{
				Item i = ctx.backpack.getItemAt(0);
				if(ctx.backpack.select().id(Settings.CosmicRuneID).isEmpty()){
					ctx.bank.withdraw(Settings.CosmicRuneID, 78);
				}else if(i.getStackSize()!=78){
					ctx.bank.withdraw(Settings.CosmicRuneID, 78-i.getStackSize());
				}else{
					if(ctx.backpack.select().id(Settings.CamalotTeleportID).isEmpty()){
						ctx.bank.withdraw(Settings.CamalotTeleportID, 1);
					}else{
						if(ctx.backpack.select().id(Settings.OrbID).isEmpty()){
							ctx.bank.withdraw(Settings.OrbID, Amount.ALL);
						}else{
							ctx.bank.close();
						}
					}
				}
			}
		}
		
	}

	
}

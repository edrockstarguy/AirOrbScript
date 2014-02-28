package me.johngreen.com;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.Widgets;

public enum Teleport {
CANFIS(34,true),
AL_KHARID(21,false),
VARROCK(32,false),
LUMBRIDGE(28,false),
BANDIT_CAMP(9,true),
DRAYNOR_VILLAGE(25,false),
EDGEVILL(26,false),
FALADOR(27,false),
PORT_SARIM(29,true),
TAVERLEY(31,true),
BURTHORPE(23,true),
KARAMAJA(37,true),
CATHERBY(24,true),
WILDERNESS_VOLCAINO(40,true),
FREMENNIK_PROVINCE(36,true),
SEERS_VILLAGE(30,true),
ARDOUGNE(22,true),
YANILLE(33,true),
OO_GLOG(38,true),
EGALS_PEEK(35,true),
TIRANNWN(39,true),
LUNAR_ISLAND(20,true);

	private int id;
	private boolean members;
	
	private Teleport(int id, boolean members){
		this.id = id;
		this.members = members;
	}
	
	public int getID(){
		return id;
	}
	public boolean isMembersTeleport(){
		return members;
	}
	public static void openMenu(MethodContext ctx){
		Widgets w = new Widgets(ctx);
		w.get(1465, 11).click();
	}
	public static boolean isTeleportMenuOpen(MethodContext ctx){
		Widgets w = new Widgets(ctx);
		return w.get(1092).getComponent(11).isInViewport();
	}
	public void teleport(MethodContext ctx){
		Widgets w = new Widgets(ctx);
		w.get(1092, id).click();
	}
	public static boolean isTeleporting(MethodContext ctx){
		return ctx.players.local().getAnimation() == 21288||
				ctx.players.local().getAnimation() == 16385;
	}
	//example
	/*if(!Teleport.isTeleporting(ctx)){
		if(Teleport.isTeleportMenuOpen(ctx)){
			Teleport.AL_KHARID.teleport(ctx);
		}else{
			Teleport.openMenu(ctx);
		}
	}*/
}

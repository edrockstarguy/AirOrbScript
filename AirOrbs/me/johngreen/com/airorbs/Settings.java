package me.johngreen.com.airorbs;

import java.util.ArrayList;

import org.powerbot.script.wrappers.Area;
import org.powerbot.script.wrappers.Tile;

public class Settings {
public static boolean Clicked = false;
public static final int AirOrbID = 573;
public static final int OrbID = 567;
public static final int CosmicRuneID = 564;
public static final int CamalotTeleportID = 8010;
public static final int StaffOfAirID = 1381;
public static final int AirBattleStaffID = 1397;

public static final int Gate1_ID1_Closed = 29315;
public static final int Gate1_ID2_Closed = 29316;
public static final int Gate1_ID1 = 29317;
public static final int Gate1_ID2 = 29318;

public static final int Gate2_ID1_Closed = 29319;
public static final int Gate2_ID2_Closed = 29320;


public static final int Ladder1ID = 26934;
public static final int Ladder1ID_Closed = 26933;

public static final int Ladder2ID = 29355;

public static final int Alter = 2152;

public static final boolean timerStarted = false;
public static String Status;
public static ArrayList<String> Areas = new ArrayList<String>();



//areas

public static final Tile Bank_Pos1 = new Tile(3090,3500,0);
public static final Tile Bank_Pos2 = new Tile(3099,3487,0);

public static final Tile Alter_Pos1 = new Tile(3080,3574,0);
public static final Tile Alter_Pos2 = new Tile(3091,3566,0);



public static final Area ladder1 = new Area(new Tile(3097,3467),new Tile(3092,3473));
public static final Area gate1 = new Area(new Tile(3104,9912),new Tile(3101,9906));
public static final Area gate2 = new Area(new Tile(3134,9916),new Tile(3130,9914));
public static final Area halfwaypoint1 = new Area(new Tile(3132,9941),new Tile(3134,9946));
public static final Area ladder2 = new Area(new Tile(3093,9973),new Tile(3086,9965));

public static final Area area1 = new Area(new Tile(3100,3489),new Tile(3081,3465));
public static final Area area2 = new Area(new Tile(3104,9915),new Tile(3090,9867));
public static final Area area3 = new Area(new Tile(3142,9917),new Tile(3104,9907));
public static final Area area4 = new Area(new Tile(3133,9918),new Tile(3123,9952));
public static final Area area5 = new Area(new Tile(3122,9948),new Tile(3080,9973));
}

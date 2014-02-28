package me.johngreen.com.Widget;

import org.powerbot.script.methods.MethodContext;

public enum Widget {
	MINI_MAP(1465);
	
	
	private int id;
	private Widget(int ID){
		this.id = ID;
	}
	
	public int getID(){
		return id;
	}
	public void click(MethodContext ctx,int child){
		ctx.widgets.get(id,child).click();
	}
	public static boolean isOnScreen(MethodContext ctx,int id,int component,int child){
		return ctx.widgets.get(id).getComponent(component).getChild(child).isValid();
	}
	public static boolean isOnScreen(MethodContext ctx,int id,int child){
		return ctx.widgets.get(id,child).isValid();
	}
	public static boolean isOnScreen(MethodContext ctx,int id){
		return ctx.widgets.get(id).isValid();
	}
}

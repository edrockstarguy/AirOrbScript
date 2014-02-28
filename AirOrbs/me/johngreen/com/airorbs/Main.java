package me.johngreen.com.airorbs;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import me.johngreen.com.Player;

import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Random;

import Core.Job;
import Core.JobContainer;
import JobsAirOrbs.Alter;
import JobsAirOrbs.AvoidDeath;
import JobsAirOrbs.Banking;
import JobsAirOrbs.WalkingToAlter;

@Manifest(name = "AirOrbs", description = "Crafts AirOrbs in edgevill" , version = 1.0)
public class Main extends PollingScript implements PaintListener{

	public JobContainer jc = new JobContainer();
	
	public Main(){
		jc = new JobContainer(new Banking(ctx),new WalkingToAlter(ctx),new Alter(ctx),new AvoidDeath(ctx));
		Player.ctx = ctx;
	}
	
	@Override
	public int poll() {
		//gets all the jobs
		Job j = jc.get();
		//checks if they are ready
		if(j!=null){
			//exicutes
			j.execute();
		}
		//time out between script commands like, clicking on the bank
		return Random.nextInt(450, 780);
	}


	@Override
	public void repaint(Graphics g2) {
		Graphics2D g = (Graphics2D) g2;
		 g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.8F));
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(50, 50, 180, 200);
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(2));
		g.drawRect(50, 50, 180, 200);
		g.drawRect(50, 50, 180, 12);
		g.drawString("Air Orbs", 60, 60);
		g.drawString("V.1.1", 170, 60);
		g.drawString("Status: "+Settings.Status, 60, 75);
		if(Settings.Areas!=null){
		g.drawString("Area's inside: "+Settings.Areas.toString(), 60, 85);
		}
		g.drawString("Health persentage: "+Player.getHealthPersentage()+"%", 60, 95);
	}
	
}

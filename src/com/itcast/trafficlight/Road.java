package com.itcast.trafficlight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Road {
	private List<String> vehicles = new ArrayList<String>();
	private String direc;
	public Road(String direc) {
		this.direc = direc;
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<1000; i++) {
					try {
						Thread.sleep((new Random().nextInt(10)+1)*1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					vehicles.add(Road.this.direc+"_"+i);
				}
			}
		});
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable() {
					
					@Override
					public void run() {
						if(vehicles.size()>0) {
							boolean lighted = Lamp.valueOf(Road.this.direc).isLighted();						
							if(lighted) {
								System.out.println(vehicles.remove(0)+" is traveling!");								
							}
						}
					}
				},
				1,
				1,
				TimeUnit.SECONDS);
	}
}

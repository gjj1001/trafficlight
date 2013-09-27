package com.itcast.trafficlight;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LampController {
	private Lamp currentLamp = Lamp.S2N;
	
	
	private LampController() {}
	private static LampController lampController = null;
	public static LampController getInstance() {
		if(lampController==null) {
			lampController = new LampController();
		}
		return lampController;
	}
	
	public void start() {
		currentLamp.light();
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				new Runnable() {
					@Override
					public void run() {
						currentLamp = currentLamp.black();
					}
					
				},
				10,
				10,
				TimeUnit.SECONDS);
	}
}

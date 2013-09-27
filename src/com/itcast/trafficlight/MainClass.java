package com.itcast.trafficlight;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] directions = new String[] {"S2N","N2S","S2W","N2E","E2W","W2E","E2S","W2N","S2E","N2W","E2N","W2S"};
		for(int i=0; i<directions.length; i++) {
			new Road(directions[i]);
		}
		
		LampController.getInstance().start();

	}

}

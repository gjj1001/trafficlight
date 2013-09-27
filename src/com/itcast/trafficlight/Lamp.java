package com.itcast.trafficlight;

public enum Lamp {
	S2N("N2S",false,"S2W"),S2W("N2E",false,"E2W"),E2W("W2E",false,"E2S"),E2S("W2N",false,"S2N"),
	N2S(null,false,null),N2E(null,false,null),W2E(null,false,null),W2N(null,false,null),
	S2E(null,true,null),E2N(null,true,null),N2W(null,true,null),W2S(null,true,null);
	
	private String oppositeLampName;
	private boolean lighted;
	private String nextLampName;
	public boolean isLighted() {
		return lighted;
	}
	
	private Lamp(String oppositeLampName, boolean lighted, String nextLampName) {
		this.oppositeLampName = oppositeLampName;
		this.lighted = lighted;
		this.nextLampName = nextLampName;
		
	}
	
	public void light() {
		this.lighted = true;
		if(oppositeLampName!=null) {
			Lamp.valueOf(oppositeLampName).light();
		}
		System.out.println(name()+"为绿灯,下面总共有六个方向能看到汽车通行");
	}
	
	public Lamp black() {
		this.lighted = false;
		if(oppositeLampName!=null) {
			Lamp.valueOf(oppositeLampName).black();
		}
		Lamp nextLamp = null;
		if(nextLampName!=null) {
			nextLamp = Lamp.valueOf(nextLampName);
			System.out.println("绿灯从" + name() + "-------->切换为" + nextLampName);
			nextLamp.light();
		}
		
		return nextLamp;
		
	}
}

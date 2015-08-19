package com.thehacker.minemoney;

public class ClientProxyMineMoney extends CommonProxyMineMoney{

	@Override
	public void registerRenderers(MineMoney ins) {
		ins.mod_0.registerRenderers();
		ins.mod_1.registerRenderers();
		ins.mod_2.registerRenderers();
		ins.mod_3.registerRenderers();
		ins.mod_4.registerRenderers();
		ins.mod_5.registerRenderers();
		ins.mod_6.registerRenderers();
	}
}

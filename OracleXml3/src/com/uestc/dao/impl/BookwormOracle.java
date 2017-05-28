package com.uestc.dao.impl;

import com.uestc.dao.Encyclopedia;
import com.uestc.dao.Oracle;

public class BookwormOracle implements Oracle{
	private Encyclopedia encyclopedia;
	@Override
	public String defineMeaningOflife() {
		Integer ageOfUniverse = this.encyclopedia.findInteger("AgeOfUniverse");
		Integer constantOfLife = this.encyclopedia.findInteger("ConstantOfLife");
		return String.valueOf(ageOfUniverse.intValue()/constantOfLife.intValue());
	}
	public Encyclopedia getEncyclopedia() {
		return encyclopedia;
	}
	public void setEncyclopedia(Encyclopedia encyclopedia) {
		this.encyclopedia = encyclopedia;
	}
}

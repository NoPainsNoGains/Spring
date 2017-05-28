package com.uestc.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.uestc.dao.Encyclopedia;

public class HardcodedEncyclopedia implements Encyclopedia {
	private Map<String, Integer> entryValues = new HashMap<String, Integer>();

	public HardcodedEncyclopedia() {
		this.entryValues.put("AgeOfUniverse", 1200);
		this.entryValues.put("ConstantOfLife", 20);
	}
	@Override
	public Integer findInteger(String entry) {
		return this.entryValues.get(entry);
	}

}

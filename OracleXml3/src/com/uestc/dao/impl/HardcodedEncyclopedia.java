package com.uestc.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.uestc.dao.Encyclopedia;

public class HardcodedEncyclopedia implements Encyclopedia {
	private Map<String, Integer> entryValues = new HashMap<String, Integer>();
	
	public HardcodedEncyclopedia(Map<String, Integer> entryValues){//注意在配置文件怎样配置
		this.entryValues = entryValues;
	}
	@Override
	public Integer findInteger(String entry) {
		return this.entryValues.get(entry);
	}

}

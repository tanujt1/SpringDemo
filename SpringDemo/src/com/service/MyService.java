package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	List<String> list = new ArrayList<>(Arrays.asList("tanuj", "Aviral", "Pritish", "Vikhyat"));

	public List<String> retrieveList() {
		return list;
	}

	public List<String> add(String value) {
		list.add(value);
		System.out.println(list);
		return list;
	}

	public List<String> delete(String value) {
		if (list.contains(value)) {
			list.remove(value);
		} else {
			return list;
		}
		return list;
	}

	public String get(String value) {
		if (list.contains(value)) {
			return value;
		} else {
			return "Sorry, there is nothing by the name " + value;
		}
	}

	public List<String> update(String value, String value1) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(value)) {
				list.set(i, value1);
				break;
			}
			count++;
		}
		if (count == list.size()) {
			return list;
		} else {
			return list;
		}
	}

}

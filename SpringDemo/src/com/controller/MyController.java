package com.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.MyService;

@Controller
public class MyController {

	@Autowired
	private MyService myService;

	@RequestMapping(value = "retrieveList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	// @ResponseBody
	public String retrieveList(Model model) {
		List<String> list = myService.retrieveList();
		model.addAttribute("list", list);
		return "view";
	}

	@RequestMapping(value = "get/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public String get(@PathVariable String value) {
		return myService.get(value);
	}

	@RequestMapping(value = "add/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	// @ResponseBody
	public String add(@PathVariable String value, Model model) {
		List<String> list = myService.add(value);
		model.addAttribute("list", list);
		return "view";
	}

	@RequestMapping(value = "delete/{value}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	// @ResponseBody
	public String delete(@PathVariable String value, Model model) {

		List<String> list = myService.delete(value);
		model.addAttribute("list", list);
		return "view";

	}

	@RequestMapping(value = "update/{valueToBeUpdated}/{UpdatedValue}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	// @ResponseBody
	public String update(@PathVariable String valueToBeUpdated, @PathVariable String UpdatedValue, Model model) {
		List<String> list = myService.update(valueToBeUpdated, UpdatedValue);
		model.addAttribute("list", list);
		return "view";

	}
}

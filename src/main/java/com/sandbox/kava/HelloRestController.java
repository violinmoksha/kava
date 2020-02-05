package com.sandbox.kava;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1")
public class HelloRestController {
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from Vanuatu!";
	}

	@GetMapping
	@RequestMapping("/guid")
	public Map<String, String> guid() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		
		HashMap<String, String> map = new HashMap<>();
		map.put("guid", uuidStr);
		
		return map;
	}
}
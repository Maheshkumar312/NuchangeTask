package com.prodian.JobTask.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.criteria.Order;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodian.JobTask.model.Pojo;
import com.prodian.JobTask.repo.NuchangeRepo;

@RestController
public class ApiController {

	@Autowired
	private NuchangeRepo nuchangeRepo;
	private static int count = 0;
	private static String url = null;

	@GetMapping("/storeurl")
	public void storeUrl(@RequestParam(value = "url", required = false, defaultValue = "") String url) {
		System.out.println("method called");
		count++;
		String uniqueId = UUID.randomUUID().toString();
		Pojo pojo = new Pojo();
		pojo.setUniqueId(uniqueId);
		pojo.setUrl(url);
		pojo.setCount(count);
		nuchangeRepo.save(pojo);

	}

	@GetMapping("/get")
	public String get(@RequestParam(value = "url", required = false, defaultValue = "") String url) {
		String uniqueId = UUID.randomUUID().toString();
		count = count + 1;
		System.out.println(count);

		return uniqueId;

	}

	@GetMapping("/list")
	public Page<List<Pojo>> list() {
		Pageable paging = PageRequest.of(0, 1);
		Page<List<Pojo>> res = null;
		List<JSONObject> objectNode = new ArrayList<JSONObject>();
		List<Pojo> result = new ArrayList<Pojo>();
		List<Pojo> s = nuchangeRepo.findAll();
		System.out.println(s);
		System.out.println("count is" + s.get(count));
		for (Pojo s1 : s) {
			url = s1.getUrl();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("url", url);
			Pojo pojo = new Pojo();
			pojo.setUrl(url);
			result.add(pojo);
			System.out.println("json object is" + jsonObject);
			objectNode.add(jsonObject);

		}
		System.out.println(objectNode);
		res = new PageImpl(result, paging, 1);
		return res;

	}

	@GetMapping("/count")
	public int count(@RequestParam(value = "url", required = false, defaultValue = "") String url) {
		count = count + 1;
		return count;

	}

}

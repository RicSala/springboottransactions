package com.imprender.springboottransactions.controller;


import com.imprender.springboottransactions.model.User;
import com.imprender.webapputils.MustacheUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "users", produces = MediaType.TEXT_HTML_VALUE)
public class UserController {

	private List<User> users = new ArrayList<>();

	public UserController() {
		users = new ArrayList<>();


		users.add(new User("Ricardo", "11/03/1986", 200, "Java delevoper", "https://ca.slack-edge.com/T31TKJJCA-U5DCZ153R-aa43d591b8c9-512"));
		users.add(new User("Ferran", "11/04/1986", 180, "Ruby delevoper", "https://ca.slack-edge.com/T31TKJJCA-U31U6GR4J-4f1fda04a98f-512"));
		users.add(new User("Laia", "11/05/1986", 202, "JS delevoper", "https://ca.slack-edge.com/T31TKJJCA-U5SDPVCG2-d262d8f1e04b-512"));
		users.add(new User("Javi", "11/06/1986", 178, "Python delevoper", "https://ca.slack-edge.com/T31TKJJCA-U5UACDBSQ-e25a2d870c57-512"));

		User.save(users);
	}

	@RequestMapping
	public String viewUsers() {

		Map<String, String> customizedHeader = MustacheUtil.customizeHeader("List of users", "style.css");
		return MustacheUtil.customizeTemplate(users, customizedHeader, "templates/users.html").toString();
	}

	@RequestMapping("/{ID}")
	public String viewUser(@PathVariable("ID") int ID) {

		Map<String, String> customizedHeader = MustacheUtil.customizeHeader("User information", "GeneralStyle.css");
		return MustacheUtil.customizeTemplate(users.get(ID), customizedHeader, "templates/profileCard.html").toString();
	}


}

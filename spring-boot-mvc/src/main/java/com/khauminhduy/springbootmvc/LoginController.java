package com.khauminhduy.springbootmvc;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khauminhduy.springbootmvc.model.LoginForm;

@RestController
public class LoginController {

	@PostMapping("/loginform")
	public String processLogin(@Valid LoginForm form) {
		return "Success";
	}

}

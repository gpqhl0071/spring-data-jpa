package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping(value = "/")
public class Controller {
  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public String test() {
    Optional<User> user = userRepository.findById(29L);

    return user.toString();
  }
  @RequestMapping(value = "/findTopByOrderByIdDesc", method = RequestMethod.GET)
  @ResponseBody
  public String findTopByOrderByIdDesc() {
    User user = userRepository.findTopByOrderByIdDesc();

    return user.toString();
  }

  @RequestMapping(value = "/setFirstNameByID", method = RequestMethod.GET)
  @ResponseBody
  public String setFirstNameByID() {
    int count = userRepository.setFirstNameByID("GGGG", 29L);

    return "success";
  }

}

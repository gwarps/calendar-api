package com.cldr.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cldr.repository.UserRepository;


@RestController // This means that this class is a Controller
// @RequestMapping(path="/users") // This means URL's start with /demo (after Application path)
public class UserController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;

//   @PostMapping() // Map ONLY POST Requests
//   public @ResponseBody String addNewUser (@RequestParam String name
//       , @RequestParam String email) {
//     // @ResponseBody means the returned String is the response, not a view name
//     // @RequestParam means it is a parameter from the GET or POST request

//     User user = new User();
//     // n.setName(name);
//     // n.setEmail(email);
//     userRepository.save(user);
//     return "Saved";
//   }
  @PostMapping("/users")
  public @ResponseBody User addNewUser(@RequestBody User user) {
    //   User user = new User();
      return userRepository.save(user);
  }

  @GetMapping(path="/users")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}
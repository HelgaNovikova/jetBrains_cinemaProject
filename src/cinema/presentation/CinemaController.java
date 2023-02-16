package cinema.presentation;

import cinema.businesslayer.CinemaService;
import cinema.domainmodel.Seats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @GetMapping("/seats")
        public Seats getSeats() {
            return cinemaService.getSeats();
        }
//
//    @RestController
//    public class UserController {
//
//        @Autowired
//        UserService userService;
//
//        @PostMapping("/user")
//        public User saveUser(@RequestBody User user) {
//            User createdUser = userService.save(new User(
//                    user.getId(), user.getUsername(),
//                    user.getFirstName(), user.getLastName()));
//
//            return createdUser;
//        }
//
//        @GetMapping("/user/{id}")
//        public User getUser(@PathVariable long id) {
//            return userService.findUserById(id);
//        }
//    }
}

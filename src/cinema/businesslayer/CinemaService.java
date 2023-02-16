package cinema.businesslayer;

import cinema.domainmodel.Seat;
import cinema.domainmodel.Seats;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaService implements CommandLineRunner {

    private final int numOfRows = 9;
    private final int numOfColumns = 9;
    private Seats seats;

    private void generateSeats(){
        List<Seat> seatsArr = new ArrayList<>();
        for (int i = 1; i <= numOfRows; i++){
            for (int j = 1; j <= numOfColumns; j++){
                seatsArr.add(new Seat(i, j));
            }
        }
        seats = new Seats(numOfRows, numOfColumns, seatsArr);
    }

    @Override
    public void run(String... args) throws Exception {
        generateSeats();
    }

    public Seats getSeats() {
        return seats;
    }
    //    @Service
//    public class UserService {
//
//        private final UserRepository userRepository;
//
//        @Autowired
//        public UserService(UserRepository userRepository) {
//            this.userRepository = userRepository;
//        }
//
//        public User findUserById(Long id) {
//            return userRepository.findUserById(id);
//        }
//
//        public User save(User toSave) {
//            return userRepository.save(toSave);
//        }
//
//    }
}

package Archives;

import dev.lubna.JA.model.Users;
import dev.lubna.JA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class Archived_customUserDetailsService {
//        implements UserDetailsService {

//   @Autowired
//   private UserRepo userRepo;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Users users = userRepo.findByUsername(username);
//
//        if (users != null){
//            UserDetails userDetails;
//            userDetails = org.springframework.security.core.userdetails.User.builder()
//                    .username(users.getUsername())
//                    .password(users.getPassword())
//                    .roles(users.getUserRole() == null || users.getUserRole().isEmpty()
//                            ? new String[]{"USER"}
//                            : users.getUserRole().toArray(new String[0]))
//
//                    .build();
//
//            return  userDetails;
//        }
//
//
//       throw new UsernameNotFoundException("This username is not found :" + username);
//    }

}

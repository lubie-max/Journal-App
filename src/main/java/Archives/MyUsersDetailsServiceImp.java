package Archives;

import dev.lubna.JA.model.Users;
import dev.lubna.JA.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class MyUsersDetailsServiceImp
//        implements UserDetailsService
{

    @Autowired
    private  UserRepo userRepo;


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Users user = userRepo.findByUsername(username);
//
//        if (user == null){
//            throw  new UsernameNotFoundException("User not found !!");
//        }

//        return new UserPrinciple(user);



//    }

}

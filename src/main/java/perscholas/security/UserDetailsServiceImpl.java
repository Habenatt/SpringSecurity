package perscholas.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;
import perscholas.database.entity.UserRole;
import perscholas.dependencyinjectionexample.Worker3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final Logger LOG= LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user=userDao.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("UserName '" +username +" 'not foundin database");
        }

        //check the account status
        boolean accountIsEnabled =true;
        //accountIsEnabled=user.isActive();

        boolean accountNonExpired=true;
        boolean credentialsNonExpired=true;
        boolean accountNonLocked=true;

        List<UserRole> userRoles = userDao.getUserRoles(user.getId());
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);


        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), accountIsEnabled, accountNonExpired,credentialsNonExpired, accountNonLocked, springRoles) ;
    }


    Collection<? extends GrantedAuthority>  buildGrantAuthorities(List<UserRole> userRoles){

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(UserRole role:userRoles){
            authorities.add(new SimpleGrantedAuthority(role.getUserRole().toString()));
        }

        return authorities;
    }

}

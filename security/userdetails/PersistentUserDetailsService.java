$[let modelClassName = userEntity|domain:Model|name]
package ${domain.namespace};

import ${userEntity|domain:Model|fullname};
import ${userEntity|domain:Repository|fullname};
import ${userEntity|domain:Service|fullname};
import ${roleEnum|domain:Model|fullname};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${space.domain("Exception").namespace}.ServiceException;

import java.util.HashSet;
import java.util.HashMap;

@Service
@Transactional
@Qualifier("userDetailsService")
public class PersistentUserDetailsService implements UserDetailsService {

    $[capture mapVariableName]${userEntity|name|uncapitalize}By${usernameAttribute|name|capitalize}$[/capture]
    private final ${userEntity|domain:Repository|name} userRepository;
    private final UserDetailsMapper userDetailsMapper;
    private final HashMap<String,${modelClassName}> ${mapVariableName} = new HashMap<>();

    public PersistentUserDetailsService(${userEntity|domain:Repository|name} userRepository, UserDetailsMapper userDetailsMapper) {
        this.userRepository = userRepository;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ${modelClassName} user = this.findBy${usernameAttribute|domain:Model|name|capitalize}(username);
        if (user == null) {
            return null;
        }
        return userDetailsMapper.toUserDetails(user);
    }

    public ${modelClassName} findBy${usernameAttribute|domain:Model|name|capitalize}(String ${usernameAttribute|domain:Model|name}) {
        if (${mapVariableName}.containsKey(${usernameAttribute|domain:Model|name})) {
            return ${mapVariableName}.get(${usernameAttribute|domain:Model|name});
        }
        ${modelClassName} obj = userRepository.findBy${usernameAttribute|domain:Model|name|capitalize}(${usernameAttribute|domain:Model|name});
        ${mapVariableName}.put(${usernameAttribute|domain:Model|name}, obj);
        return obj;
    }

    public void updateUser(${modelClassName} user) {
        ${mapVariableName}.put(user.get${usernameAttribute|domain:Model|name|capitalize}(), user);
    }
}
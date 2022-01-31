package ${domain.namespace};

import ${userEntity|domain:Model|fullname};
import ${userEntity|domain:Repository|fullname};

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PersistentUserDetailsPasswordService implements UserDetailsPasswordService {

    private final ${userEntity|domain:Repository|name} userRepository;
    private final UserDetailsMapper userDetailsMapper;

    public PersistentUserDetailsPasswordService(${userEntity|domain:Repository|name} userRepository, UserDetailsMapper userDetailsMapper) {
        this.userRepository = userRepository;
        this.userDetailsMapper = userDetailsMapper;
    }

    @Override
    public UserDetails updatePassword(UserDetails userDetails, String newPassword) {
        ${userEntity|domain:Model|name} user = userRepository.findBy${usernameAttribute|domain:Model|name|capitalize}(userDetails.getUsername());
        user.set${passwordAttribute|domain:Model|name|capitalize}(newPassword);
        userRepository.save(user);
        return userDetailsMapper.toUserDetails(user);
    }
}

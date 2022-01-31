package ${domain.namespace};

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

import ${roleEnum|domain:Model|fullname};
import ${userEntity|domain:Model|fullname};

@Component
public class UserDetailsMapper {

    UserDetails toUserDetails(${userEntity|domain:Model|name} user) {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (${roleEnum|domain:Model|name} role : user.get${userEntity.attributeOfTypeTagged("role")|domain:Model|name|capitalize}()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
        }

        return new org.springframework.security.core.userdetails.User(user.get${usernameAttribute|domain:Model|name|capitalize}(), user.get${passwordAttribute|domain:Model|name|capitalize}(), grantedAuthorities);
    }

    public Set<${roleEnum|domain:Model|name}> rolesForUserDetails(UserDetails userDetails) {
        Set <${roleEnum|domain:Model|name}> roles = new HashSet<>();
        for(GrantedAuthority authority : userDetails.getAuthorities()) {
            String role = authority.getAuthority();
            if (role.startsWith("ROLE_")) {
                role = role.substring(5); // strip that off
                roles.add(${roleEnum|domain:Model|name}.valueOf(role));
            }
        }
        return roles;
    }
}

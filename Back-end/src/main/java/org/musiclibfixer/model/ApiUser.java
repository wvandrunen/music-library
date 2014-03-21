package org.musiclibfixer.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ApiUser extends org.springframework.security.core.userdetails.User {

    @Id
    private ObjectId id;

    public ApiUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /**
     * Default constructor needed for Mophia. Note that the extended class has no super constructor and values must be passed.
     */
    public ApiUser() {
        super("23k4j23klrjfnklqewkjbnjksdvabv", "23k4j23klrjfnklqewkjbnjksdvabv", new ArrayList<>());
    }

    public ObjectId getId() {
        return id;
    }
}

package org.musiclibfixer.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity(value = "users", noClassnameStored = true)
public class User extends org.springframework.security.core.userdetails.User {

    @Id
    private ObjectId id;

    public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public ObjectId getId() {
        return id;
    }
}

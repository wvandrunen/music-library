package org.musiclibfixer.security;

import org.musiclibfixer.dao.MongoDBUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDetailsService implements UserDetailsService {

    private MongoDBUserDao mongoDBUserDao;

    @Autowired
    public MongoUserDetailsService(MongoDBUserDao mongoDBUserDao) {
        this.mongoDBUserDao = mongoDBUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.mongoDBUserDao.findOne("username", username);
    }
}

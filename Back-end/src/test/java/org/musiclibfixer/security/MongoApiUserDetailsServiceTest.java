package org.musiclibfixer.security;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.musiclibfixer.dao.MongoDBUserDao;

public class MongoApiUserDetailsServiceTest {

    private MongoUserDetailsService mongoUserDetailsService;
    private MongoDBUserDao mongoDBUserDao;

    @Before
    public void setUp() {
        mongoDBUserDao = Mockito.mock(MongoDBUserDao.class);

        mongoUserDetailsService = new MongoUserDetailsService(mongoDBUserDao);
    }

    @Test
    public void whenMongoUserDetailsServiceGivenUsernameThenMongoDBUserDaoShouldBeCalled() {
        String username = "test";

        mongoUserDetailsService.loadUserByUsername(username);

        Mockito.verify(mongoDBUserDao).findOne("username", username);
    }

}

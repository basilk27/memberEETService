package com.anthem.member.eetmember.services;

import com.anthem.member.eetmember.domain.Login;
import com.anthem.member.eetmember.domain.LoginStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;
import static org.mockito.BDDMockito.willReturn;

public class LoginServiceImpTest {

    @Mock
    private LoginServiceImp loginServiceImp;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //loginServiceImp = new LoginServiceImp();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void login_is_valid() {
        //given a Login
        LoginStatus loginStatus = new LoginStatus( true, "Valid Login" );

        when(loginServiceImp.login( any(Login.class ))).thenReturn( loginStatus);

        //assert
        assertThat( loginStatus ).isNotNull();
        assertThat( loginStatus.isLoginFlag() ).isTrue();
    }

    @Test
    public void login_is_invalid() {
        //given a Login
        LoginStatus loginStatus = new LoginStatus( false, "Invalid Login" );

        when(loginServiceImp.login( any(Login.class ))).thenReturn( loginStatus);

        //assert
        assertThat( loginStatus ).isNotNull();
        assertThat( loginStatus.isLoginFlag() ).isFalse();
    }
}
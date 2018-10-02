package com.anthem.member.eetmember.controller;

import com.anthem.member.eetmember.domain.Login;
import com.anthem.member.eetmember.domain.LoginStatus;
import com.anthem.member.eetmember.services.LoginServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith( SpringRunner.class )
@WebMvcTest( LoginController.class )
public class LoginControllerTest {

    @MockBean
    private LoginServiceImp loginService;

    @Autowired
    private MockMvc mvc;

    private JacksonTester< LoginStatus > loginStatusJacksonTester;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields( this, new ObjectMapper() );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void login_is_valid() throws Exception {
        // given
        LoginStatus loginStatus = new LoginStatus(true, "Valid login");

        given( loginService.login( any( Login.class ) ) ).willReturn( loginStatus );

        // when
        MockHttpServletResponse response = mvc.perform( post( "/v1/api/login" )
                                                .contentType( MediaType.APPLICATION_JSON )
                                                .content( loginStatusJacksonTester.write( loginStatus )
                                                .getJson()))
                                            .andReturn().getResponse();

        // then
        assertThat( response.getStatus()).isEqualTo( HttpStatus.OK.value() );
        assertThat( response.getContentAsString() ).isEqualTo(
                        loginStatusJacksonTester.write( loginStatus).getJson());
    }
}
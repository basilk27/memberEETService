package com.anthem.member.eetmember.services;

import com.anthem.member.eetmember.domain.Login;
import com.anthem.member.eetmember.domain.LoginStatus;

public class LoginServiceImp implements LoginService {
    @Override
    public LoginStatus login( Login login ) {
        return new LoginStatus(true, "Valid login");
    }
}

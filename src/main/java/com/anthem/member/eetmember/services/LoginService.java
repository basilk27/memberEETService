package com.anthem.member.eetmember.services;

import com.anthem.member.eetmember.domain.Login;
import com.anthem.member.eetmember.domain.LoginStatus;

public interface LoginService {
    LoginStatus login( Login login );
}

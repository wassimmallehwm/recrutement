package com.recrutement.modules.auth.service;

import com.recrutement.exceptions.*;
import com.recrutement.modules.auth.httpRequest.AuthRequest;
import com.recrutement.modules.auth.httpRequest.SignupRequest;
import com.recrutement.modules.auth.httpResponse.AuthResponse;
import com.recrutement.modules.user.dto.ChangePasswordReq;
import com.recrutement.modules.user.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

public interface IAuthService {

    UserDto signup(SignupRequest request) throws UserAlreadyExistsException;

    void sendAccountActivation(UserDto user);

    @Transactional
    Boolean activateAccount(String token) throws TokenExpiredException, DataNotFoundException;

    @Transactional
    void creatAdmin(SignupRequest request) throws UserAlreadyExistsException;

    AuthResponse signin(AuthRequest authRequest) throws UserNotFoundException, DeactivatedAccountException;

    AuthResponse MFASignin(String MFAToken) throws DataNotFoundException, TokenExpiredException;

    Long resendCode(Long tokenId) throws DataNotFoundException;

    AuthResponse refreshToken() throws TokenExpiredException, UserNotFoundException, DataNotFoundException;
}

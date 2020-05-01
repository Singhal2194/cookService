package com.cook.authentication.service;

import com.cook.authentication.dto.LoginPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.cook.authentication.app.Constants.*;

@Component
public class LoginService {

    @Autowired
    ValidationService validationService;

    public Map<String,Object> login(LoginPayload loginPayload)
    {
        Map<String,Object> response = new HashMap<>();
        Boolean validatePass = validationService.validatePhoneNumber(loginPayload.getPhoneNumber());
        if(!validatePass)
        {
            response.put(STATUS,STATUS_FAILURE);
            response.put(REASON,INVALID_NUMBER);
            return response;
        }

        response.put(STATUS,STATUS_SUCCESS);
        return response;

    }


}

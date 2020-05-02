package com.cook.authentication.service;

import com.cook.authentication.dto.LoginPayload;
import com.cook.authentication.model.CookEntity;
import com.cook.authentication.repository.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.cook.authentication.app.Constants.*;

@Component
public class LoginService {
    @Autowired
    CookRepository cookRepository;

    public Map<String, Object> login(LoginPayload loginPayload) {
        Map<String, Object> response = new HashMap<>();
        CookEntity cookEntity = cookRepository.findByPhoneNumber(loginPayload.getPhoneNumber());
        if(Objects.isNull(cookEntity)){
            response.put(STATUS, STATUS_FAILURE);
            response.put(REASON, NUMBER_NOT_REGISTERED);
            return response;
        }
        response.put(STATUS, STATUS_SUCCESS);
        response.put(COOKID,cookEntity.getCookId());
        return response;

    }


}

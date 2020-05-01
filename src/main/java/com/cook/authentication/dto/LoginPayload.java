package com.cook.authentication.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LoginPayload {

    private String phoneNumber;

}

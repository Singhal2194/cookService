package com.cook.authentication.controllers;

import com.cook.authentication.app.Constants;
import com.cook.authentication.dto.LoginPayload;
import com.cook.authentication.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static com.cook.authentication.app.Constants.STATUS_FAILURE;

@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @Autowired
    private LoginService loginService;

//    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/login")
    @PostMapping(path = "/login")
    public Response login(LoginPayload loginPayload) {

        logger.info("Login Request with request object:{}",loginPayload);

        Map<String, Object> response = loginService.login(loginPayload);

        if (STATUS_FAILURE.equals(response.get(Constants.STATUS).toString())) {
            return Response.status(400).entity(response).build();
        }

        return Response.ok().entity(response).build();


    }

}

package org.aman.userservice.implementor;

import org.aman.shared.Utils;
import org.aman.ui.model.request.UserDetailsRequestModel;
import org.aman.ui.model.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {

    Map<String, UserRest> users;
    Utils utlis;

    public UserServiceImplementation() {}

    @Autowired
    public UserServiceImplementation(Utils utils) {
        this.utlis= utils;
    }
    @Override
    public UserRest CreateUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = utlis.generateUserId();
        returnValue.setUserId(userId);

        if(users == null) users = new HashMap<>();
        users.put(userId, returnValue);
        return returnValue;
    }
}

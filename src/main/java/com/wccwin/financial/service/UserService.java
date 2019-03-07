package com.wccwin.financial.service;

import com.wccwin.financial.entity.User;
import com.wccwin.financial.pub.BusinessException;

import java.io.IOException;

public interface UserService {

    User getUser(int id) throws BusinessException;

    User register(User user) throws BusinessException;

    User login(User user) throws BusinessException, IOException, ClassNotFoundException;

}

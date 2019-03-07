package com.wccwin.financial.service.impl;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;
import com.wccwin.financial.dao.UserRepository;
import com.wccwin.financial.entity.User;
import com.wccwin.financial.pub.BusinessException;
import com.wccwin.financial.service.UserService;
import com.wccwin.financial.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User  getUser(int id) {
        return userRepository.findById(id).get();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public User register(User user) throws BusinessException {

        int count = userRepository.countByUsername(user.getUsername());

        if(count > 0) throw BusinessException.error(100);

        String token = UUID.randomUUID().toString();
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        user.setToken(DigestUtils.md5DigestAsHex(token.getBytes()));
        userRepository.save(user);
        user.setToken(token);
        return user;
    }

    @Transactional
    @Override
    public User login(User user) throws BusinessException, IOException, ClassNotFoundException{

        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        User userLogin = userRepository.findByUsernameAndPassword(user.getUsername(), pwd);
        if(userLogin == null) throw BusinessException.error(101);

        User result = CopyUtils.deepClone(userLogin);
        String token = UUID.randomUUID().toString();
        result.setToken(token);

        userLogin.setToken(DigestUtils.md5DigestAsHex(token.getBytes()));
        int count = userRepository.updateTokenById(userLogin.getId(), userLogin.getToken());

        if(count < 1) throw BusinessException.error("服务繁忙，请稍后重试。");
        return result;
    }
}

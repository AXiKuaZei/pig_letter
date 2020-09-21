package indi.axikuazei.pigletter.service.impls;


import indi.axikuazei.pigletter.dao.UserMapper;
import indi.axikuazei.pigletter.dao.entity.User;
import indi.axikuazei.pigletter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

@Transactional
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByName(String username) {
        return userMapper.selectUserByName(username);
    }

    @Override
    public void insertNewUser(User user) {
        userMapper.insertNewUser(user);
    }

    @Override
    public boolean containsUser(String username) {
        return selectUserByName(username)!=null;
    }
}

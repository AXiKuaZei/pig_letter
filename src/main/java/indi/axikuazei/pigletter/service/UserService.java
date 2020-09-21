package indi.axikuazei.pigletter.service;


import indi.axikuazei.pigletter.dao.entity.User;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

public interface UserService {

    User selectUserByName(String username);

    void insertNewUser(User user);

    boolean containsUser(String username);
}

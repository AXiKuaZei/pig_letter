package indi.axikuazei.pigletter.service;


import indi.axikuazei.pigletter.dao.entity.UserTbl;

import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

public interface UserService {

    List<UserTbl> selectUserByName(String userName);

    int insertNewUser(UserTbl user);

    boolean existsUser(String userName);
}

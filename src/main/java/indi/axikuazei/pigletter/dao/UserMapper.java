package indi.axikuazei.pigletter.dao;


import indi.axikuazei.pigletter.dao.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@Repository
public interface UserMapper {

    void insertNewUser(User user);
    User selectUserByName(String name);

}

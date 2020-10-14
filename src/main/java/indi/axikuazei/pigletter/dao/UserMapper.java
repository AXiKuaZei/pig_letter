package indi.axikuazei.pigletter.dao;


import indi.axikuazei.pigletter.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@Mapper
public interface UserMapper {

    void insertNewUser(User user);

    User selectUserByName(String name);

}

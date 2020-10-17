package indi.axikuazei.pigletter.service.impls;


import indi.axikuazei.pigletter.dao.UserTblMapper;
import indi.axikuazei.pigletter.dao.entity.UserTbl;
import indi.axikuazei.pigletter.dao.entity.UserTblExample;
import indi.axikuazei.pigletter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

@Transactional
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserTblMapper userTblMapper;

    @Override
    public List<UserTbl> selectUserByName(String userName) {
        UserTblExample example = new UserTblExample();
        example.createCriteria().andDeletedEqualTo((byte)0).andUserNameEqualTo(userName);
        return userTblMapper.selectByExample(example);
    }

    @Override
    public int insertNewUser(UserTbl user) {
        return userTblMapper.insertSelective(user);
    }

    @Override
    public boolean existsUser(String userName) {
        UserTblExample example = new UserTblExample();
        example.createCriteria()
                .andUserNameEqualTo(userName)
                .andDeletedEqualTo((byte)0);
        return userTblMapper.countByExample(example)>0;
    }
}

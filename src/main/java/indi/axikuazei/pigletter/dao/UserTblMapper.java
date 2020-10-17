package indi.axikuazei.pigletter.dao;

import indi.axikuazei.pigletter.dao.entity.UserTbl;
import indi.axikuazei.pigletter.dao.entity.UserTblExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserTblMapper {
    long countByExample(UserTblExample example);

    int deleteByExample(UserTblExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserTbl record);

    int insertSelective(UserTbl record);

    List<UserTbl> selectByExample(UserTblExample example);

    UserTbl selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserTbl record, @Param("example") UserTblExample example);

    int updateByExample(@Param("record") UserTbl record, @Param("example") UserTblExample example);

    int updateByPrimaryKeySelective(UserTbl record);

    int updateByPrimaryKey(UserTbl record);
}
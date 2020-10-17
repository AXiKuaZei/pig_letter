package indi.axikuazei.pigletter.dao;

import indi.axikuazei.pigletter.dao.entity.ArticleTbl;
import indi.axikuazei.pigletter.dao.entity.ArticleTblExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ArticleTblMapper {
    long countByExample(ArticleTblExample example);

    int deleteByExample(ArticleTblExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(ArticleTbl record);

    int insertSelective(ArticleTbl record);

    List<ArticleTbl> selectByExample(ArticleTblExample example);

    ArticleTbl selectByPrimaryKey(Integer articleId);

    int updateByExampleSelective(@Param("record") ArticleTbl record, @Param("example") ArticleTblExample example);

    int updateByExample(@Param("record") ArticleTbl record, @Param("example") ArticleTblExample example);

    int updateByPrimaryKeySelective(ArticleTbl record);

    int updateByPrimaryKey(ArticleTbl record);
}
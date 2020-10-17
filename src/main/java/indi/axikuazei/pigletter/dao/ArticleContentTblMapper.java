package indi.axikuazei.pigletter.dao;

import indi.axikuazei.pigletter.dao.entity.ArticleContentTbl;
import indi.axikuazei.pigletter.dao.entity.ArticleContentTblExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ArticleContentTblMapper {
    long countByExample(ArticleContentTblExample example);

    int deleteByExample(ArticleContentTblExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleContentTbl record);

    int insertSelective(ArticleContentTbl record);

    List<ArticleContentTbl> selectByExampleWithBLOBs(ArticleContentTblExample example);

    List<ArticleContentTbl> selectByExample(ArticleContentTblExample example);

    ArticleContentTbl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleContentTbl record, @Param("example") ArticleContentTblExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleContentTbl record, @Param("example") ArticleContentTblExample example);

    int updateByExample(@Param("record") ArticleContentTbl record, @Param("example") ArticleContentTblExample example);

    int updateByPrimaryKeySelective(ArticleContentTbl record);

    int updateByPrimaryKeyWithBLOBs(ArticleContentTbl record);

    int updateByPrimaryKey(ArticleContentTbl record);
}
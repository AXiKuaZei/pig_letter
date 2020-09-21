package indi.axikuazei.pigletter.dao;


import indi.axikuazei.pigletter.dao.entity.Leetcode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
@Repository
public interface LeetcodeMapper {

    List<Leetcode> selectLeetcodes();
    void insertLeetcode(Leetcode leetcode);
    void deleteLeetcodeByID(int id);

    Leetcode selectLeetcodeByID(int id);

    void updateLeetcode(Leetcode leetcode);

    List<Leetcode> selectLeetcodesPage(@Param("id") int id, @Param("size") int size);

    int selectLeetcodesPageNum();
}

package indi.axikuazei.pigletter.service;


import indi.axikuazei.pigletter.dao.entity.Leetcode;

import java.util.List;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */

public interface LeetcodeService {
    List<Leetcode> selectLeetcodes();

    void insertLeetcode(Leetcode leetcode);
    void updateLeetcode(Leetcode leetcode);

    void deleteLeetcodeByID(int id);
    Leetcode selectLeetcodeByID(int id);

    List<Leetcode> selectLeetcodesPage(int i, int i1);

    int selectLeetcodesPageNum(int i);
}

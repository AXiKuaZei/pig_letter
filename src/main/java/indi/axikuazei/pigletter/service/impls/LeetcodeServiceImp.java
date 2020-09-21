package indi.axikuazei.pigletter.service.impls;


import indi.axikuazei.pigletter.dao.LeetcodeMapper;
import indi.axikuazei.pigletter.dao.entity.Leetcode;
import indi.axikuazei.pigletter.service.LeetcodeService;
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
public class LeetcodeServiceImp implements LeetcodeService {
    @Autowired
    LeetcodeMapper leetcodeMapper;

    @Override
    public List<Leetcode> selectLeetcodes() {
        return leetcodeMapper.selectLeetcodes();
    }

    @Override
    public void insertLeetcode(Leetcode leetcode) {
        leetcodeMapper.insertLeetcode(leetcode);
    }

    @Override
    public void updateLeetcode(Leetcode leetcode) {
        leetcodeMapper.updateLeetcode(leetcode);
    }

    @Override
    public void deleteLeetcodeByID(int id) {
        leetcodeMapper.deleteLeetcodeByID(id);
    }

    @Override
    public Leetcode selectLeetcodeByID(int id) {
        return leetcodeMapper.selectLeetcodeByID(id);
    }

    @Override
    public List<Leetcode> selectLeetcodesPage(int id, int size) {
        return leetcodeMapper.selectLeetcodesPage(id,size);
    }

    @Override
    public int selectLeetcodesPageNum(int i) {
        int page=(int)Math.ceil(leetcodeMapper.selectLeetcodesPageNum()/(float)i);
        return page>0?page:1;
    }

}

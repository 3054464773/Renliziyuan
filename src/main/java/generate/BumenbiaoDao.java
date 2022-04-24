package generate;

import generate.Bumenbiao;

public interface BumenbiaoDao {
    int deleteByPrimaryKey(Integer bcbh);

    int insert(Bumenbiao record);

    int insertSelective(Bumenbiao record);

    Bumenbiao selectByPrimaryKey(Integer bcbh);

    int updateByPrimaryKeySelective(Bumenbiao record);

    int updateByPrimaryKey(Bumenbiao record);
}
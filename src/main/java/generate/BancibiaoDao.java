package generate;

import generate.Bancibiao;

public interface BancibiaoDao {
    int deleteByPrimaryKey(Integer bcbh);

    int insert(Bancibiao record);

    int insertSelective(Bancibiao record);

    Bancibiao selectByPrimaryKey(Integer bcbh);

    int updateByPrimaryKeySelective(Bancibiao record);

    int updateByPrimaryKey(Bancibiao record);
}
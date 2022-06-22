package com.trkj.renliziyuangl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.renliziyuangl.pojo.Bumenbiao;
import com.trkj.renliziyuangl.pojo.Yuangongbiao;
import com.trkj.renliziyuangl.vo.UsersXinZiVo;
import com.trkj.renliziyuangl.vo.ZpVo;
import com.trkj.renliziyuangl.vo.usersssVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface YuangongbiaoDao extends BaseMapper<Yuangongbiao> {
        //通过员工表员工id找到员工子表姓名
        String byidfindYgname(int yid);
        //修改
        public int updateUser(Yuangongbiao user);
        //查询所有以及分页
        public List<Yuangongbiao> findusers();
        //根据id查找
        public Yuangongbiao findUserById(int ybh);
        //添加
        public int insersUsers(Yuangongbiao user);
       //员工多表详细信息
        public List<usersssVo> finduserssss();
    public List<usersssVo> findusersx();

        //员工多表薪资信息
        public  List<UsersXinZiVo> findxinzi(int ybh);
        //员工黑名单
      public  List<usersssVo> findusershmd();
      //员工未到岗
      public  List<usersssVo> findwdg();
      //修改员工状态
    public int xiugairuzhi(int ybh);
    //员工离职
    public List<usersssVo> finduserslz();
    //入职时间查询
    List<usersssVo> ruzhishijian(String ygrzsj);
    List<usersssVo> ruzhishijianhmd(String ygrzsj);
    List<usersssVo> ruzhishijianlz(String ygrzsj);
    List<usersssVo> ruzhishijiansx(String ygrzsj);


    //查询员工权限
    List<String> chaxunquanxina(int ygid);
    //根据部门查询
    List<usersssVo> bumenchauxn(String bmmc);
    List<usersssVo> bumenchauxnhmd(String bmmc);
    List<usersssVo> bumenchauxnlz(String bmmc);
    List<usersssVo> bumenchauxwbd(String bmmc);
    List<usersssVo> bumenchauxsx(String bmmc);

}
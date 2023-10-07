package com.yupi.yupao.mapper;

import com.yupi.yupao.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ASUS
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2023-09-13 21:29:06
* @Entity com.yupi.yupao.model.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}





package com.yupi.yupao.mapper;

import com.yupi.yupao.model.domain.UserTeam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ASUS
* @description 针对表【user_team(用户队伍关系)】的数据库操作Mapper
* @createDate 2023-10-02 17:50:49
* @Entity com.yupi.yupao.model.domain.UserTeam
*/
@Mapper
public interface UserTeamMapper extends BaseMapper<UserTeam> {

}





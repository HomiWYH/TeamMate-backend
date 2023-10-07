package com.yupi.yupao.mapper;

import com.yupi.yupao.model.domain.Team;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ASUS
* @description 针对表【team(队伍)】的数据库操作Mapper
* @createDate 2023-10-02 17:50:49
* @Entity domain.model.com.yupiyupao.Team
*/
@Mapper
public interface TeamMapper extends BaseMapper<Team> {

}





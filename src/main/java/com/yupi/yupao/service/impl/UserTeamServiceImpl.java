package com.yupi.yupao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.yupao.model.domain.UserTeam;
import com.yupi.yupao.service.UserTeamService;
import com.yupi.yupao.mapper.UserTeamMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2023-10-02 17:50:49
*/
@Service
@Slf4j
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}





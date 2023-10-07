package com.yupi.yupao.job;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.yupao.model.domain.Team;
import com.yupi.yupao.model.domain.UserTeam;
import com.yupi.yupao.service.TeamService;
import com.yupi.yupao.service.UserTeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

//@Component
@Slf4j
public class DeleteOutTimeTeamJob {
    @Resource
    private TeamService teamService;

    @Resource
    private UserTeamService userTeamService;

    @Scheduled(cron = "*/5 * * * * ?")
    public void deleteTeam() {
        List<Team> teamList = teamService.list();
        List<UserTeam> userTeams = userTeamService.list();
        for (Team team : teamList) {
            if (new Date().after(team.getExpireTime())) {//判断当前是时间是否大于
                teamService.removeById(team);
                QueryWrapper qw = new QueryWrapper<>();
                qw.eq("teamId", team.getId());
                userTeamService.remove(qw);
            }
        }
    }
}

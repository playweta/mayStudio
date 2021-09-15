package cc.maystudio.febs.monitor.controller;

import cc.maystudio.febs.monitor.entity.ActiveUser;
import cc.maystudio.febs.monitor.service.ISessionService;
import cc.maystudio.febs.common.controller.BaseController;
import cc.maystudio.febs.common.entity.FebsResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author mayStudio
 */
@RestController
@RequestMapping("session")
@RequiredArgsConstructor
public class SessionController extends BaseController {

    private final ISessionService sessionService;

    @GetMapping("list")
    @RequiresPermissions("online:view")
    public FebsResponse list(String username) {
        List<ActiveUser> list = sessionService.list(username);
        return new FebsResponse().success()
                .data(getDataTable(list, CollectionUtils.size(list)));
    }

    @GetMapping("delete/{id}")
    @RequiresPermissions("user:kickout")
    public FebsResponse forceLogout(@PathVariable String id) {
        sessionService.forceLogout(id);
        return new FebsResponse().success();
    }
}

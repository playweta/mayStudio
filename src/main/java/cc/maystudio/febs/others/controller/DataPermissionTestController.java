package cc.maystudio.febs.others.controller;

import cc.maystudio.febs.common.controller.BaseController;
import cc.maystudio.febs.common.entity.FebsResponse;
import cc.maystudio.febs.common.entity.QueryRequest;
import cc.maystudio.febs.others.entity.DataPermissionTest;
import cc.maystudio.febs.others.service.IDataPermissionTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller
 *
 * @author mayStudio
 * @date 2020-04-14 15:25:33
 */
@Slf4j
@RestController
@RequestMapping("datapermission/test")
@RequiredArgsConstructor
public class DataPermissionTestController extends BaseController {

    private final IDataPermissionTestService dataPermissionTestService;

    @GetMapping("list")
    @RequiresPermissions("others:datapermission")
    public FebsResponse dataPermissionTestList(QueryRequest request, DataPermissionTest dataPermissionTest) {
        return new FebsResponse().success()
                .data(getDataTable(dataPermissionTestService.findDataPermissionTests(request, dataPermissionTest)));
    }
}

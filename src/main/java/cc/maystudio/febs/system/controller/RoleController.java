package cc.maystudio.febs.system.controller;


import cc.maystudio.febs.system.entity.Role;
import cc.maystudio.febs.system.service.IRoleService;
import cc.maystudio.febs.common.annotation.ControllerEndpoint;
import cc.maystudio.febs.common.controller.BaseController;
import cc.maystudio.febs.common.entity.FebsResponse;
import cc.maystudio.febs.common.entity.QueryRequest;
import cc.maystudio.febs.common.exception.FebsException;
import com.wuwenze.poi.ExcelKit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author mayStudio
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("role")
public class RoleController extends BaseController {

    private final IRoleService roleService;

    @GetMapping
    public FebsResponse getAllRoles(Role role) {
        return new FebsResponse().success().data(roleService.findRoles(role));
    }

    @GetMapping("list")
    @RequiresPermissions("role:view")
    public FebsResponse roleList(Role role, QueryRequest request) {
        return new FebsResponse().success()
                .data(getDataTable(roleService.findRoles(role, request)));
    }

    @PostMapping
    @RequiresPermissions("role:add")
    @ControllerEndpoint(operation = "新增角色", exceptionMessage = "新增角色失败")
    public FebsResponse addRole(@Valid Role role) {
        roleService.createRole(role);
        return new FebsResponse().success();
    }

    @GetMapping("delete/{roleIds}")
    @RequiresPermissions("role:delete")
    @ControllerEndpoint(operation = "删除角色", exceptionMessage = "删除角色失败")
    public FebsResponse deleteRoles(@NotBlank(message = "{required}") @PathVariable String roleIds) {
        roleService.deleteRoles(roleIds);
        return new FebsResponse().success();
    }

    @PostMapping("update")
    @RequiresPermissions("role:update")
    @ControllerEndpoint(operation = "修改角色", exceptionMessage = "修改角色失败")
    public FebsResponse updateRole(Role role) {
        roleService.updateRole(role);
        return new FebsResponse().success();
    }

    @GetMapping("excel")
    @RequiresPermissions("role:export")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest queryRequest, Role role, HttpServletResponse response) throws FebsException {
        ExcelKit.$Export(Role.class, response)
                .downXlsx(roleService.findRoles(role, queryRequest).getRecords(), false);
    }

}

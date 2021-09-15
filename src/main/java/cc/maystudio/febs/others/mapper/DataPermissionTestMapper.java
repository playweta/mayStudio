package cc.maystudio.febs.others.mapper;

import cc.maystudio.febs.common.annotation.DataPermission;
import cc.maystudio.febs.others.entity.DataPermissionTest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author mayStudio
 */
@DataPermission(methods = {"selectPage"})
public interface DataPermissionTestMapper extends BaseMapper<DataPermissionTest> {

}

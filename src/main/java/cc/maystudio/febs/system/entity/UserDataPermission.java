package cc.maystudio.febs.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author mayStudio
 */
@Data
@TableName("t_user_data_permission")
public class UserDataPermission {

    @TableField("USER_ID")
    private Long userId;
    @TableField("DEPT_ID")
    private Long deptId;

}
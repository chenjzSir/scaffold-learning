package com.goblin.manage.bean.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限资源
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("manage_permission_resource")
public class PermissionResource extends Model<PermissionResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父权限资源ID(0:表示root级)
     */
    private Long parentId;

    /**
     * 资源深度
     */
    private Integer resourceDepth;

    /**
     * 排序字段
     */
    private Integer permissionSort;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 资源样式class(前端class属性)
     */
    private String resourceClass;

    /**
     * 资源样式style(前端style属性)
     */
    private String resourceStyle;

    /**
     * 资源路由URL(前端使用)
     */
    private String resourceRouterUrl;

    /**
     * 资源类型(API:接口,MENU:菜单,BUTTON:按钮)
     */
    private String resourceType;

    /**
     * 资源API URI(非必须,api才有)
     */
    private String resourceApiUri;

    /**
     * 资源API URI方法methods(GET,POST,DELETE,PUT,以','分割)
     */
    private String resourceApiUriMethods;

    /**
     * 资源API URI 显示字段列表           提供选择以','逗号分隔
     */
    private String resourceApiUriOptionsFields;

    /**
     * 资源状态
     */
    private Boolean enabled;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 修改人
     */
    private Long updateUserId;

    /**
     * 备注
     */
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

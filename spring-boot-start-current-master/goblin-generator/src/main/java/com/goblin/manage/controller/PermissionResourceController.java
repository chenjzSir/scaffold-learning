package com.goblin.manage.controller;

import org.springframework.http.ResponseEntity;
import com.goblin.manage.bean.domain.PermissionResource;
import com.goblin.manage.service.PermissionResourceService;
        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 权限资源 前端控制器
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@RestController
@RequestMapping("permission-resources")
public class PermissionResourceController {
    @Autowired
    private PermissionResourceService ${serviceVariableName};

    /*
            
         主键  id  Long         
             
         父权限资源ID(0:表示root级)  parentId  Long         
             
         资源深度  resourceDepth  Integer         
             
         排序字段  permissionSort  Integer         
             
         权限名称  permissionName  String         
             
         资源样式class(前端class属性)  resourceClass  String         
             
         资源样式style(前端style属性)  resourceStyle  String         
             
         资源路由URL(前端使用)  resourceRouterUrl  String         
             
         资源类型(API:接口,MENU:菜单,BUTTON:按钮)  resourceType  String         
             
         资源API URI(非必须,api才有)  resourceApiUri  String         
             
         资源API URI方法methods(GET,POST,DELETE,PUT,以','分割)  resourceApiUriMethods  String         
             
         资源API URI 显示字段列表           提供选择以','逗号分隔  resourceApiUriOptionsFields  String         
             
         资源状态  enabled  boolean         
             
         创建时间  createTime  LocalDateTime         
             
         修改时间  updateTime  LocalDateTime         
             
         创建人  createUserId  Long         
             
         修改人  updateUserId  Long         
             
         备注  remark  String         
             
     */
    
    
    @GetMapping("{id}")
    public ResponseEntity< PermissionResource > get ( @PathVariable ${primaryKeyTypeString} id ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.selectById( id ));
    }

    @GetMapping
    public ResponseEntity< PageInfo<PermissionResource> > list ( PagingRequest pagingRequest ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.listPage( pagingRequest ));
    }

    @PostMapping
    public ResponseEntity insert ( @RequestBody PermissionResource ${entityVariableName} ){
        if ( ! ${serviceVariableName}.insert( ${entityVariableName}) ){
            return ResponseEntity.badRequest("保存失败");    
        }
        return ResponseEntity.ok("保存成功");
    }

    @PutMapping("{id}")
    public ResponseEntity update ( @PathVariable ${primaryKeyTypeString} id,
                                              @RequestBody PermissionResource ${entityVariableName} ){
        if ( ! ${serviceVariableName}.updateById( ${entityVariableName}.setId(id)) ){
            return ResponseEntity.badRequest("更新失败");    
        }
        return ResponseEntity.ok("更新成功");
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete ( @PathVariable ${primaryKeyTypeString} id ){
        if ( ! ${serviceVariableName}.deleteById(id) ){
            return ResponseEntity.badRequest("删除失败");    
        }
        return ResponseEntity.ok("删除成功");
    }

    
    
}

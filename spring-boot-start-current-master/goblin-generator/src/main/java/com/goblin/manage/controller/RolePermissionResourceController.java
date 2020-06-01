package com.goblin.manage.controller;

import org.springframework.http.ResponseEntity;
import com.goblin.manage.bean.domain.RolePermissionResource;
import com.goblin.manage.service.RolePermissionResourceService;
        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 角色和权限资源中间表 前端控制器
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@RestController
@RequestMapping("role-permission-resources")
public class RolePermissionResourceController {
    @Autowired
    private RolePermissionResourceService ${serviceVariableName};

    /*
            
         主键  id  Long         
             
         后台管理角色_id  roleId  Long         
             
         后台管理权限资源_id  permissionResourceId  Long         
             
         资源API URI 显示字段
                        (
                        "*":表示显示所有[默认"*"].
                        "-" + 字段名,表示排除某个字段.如果要排除多个以","进行分隔,比如: -username,-password.
                        字段名,表示只显示某个字段,如果只要显示某几个字段可以用","分隔,比如:username,password.
                        示例 : 
                        * : 显示所有字段
                        -username,-password : 除了不显示username,password这2个字段,其他字段都显示
                        username,password : 只显示username,password这2个字段,都不显示
                        )
                        目前只是精确到角色,具体到用户,还需要后续思考  resourceApiUriShowFields  String         
             
     */
    
    
    @GetMapping("{id}")
    public ResponseEntity< RolePermissionResource > get ( @PathVariable ${primaryKeyTypeString} id ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.selectById( id ));
    }

    @GetMapping
    public ResponseEntity< PageInfo<RolePermissionResource> > list ( PagingRequest pagingRequest ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.listPage( pagingRequest ));
    }

    @PostMapping
    public ResponseEntity insert ( @RequestBody RolePermissionResource ${entityVariableName} ){
        if ( ! ${serviceVariableName}.insert( ${entityVariableName}) ){
            return ResponseEntity.badRequest("保存失败");    
        }
        return ResponseEntity.ok("保存成功");
    }

    @PutMapping("{id}")
    public ResponseEntity update ( @PathVariable ${primaryKeyTypeString} id,
                                              @RequestBody RolePermissionResource ${entityVariableName} ){
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

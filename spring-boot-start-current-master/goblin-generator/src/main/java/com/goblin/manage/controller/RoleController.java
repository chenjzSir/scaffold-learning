package com.goblin.manage.controller;

import org.springframework.http.ResponseEntity;
import com.goblin.manage.bean.domain.Role;
import com.goblin.manage.service.RoleService;
        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 后台管理角色表 前端控制器
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@RestController
@RequestMapping("roles")
public class RoleController {
    @Autowired
    private RoleService ${serviceVariableName};

    /*
            
         主键  id  Long         
             
         角色名称  roleName  String         
             
         角色名称code  roleNameCode  String         
             
         角色状态(1:激活,0:锁定)  enabled  boolean         
             
         描述  description  String         
             
         创建时间  createTime  LocalDateTime         
             
         修改时间  updateTime  LocalDateTime         
             
         备注  remark  String         
             
     */
    
    
    @GetMapping("{id}")
    public ResponseEntity< Role > get ( @PathVariable ${primaryKeyTypeString} id ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.selectById( id ));
    }

    @GetMapping
    public ResponseEntity< PageInfo<Role> > list ( PagingRequest pagingRequest ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.listPage( pagingRequest ));
    }

    @PostMapping
    public ResponseEntity insert ( @RequestBody Role ${entityVariableName} ){
        if ( ! ${serviceVariableName}.insert( ${entityVariableName}) ){
            return ResponseEntity.badRequest("保存失败");    
        }
        return ResponseEntity.ok("保存成功");
    }

    @PutMapping("{id}")
    public ResponseEntity update ( @PathVariable ${primaryKeyTypeString} id,
                                              @RequestBody Role ${entityVariableName} ){
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

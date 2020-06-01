package com.goblin.manage.controller;

import org.springframework.http.ResponseEntity;
import com.goblin.manage.bean.domain.UserRole;
import com.goblin.manage.service.UserRoleService;
        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 用户和角色中间表 前端控制器
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@RestController
@RequestMapping("user-roles")
public class UserRoleController {
    @Autowired
    private UserRoleService ${serviceVariableName};

    /*
            
         主键  id  Long         
             
         后台管理用户_id  userId  Long         
             
         后台管理角色_id  roleId  Long         
             
     */
    
    
    @GetMapping("{id}")
    public ResponseEntity< UserRole > get ( @PathVariable ${primaryKeyTypeString} id ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.selectById( id ));
    }

    @GetMapping
    public ResponseEntity< PageInfo<UserRole> > list ( PagingRequest pagingRequest ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.listPage( pagingRequest ));
    }

    @PostMapping
    public ResponseEntity insert ( @RequestBody UserRole ${entityVariableName} ){
        if ( ! ${serviceVariableName}.insert( ${entityVariableName}) ){
            return ResponseEntity.badRequest("保存失败");    
        }
        return ResponseEntity.ok("保存成功");
    }

    @PutMapping("{id}")
    public ResponseEntity update ( @PathVariable ${primaryKeyTypeString} id,
                                              @RequestBody UserRole ${entityVariableName} ){
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

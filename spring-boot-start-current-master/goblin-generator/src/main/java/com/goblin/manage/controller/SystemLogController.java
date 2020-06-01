package com.goblin.manage.controller;

import org.springframework.http.ResponseEntity;
import com.goblin.manage.bean.domain.SystemLog;
import com.goblin.manage.service.SystemLogService;
        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@RestController
@RequestMapping("system-logs")
public class SystemLogController {
    @Autowired
    private SystemLogService ${serviceVariableName};

    /*
            
         主键  id  Long         
             
         后台管理用户ID  userId  Long         
             
         后台管理用户真实姓名  userRealName  String         
             
         操作日志(也用于可以存储异常栈信息,或者运行的sql) json  actionLog  String         
             
         操作ip地址  actionIpAddress  String         
             
         操作描述  actionDescription  String         
             
         动作开始时间  actionStartTime  LocalDateTime         
             
         动作结束时间  actionEndTime  LocalDateTime         
             
         总执行时间(微秒)  actionTotalTime  Long         
             
         操作类  actionClass  String         
             
         操作方法  actionMethod  String         
             
         方法参数  actionArgs  String         
             
         是否异常  exception  boolean         
             
         异常是否警报  exceptionWarn  boolean         
             
         通知类型(SMS:短信,MAIL:邮箱)  noticeType  String         
             
         创建时间  createTime  LocalDateTime         
             
         修改时间  updateTime  LocalDateTime         
             
     */
    
    
    @GetMapping("{id}")
    public ResponseEntity< SystemLog > get ( @PathVariable ${primaryKeyTypeString} id ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.selectById( id ));
    }

    @GetMapping
    public ResponseEntity< PageInfo<SystemLog> > list ( PagingRequest pagingRequest ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.listPage( pagingRequest ));
    }

    @PostMapping
    public ResponseEntity insert ( @RequestBody SystemLog ${entityVariableName} ){
        if ( ! ${serviceVariableName}.insert( ${entityVariableName}) ){
            return ResponseEntity.badRequest("保存失败");    
        }
        return ResponseEntity.ok("保存成功");
    }

    @PutMapping("{id}")
    public ResponseEntity update ( @PathVariable ${primaryKeyTypeString} id,
                                              @RequestBody SystemLog ${entityVariableName} ){
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

package com.goblin.manage.controller;

import org.springframework.http.ResponseEntity;
import com.goblin.manage.bean.domain.MailSubscribe;
import com.goblin.manage.service.MailSubscribeService;
        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 修改时间 前端控制器
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@RestController
@RequestMapping("mail-subscribes")
public class MailSubscribeController {
    @Autowired
    private MailSubscribeService ${serviceVariableName};

    /*
            
         主键  id  Long         
             
         用户ID  userId  Long         
             
         收件箱  toEmail  String         
             
         收件箱类型(SYSTEM:系统邮箱,OTHER:其他邮箱[非系统邮箱]),
            默认为 : SYSTEM  toEmailType  String         
             
         邮件主题  emailSubject  String         
             
         邮件内容  emailText  String         
             
         邮件附件地址(多个用逗号','分隔)  emailAttachmentUrl  String         
             
         邮件发送时间(默认:即刻发送)  emailSendTime  LocalDateTime         
             
         发送状态(  NOT_SEND : 未发送,SEND : 已发送,FAIL_SEND : 发送失败,
                   FINAL_FAIL_SEND : 重试次数用完后,还是发送失败    )  emailSendState  String         
             
         失败重试次数  emailSendRetryNumber  Integer         
             
         重试发送统计  emailSendRetryCount  Integer         
             
         备注  remark  String         
             
         创建时间  createTime  LocalDateTime         
             
         修改时间  updateTime  LocalDateTime         
             
     */
    
    
    @GetMapping("{id}")
    public ResponseEntity< MailSubscribe > get ( @PathVariable ${primaryKeyTypeString} id ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.selectById( id ));
    }

    @GetMapping
    public ResponseEntity< PageInfo<MailSubscribe> > list ( PagingRequest pagingRequest ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.listPage( pagingRequest ));
    }

    @PostMapping
    public ResponseEntity insert ( @RequestBody MailSubscribe ${entityVariableName} ){
        if ( ! ${serviceVariableName}.insert( ${entityVariableName}) ){
            return ResponseEntity.badRequest("保存失败");    
        }
        return ResponseEntity.ok("保存成功");
    }

    @PutMapping("{id}")
    public ResponseEntity update ( @PathVariable ${primaryKeyTypeString} id,
                                              @RequestBody MailSubscribe ${entityVariableName} ){
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

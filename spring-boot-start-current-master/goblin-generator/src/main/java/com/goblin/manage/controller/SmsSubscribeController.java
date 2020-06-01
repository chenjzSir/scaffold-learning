package com.goblin.manage.controller;

import org.springframework.http.ResponseEntity;
import com.goblin.manage.bean.domain.SmsSubscribe;
import com.goblin.manage.service.SmsSubscribeService;
        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 短信订阅 前端控制器
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@RestController
@RequestMapping("sms-subscribes")
public class SmsSubscribeController {
    @Autowired
    private SmsSubscribeService ${serviceVariableName};

    /*
            
         主键  id  Long         
             
         用户ID  userId  Long         
             
         手机号码  smsPhone  String         
             
         运营商(CHINA_UNICOM:中国联通,CHINA_TELICOM:中国电信,CHINA_MOBILE:中国移动,UNDEFINED:未指定)  mobileOperators  String         
             
         短信内容  smsContent  String         
             
         短信发送时间(默认:即刻发送)  smsSendTime  LocalDateTime         
             
         发送状态 
            ( NOT_SEND : 未发送,SEND : 已发送,
            FAIL_SEND : 发送失败,FINAL_FAIL_SEND : 重试次数用完后,还是发送失败 )  smsSendState  String         
             
         失败重试次数  smsSendRetryNumber  Integer         
             
         重试发送统计  smsSendRetryCount  Integer         
             
         备注  remark  String         
             
         创建时间  createTime  LocalDateTime         
             
         修改时间  updateTime  LocalDateTime         
             
     */
    
    
    @GetMapping("{id}")
    public ResponseEntity< SmsSubscribe > get ( @PathVariable ${primaryKeyTypeString} id ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.selectById( id ));
    }

    @GetMapping
    public ResponseEntity< PageInfo<SmsSubscribe> > list ( PagingRequest pagingRequest ){
        return ResponseEntity.ok().setResponseContent(${serviceVariableName}.listPage( pagingRequest ));
    }

    @PostMapping
    public ResponseEntity insert ( @RequestBody SmsSubscribe ${entityVariableName} ){
        if ( ! ${serviceVariableName}.insert( ${entityVariableName}) ){
            return ResponseEntity.badRequest("保存失败");    
        }
        return ResponseEntity.ok("保存成功");
    }

    @PutMapping("{id}")
    public ResponseEntity update ( @PathVariable ${primaryKeyTypeString} id,
                                              @RequestBody SmsSubscribe ${entityVariableName} ){
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

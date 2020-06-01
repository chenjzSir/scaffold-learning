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
 * 短信订阅
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("manage_sms_subscribe")
public class SmsSubscribe extends Model<SmsSubscribe> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 手机号码
     */
    private String smsPhone;

    /**
     * 运营商(CHINA_UNICOM:中国联通,CHINA_TELICOM:中国电信,CHINA_MOBILE:中国移动,UNDEFINED:未指定)
     */
    private String mobileOperators;

    /**
     * 短信内容
     */
    private String smsContent;

    /**
     * 短信发送时间(默认:即刻发送)
     */
    private LocalDateTime smsSendTime;

    /**
     * 发送状态 
            ( NOT_SEND : 未发送,SEND : 已发送,
            FAIL_SEND : 发送失败,FINAL_FAIL_SEND : 重试次数用完后,还是发送失败 )
     */
    private String smsSendState;

    /**
     * 失败重试次数
     */
    private Integer smsSendRetryNumber;

    /**
     * 重试发送统计
     */
    private Integer smsSendRetryCount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

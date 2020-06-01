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
 * 修改时间
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("manage_mail_subscribe")
public class MailSubscribe extends Model<MailSubscribe> {

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
     * 收件箱
     */
    private String toEmail;

    /**
     * 收件箱类型(SYSTEM:系统邮箱,OTHER:其他邮箱[非系统邮箱]),
            默认为 : SYSTEM
     */
    private String toEmailType;

    /**
     * 邮件主题
     */
    private String emailSubject;

    /**
     * 邮件内容
     */
    private String emailText;

    /**
     * 邮件附件地址(多个用逗号','分隔)
     */
    private String emailAttachmentUrl;

    /**
     * 邮件发送时间(默认:即刻发送)
     */
    private LocalDateTime emailSendTime;

    /**
     * 发送状态(  NOT_SEND : 未发送,SEND : 已发送,FAIL_SEND : 发送失败,
                   FINAL_FAIL_SEND : 重试次数用完后,还是发送失败    )
     */
    private String emailSendState;

    /**
     * 失败重试次数
     */
    private Integer emailSendRetryNumber;

    /**
     * 重试发送统计
     */
    private Integer emailSendRetryCount;

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

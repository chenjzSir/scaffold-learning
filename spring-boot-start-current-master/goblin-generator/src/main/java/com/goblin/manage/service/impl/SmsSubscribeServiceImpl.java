package com.goblin.manage.service.impl;

import com.goblin.manage.bean.domain.SmsSubscribe;
import com.goblin.manage.mapper.SmsSubscribeMapper;
import com.goblin.manage.service.SmsSubscribeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 短信订阅 服务实现类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@Service
public class SmsSubscribeServiceImpl extends ServiceImpl<SmsSubscribeMapper, SmsSubscribe> implements SmsSubscribeService {


    @Override
    public PageInfo<SmsSubscribe> listPage( PagingRequest pagingRequest ) {
        PageHelper.startPage( pagingRequest.getPageNumber(), pagingRequest.getPageSize() );
        return new PageInfo<>( super.list( null ) );
    }
    
    
}

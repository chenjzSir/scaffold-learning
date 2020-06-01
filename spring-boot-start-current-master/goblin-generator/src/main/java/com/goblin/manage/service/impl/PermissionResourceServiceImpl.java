package com.goblin.manage.service.impl;

import com.goblin.manage.bean.domain.PermissionResource;
import com.goblin.manage.mapper.PermissionResourceMapper;
import com.goblin.manage.service.PermissionResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 权限资源 服务实现类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@Service
public class PermissionResourceServiceImpl extends ServiceImpl<PermissionResourceMapper, PermissionResource> implements PermissionResourceService {


    @Override
    public PageInfo<PermissionResource> listPage( PagingRequest pagingRequest ) {
        PageHelper.startPage( pagingRequest.getPageNumber(), pagingRequest.getPageSize() );
        return new PageInfo<>( super.list( null ) );
    }
    
    
}

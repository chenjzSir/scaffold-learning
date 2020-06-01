package com.goblin.manage.service.impl;

import com.goblin.manage.bean.domain.RolePermissionResource;
import com.goblin.manage.mapper.RolePermissionResourceMapper;
import com.goblin.manage.service.RolePermissionResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 角色和权限资源中间表 服务实现类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@Service
public class RolePermissionResourceServiceImpl extends ServiceImpl<RolePermissionResourceMapper, RolePermissionResource> implements RolePermissionResourceService {


    @Override
    public PageInfo<RolePermissionResource> listPage( PagingRequest pagingRequest ) {
        PageHelper.startPage( pagingRequest.getPageNumber(), pagingRequest.getPageSize() );
        return new PageInfo<>( super.list( null ) );
    }
    
    
}

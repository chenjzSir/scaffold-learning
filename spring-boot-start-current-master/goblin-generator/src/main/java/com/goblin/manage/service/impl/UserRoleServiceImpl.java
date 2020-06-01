package com.goblin.manage.service.impl;

import com.goblin.manage.bean.domain.UserRole;
import com.goblin.manage.mapper.UserRoleMapper;
import com.goblin.manage.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 用户和角色中间表 服务实现类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {


    @Override
    public PageInfo<UserRole> listPage( PagingRequest pagingRequest ) {
        PageHelper.startPage( pagingRequest.getPageNumber(), pagingRequest.getPageSize() );
        return new PageInfo<>( super.list( null ) );
    }
    
    
}

package com.goblin.manage.service.impl;

import com.goblin.manage.bean.domain.User;
import com.goblin.manage.mapper.UserMapper;
import com.goblin.manage.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goblin.common.PagingRequest;


/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author 披荆斩棘
 * @since 2020-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public PageInfo<User> listPage( PagingRequest pagingRequest ) {
        PageHelper.startPage( pagingRequest.getPageNumber(), pagingRequest.getPageSize() );
        //return new PageInfo<>( super.selectList( null ) );
		return new PageInfo<>( super.list( null ) );
    }
    
    
}

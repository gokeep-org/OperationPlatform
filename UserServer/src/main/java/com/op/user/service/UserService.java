package com.op.user.service;

import java.util.List;

import com.op.user.action.input.user.SearchInput;
import com.op.user.bean.entity.user.User;
import com.op.util.bean.Paging;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/20.
 ****************************************/
public interface UserService{
    String createOneUser(User user);

    String createUsers(List<User> users);

    String deleteUserByUserId(String userId);

    String deleteUser(User user);

    String updateUserByUserId(User user);

    String updateUser(User user);

    String searchUserByUserId(String userId);

    List searchUserByPaging(SearchInput searchInput, Paging paging);

    List<User> searchUser(User user);

    Long size();

    Long size(SearchInput searchInput);

}

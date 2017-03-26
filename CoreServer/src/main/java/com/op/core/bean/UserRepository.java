package com.op.core.bean;

import org.springframework.data.mongodb.repository.MongoRepository;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/23.
 ****************************************/
public interface UserRepository extends MongoRepository<User, String> {
    public User findByUsername(String username);
    public User findByUser(User user);
}
package com.op.oauth.bean.action.output.user;

import com.op.oauth.bean.action.output.BaseOutput;
import com.op.oauth.bean.entity.User;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/3/2.
 ****************************************/
public class GetUserOutput extends BaseOutput{
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

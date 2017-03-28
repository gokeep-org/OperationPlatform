package com.op.core;


import com.op.core.bean.action.output.BaseOutput;
import com.op.core.exception.OperationPlatformException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 17-2-18
 ****************************************/
public abstract class BaseAction<T extends BaseOutput> {

    private final static Logger logger = LoggerFactory.getLogger(BaseAction.class);

    public final T execute() throws Exception {
        try {
            // 用户参数格式校验
            inputValidate();
            // 权限校验
            permissionValidate();
            // 附加验证,外加参数组装
            additionalValidate();
            // 业务逻辑
            start();
            // 格式化输出
            T res = formatOutput();
            // 推送 sync 变化
            logSyncAction();

            return res;
        } catch (Exception e) {
            throw new OperationPlatformException(e);
        }
    }

    private void inputValidate() throws Exception {

    }

    private void processInputException() throws Exception {

    }

    /**
     * 权限校验
     * @throws Exception
     */
    protected abstract void permissionValidate() throws Exception;

    /**
     * 一些额外的验证逻辑,也可以做一些参数的组装
     * @throws Exception
     */
    protected abstract void additionalValidate() throws Exception;

    /**
     * 主业务逻辑, 装配其他参数如 logSyncAction
     */
    protected abstract void start() throws Exception;

    /**
     * 格式化最终的输出结果
     */
    protected abstract T formatOutput() throws Exception;

    /**
     * sync 推送, 整理 sync 参数, 发送到队列
     */
    protected abstract void logSyncAction() throws Exception;
}

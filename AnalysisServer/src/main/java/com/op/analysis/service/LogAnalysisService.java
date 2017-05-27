package com.op.analysis.service;

import java.util.List;
import java.util.Map;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/5/20.
 ****************************************/
public interface LogAnalysisService {
    /**
     * 分析某个用户的登录情况
     */
    public Map<String, Object> analysisUserLogin();

    /**
     * 获取某一个用户的操作日志信息
     */
    public Map<String, Object> analyUserOperLogInfo();

    /**
     * 获取当前系统日志信息列表
     */
    public List searchSystemLogInfoList();

    /**
     * 获取某一个用户的错误日志信息列表
     */
    public List searchUserErrorLogInfoList();

    /**
     * 获取当前系统的所有错误信息列表
     */
    public List searchSyatemErrorInfoList();

    /**
     * 分析系统消息数目
     */
    public long searchSystemLogTotal();

    /**
     * 获取某一个用户的活跃度
     */
    public Map<String, Object> analysisUserLiveness();

    /**
     * 通用分析接口
     * @return
     */
    public Map<String, Object> commonLogAnalysis(String index, String type, Map query);
}

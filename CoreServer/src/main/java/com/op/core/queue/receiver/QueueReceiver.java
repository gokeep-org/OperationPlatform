package com.op.core.queue.receiver;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public abstract class QueueReceiver {
	//处理队列消息
	public abstract void process(String message) throws Exception;
}
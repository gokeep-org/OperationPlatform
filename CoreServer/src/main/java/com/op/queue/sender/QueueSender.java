package com.op.queue.sender;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/2/15.
 ****************************************/
public abstract class QueueSender {
	//发送队列消息
	public abstract void send(String message);
}

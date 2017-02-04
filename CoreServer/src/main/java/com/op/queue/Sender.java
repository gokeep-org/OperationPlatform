package com.op.queue;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>功能描述,该部分必须以中文句号结尾。<p>
 * <p>
 * 创建日期 2017/2/3<br>
 *
 * @author $Author$<br>
 * @version $Revision$ $Date$
 * @since 3.0.0
 */
@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String queueName, String jsonStr) {
		if (null != jsonStr && jsonStr.toString().trim() != "") {
			this.rabbitTemplate.convertAndSend(queueName, jsonStr);
		} else {
			throw new RuntimeException("Error: json string is null");
		}
	}
}

package com.gss.commons.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.gss.uitls.Constant.DataTransmitter;
import com.gss.uitls.TransmitterPropertyConfigs.ActiveMQConfig;
import com.gss.uitls.TransmitterPropertyConfigs.CommonConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: activemq 动态配置项
 * @author-lsh
 * @date 2018年5月4日 下午2:56:24
 */
@Configuration
@Slf4j
public class SpringActiveMQContext {
	
	/**
	 * @Description: 配置JMS连接工厂， 引入spring的mq连接池。可以配置缓存的连接数 100
	 * @return 
	 */
	@Bean
	public ActiveMQConnectionFactory activeMqConnectionFactory() {
		if (StringUtils.equalsIgnoreCase(CommonConfig.TRANS_SRC, DataTransmitter.ACTIVEMQ)) {
			ActiveMQConnectionFactory mq = new ActiveMQConnectionFactory();
			mq.setBrokerURL(ActiveMQConfig.BROKER_URL);
			mq.setUserName(ActiveMQConfig.USERNAME);
			mq.setPassword(ActiveMQConfig.PASSWORD);
	    	return mq;
		}
		return null;
	}
	
	/**
	 * @Description: jms模板用于发送信息
	 * @return 
	 */
	@Bean(name = "activemqJmsTemplate")
	public JmsTemplate activemqJmsTemplate() {
		if (StringUtils.equalsIgnoreCase(CommonConfig.TRANS_SRC, DataTransmitter.ACTIVEMQ)) {
			JmsTemplate jmsTemplate = new JmsTemplate(activeMqConnectionFactory());
			//非pub/sub模型（发布/订阅），即队列模式
        	jmsTemplate.setPubSubDomain(false);
        	//指定目的地
        	jmsTemplate.setDefaultDestinationName(ActiveMQConfig.RECEIPT_QUEUE);
        	//
        	jmsTemplate.setMessageConverter(new SimpleMessageConverter());
		}
		return null;
	}

}

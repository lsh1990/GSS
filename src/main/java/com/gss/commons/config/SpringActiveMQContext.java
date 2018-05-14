package com.gss.commons.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

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
	
	public JmsTemplate activemqJmsTemplate() {
		if (StringUtils.equalsIgnoreCase(CommonConfig.TRANS_SRC, DataTransmitter.ACTIVEMQ)) {
			JmsTemplate jmsTemplate = new JmsTemplate(activeMqConnectionFactory());
			
		}
		return null;
	}

}

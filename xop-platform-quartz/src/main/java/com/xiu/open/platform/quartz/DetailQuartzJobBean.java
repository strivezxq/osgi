package com.xiu.open.platform.quartz;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DetailQuartzJobBean extends QuartzJobBean {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private String targetObject;

	private String targetMethod;

	private ApplicationContext ctx;

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		try {
			logger.info("execute [" + targetObject + "] at once>>>>>>");

			Object otargetObject = ctx.getBean(targetObject);

			Method method = null;

			method = otargetObject.getClass().getMethod(targetMethod,
					new Class[] {});

			method.invoke(otargetObject, new Object[] {});
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new JobExecutionException(e);
		}

	}

	public void setApplicationContext(ApplicationContext applicationContext) {

		this.ctx = applicationContext;

	}

	public void setTargetObject(String targetObject) {

		this.targetObject = targetObject;

	}

	public void setTargetMethod(String targetMethod) {

		this.targetMethod = targetMethod;

	}
}

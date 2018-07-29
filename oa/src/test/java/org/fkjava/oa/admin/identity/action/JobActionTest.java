package org.fkjava.oa.admin.identity.action;


import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionProxy;
/**
 * 职位控制器的测试用例
 * 没有页面时可用来测试，模拟action
 */
@RunWith(SpringJUnit4ClassRunner.class)  // 测试的主类
@ContextConfiguration(locations= {"file:\\E:\\Repository\\git\\oa\\src\\main\\webapp\\WEB-INF\\applicationContext*.xml"})
public class JobActionTest extends StrutsSpringJUnit4TestCase<JobAction>{
	
	@Test
	public void selectJob( ) throws Exception {
		/**	获取Action代理 */
		ActionProxy actionProxy = this.getActionProxy("/selectJob.action");
		/**  断言不为空  */
		Assert.assertNotNull(actionProxy);
		
		JobAction jobAction = (JobAction) actionProxy.getAction();
		Assert.assertNotNull(jobAction);
		Assert.assertEquals("success", jobAction.execute());
		System.out.println(jobAction.execute());
		
	}
}

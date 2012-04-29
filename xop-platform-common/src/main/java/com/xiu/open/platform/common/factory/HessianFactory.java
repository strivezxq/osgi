package com.xiu.open.platform.common.factory;

import java.net.MalformedURLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caucho.hessian.client.HessianProxyFactory;
import com.xiu.open.platform.common.exception.ServiceException;

/**
 * <p>Title: HessianFactory</p>     
 * <p>Description:hessian工厂 </p>
 * <p>Copyright:2008-2011</p>
 * <p>Company: Xiu.com</p>
 * @user zhouxq
 * @version xiu2.0
 * @date 2011-12-10 下午3:29:05
 */
public class HessianFactory {
	
	private  final static Logger logger = LoggerFactory.getLogger(HessianFactory.class);
	
	//创建HessianProxyFactory实例
    private static HessianProxyFactory factory = new HessianProxyFactory();
    
	private static ConcurrentMap<String, Object> cacheMap = new ConcurrentHashMap<String, Object>();
    
	/**
	 * 根据服务接口class生成hessian客户端接口，根据Class名查询，如果缓存中有就从缓存中取
	 * @param c   服务接口Class
	 * @param url  
	 * @return
	 * @throws MalformedURLException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T>  T   getHessianClient(Class c, String url) throws ServiceException {
    	try {
    		if(cacheMap.containsKey(c.getName())){
    			return (T)cacheMap.get(c.getName());
    		}else{
    			T t = (T) factory.create(c, url);
    			cacheMap.put(c.getName(), t);
    			return t;
    		}
		} catch (MalformedURLException e) {
			logger.error("URL不正确", e);
			throw new ServiceException("URL不正确") ;
		}
    }
}

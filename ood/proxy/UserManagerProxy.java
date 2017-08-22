package com.edu.tery.proxy;
/**
 * @author Create by tery007
 * @date   2017年8月22日
 *代理类实现接口，并组合缓存对象，增强了处理业务前后的逻辑
 */
public class UserManagerProxy implements UserManager{

	private UserManager userManager;//组合
	private Cache<User> cache;//组合
	
	@Override
	public User getUser(String id) {
		User user=cache.getUser(id);
		if(user!=null){
			return user;
		}
		user=userManager.getUser(id);
		cache.putUser(id,user);
		return user;
	}

	public static void main(String[] args) {
		UserManager manager=new UserManagerProxy();
		manager.getUser("67");
		
	}
}

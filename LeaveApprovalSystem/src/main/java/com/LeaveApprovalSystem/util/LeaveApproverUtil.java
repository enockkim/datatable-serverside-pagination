package com.LeaveApprovalSystem.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class LeaveApproverUtil {
	
	private static SqlSessionFactory factory;
	 
	private LeaveApproverUtil() {}
	 
	static{
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("leaveApplication-config.xml");
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(reader);
	}
	 
	public static SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
}

package com.proxet.core.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.RuntimeErrorException;

import com.proxet.dao.DAO;

public class DAOFactory {

	private static final Map<Class<? extends DAO>, DAO> DAOClassInstanceMap = new ConcurrentHashMap<>();
	static <T extends DAO> T getDAO(Class<T> DAOCLASS){
		T DAOInstance = (T)DAOClassInstanceMap.get(DAOCLASS);
		if(DAOInstance==null){
			try {
				DAOInstance = DAOCLASS.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("Error creatingn DAO instace"+DAOCLASS.getName(), e);
			}
			DAOClassInstanceMap.put(DAOCLASS, DAOInstance);
		}
		return DAOInstance;
	}
}

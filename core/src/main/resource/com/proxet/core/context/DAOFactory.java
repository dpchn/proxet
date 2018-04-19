package com.proxet.core.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.proxet.api.dao.DAO;

public class DAOFactory {

	@SuppressWarnings("rawtypes")
	private static final Map<Class<? extends DAO>, DAO> DAOClassInstanceMap = new ConcurrentHashMap<>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
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

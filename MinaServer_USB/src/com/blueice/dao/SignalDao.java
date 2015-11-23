package com.blueice.dao;

import java.sql.SQLException;
import java.util.List;

import com.blueice.bean.Signal;

public interface SignalDao extends Dao {

	void addSignal(String signal) throws SQLException;
	
	List<Signal> findAllSignal() throws SQLException;
	
	int delSignalById(String signal);
}

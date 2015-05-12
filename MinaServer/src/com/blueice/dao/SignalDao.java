package com.blueice.dao;

import java.sql.SQLException;

import com.blueice.bean.Signal;

public interface SignalDao extends Dao {

	void addSignal(Signal signal) throws SQLException;
	
	void findAllSignal() throws SQLException;
}

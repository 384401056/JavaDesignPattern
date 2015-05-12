package com.blueice.dao;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.blueice.bean.Signal;
import com.blueice.utils.DaoUtils;

public class SignalDaoImp implements SignalDao {

	@Override
	public void addSignal(Signal signal) throws SQLException {
		String sql = "INSERT INTO orderitem VALUES(?,?)";
		try {
			
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			runner.update(sql,signal.getTemperature(),signal.getHumidity());
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void findAllSignal() throws SQLException {
		

	}

}

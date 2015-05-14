package com.blueice.dao;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.log4j.Logger;

import com.blueice.bean.Signal;
import com.blueice.server.TimeServerHandler;
import com.blueice.utils.DaoUtils;

public class SignalDaoImp implements SignalDao {

	private static Logger logger = Logger.getLogger(SignalDaoImp.class);
	
	@Override
	public void addSignal(Signal signal) throws SQLException {
		String sql = "INSERT INTO tb_signal VALUES(null,?,?,null)";
		try {
			
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			runner.update(sql,signal.getTemperature(),signal.getHumidity());
			logger.info("Save to mysql..");
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void findAllSignal() throws SQLException {
		

	}

}

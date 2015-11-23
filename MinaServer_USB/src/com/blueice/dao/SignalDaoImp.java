package com.blueice.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import com.blueice.bean.Signal;
import com.blueice.utils.AnalyzeData;
import com.blueice.utils.DaoUtils;

public class SignalDaoImp implements SignalDao {

	private static Logger logger = Logger.getLogger(SignalDaoImp.class);
	
	@Override
	public void addSignal(String data) {
		
		Signal signal = AnalyzeData.jsonToBean(data);

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
	public List<Signal> findAllSignal() {
		String sql = "SELECT * FROM tb_signal";
		try {
			
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Signal>(Signal.class));
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delSignalById(String data) {
		
		Signal signal = AnalyzeData.jsonToBean(data);
		
		String sql = "DELETE FROM tb_signal WHERE id = ?";
		try {
			
			QueryRunner runner = new QueryRunner(DaoUtils.getDataSource());
			return runner.update(sql,signal.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return 0;
	}

}














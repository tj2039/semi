package com.mymvc.pd.model;

import java.sql.SQLException;
import java.util.List;

public class PdService {
	private PdDAO pdDao;
	
	public PdService() {
		pdDao = new PdDAO();
	}
	public int insertPd(PdDTO dto) throws SQLException {
		return pdDao.insertPd(dto);
	}
	public PdDTO selectByNo(int no) throws SQLException {
		return pdDao.selectByNo(no);
	}
	public List<PdDTO> selectAll() throws SQLException {
		return pdDao.selectAll();
	}
	public int updatePd(PdDTO dto) throws SQLException {
		return pdDao.updatePd(dto);
	}
	public int deletePd(int no) throws SQLException {
		return pdDao.deletePd(no);
	}
	public List<PdDTO> selectByPdName(String pdName) throws SQLException {
		return pdDao.selectByPdName(pdName);
	}
}

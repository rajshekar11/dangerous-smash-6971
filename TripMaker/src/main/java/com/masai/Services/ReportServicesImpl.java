package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.ReportDao;
import com.masai.Exception.ReportException;
import com.masai.been.Report;

@Service
public class ReportServicesImpl implements ReportServices{
	
	@Autowired
	private ReportDao reportDao;

	@Override
	public Report addReport(Report report) throws ReportException {
		Report newreport = reportDao.save(report);
		if(newreport == null)
			throw new ReportException("cannot insert record");
		else
			return newreport;
	}

	@Override
	public Report deleteReport(Integer reportId) throws ReportException {
		Optional<Report> oR = reportDao.findById(reportId);
		Report report = oR.get();
		if(report == null)
			throw new ReportException("Report not found by id" + reportId);
		else {
			reportDao.delete(report);
			return report;
		}
	}

	@Override
	public Report viewReport(Integer reportId) throws ReportException {
		Optional<Report> oR = reportDao.findById(reportId);
		Report report = oR.get();
		if(report == null)
			throw new ReportException("Report not foundby id " + reportId);
		else
			return report;
	}

	@Override
	public List<Report> viewAllReport() throws ReportException {
		List<Report> reportList = reportDao.findAll();
		if(reportList.size() == 0)
			throw new ReportException("Report not found");
		else
			return reportList;
	}

}

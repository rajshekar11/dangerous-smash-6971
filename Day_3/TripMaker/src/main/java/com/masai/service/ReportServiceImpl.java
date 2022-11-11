package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ReportException;
import com.masai.model.Report;
import com.masai.repository.ReportRepo;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepo rRepo;

	@Override
	public Report addReport(Report report) throws ReportException {
		Optional<Report> opt= rRepo.findById(report.getReportId());
		if(opt.isPresent()) {
			throw new ReportException("Report with id: "+report.getReportId()+" is already present");
		}
		return rRepo.save(report);
	}

	@Override
	public Report deleteReport(Integer reportId) throws ReportException {
		Optional<Report> opt = rRepo.findById(reportId);
		if(opt.isPresent()) {
			Report report=opt.get();
			rRepo.delete(report);
			return report;
		}
		throw new ReportException("Report with id: "+reportId+" does not exists");
	}

	@Override
	public Report viewReportById(Integer reportId) throws ReportException {
		Optional<Report> opt = rRepo.findById(reportId);
		if(opt.isPresent()) {
			Report report=opt.get();
			return report;
		}
		throw new ReportException("Report with id: "+reportId+" does not exists");
	}

	@Override
	public List<Report> viewAllReport() throws ReportException {
		List<Report> li = rRepo.findAll();
		if(li.size() == 0) {
			throw new ReportException("There are no reports available currently");
		}
			return li;
	}
	
	
	
}

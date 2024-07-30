package com.farmcollector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.farmcollector.entity.Season;
import com.farmcollector.model.CropReportDto;
import com.farmcollector.model.FarmReportDto;
import com.farmcollector.service.ReportService;

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/farmReport/{farmId}/{season}")
    public String farmReport(@PathVariable Long farmId, @PathVariable Season season, Model model) {
        FarmReportDto report = reportService.getFarmReport(farmId, null);
        model.addAttribute("report", report);
        return "farmReport"; // Assuming a Thymeleaf template named farmReport.html
    }

    @GetMapping("/cropReport/{cropId}/{season}")
    public String cropReport(@PathVariable Long cropId, @PathVariable Season season, Model model) {
        CropReportDto report = reportService.getCropReport(cropId, season);
        model.addAttribute("report", report);
        return "cropReport";
    }
}

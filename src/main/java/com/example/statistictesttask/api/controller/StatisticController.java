package com.example.statistictesttask.api.controller;

import com.example.statistictesttask.api.dto.AsinStatisticDto;
import com.example.statistictesttask.api.dto.DateStatisticDto;
import com.example.statistictesttask.mapper.AsinStatisticMapper;
import com.example.statistictesttask.mapper.DateStatisticMapper;
import com.example.statistictesttask.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticController {

    @Autowired
    private AsinStatisticMapper asinStatisticMapper;

    @Autowired
    private DateStatisticMapper dateStatisticMapper;

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/date")
    public List<DateStatisticDto> getDateStatistics (@RequestParam("startDate") String startDate,
                                                        @RequestParam("finishDate") String finishDate) {
        return dateStatisticMapper.mapListEntityToListDto(statisticService.getAllDateStatistics(startDate, finishDate));
    }

    @GetMapping("/asin")
    public List<AsinStatisticDto> getAsinStatistics (@RequestParam("asins") List<String> asins) {
        return asinStatisticMapper.mapListEntityToListDto(statisticService.getAsinStatistics(asins));
    }

}

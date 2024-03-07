package com.example.statistictesttask.service.impl;

import com.example.statistictesttask.persistence.entity.AsinStatisticEntity;
import com.example.statistictesttask.persistence.entity.DateStatisticEntity;
import com.example.statistictesttask.persistence.repository.AsinStatisticRepository;
import com.example.statistictesttask.persistence.repository.DateStatisticRepository;
import com.example.statistictesttask.service.StatisticService;
import com.example.statistictesttask.service.impl.model.Report;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private AsinStatisticRepository asinStatisticRepository;

    @Autowired
    private DateStatisticRepository dateStatisticRepository;

    @Cacheable(value = "statistic", unless = "#result.isEmpty")
    @Override
    public List<DateStatisticEntity> getAllDateStatistics(String startDate, String finishDate) {
        if (!startDate.isBlank() && !finishDate.isBlank()) {
            List<String> dates = getDatesPeriod(startDate, finishDate);
            return dateStatisticRepository.findAllById(dates);
        }
        if (!startDate.isBlank()) {
            return List.of(Objects.requireNonNull(dateStatisticRepository.findById(startDate).orElse(null)));
        }
        return dateStatisticRepository.findAll();
    }

    @Cacheable(value = "statistic", unless = "#result.isEmpty")
    @Override
    public List<AsinStatisticEntity> getAsinStatistics(List<String> asins) {
        return asins.size() == 0 ? asinStatisticRepository.findAll() : asinStatisticRepository.findAllById(asins);
    }

    @Override
    public void saveAllDate(List<DateStatisticEntity> dateStatisticEntityList) {
        dateStatisticRepository.saveAll(dateStatisticEntityList);
    }

    @Override
    public void saveAllAsin(List<AsinStatisticEntity> asinStatisticEntityList) {
        asinStatisticRepository.saveAll(asinStatisticEntityList);
    }

    @SneakyThrows
    @Scheduled(fixedDelay = 60000)
    protected void updateDbFromFile(){
        final String FILE_NAME = "src/main/resources/test_report.json";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Report report = objectMapper.readValue(new File(FILE_NAME), Report.class);

        saveAllAsin(report.getSalesAndTrafficByAsin());
        saveAllDate(report.getSalesAndTrafficByDate());

        log.info("Db updated");

    }

    @Scheduled(fixedDelay = 300000)
    protected void clearCash() {
        Cache statistic = cacheManager.getCache("statistic");
        if (statistic != null){
            statistic.clear();
            log.info("Cash cleared");
        }
    }
    private List<String> getDatesPeriod(String startDate, String finishDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate finish = LocalDate.parse(finishDate).plusDays(1);

        List<LocalDate> dates = start.datesUntil(finish).toList();
        return dates.stream()
                .map(date -> date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .collect(Collectors.toList());
    }

}

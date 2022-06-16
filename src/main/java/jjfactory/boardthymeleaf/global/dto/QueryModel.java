package jjfactory.boardthymeleaf.global.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QueryModel {
    private String query;

    private LocalDateTime startDate;

    private LocalDateTime endDate;


    public QueryModel(String query,String startDate,String endDate){
        this.query = query;
        this.startDate = convertLocalDateTime(startDate);
        this.endDate = convertLocalDateTime(endDate);
    }

    public static LocalDateTime convertLocalDateTime(String date){
        if(date == null || date.equals("")){
            return null;
        }
        return  LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ISO_DATE), LocalTime.MIN);
    }
}

package com.epam.lab.userCash;

import com.epam.lab.entity.DateEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Cash {
    private Map<String, DateEntity> dataCash = new HashMap<String, DateEntity>();
     public void saveDate(DateEntity date){dataCash.put(date.getDayOfWeek(), date);}

    public DateEntity getDate(String dayOfWeek) {return dataCash.get(dayOfWeek);}

    public Integer getDateCount() {return dataCash.size();}

    public List <DateEntity> getSavedDates(){
         List<DateEntity> dateEntityList = new ArrayList<DateEntity>();
         dataCash.forEach((k, v) -> dateEntityList.add(v));
         return dateEntityList;

    }
}

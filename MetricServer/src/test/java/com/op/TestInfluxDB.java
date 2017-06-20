package com.op;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.junit.Before;
import org.junit.Test;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/6/19.
 ****************************************/
public class TestInfluxDB {
    public InfluxDB influxDB;

    @Before
    public void before(){
        influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", null);
    }

    /**
     * 简单查询infludb结果信息
     */
    @Test
    public void simple(){
        Query query = new Query("SELECT host,value FROM cpu", "test");
        QueryResult queryResult = influxDB.query(query);
        System.out.println(queryResult.getResults().get(0).getSeries().get(0).getValues().get(0).get(0));
    }
}

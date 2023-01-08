package com.epam.tc.hw7.data;

import com.epam.tc.hw7.entities.MetalsInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderJson {

    @DataProvider(name = "JsonProvider")
    public Object[][] getData() throws IOException, JsonMappingException {
        HashMap<String, MetalsInfo> map1 = new ObjectMapper()
                .readValue(new File(System.getProperty("user.dir")
                                + "/src/test/resources/json/JDI_ex8_metalsColorsDataSet.json"),
                        new TypeReference<HashMap<String, MetalsInfo>>() {});

        int i = 0;
        Object[][] object = new Object[map1.size()][1];
        for (Map.Entry<String, MetalsInfo> entry : map1.entrySet()) {
            object[i][0] = entry.getValue();
            i++;
        }

        return object;
    }
}

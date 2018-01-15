package org.elsys.ip.rest.service;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.elsys.ip.rest.model.AirConditioner;
import org.elsys.ip.rest.repository.AirConditionerRepository;

import javax.ws.rs.core.MultivaluedMap;
import java.io.*;
import java.util.List;
import java.util.Set;

public class AirConditionerService {

    private AirConditionerRepository airConditionerRepository = new AirConditionerRepository();

    public List<AirConditioner> getAirConditioners() {
        return airConditionerRepository.getAirConditionersList();
    }

    public AirConditioner getAirConditionerById(Integer id) {
        return airConditionerRepository.getAirConditionerById(id).orElse(null);
    }

    public List<AirConditioner> getByMultipleIds(Set<Integer> ids) {
        return airConditionerRepository.findByIds(ids);
    }

    public List<AirConditioner> getByMultipleFields(MultivaluedMap<String, String> fieldsToValues) {
        return airConditionerRepository.findBySearchFields(fieldsToValues);
    }

    public AirConditioner saveAirConditioner(AirConditioner airConditioner) {
        return airConditionerRepository.saveAirConditioner(airConditioner);
    }

    public AirConditioner updateAirConditioner(Integer id, AirConditioner airConditioner) {
        return airConditionerRepository.updateAirConditioner(id, airConditioner);
    }

    public void deleteAirConditioner(Integer id) {
        airConditionerRepository.deleteAirConditioner(id);
    }

    public void writeCSVFile() throws Exception {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(AirConditioner.class);
        schema = schema.withColumnSeparator('\t');

        ObjectWriter myObjectWriter = mapper.writer(schema);
        File tempFile = new File("D:\\data.csv");
        FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
        OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");

        myObjectWriter.writeValue(writerOutputStream, this.getAirConditioners());
    }

    public void addList(List<AirConditioner> airConditioners) {

        airConditionerRepository.addAirConditioners(airConditioners);
    }
}

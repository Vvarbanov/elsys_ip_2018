package org.elsys.ip.rest.repository;

import org.elsys.ip.rest.model.AirConditioner;

import javax.ws.rs.core.MultivaluedMap;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AirConditionerRepository {
    private static final List<AirConditioner> airConditionersList = new ArrayList<>(
            Arrays.asList(
                    new AirConditioner(1, "Haier", "AC242ACEAA", 6.800, 7.400, 56, 52, "yes", "yes", "yes", 36),
                    new AirConditioner(2, "Haier", "AS182AVERA", 5.100, 6.000, 57, 57, "yes", "yes", "no", 36),
                    new AirConditioner(3, "Beko", "BIN121", 3.500, 2.800, 60, 29, "no", "no", "yes", 24),
                    new AirConditioner(4, "Beko", "BDIN091WIFI", 4.100, 3.200, 64, 34, "no", "yes", "yes", 36)
            ));

    public List<AirConditioner> getAirConditionersList() {
        return airConditionersList;
    }

    public Optional<AirConditioner> getAirConditionerById(Integer id) {
        return airConditionersList.stream().filter(airConditioner -> airConditioner.getId() == id).findFirst();
    }

    public AirConditioner saveAirConditioner(AirConditioner airConditioner) {
        airConditionersList.add(airConditioner);
        return airConditioner;
    }

    public AirConditioner updateAirConditioner(Integer id, AirConditioner airConditioner) {
        int realId = id - 1;
        airConditionersList.set(realId, airConditioner);
        return airConditioner;
    }

    public void deleteAirConditioner(Integer id) {
        airConditionersList.removeIf(it -> it.getId() == id);
    }


    public List<AirConditioner> findByIds(Set<Integer> ids) {
        return airConditionersList.stream().filter(
                eachAirConditioner -> ids.contains(eachAirConditioner.getId())
        ).collect(Collectors.toList());
    }

    public List<AirConditioner> findBySearchFields(MultivaluedMap<String, String> fieldsToValues) {
        Collection<Predicate<AirConditioner>> listOfPredicates = new ArrayList<>();

        for (String fieldName : fieldsToValues.keySet()) {
            Object value = fieldsToValues.get(fieldName).get(0);
            if ("brand".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getBrand().equals(value));
            } else if ("model".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getModel().equals(value));
            } else if ("id".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getId() == Integer.valueOf((String) value));
            } else if ("coolingPower".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getCoolingPower().equals(value));
            } else if ("heatingPower".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getHeatingPower() == value);
            } else if ("noiseLevel".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getNoiseLevel() == value);
            } else if ("weight".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getWeight() == value);
            } else if ("warranty".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getWarranty() == value);
            } else if ("autoRestart".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getAutoRestart().equals(value));
            } else if ("antibacterialFilter".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getAntibacterialFilter().equals(value));
            } else if ("remoteControl".equals(fieldName)) {
                listOfPredicates.add(eachAirConditioner -> eachAirConditioner.getRemoteControl().equals(value));
            }
        }

        return airConditionersList.stream().filter(
                airConditioner -> listOfPredicates.stream().allMatch(predicate -> predicate.test(airConditioner))
        ).collect(Collectors.toList());
    }

    public void addAirConditioners(List<AirConditioner> airConditioners) {
        airConditionersList.addAll(airConditioners);
    }
}

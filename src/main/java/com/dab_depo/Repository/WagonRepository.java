package com.dab_depo.Repository;

import com.dab_depo.Entity.Wagon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WagonRepository implements IWagonRepository {

    private List<Wagon> wagons = new ArrayList<>();

    public WagonRepository() {
        try {
            // Parse data from XML file using JacksonXML
            XmlMapper xmlMapper = new XmlMapper();
            wagons = xmlMapper.readValue(new File("src/main/resources/XMLfiles/data.xml"), new TypeReference<List<Wagon>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Async
    public List<Wagon> getWagons() {
        return wagons;
    }

    @Async
    public Wagon findWagonById(Integer wagon_id) {
        for (Wagon wagon : wagons) {
            if (wagon.getId().equals(wagon_id)) {
                return wagon;
            }
        }
        return null;
    }

    @Async
    public void add(Wagon wagon) {
        wagons.add(wagon);
        saveData();
    }

    @Async
    public void update(Wagon wagon) {
        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i).getId().equals(wagon.getId())) {
                wagons.set(i, wagon);
                saveData();
                return;
            }
        }
    }

    @Async
    public void delete(Integer id) {
        wagons.removeIf(wagon -> wagon.getId().equals(id));
        saveData();
    }

    // Saves the updated wagon data to the XML file
    private void saveData() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File("data.xml"), wagons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

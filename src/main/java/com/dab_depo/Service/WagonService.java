package com.dab_depo.Service;

import com.dab_depo.Entity.Wagon;
import com.dab_depo.Repository.IWagonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WagonService implements IWagonService {

    @Autowired
    private IWagonRepository wagonRepository;

    @Async
    public List<Wagon> getWagons() {
        return wagonRepository.getWagons();
    }

    @Async
    public Wagon findWagonById(Integer wagon_id) {
        return wagonRepository.findWagonById(wagon_id);
    }

    @Async
    public void add(Wagon wagon) {
        wagonRepository.add(wagon);
    }

    @Async
    public void update(Wagon wagon) {
        wagonRepository.update(wagon);
    }

    @Async
    public void delete(Integer id) {
        wagonRepository.delete(id);
    }

    @Async
    public void uploadWagon(Integer wagon_id, Integer increaseLoadingPercentage) {
        Wagon wagon = wagonRepository.findWagonById(wagon_id);
        if (wagon != null) {
            Integer currentLoadingPercentage = wagon.getLoadingPercentage();
            Integer newLoadingPercentage = currentLoadingPercentage + increaseLoadingPercentage;
            if (newLoadingPercentage >  100) {
                newLoadingPercentage = 100;
            }
            wagon.setLoadingPercentage(newLoadingPercentage);
            update(wagon);
        }

    }

    @Async
    public void unloadWagon(Integer wagon_id, Integer decreaseLoadingPercentage) {
        Wagon wagon = wagonRepository.findWagonById(wagon_id);
        if (wagon != null) {
            Integer currentLoadingPercentage = wagon.getLoadingPercentage();
            Integer newLoadingPercentage = currentLoadingPercentage - decreaseLoadingPercentage;
            if (newLoadingPercentage < 0) {
                newLoadingPercentage = 0;
            }
            wagon.setLoadingPercentage(newLoadingPercentage);
            update(wagon);
        }
    }
}

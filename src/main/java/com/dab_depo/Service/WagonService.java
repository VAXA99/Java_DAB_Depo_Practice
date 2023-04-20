package com.dab_depo.Service;

import com.dab_depo.Entity.Wagon;
import com.dab_depo.Repository.IWagonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public void changeStatus(Integer id) {
        Wagon wagon = wagonRepository.findWagonById(id);
        wagon.setIsServicable(!wagon.getIsServicable());
        wagonRepository.update(wagon);
    }

}

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
    public Wagon add(Wagon wagon) {
        return wagonRepository.add(wagon);
    }

    @Async
    public Wagon update(Wagon wagon) {
        return wagonRepository.update(wagon);
    }

    @Async
    public void delete(Integer id) {
        wagonRepository.delete(id);
    }

}

package com.dab_depo.Repository;

import com.dab_depo.Entity.Wagon;

import java.util.List;

public interface IWagonRepository {
    public List<Wagon> getWagons();
    public Wagon findWagonById(Integer wagon_id);
    public void add(Wagon wagon);
    public void update(Wagon wagon);
    public void delete(Integer id);
}

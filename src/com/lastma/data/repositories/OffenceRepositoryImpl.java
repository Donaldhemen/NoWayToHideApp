package com.lastma.data.repositories;

import com.lastma.data.models.Offence;

import java.util.ArrayList;
import java.util.List;

public class OffenceRepositoryImpl implements OffenceRepository {
    private static List<Offence> offences = new ArrayList<>();

    @Override
    public long count() {
        return offences.size();
    }

    @Override
    public void save(Offence offence) {
        offences.add(offence);
    }

    @Override
    public Offence findById(String id) {
        for(Offence forEachOffenceIn : offences){
            if(forEachOffenceIn.getId().equals(id)){
                return forEachOffenceIn;
            }
        }
        throw new IllegalArgumentException("Offence with id " + id + " not found");
    }

    @Override
    public void deleteById(String id) {
        for(Offence offence : offences){
            if(offence.getId().equals(id)){
                offences.remove(offence);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        offences.clear();
    }

    @Override
    public boolean existsById(String id) {
        for(Offence forEachOffenceIn : offences){
            if(forEachOffenceIn.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Offence> findAll() {
        return List.copyOf(offences);
    }
}

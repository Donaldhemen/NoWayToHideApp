package com.lastma.data.repositories;

import com.lastma.data.models.Officer;

import java.util.ArrayList;
import java.util.List;

public class OfficerRepositoryImpl implements OfficerRepository {
    private static List<Officer> officers = new ArrayList<>();

    @Override
    public long count() {
        return officers.size();
    }

    @Override
    public void save(Officer officer) {
        officers.add(officer);
    }

    @Override
    public Officer findById(int id) {
        for(Officer forEachOfficerIn : officers){
            if(forEachOfficerIn.getId() == id){
                return forEachOfficerIn;
            }
        }
        throw new IllegalArgumentException("Officer with id " + id + " not found");
    }

    @Override
    public void del(int id) {
        for(Officer officer : officers){
            if(officer.getId() == id){
                officers.remove(officer);
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        officers.clear();
    }

    @Override
    public boolean existsById(int id) {
        for(Officer forEachOfficerIn : officers){
            if(forEachOfficerIn.getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Officer> findAll() {
        return officers;
    }
}

package com.eliaviv.map.rest.service;

import java.util.UUID;

import com.eliaviv.map.objects.beans.PairList;
import com.eliaviv.map.objects.pojo.Pair;
import com.eliaviv.map.rest.dao.MapAerospikeDAO;
import com.eliaviv.map.rest.model.MapReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl<K, V> implements MapService<K, V> {

  private MapAerospikeDAO<K, V> mapDAO;

  @Autowired
  public void setMapDAO(MapAerospikeDAO<K, V> mapDAO) {
    this.mapDAO = mapDAO;
  }

  @Override
  public MapReference createMap(PairList<K, V> PairList) throws Exception {
    return mapDAO.createMap(PairList);
  }

  @Override
  public void put(Pair<K, V> pair) {
    mapDAO.put(pair);
  }

  @Override
  public boolean findMapById(UUID uuid) {
    return true;
  }
}

package com.eliaviv.map.rest.service;

import java.util.UUID;

import com.eliaviv.map.objects.beans.PairList;
import com.eliaviv.map.objects.pojo.Pair;
import com.eliaviv.map.rest.model.MapReference;

import org.springframework.stereotype.Service;

@Service
public interface MapService<K,V> {
  public MapReference createMap(PairList<K, V> pairArray) throws Exception;    
  public void put(Pair<K,V> pair);
  public boolean findMapById(UUID uuid);
}

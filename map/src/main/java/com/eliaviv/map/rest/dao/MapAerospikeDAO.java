package com.eliaviv.map.rest.dao;

import java.util.UUID;

import com.aerospike.client.AerospikeClient;
import com.eliaviv.map.objects.beans.PairList;
import com.eliaviv.map.objects.config.AerospikeParameters;
import com.eliaviv.map.objects.pojo.Pair;
import com.eliaviv.map.rest.dao.helpers.MapAerospikeDAOHelper;
import com.eliaviv.map.rest.model.MapReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapAerospikeDAO<K, V> {

  private AerospikeClient aerospikeClient;
  private MapAerospikeDAOHelper<K,V> mapAerospikeDAOHelper;

  @Autowired
  public void setMapRepository(AerospikeClient aerospikeClient) {
    this.aerospikeClient = aerospikeClient;
  }

  @Autowired
  public void setMapAerospikeDAOHelper(MapAerospikeDAOHelper<K,V> mapAerospikeDAOHelper) {
    this.mapAerospikeDAOHelper = mapAerospikeDAOHelper;
  }

  public MapReference createMap(PairList<K, V> pairList) throws Exception {
    MapReference mapReference = new MapReference();
    UUID uuid = mapAerospikeDAOHelper.creatUUIDtoNewMap();
    mapReference.setUuid(uuid);
    if (!pairList.getPairList().isEmpty()){
        for(Pair<K,V> pair:pairList.getPairList()){
          pair.setMapRefuuid(uuid);
          put(pair);
        }
    }
    return mapReference;
  }

  public V put(Pair<K,V> pair) throws ClassCastException{
    isTypeOfPairValid((pair.getMapRefuuid()));
    AerospikeParameters aerospikeParameters = mapAerospikeDAOHelper.generateKeyAndBin(pair);
    this.aerospikeClient.writePolicyDefault.sendKey = true;
    this.aerospikeClient.readPolicyDefault.sendKey = true;
    this.aerospikeClient.scanPolicyDefault.sendKey = true;   			
    aerospikeClient.put(null, aerospikeParameters.getKey(), aerospikeParameters.getBinList().get(0),aerospikeParameters.getBinList().get(1));
    return pair.getValue();
  }

  private void isTypeOfPairValid(UUID uuid) {

  }
}
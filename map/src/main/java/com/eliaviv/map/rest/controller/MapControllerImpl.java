package com.eliaviv.map.rest.controller;

import com.eliaviv.map.objects.beans.PairList;
import com.eliaviv.map.objects.pojo.Pair;
import com.eliaviv.map.rest.service.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapControllerImpl<K, V, T> implements MapController<K, V, T> {

  private MapService<K, V> mapService;

  @Autowired
  public void setMapService(MapService<K, V> mapService) {
    this.mapService = mapService;
  }

  @Override
  public Boolean healthCheck() {
    return true;
  }

  @Override
  public ResponseEntity createMap(PairList<K, V> pairList) throws Exception {
    if (pairList.getPairList() == null || !pairList.isValid()) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(mapService.createMap(pairList), HttpStatus.OK);
  }

  @Override
  public ResponseEntity put(@RequestBody Pair<K, V> pair) throws ClassCastException, IllegalArgumentException {
    try {
      isTargetMapValid(pair);
      mapService.put(pair);
    } catch (ClassCastException e) {
      return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(pair.getValue(), HttpStatus.OK);
  }


  private void isTargetMapValid(Pair<K, V> pair) throws IllegalArgumentException {
    if (mapService.findMapById(pair.getMapRefuuid())) {
      throw new IllegalArgumentException();
    }
  }
}
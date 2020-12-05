package com.eliaviv.map.rest.controller;

import com.eliaviv.map.objects.beans.PairList;
import com.eliaviv.map.objects.pojo.Pair;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value   ="/api/method/", 
                consumes = MediaType.APPLICATION_JSON_VALUE, 
                produces = MediaType.APPLICATION_JSON_VALUE)            
public interface MapController<K,V,T> {

  @GetMapping(path="/healthCheck",consumes= MediaType.ALL_VALUE)
  Boolean healthCheck();
  
  @PostMapping("/createMap")
  ResponseEntity<T> createMap(@RequestBody PairList<K, V> pairArray) throws Exception;

  @PostMapping("/put")
  ResponseEntity<T> put(@RequestBody Pair<K,V> pair);  
}

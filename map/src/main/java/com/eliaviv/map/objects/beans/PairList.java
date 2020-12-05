package com.eliaviv.map.objects.beans;

import java.util.List;

import com.eliaviv.map.objects.pojo.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PairList<K,V> {

  private List<Pair<K,V>> pairList;

  public boolean isValid(){
    if (pairList.isEmpty()){
      return true;
    }else{
      String typeKey =  pairList.get(0).getKey().getClass().getName();
      String typeValue =  pairList.get(0).getValue().getClass().getName();
      for (Pair<K,V> pair : pairList) {
        if (!typeKey.equals(pair.getKey().getClass().getName())  || !typeValue.equals(pair.getValue().getClass().getName())){
            return false;
        }
      }
    }
    return true;
  }
  
}

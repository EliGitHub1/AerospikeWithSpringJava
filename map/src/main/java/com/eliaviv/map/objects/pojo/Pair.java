package com.eliaviv.map.objects.pojo;

import java.util.UUID;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<K, V> {
  private K key;
  private V value;
  private UUID mapRefuuid;
}
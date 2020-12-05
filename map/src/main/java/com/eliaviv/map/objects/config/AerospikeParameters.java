package com.eliaviv.map.objects.config;

import java.util.List;

import com.aerospike.client.Bin;
import com.aerospike.client.Key;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AerospikeParameters {
  Key key;
  List<Bin> binList;
}

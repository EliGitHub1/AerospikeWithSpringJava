package com.eliaviv.map.rest.dao.helpers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;

import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.eliaviv.map.objects.config.AerospikeParameters;
import com.eliaviv.map.objects.pojo.Pair;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class MapAerospikeDAOHelper<K, V> {

  public AerospikeParameters generateKeyAndBin(Pair<K, V> pair) {
    AerospikeParameters aerospikeParameters = new AerospikeParameters();
    String inputKeyString = pair.getKey().toString();
    Key key;
    if (pair.getKey() instanceof Integer) {
      key = new Key("test", pair.getMapRefuuid().toString(), Integer.valueOf(inputKeyString));
    } else {
      key = new Key("test", pair.getMapRefuuid().toString(), inputKeyString);
    }
    Bin bin = new Bin("value", pair.getValue());
    Bin binOfKey = new Bin("Key", pair.getKey().hashCode());

    aerospikeParameters.setKey(key);
    ArrayList<Bin> binList = new ArrayList<>();
    binList.add(bin);
    binList.add(binOfKey);

    aerospikeParameters.setBinList(binList);

    return aerospikeParameters;
  }

  public UUID creatUUIDtoNewMap() throws NoSuchAlgorithmException, UnsupportedEncodingException {
    UUID uuid = UUID.randomUUID();
    MessageDigest salt = MessageDigest.getInstance("SHA-256");
    salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
    return uuid;
  }
}
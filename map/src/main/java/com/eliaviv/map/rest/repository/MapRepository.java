package com.eliaviv.map.rest.repository;

import java.util.UUID;

import com.eliaviv.map.rest.model.MapReference;

import org.springframework.data.aerospike.repository.AerospikeRepository;

public interface MapRepository extends AerospikeRepository<MapReference, UUID> {
}
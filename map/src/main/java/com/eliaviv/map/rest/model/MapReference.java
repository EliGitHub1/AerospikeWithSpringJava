package com.eliaviv.map.rest.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapReference{
  @Id
  private UUID uuid;
}


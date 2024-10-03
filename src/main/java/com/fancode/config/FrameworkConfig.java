package com.fancode.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "system:env",
  "file:${user.dir}/src/test/resources/config/config.properties"})
public interface FrameworkConfig extends Config {

  String base_uri();
}
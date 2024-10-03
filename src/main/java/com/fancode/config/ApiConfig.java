package com.fancode.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
  "system:properties",
  "system:env",
  "file:${user.dir}/src/test/resources/testconfig/api-config.properties"
})
public interface ApiConfig extends Config {

  @Key("base.url")
  String apiBaseUrl();

  @Key("api.todos")
  String todosEndpoint();

  @Key("api.users")
  String usersEndpoint();
}
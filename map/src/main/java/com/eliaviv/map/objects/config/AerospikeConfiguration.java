package com.eliaviv.map.objects.config;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

@Configuration
@EnableAerospikeRepositories
public class AerospikeConfiguration {

    // @Autowired
    // private MappingAerospikeConverter mappingAerospikeConverter;

    @Bean(destroyMethod = "close")
    public AerospikeClient  aerospikeClient(){
        ClientPolicy clientPolicy = new ClientPolicy();
        clientPolicy.failIfNotConnected = true;
        // clientPolicy.writePolicyDefault.expiration = 3600;

        return new AerospikeClient(clientPolicy,"172.28.128.3",3000);
        
    }

}
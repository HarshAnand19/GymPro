package com.stackroute.adminservice.gym.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.adminservice.gym.entity.Subscription;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription,String>{

}

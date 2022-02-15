package com.jumia.customer.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jumia.customer.enums.StrategyName;

@Component
public class SearchStrategyFactory {
  private Map<StrategyName, SearchStrategy> strategies;
  
  @Autowired
  public SearchStrategyFactory(Set<SearchStrategy> strategySet) {
     createStrategy(strategySet);
  }
  
  public SearchStrategy findStrategy(StrategyName strategyName) {
     return strategies.get(strategyName);
  }
  private void createStrategy(Set<SearchStrategy> strategySet) {
      strategies = new HashMap<StrategyName, SearchStrategy>();
      strategySet.forEach( 
   strategy ->strategies.put(strategy.getStrategyName(), strategy));
  }
}
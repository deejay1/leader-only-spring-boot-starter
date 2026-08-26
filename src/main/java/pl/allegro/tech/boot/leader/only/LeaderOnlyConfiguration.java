package pl.allegro.tech.boot.leader.only;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.allegro.tech.boot.leader.only.api.LeadershipFactory;

@AutoConfiguration
public class LeaderOnlyConfiguration {
    @Bean
    static LeadershipProxyFactory leaderOnlyProxyFactory(LeadershipFactory leadershipFactory) {
        return new LeadershipProxyFactory(leadershipFactory);
    }

    @Bean
    @ConditionalOnBean(LeadershipProxyFactory.class)
    static LeaderOnlyBeanPostProcessor leaderOnlyBeanPostProcessor(LeadershipProxyFactory leadershipProxyFactory) {
        return new LeaderOnlyBeanPostProcessor(leadershipProxyFactory);
    }
}

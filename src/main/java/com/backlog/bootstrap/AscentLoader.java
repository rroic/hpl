package com.backlog.bootstrap;

import com.backlog.domain.Ascent;
import com.backlog.repositories.AscentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class AscentLoader implements ApplicationListener<ContextRefreshedEvent> {

    private AscentRepository ascentRepository;

    private Logger log = Logger.getLogger(AscentLoader.class);

    @Autowired
    public void setAscentRepository(AscentRepository ascentRepository) {
        this.ascentRepository = ascentRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Ascent route = new Ascent();
        route.setName("Aurora");
        route.setCrag("Kalnik");
        route.setCountry("Croatia");
        route.setPoints(1000);
        route.setGrade("7a+");
        ascentRepository.save(route);

        log.info("Saved route - id: " + route.getId());

        Ascent boulder = new Ascent();
        route.setName("Helikopter");
        route.setCrag("Maltatal");
        route.setCountry("Austria");
        route.setPoints(1000);
        route.setGrade("7a");
        ascentRepository.save(boulder);

        log.info("Saved boulder - id:" + boulder.getId());
    }
}
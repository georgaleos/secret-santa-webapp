package com.elefth.secretsanta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EntityScan("com.elefth.secretsanta.domain")
@EnableNeo4jRepositories
public class SecretSantaApplication extends SpringBootServletInitializer {

    private final static Logger log = LoggerFactory.getLogger(SecretSantaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SecretSantaApplication.class, args);
	}

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

//    @Bean
//    CommandLineRunner demo(PersonRepository personRepository, GroupRepository groupRepository) {
//        return args -> {
//
//            personRepository.deleteAll();
//            groupRepository.deleteAll();
//
//            Group group = new Group("Friends");
//
//            Person greg = new Person("Greg", "greg@secretsanta.com");
//            Person gray = new Person("Gray", "gray@secretsanta.com");
//            Person roy = new Person("Roy", "roy@secretsanta.com");
//            Person craig = new Person("Craig", "craig@secretsanta.com");
//
//            List<Person> team = Arrays.asList(greg, gray, roy, craig);
//
//            group.setMembers(new HashSet<>(team));
//
//            log.info("Before linking up with Neo4j...");
//
//            team.forEach(person -> log.info("\t" + person.toString()));
//
//            personRepository.save(greg);
//            personRepository.save(gray);
//            personRepository.save(roy);
//            personRepository.save(craig);
//
//            groupRepository.save(group);
//
////            greg = personRepository.findByName(greg.getName());
////            greg.worksWith(roy);
////            greg.worksWith(craig);
//            personRepository.save(greg);
//
////            roy = personRepository.findByName(roy.getName());
////            roy.worksWith(craig);
//            // We already know that roy works with greg
//            personRepository.save(roy);
//
//            greg.addPossibleGift(new PossibleGift(greg, craig));
//
//            personRepository.save(greg);
//
//            // We already know craig works with roy and greg
//
//            // MATCH (greg:Person {name:"Greg"}), (roy:Person {name:"Roy"}) CREATE (greg)-[:POSSIBLE_GIFT]->(roy) RETURN greg,roy
//
//            log.info("Lookup each person by name...");
//            team.forEach(person -> log.info("\t" + personRepository.findByName(person.getName()).toString()));
//
//            log.info("Lookup each person by name...");
//            groupRepository.findByMemberId(craig.getName()).forEach(group1 -> log.info("\t" + group1));
//
//            log.info("personRepository.findByName(\"Greg\")");
//            personRepository.findByName("Greg").forEach(person -> log.info("\t" + personRepository.findByName(person.getName()).toString()));
//
//            log.info("personRepository.findByNameLike(\"Greg\")");
//            personRepository.findByNameLike("*Gr*").forEach(person -> log.info("\t" + personRepository.findByName(person.getName()).toString()));
//
//            log.info("Lookup each person by name...");
//            log.info("\t" + personRepository.findOne(greg.getId()));
//        };
//    }

}

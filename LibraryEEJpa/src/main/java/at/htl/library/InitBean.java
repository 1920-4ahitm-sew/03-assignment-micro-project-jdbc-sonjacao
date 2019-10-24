package at.htl.library;

import at.htl.library.entity.PublishingHouse;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class InitBean {

    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        System.out.println("*** It works! ***");
        em.persist(new PublishingHouse("CARLSEN Verlag GmbH", "Völckersstraße 14 - 20", 22765L, "Hamburg", "Germany"));
        em.persist(new PublishingHouse("Trauner Verlag + Buchservice GmbH", "Köglstraße 14", 4020L, "Linz", "Austria"));
        em.persist(new PublishingHouse("Springer-Verlag GmbH", "Tiergartenstrasse 17", 69121L, "Heidelberg", "Germany"));
        em.persist(new PublishingHouse("Cornelsen Verlag GmbH", "Mecklenburgische Straße 53", 14197L, "Berlin", "Germany"));
        em.persist(new PublishingHouse("Ernst Klett Verlag GmbH", "Rotebühlstraße 77", 70178L, "Stuttgart", "Germany"));
        em.persist(new PublishingHouse("Georg Westermann Verlag, Druckerei und Kartographische Anstalt GmbH & Co. KG", "Georg-Westermann-Allee 66", 38104L, "Braunschweig", "Germany"));
        em.persist(new PublishingHouse("Weltbild Verlag GmbH", "Sterneckstraße 33", 5020L, "Salzburg", "Austria"));
        em.persist(new PublishingHouse("WEKA Holding GmbH & Co. KG", "Römerstraße 4", 86438L, "Kissing", "Germany"));
        em.persist(new PublishingHouse("Verlagsgruppe Random House GmbH", "Neumarkter Straße 28", 81673L, "Munich", "Germany"));
        em.persist(new PublishingHouse("Vogel Communications Group GmbH & Co.KG", "Max-Planck-Straße 7/9", 97082L, "Würzburg", "Germany"));
    }

    public void tearDown(@Observes @Destroyed(ApplicationScoped.class) Object init) {
        // when app is undeployed
    }
}

package peaksoft.dao.socialMedia;

import jakarta.persistence.EntityManager;
import peaksoft.classes.Person;
import peaksoft.classes.SocialMedia;
import peaksoft.config.HibernateConfig;

import java.util.List;

/**
 * name : kutman
 **/
public class MediaDaoImpl implements MediaDao{
    private final EntityManager entityManager = HibernateConfig.getEntity().createEntityManager();
    @Override
    public String save(SocialMedia socialMedia) {
        entityManager.getTransaction().begin();
        entityManager.persist(socialMedia);
        entityManager.getTransaction().commit();
        return socialMedia.getName()+" сохранен!";
    }
    @Override
    public SocialMedia getSocialMediaByPersonName(String name) {
        entityManager.getTransaction().begin();
        SocialMedia name1 = entityManager.createQuery("select s from SocialMedia s join Person p on p.id = s.id where p.name = :name", SocialMedia.class)
                .setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return name1;
    }

    @Override
    public String deleteById(Long id) {
        entityManager.getTransaction().begin();
        SocialMedia person = entityManager.find(SocialMedia.class,id);
        entityManager.remove(person);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "deleted";
    }

    @Override
    public List<SocialMedia> getAllSocialMediaSortByNameByDesc() {
        entityManager.isOpen();
        entityManager.getTransaction().begin();
        List<SocialMedia> c = entityManager.createQuery("select s from SocialMedia s order by name desc ").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return c;
    }

    @Override
    public String addPersonVSocialMediaByID(Long id, Long personID) {
        entityManager.getTransaction().begin();
        SocialMedia socialMedia = entityManager.find(SocialMedia.class,id);
        Person person = entityManager.find(Person.class,personID);
        socialMedia.setPeople(List.of(person));
        person.setSocialMedia(List.of(socialMedia));
        entityManager.getTransaction().commit();
        entityManager.close();
        return "yes";
    }
}

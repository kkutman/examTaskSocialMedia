package peaksoft.dao.socialMedia;

import peaksoft.classes.Person;
import peaksoft.classes.SocialMedia;

import java.util.List;

/**
 * name : kutman
 **/
public interface MediaDao {
    String save(SocialMedia socialMedia);
    SocialMedia getSocialMediaByPersonName(String name);
    String deleteById(Long id);
    List<SocialMedia> getAllSocialMediaSortByNameByDesc();

    String addPersonVSocialMediaByID(Long id, Long personID);
}

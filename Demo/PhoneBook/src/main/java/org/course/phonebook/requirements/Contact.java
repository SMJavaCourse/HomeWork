package org.course.phonebook.requirements;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.course.phonebook.impl.ContactImpl;

import java.util.List;

@JsonDeserialize(as = ContactImpl.class)
public interface Contact {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public String getPhone();

    public void setPhone(String phone);

    public List<String> getGroups();

    public void setGroups(List<String> groups);
}

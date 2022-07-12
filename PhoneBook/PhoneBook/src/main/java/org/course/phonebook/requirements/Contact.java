package org.course.phonebook.requirements;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.course.phonebook.impl.ContactImpl;

@JsonDeserialize(as = ContactImpl.class)
public interface Contact {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public String getPhone();

    public void setPhone(String phone);

    public String[] getGroups();

    public void setGroups(String[] group);
}

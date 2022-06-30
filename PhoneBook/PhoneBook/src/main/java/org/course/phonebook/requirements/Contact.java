package org.course.phonebook.requirements;

public interface Contact {
    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public String getPhone();

    public void setPhone(String phone);

    public String[] getGroup();

    public void setGroup(String[] group);
}

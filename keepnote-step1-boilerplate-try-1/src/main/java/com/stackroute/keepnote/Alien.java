package com.stackroute.keepnote;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

//@Table(name = "student")  -- this should be just below entity
@Entity
//@Table(name = "new_alien_table")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Alien {

    @Id
    //@Column(name = "new_id")
    private int aid;

    //@Transient ---this means this variable will not be getting stored in database as column.
    //@Column(name = "new_name")
    private String aName;

    //@Column(name = "new_col")
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

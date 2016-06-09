package com.solvedbysunrise.wastedtime.data.entity.jpa;

import com.solvedbysunrise.bean.RefelctiveBean;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(indexes = {
        @Index(name = "event_id",  columnList="id", unique = true)
})
public class WastedTimeEvent extends RefelctiveBean {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    private String who;

    private Long duration;

    private String activity;

    private Timestamp date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
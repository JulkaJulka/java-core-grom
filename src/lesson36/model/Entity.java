package lesson36.model;

import lesson36.exception.BadRequestException;

import java.util.Arrays;

/**
 * Created by user on 18.12.2017.
 */
public class Entity {
    private long id;


    public Entity() {
    }

    public Entity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Entity formEntity(String[] str) throws Exception {
        if (str.length == 0 || str == null)
            throw new Exception("Error of reading: Incorrect data");
        for (String el : str) {
            if (el == null) {
                throw new BadRequestException("Error of reading: Incorrect data");
            }
        }
        Entity entity = new Entity();
        long id = Long.parseLong(str[0]);
        entity.setId(id);
        return entity;
    }
    @Override
    public String toString() {
        return String.valueOf(id);
    }

}

package me.souprpk.gameapi.api.managers;

import me.souprpk.gameapi.api.nms.Body;

import java.util.ArrayList;
import java.util.List;

public class BodyManager {

    private List<Body> bodies;

    public BodyManager(){
        this.bodies = new ArrayList<>();
    }

    public List<Body> getBodies(){
        return bodies;
    }
}

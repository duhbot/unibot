package org.duh102.unibot.server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("")
public class UniBotApplication extends Application {
    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<>();
        set.add(new EventResource(new ArrayList<>(), new ArrayList<>()));
        return set;
    }
}

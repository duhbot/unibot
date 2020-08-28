package org.duh102.unibot.server;

import org.duh102.unibot.model.plugin.MessageEventListener;
import org.duh102.unibot.model.plugin.PrivateMessageEventListener;
import org.duh102.unibot.server.resources.EventResource;
import org.pf4j.JarPluginManager;
import org.pf4j.PluginManager;

import javax.annotation.PreDestroy;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationPath("")
public class UniBotApplication extends Application {
    private final EventResource eventResource;
    private final PluginManager pluginManager;
    public UniBotApplication() {
        pluginManager = new JarPluginManager();

        eventResource = new EventResource();

        loadPlugins();
    }

    public void stopPlugins() {
        eventResource.clearMessageEventListeners();
        eventResource.clearPrivateMessageEventListeners();
        pluginManager.stopPlugins();
        pluginManager.unloadPlugins();
    }

    public void loadPlugins() {
        pluginManager.loadPlugins();
        pluginManager.startPlugins();
        List<MessageEventListener> messageListeners = pluginManager.getExtensions(MessageEventListener.class);
        List<PrivateMessageEventListener> privateMessageListeners = pluginManager.getExtensions(PrivateMessageEventListener.class);
        eventResource.setMessageEventListeners(messageListeners);
        eventResource.setPrivateMessageEventListeners(privateMessageListeners);
    }

    public void reloadPlugins() {
        stopPlugins();
        loadPlugins();
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<>();
        set.add(eventResource);
        return set;
    }

    @PreDestroy
    public void stop() {
        System.out.println("Stop called");
        stopPlugins();
    }
}

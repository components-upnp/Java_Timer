package com.irit.fenetre.upnp;

import org.fourthline.cling.binding.annotations.*;

import java.beans.PropertyChangeSupport;

/**
 * Created by Abdourahamane Ly on 01/02/2017.
 */

/**
 * Classe ChronoService pour afficher un chronometre.
 * @author Creative Technology
 *
 */

@UpnpService(
        serviceId = @UpnpServiceId("ChronoService"),								// Identifiant Unique
        serviceType = @UpnpServiceType(value = "ChronoService", version = 1)		// Définition de la version
)
public class ChronoService {
    /**
     * Variable qui me permet d'emmettre des évenements UPnP et JavaBean
     */
    private final PropertyChangeSupport propertyChangeSupport;
    public ChronoService() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }
    /**
     * Get propertyChangeSupport
     * @return PropertyChangeSupport
     */
    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    @UpnpStateVariable(defaultValue = "0", sendEvents = false)
    private String target = "0";

    /**
     * Variable d'etat évenemmencée
     * Permet de vrifier si le chrono est en marche ou arreté
     */
    @UpnpStateVariable(defaultValue = "0")
    private String status = "0";

    @UpnpAction(name = "setTarget")
    public void setTarget(@UpnpInputArgument(name = "NewTargetValue") String newTargetValue) {
        String targetOldValue = target;
        String statusOldValue = status;
        status = newTargetValue;
        target = status;
        getPropertyChangeSupport().firePropertyChange("status", statusOldValue, status);
    }
}
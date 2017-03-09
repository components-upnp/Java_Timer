package com.irit;

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
        serviceType = @UpnpServiceType(value = "ChronoService", version = 2)		// Définition de la version
)
public class ChronoService {
    /**
     * Variable D'Etat, non évenemencée
     * Permet d'envoyer le message de l'état dans lequel le chronomètre doit étre
     */
    @UpnpStateVariable(defaultValue = "start", sendEvents = false)
    private boolean target = false;

    /**
     * Variable d'etat évenemmencée
     * Permet de vrifier si le chrono est en marche ou arreté
     */
    @UpnpStateVariable(defaultValue = "start")
    private boolean status = false;

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

    /**
     * Permet d'envoyer un message de changement du chronomètre
     * @param newTargetValue
     */
    @UpnpAction
    public void setTarget(@UpnpInputArgument(name = "NewTargetValue") boolean newTargetValue) {

        // [FACULTATIF] je garde la l'ancienne valeur pour emmettre l'evenenment
        boolean targetOldValue = target;
        target = newTargetValue;

        boolean statusOldValue = status;
        status = newTargetValue;

        // Envoie un évenement UPnP, c'est le nom de la variable d'etat qui lance l'évenement
        // COMMENCE PAR UNE MAJUSCULE. Ici "Status" pour la varialbe status
        getPropertyChangeSupport().firePropertyChange("Status", statusOldValue, status);

       // System.err.println("FIRE");
        // Fonctionne aussi :
        // getPropertyChangeSupport().firePropertyChange("Status", null null);

        // [FACULTATIF]
        // Ceci n'a pas d'effet pour le monitoring UPnP, mais fonctionne avec Javabean.
        // Ici on met le nom de la variable : status
        getPropertyChangeSupport().firePropertyChange("status", statusOldValue, status);
    }

    /**
     * Get target of the lamp
     * Methode Upnp grace au systéme d'annotation
     * @return boolean
     */
    @UpnpAction(out = @UpnpOutputArgument(name = "RetTargetValue"))
    public boolean getTarget() {
        return target;
    }

    /**
     * Get Status du chronomètre
     * Methode Upnp grace au systéme d'annotation
     * @return boolean
     */
    @UpnpAction(out = @UpnpOutputArgument(name = "ResultStatus"))
    public boolean getStatus() {
        // Pour ajouter des informations supplémentaires UPnP en cas d'erreur :
        // throw new ActionException(ErrorCode.ACTION_NOT_AUTHORIZED);
        return status;
    }

    /**
     * Print the version of the code
     * Ceci n'est pas une methode UPnP
     */
    public void printVersion(){
        System.out.println("Version : 1.1");
    }

    /**
     * Permet d'envoyer un evenement après un temps donné
     */
}
/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package org.javaee7.components.model;

import javax.faces.event.ActionEvent;
import org.javaee7.components.web.MapComponent;

/**
 * <p>An {@link ActionEvent} indicating that the specified {@link AreaComponent}
 * has just become the currently selected hotspot within the source
 * {@link MapComponent}.</p>
 */
public class AreaSelectedEvent extends ActionEvent {

    private static final long serialVersionUID = 5030325260451465110L;

    /**
     * <p>Construct a new {@link AreaSelectedEvent} from the specified source
     * map.</p>
     *
     * @param map The {@link MapComponent} originating this event
     */
    public AreaSelectedEvent(MapComponent map) {
        super(map);
    }

    /**
     * <p>Return the {@link MapComponent} of the map for which an area was
     * selected.</p>
     */
    public MapComponent getMapComponent() {
        return ((MapComponent) getComponent());
    }
}

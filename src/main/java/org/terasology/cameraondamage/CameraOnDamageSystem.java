/*
 * Copyright 2019 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.cameraondamage;

import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.ReceiveEvent;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.logic.characters.events.VerticalCollisionEvent;
import org.terasology.logic.location.LocationComponent;
import org.terasology.logic.players.LocalPlayer;
import org.terasology.math.geom.Quat4f;
import org.terasology.registry.In;


@RegisterSystem
public class CameraOnDamageSystem extends BaseComponentSystem {

    @In
    LocalPlayer localPlayer;

    @ReceiveEvent
    public void onDamage(VerticalCollisionEvent event, EntityRef entity) {
        LocationComponent location = localPlayer.getCharacterEntity().getComponent(LocationComponent.class);
        location.setLocalRotation(new Quat4f(0.0f, 0.0f, 100.0f, 0.0f));
        localPlayer.getCharacterEntity().saveComponent(location);
    }
}

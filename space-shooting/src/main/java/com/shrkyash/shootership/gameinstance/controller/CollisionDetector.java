package com.shrkyash.shootership.gameinstance.controller;

import com.shrkyash.shootership.gameinstance.models.ShootingShipState;
import com.shrkyash.shootership.gameinstance.models.base.Mass;
import com.shrkyash.shootership.gameinstance.models.base.Sprite;
import com.shrkyash.shootership.gameinstance.models.base.Bullet;
import com.shrkyash.shootership.gameinstance.models.base.Ship;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollisionDetector extends Controller<ShootingShipState> {
    private void addBullets(Map<String, Mass> locationMap, List<Bullet> bullets) {
        String locationId;
        for (Bullet bullet : bullets) {
            if (!detectCollision(locationMap, bullet)) {
                locationId = formLocationId(bullet);
                locationMap.put(locationId, bullet);
            }
        }
    }

    private void addShip(Map<String, Mass> locationMap, Ship playerShip) {
        String locationId = formLocationId(playerShip);
        locationMap.put(locationId, playerShip);
    }

    private String formLocationId(Sprite sprite) {
        return sprite.getX() + "-" + sprite.getY();
    }

    private boolean detectCollision(Map<String, Mass> locationMap, Mass currentEntity) {
        String locationId = formLocationId(currentEntity);
        if (locationMap.containsKey(locationId)) {
            Mass entityAtLocation = locationMap.get(locationId);
            int entityHealth = entityAtLocation.getHealth();
            entityAtLocation.impact(currentEntity.getHealth());
            currentEntity.impact(entityHealth);
            return true;
        }
        return false;
    }

    @Override
    public void update(ShootingShipState state) {
        Map<String, Mass> locationMap = new HashMap<>();
        state.getPlayerShips().forEach(ship -> addShip(locationMap, ship));
        addBullets(locationMap, state.getBullets());
    }
}

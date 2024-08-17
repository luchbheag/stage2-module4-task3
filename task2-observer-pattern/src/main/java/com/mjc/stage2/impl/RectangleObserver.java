package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle source = event.getSource();
        RectangleValues values = RectangleWarehouse.getInstance().get(source.getId());
        values.setPerimeter((source.getSideA() + source.getSideB()) * 2);
        values.setSquare(source.getSideA() * source.getSideB());
    }
}

package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder sb = new StringBuilder();
        for (AbstractTextComponent component : componentList) {
            sb.append(component.operation());
            sb.append(componentType.getDelimiter());
        }

        return sb.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
        size += textComponent.getSize();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
        size -= textComponent.getSize();
    }

    @Override
    public int getSize() {
        return size;
    }
}

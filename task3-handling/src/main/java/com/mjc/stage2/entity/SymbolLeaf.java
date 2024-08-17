package com.mjc.stage2.entity;

public class SymbolLeaf extends AbstractTextComponent {

    private char value;

    public SymbolLeaf(TextComponentType componentType, char value) {
        super(componentType);
        this.value = value;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String operation() {
        return String.valueOf(value);
    }
}

package org.endorodrigo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public void addItemCarro(ItemCarro itemsCarro){
        if (items.contains(itemsCarro)) {
            Optional<ItemCarro> optionalIntemCarro = items.stream()
                    .filter(
                    c -> c.equals(itemsCarro))
                    .findAny();
            if (optionalIntemCarro.isPresent()) {
                ItemCarro i = optionalIntemCarro.get();
                i.setCantidad(i.getCantidad() + 1);
            }
        }else{
            this.items.add(itemsCarro);
        }
    }

    public int getTotal(){
        return items.stream().mapToInt(ItemCarro::getImporte).sum();
    }
}
